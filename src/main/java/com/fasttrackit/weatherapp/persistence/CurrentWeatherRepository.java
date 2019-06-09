package com.fasttrackit.weatherapp.persistence;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeather, Long> {
	Optional<CurrentWeather> findByWwwapiid(long wwwapiid);
	void deleteByWwwapiid(long wwwapiid);
	boolean existsByWwwapiid(long id);
}
