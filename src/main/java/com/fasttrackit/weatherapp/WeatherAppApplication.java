package com.fasttrackit.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasttrackit.weatherapp.domain.Forecast;
import com.fasttrackit.weatherapp.weatherprovider.WeatherProvider;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
//Where are the beans?
//this scans the packages containing below classes
@SpringBootApplication(scanBasePackageClasses = { WeatherAppApplication.class, Forecast.class, WeatherProvider.class })
public class WeatherAppApplication {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext applicationContext = SpringApplication.run(WeatherAppApplication.class, args);
	}

}
