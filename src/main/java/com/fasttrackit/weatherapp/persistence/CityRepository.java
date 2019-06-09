package com.fasttrackit.weatherapp.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fasttrackit.weatherapp.domain.city.City;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

	// Important: table columns to be searched must be named lowercase, no
	// underscore
	// in order for the repository to function properly.
	// Another way is to create a correspondence in domain class
	// e.g. City.java
	// @Column(name = "api_id"...
	// private long wwwapiid;
	Page<City> findAllByCountrycode(String countrycode, Pageable pageable);

	Page<City> findCitiesByPopulationBetween(Long minPopulation, Long maxPopulation,
			Pageable pageable);

	City findByWwwapiid(long wwwapiid);

	Page<City> findAllByCitynameContaining(String partialCityname, Pageable pageable);
}
