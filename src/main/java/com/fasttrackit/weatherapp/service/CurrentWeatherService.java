package com.fasttrackit.weatherapp.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;
import com.fasttrackit.weatherapp.persistence.CurrentWeatherRepository;
import com.fasttrackit.weatherapp.tools.CurrentWeatherTools;
import com.fasttrackit.weatherapp.transfer.currentweather.CreateCurrentWeatherRequest;
import com.fasttrackit.weatherapp.transfer.currentweather.UpdateCurrentWeatherRequest;

@Service
public class CurrentWeatherService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CurrentWeatherService.class);
	private static final long VALIDITY_SECONDS = 3 * 60 * 60;

	private final CurrentWeatherRepository currentWeatherRepository;
	private final ObjectMapper objectMapper;

	@Autowired
	public CurrentWeatherService(CurrentWeatherRepository currentWeatherRepository,
			ObjectMapper objectMapper) {
		this.currentWeatherRepository = currentWeatherRepository;
		this.objectMapper = objectMapper;
	}

	// CREATE
	public CurrentWeather createCurrentWeather(CreateCurrentWeatherRequest request) {
		LOGGER.info("Creating currentWeather {}", request);
		CurrentWeather currentWeather = objectMapper.convertValue(request, CurrentWeather.class);
		return currentWeatherRepository.save(currentWeather);
	}

	// READ
	public CurrentWeather getCurrentWeatherById(long id) throws IOException, NoSuchMethodException, SecurityException {
		LOGGER.info("Searching for currentWeather with id {}", id);
		
		CurrentWeather currentWeather = null;
		Optional<CurrentWeather> currentWeatherOptional = currentWeatherRepository.findByWwwapiid(id);
		
		//check for existence
		if(currentWeatherOptional.isPresent()) {
			//check if valid timestamp
			currentWeather = currentWeatherOptional.get();
			
			long currentTimestampSeconds = Math.round(new Date().getTime() / 1000);
			if(Long.parseLong(currentWeather.getCalculation_timestamp_utc()) + 3000 >= currentTimestampSeconds) {
				// still valid
				LOGGER.info("Still valid timestamp...");
				return currentWeather;
			} else {
				//expired, time to update
				LOGGER.info("Expired timestamp: {}", currentWeather.getCalculation_timestamp_utc());
				//TODO async
				currentWeather = CurrentWeatherTools.loadCurrentWeather(id);
			}
		} else {
			// inexistent
			LOGGER.info("No weather at all ...");
			//TODO async
			currentWeather = CurrentWeatherTools.loadCurrentWeather(id);
		}
		
		// expired, time to update
		// or inexistent
		// update db
		currentWeatherRepository.save(currentWeather);
		
		return currentWeather;
	}

	// UPDATE
	public CurrentWeather updateCurrentWeather(UpdateCurrentWeatherRequest request) {
		LOGGER.info("Updating currentWeather {}", request);
		CurrentWeather currentWeather = objectMapper.convertValue(request, CurrentWeather.class);
		return currentWeatherRepository.save(currentWeather);
	}

	// DELETE
	public void deleteCurrentWeather(long wwwapiid) {
		LOGGER.info("Deleting currentWeather {}", wwwapiid);
		currentWeatherRepository.deleteByWwwapiid(wwwapiid);
	}

	// DELETE ALL
	public void deleteAllCurrentWeather() throws IllegalArgumentException {
		LOGGER.info("Deleting all CurrentWeather");
		try {
			currentWeatherRepository.deleteAll();
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	// COUNT CurrentWeather entries
	public long countCurrentWeather() {
		LOGGER.info("Counting CurrentWeather.");

		return currentWeatherRepository.count();
	}

}
