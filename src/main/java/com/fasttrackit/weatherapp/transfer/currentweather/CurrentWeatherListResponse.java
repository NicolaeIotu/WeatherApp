package com.fasttrackit.weatherapp.transfer.currentweather;

import java.util.List;

import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class CurrentWeatherListResponse {
	List<CurrentWeather> content;

	public CurrentWeatherListResponse() {

	}

	public CurrentWeatherListResponse(List<CurrentWeather> content) {
		this.content = content;
	}

	public List<CurrentWeather> getContent() {
		return content;
	}

	public void setContent(List<CurrentWeather> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CurrentWeatherListResponse [content=" + content + "]";
	}
}
