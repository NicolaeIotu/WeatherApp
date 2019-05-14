package com.fasttrackit.weatherapp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasttrackit.weatherapp.domain.city.City;
import com.fasttrackit.weatherapp.service.CityService;
import com.fasttrackit.weatherapp.tools.CitiesParser;
import com.fasttrackit.weatherapp.transfer.city.CreateCityRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRelatedTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppApplicationTests.class);

	@Autowired
	CityService cityService;
	
	
	@Test
	public void testAddCityToCitiesTable() {
		LOGGER.info("Adding city.");
		
		CreateCityRequest ccr = new CreateCityRequest();
		ccr.setWwwapiid((long) (Math.random() * 100000));
		ccr.setCity_name("dsadas");
		ccr.setCountrycode("RR");
		ccr.setGeo_latitude(12.34F);
		ccr.setGeo_longitude(23.45F);		
		
		cityService.createCity(ccr);
		
		//TODO change to get city by the same api_id and then check for other properties to match
		assertThat(1L, not(0L));
	}
	

	@Test
	public void testJsonLoadsCurrentCityList() {
		CitiesParser citiesParser;
		long countJsonCities = 0L;

		try {
			citiesParser = new CitiesParser();

			countJsonCities = citiesParser.getCountCities();

			LOGGER.info("Found {} cities in Json file.", countJsonCities);
			assertThat(countJsonCities, not(0));
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testGetCountOfEntriesInCitiesTable() {
		long citiesCount = cityService.countCities();

		LOGGER.info("Found {} cities.", citiesCount);
		
																																																																																						
		assertThat(citiesCount, not(0L));
	}

	
	@Test
	public void testPopulateCitiesTableUsingDataFromWeatherProviderJsonFile() throws Exception {
		//TODO wait here and check regularly that the results arrived
		long countPopulateEntries;
		try {
			countPopulateEntries = cityService.populateCities(false);
		} catch (SecurityException | IOException e) {
			throw e;
		}

		long citiesCount = cityService.countCities();

		assertThat(citiesCount, equalTo(countPopulateEntries));
	}
	
	@Test
	public void testCityRepositoryGetCityById() {
		City city = cityService.getCityById(18918L);
		System.out.println(city.toString());
		
		assertThat(city, notNullValue());
		
	}
}
