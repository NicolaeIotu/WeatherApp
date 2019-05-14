package com.fasttrackit.weatherapp;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.service.CurrentWeatherService;
import com.fasttrackit.weatherapp.transfer.currentweather.CurrentWeatherResponse;
import com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider;

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

		CurrentWeatherResponse currentWeatherResponse = null;

		LOGGER.info("Looking for URL: {}", owmwp.getCallUri());

		try {
			URL url = new URL(owmwp.getCallUri());
			String json = "{\"coord\":{\"lon\":138.93,\"lat\":34.97},\"weather\":[{\"id\":520,\"main\":\"Rain\",\"description\":\"light intensity shower rain\",\"icon\":\"09n\"}],\"base\":\"stations\",\"main\":{\"temp\":290.69,\"pressure\":1017,\"humidity\":82,\"temp_min\":287.59,\"temp_max\":292.15},\"visibility\":10000,\"wind\":{\"speed\":1},\"dt\":1557766211,\"sys\":{\"type\":1,\"id\":8024,\"message\":0.0064,\"country\":\"JP\",\"sunrise\":1557776535,\"sunset\":1557826747},\"id\":1851632,\"name\":\"Shuzenji\",\"cod\":200}";
			currentWeatherResponse = objectMapper.readValue(json, CurrentWeatherResponse.class);
			//currentWeatherResponse = objectMapper.readValue(url, CurrentWeatherResponse.class);
			//currentWeatherResponse = CurrentWeatherParser.getCurrentWeatherResponse(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
		}

		LOGGER.info("Got response: {}", currentWeatherResponse.toString());

		assertThat(1L, not(0L));
	}

}
