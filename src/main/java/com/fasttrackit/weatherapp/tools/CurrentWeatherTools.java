package com.fasttrackit.weatherapp.tools;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;
import com.fasttrackit.weatherapp.transfer.currentweather.CurrentWeatherResponse;
import com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider;

public abstract class CurrentWeatherTools {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static CurrentWeather loadCurrentWeather(long wwwapiid)
			throws IOException, NoSuchMethodException, SecurityException {
		OpenWeatherMapWeatherProvider owmwp = new OpenWeatherMapWeatherProvider(wwwapiid);
		CurrentWeatherResponse currentWeatherResponse = null;

		URL url = new URL(owmwp.getCallUri());
		currentWeatherResponse = objectMapper.readValue(url, CurrentWeatherResponse.class);

		return currentWeatherResponse.toCurrentWeather();
	}
}
