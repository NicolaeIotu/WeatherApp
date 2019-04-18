package com.fasttrackit.weatherapp.transfer.city;

public class CreateCityRequest {
	
	private long www_api_id;
	private long api_parent_id;
	private String city_name;
	private String city_name_translations;
	private String country_code;
	private float geo_latitude;
	private float geo_longitude;
	private long population;
	private int stations_count;
	
	
	
	
	public long getWww_api_id() {
		return www_api_id;
	}
	public void setWww_api_id(long www_api_id) {
		this.www_api_id = www_api_id;
	}
	public long getApi_parent_id() {
		return api_parent_id;
	}
	public void setApi_parent_id(long api_parent_id) {
		this.api_parent_id = api_parent_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCity_name_translations() {
		return city_name_translations;
	}
	public void setCity_name_translations(String city_name_translations) {
		this.city_name_translations = city_name_translations;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public float getGeo_latitude() {
		return geo_latitude;
	}
	public void setGeo_latitude(float geo_latitude) {
		this.geo_latitude = geo_latitude;
	}
	public float getGeo_longitude() {
		return geo_longitude;
	}
	public void setGeo_longitude(float geo_longitude) {
		this.geo_longitude = geo_longitude;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public int getStations_count() {
		return stations_count;
	}
	public void setStations_count(int stations_count) {
		this.stations_count = stations_count;
	}
	
	
	@Override
	public String toString() {
		return "CreateCityRequest [www_api_id=" + www_api_id + ", api_parent_id=" + api_parent_id + ", city_name=" + city_name
				+ ", city_name_translations=" + city_name_translations + ", country_code=" + country_code + ", geo_latitude=" + geo_latitude
				+ ", geo_longitude=" + geo_longitude + ", population=" + population + ", stations_count=" + stations_count + "]";
	}
	
	
	
}
