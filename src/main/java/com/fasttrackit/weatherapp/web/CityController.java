package com.fasttrackit.weatherapp.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasttrackit.weatherapp.domain.city.City;
import com.fasttrackit.weatherapp.service.CityService;
import com.fasttrackit.weatherapp.transfer.city.CreateCityRequest;
import com.fasttrackit.weatherapp.transfer.city.UpdateCityRequest;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@RestController
@RequestMapping(value = "/cities")
@SuppressWarnings("rawtypes")
public class CityController {

	private final CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	///////////// READ //////////////////
	// by id
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable("id") long id) {
		City response = cityService.getCityById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// read all cities
	@GetMapping("/")
	public ResponseEntity<Page<City>> getAllCities(Pageable pageable) {
		Page<City> response = cityService.getAllCities(pageable);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// filtered ranges for lat, long and population
	@GetMapping
	public ResponseEntity<Page<City>> getCitiesByPopulationBetween(
			@RequestParam(value = "minPopulation", defaultValue = "0") long minPopulation,
			@RequestParam(value = "maxPopulation", defaultValue = "9999999999999") long maxPopulation,
			Pageable pageable) {
		Page<City> response = cityService.findCitiesByPopulationBetween(minPopulation,
				maxPopulation, pageable);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// by country
	@GetMapping(value = "/country/{countrycode}")
	public ResponseEntity<Page<City>> getCitiesByCountrycode(
			@PathVariable("countrycode") String countrycode, Pageable pageable) {
		Page<City> response = cityService.getCitiesByCountrycode(countrycode, pageable);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// by name containing
	@GetMapping(value = "/name{q}")
	public ResponseEntity<Page<City>> getCitiesByNameContaining(
			@RequestParam("q") String cityNameLike, Pageable pageable) {
		Page<City> response = cityService.getCitiesByNameContaining(cityNameLike, pageable);
		// TODO all over, discuss response http status
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//////////// CREATE //////////////////
	@PostMapping
	public ResponseEntity<City> createCity(@RequestBody @Valid CreateCityRequest request) {
		City response = cityService.createCity(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/populate/for/development/only/takes/long/time")
	public long populateCities(boolean doFullPopulation) throws Exception {
		long citiesLength = cityService.populateCities(doFullPopulation);
		return citiesLength;
	}

	//////////// UPDATE //////////////
	@PutMapping("/{id}")
	public ResponseEntity updateCity(@PathVariable("id") long id,
			@RequestBody @Valid UpdateCityRequest request) {
		cityService.updateCity(request);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	/////////// DELETE ///////////////
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCity(@PathVariable("id") long id) {
		cityService.deleteCity(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
