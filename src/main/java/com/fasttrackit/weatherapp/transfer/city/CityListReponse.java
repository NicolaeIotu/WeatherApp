package com.fasttrackit.weatherapp.transfer.city;

import java.util.List;

import com.fasttrackit.weatherapp.domain.city.City;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class CityListReponse {

	List<City> content;

	public CityListReponse() {

	}

	public CityListReponse(List<City> content) {
		this.content = content;
	}

	public List<City> getContent() {
		return content;
	}

	public void setContent(List<City> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CityListReponse [content=" + content + "]";
	}

}
