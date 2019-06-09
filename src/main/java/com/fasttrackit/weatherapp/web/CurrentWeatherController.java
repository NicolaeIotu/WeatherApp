package com.fasttrackit.weatherapp.web;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;
import com.fasttrackit.weatherapp.service.CurrentWeatherService;
import com.fasttrackit.weatherapp.transfer.currentweather.UpdateCurrentWeatherRequest;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@RestController
@RequestMapping(value = "/weather")
public class CurrentWeatherController {

	private final CurrentWeatherService currentWeatherService;

	@Autowired
	public CurrentWeatherController(CurrentWeatherService currentWeatherService) {
		this.currentWeatherService = currentWeatherService;
	}

	///////////// READ //////////////////
	// by id
	@GetMapping("/{id}")
	public ResponseEntity<CurrentWeather> getCurrentWeather(@PathVariable("id") long id)
			throws NoSuchMethodException, SecurityException, IOException {
		CurrentWeather response = currentWeatherService.getCurrentWeatherById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//////////// UPDATE //////////////
	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public ResponseEntity updateCurrentWeather(@PathVariable("id") long id,
			@RequestBody @Valid UpdateCurrentWeatherRequest request) {
//		currentWeatherService.updateCurrentWeather(id, request);
		currentWeatherService.updateCurrentWeather(request);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	/////////// DELETE ///////////////
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCurrentWeather(@PathVariable("id") long id) {
		currentWeatherService.deleteCurrentWeather(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
