package com.fasttrackit.weatherapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.city.City;
import com.fasttrackit.weatherapp.persistence.CityRepository;
import com.fasttrackit.weatherapp.tools.CitiesParser;
import com.fasttrackit.weatherapp.transfer.city.CreateCityRequest;
import com.fasttrackit.weatherapp.transfer.city.UpdateCityRequest;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@Service
public class CityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);

	private final CityRepository cityRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public CityService(CityRepository cityRepository, ObjectMapper objectMapper) {
		this.cityRepository = cityRepository;
		this.objectMapper = objectMapper;
	}

	// CREATE
	public City createCity(CreateCityRequest request) {
		LOGGER.info("Creating city {}", request);
		City city = objectMapper.convertValue(request, City.class);
		return cityRepository.save(city);
	}

	// READ
	public City getCityById(long id) {
		LOGGER.info("Searching for city with id {}", id);
		return cityRepository.findByWwwapiid(id);
	}

	// READ CITIES WITH NAME CONTAINING
	public Page<City> getCitiesByNameContaining(String cityNameLike, Pageable pageable) {
		LOGGER.info("Searching for city with name like {}", cityNameLike);
		return cityRepository.findAllByCitynameContaining(cityNameLike, pageable);
	}

	// READ ALL
	public Page<City> getAllCities(Pageable pageable) {
		LOGGER.info("Loading all cities (by page): {}", pageable.toString());
		return cityRepository.findAll(pageable);
	}

	// READ ALL OF SAME COUNTRY
	public Page<City> getCitiesByCountrycode(String countrycode, Pageable pageable) {
		LOGGER.info("Loading all cities in the same country (by page): {}", pageable.toString());
		return cityRepository.findAllByCountrycode(countrycode, pageable);
	}

	// READ FILTERED CITIES
	public Page<City> findCitiesByPopulationBetween(long minPopulation, long maxPopulation,
			Pageable pageable) {
		LOGGER.info("Loading filtered cities (by page): {}", pageable.toString());
		return cityRepository.findCitiesByPopulationBetween(minPopulation, maxPopulation, pageable);
	}

	// UPDATE
	public City updateCity(UpdateCityRequest request) {
		LOGGER.info("Updating city {}", request);
		City city = objectMapper.convertValue(request, City.class);
		return cityRepository.save(city);
	}

	// DELETE
	public void deleteCity(long id) {
		LOGGER.info("Deleting city {}", id);
		cityRepository.deleteById(id);
	}

	// DELETE ALL
	public void deleteAllCities() throws IllegalArgumentException {
		LOGGER.info("Deleting all cities");
		try {
			cityRepository.deleteAll();
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	// COUNT cities entries
	public long countCities() {
		LOGGER.info("Counting cities.");

		return cityRepository.count();
	}

	// POPULATE - BATCH CREATE
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public long populateCities(boolean doFullPopulation) throws Exception {
		// TODO different thread
		LOGGER.info("Populating cities.");

		if (doFullPopulation)
			deleteAllCities();

		CitiesParser citiesParser;
		try {
			citiesParser = new CitiesParser();
		} catch (SecurityException | IOException e) {
			throw e;
		}

		final int MAXCITIES_CREATE_UPDATE = CitiesParser.MAXCITIES_CREATE_UPDATE;
		final int citiesCount = doFullPopulation ? citiesParser.getCountCities()
				: citiesParser.getMaxCitiesToParse();

		List<City> citiesList = new ArrayList<City>();

		LOGGER.info("Populating `cities` table.");

		int index;
		for (index = 0; index < citiesCount; index++) {
			citiesList.add(objectMapper.convertValue(citiesParser.getCreateCityRequestById(index),
					City.class));

			if (citiesList.size() > 0 && index > 0
					&& ((index % MAXCITIES_CREATE_UPDATE == 0) || (index == citiesCount - 1))) {
				LOGGER.info("Populating index: {}", index);
				cityRepository.saveAll(citiesList);

				citiesList = new ArrayList<City>();
			}
		}

		LOGGER.info("End of pool at index: {}", index);

		return ((long) index);
	}

}
