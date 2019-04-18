package com.fasttrackit.weatherapp;


import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasttrackit.weatherapp.service.CityService;

//import static org.hamcrest.CoreMatchers.not;
//import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherAppApplicationTests {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppApplicationTests.class);
	
	@Autowired
	CityService cityService;
	

}
