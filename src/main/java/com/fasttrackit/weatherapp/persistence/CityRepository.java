package com.fasttrackit.weatherapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasttrackit.weatherapp.domain.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
}
