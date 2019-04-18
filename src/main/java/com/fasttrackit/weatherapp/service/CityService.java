package com.fasttrackit.weatherapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.City;
import com.fasttrackit.weatherapp.persistence.CityRepository;
import com.fasttrackit.weatherapp.tools.CitiesParser;
import com.fasttrackit.weatherapp.transfer.city.CreateCityRequest;

@Service
public class CityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);

	private final CityRepository cityRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public CityService(CityRepository cityRepository, ObjectMapper objectMapper) {
		super();
		this.cityRepository = cityRepository;
		this.objectMapper = objectMapper;
	}

	// CREATE
	public City createCity(CreateCityRequest request) {
		LOGGER.info("Creating city {}", request);
		City city = objectMapper.convertValue(request, City.class);
		return cityRepository.save(city);
	}

	// COUNT cities entries
	public long countCities() {
		LOGGER.info("Counting cities.");

		return cityRepository.count();
	}

	// POPULATE - BATCH CREATE
	public long populateCities() throws SecurityException, IOException {
		LOGGER.info("Populating cities.");

		CitiesParser citiesParser;
		try {
			citiesParser = new CitiesParser();
		} catch (SecurityException | IOException e) {
			throw e;
		}

		final int MAXCITIES_CREATE_UPDATE = CitiesParser.MAXCITIES_CREATE_UPDATE;
		final int citiesCount = citiesParser.getMaxCitiesToParse();

		List<City> citiesList = new ArrayList<City>();

		LOGGER.info("Populating `cities` table.");
		
		int index;
		for (index = 0; index < citiesCount; index++) {
			citiesList.add(objectMapper.convertValue(citiesParser.getCreateCityRequestById(index), City.class));

			if (citiesList.size() > 0 && index > 0 && ((index % MAXCITIES_CREATE_UPDATE == 0) || (index == citiesCount - 1))) {
				LOGGER.info("Populating index: {}", index);
				cityRepository.saveAll(citiesList);

				citiesList = new ArrayList<City>();
			}
		}
		
		LOGGER.info("End of pool at index: {}", index);

		// make sure this large data object is marked as garbage
		citiesParser = null;
		
		return ((long) index);
	}

}
