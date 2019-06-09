package com.fasttrackit.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasttrackit.weatherapp.weatherprovider.WeatherProvider;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@SpringBootApplication(scanBasePackageClasses = { WeatherAppApplication.class,
		WeatherProvider.class })
@EnableTransactionManagement
public class WeatherAppApplication {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext applicationContext = SpringApplication.run(WeatherAppApplication.class,
				args);
	}

}
