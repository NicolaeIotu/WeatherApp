package com.fasttrackit.weatherapp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * City class is mainly used to populate the table `cities` using characteristics
 * given by a weather data provider.</br>
 * Because `cities` table uses 2 indexes, an IdClass is used: {@link CityId}
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */

@Entity
@Table(name = "cities", schema = "weather_store")
@IdClass(value = CityId.class)
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id", columnDefinition = "bigint auto_increment", unique = true)
	private long city_id;
	
	// important!
	// the second variable used for index (www_api_id) must be after city_id in alphabetical order
	@Id
	@Column(name = "api_id", nullable = false, unique = true)
	private long www_api_id;

	@Column(nullable = true)
	private long api_parent_id;

	@Column(nullable = false)
	private String city_name;

	@Column(columnDefinition = "longtext")
	private String city_name_translations;

	@Column(nullable = false, length = 4)
	private String country_code;

	@Column(nullable = false)
	private float geo_latitude;

	@Column(nullable = false)
	private float geo_longitude;

	@Column(nullable = true)
	private long population;

	@Column(nullable = true)
	private int stations_count;

	public long getCity_id() {
		return city_id;
	}

	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}

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
		return "City [city_id=" + city_id + ", www_api_id=" + www_api_id + ", api_parent_id=" + api_parent_id + ", city_name=" + city_name
				+ ", city_name_translations=" + city_name_translations + ", country_code=" + country_code + ", geo_latitude=" + geo_latitude
				+ ", geo_longitude=" + geo_longitude + ", population=" + population + ", stations_count=" + stations_count + "]";
	}

}
