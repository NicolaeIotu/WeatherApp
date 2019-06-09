package com.fasttrackit.weatherapp;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;
import com.fasttrackit.weatherapp.service.CurrentWeatherService;
import com.fasttrackit.weatherapp.tools.CurrentWeatherTools;
import com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrentWeatherRelatedTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(CurrentWeatherRelatedTests.class);

	@Autowired
	CurrentWeatherService currentWeatherService;
	@Autowired
	ObjectMapper objectMapper;


	@Test
	public void testGetJsonObjectFromURLwithJackson() {
		LOGGER.info("Reading url.");
		OpenWeatherMapWeatherProvider owmwp = new OpenWeatherMapWeatherProvider();

		CurrentWeather currentWeather = null;

		LOGGER.info("Looking for URL: {}", owmwp.getCallUri());

		try {
			currentWeather = CurrentWeatherTools.loadCurrentWeather(1851632);
		} catch (IOException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		LOGGER.info("Got response: {}", currentWeather.toString());

		assertThat(currentWeather, notNullValue());
	}

}
