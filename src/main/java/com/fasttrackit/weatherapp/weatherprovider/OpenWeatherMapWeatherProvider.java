package com.fasttrackit.weatherapp.weatherprovider;

import java.util.HashMap;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class OpenWeatherMapWeatherProvider extends WeatherProvider {
	
	private static HashMap<String, String> queryComponents = new HashMap<String, String>() {

		private static final long serialVersionUID = 366565811370506406L;

		{
			put("appid", "02a64469efecc40192091851ca6d4beb");
			put("units", "");
			put("lang", "");
			//tests
			put("id", "1851632");
		}
	};

	public OpenWeatherMapWeatherProvider() {
		super("OpenWeatherMap.org", "https://openweathermap.org", "https://api.openweathermap.org/data/2.5/weather", queryComponents);
	}
	
	public OpenWeatherMapWeatherProvider(long id) {
		super();
		queryComponents.put("id", String.valueOf(id));
		setupProperties("OpenWeatherMap.org", "https://openweathermap.org", "https://api.openweathermap.org/data/2.5/weather", queryComponents);
	}

}
