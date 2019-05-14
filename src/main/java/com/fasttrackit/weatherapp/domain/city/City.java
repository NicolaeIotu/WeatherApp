package com.fasttrackit.weatherapp.domain.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * City class is mainly used to populate the table `cities` using
 * characteristics given by a weather data provider.</br>
 * Because `cities` table uses 2 indexes, an IdClass is used: {@link CityId}
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */

@Entity
@Table(name = "cities_table", schema = "weather_store")
@IdClass(value = CityId.class)
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id", columnDefinition = "bigint auto_increment", unique = true)
	private long city_id;

	// important!
	// the second variable used for index (wwwapiid) must be after city_id in
	// alphabetical order
	@Id
	@Column(name = "api_id", nullable = false, unique = true)
	private long wwwapiid;

	@Column(nullable = true)
	private long api_parent_id;

	@Column(name = "city_name", nullable = false)
	private String cityname;

	@Column(columnDefinition = "longtext")
	private String city_name_translations;

	@Column(nullable = false, length = 2)
	private String countrycode;

	@Column(name = "geo_latitude", nullable = false)
	private float latitude;

	@Column(name = "geo_longitude", nullable = false)
	private float longitude;

	@Column(nullable = true, length = 13)
	private long population;

	@Column(nullable = true)
	private int stations_count;

	public long getCity_id() {
		return city_id;
	}

	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}

	public long getWwwapiid() {
		return wwwapiid;
	}

	public void setWwwapiid(long wwwapiid) {
		this.wwwapiid = wwwapiid;
	}

	public long getApi_parent_id() {
		return api_parent_id;
	}

	public void setApi_parent_id(long api_parent_id) {
		this.api_parent_id = api_parent_id;
	}

	public String getCity_name() {
		return cityname;
	}

	public void setCity_name(String city_name) {
		this.cityname = city_name;
	}

	public String getCity_name_translations() {
		return city_name_translations;
	}

	public void setCity_name_translations(String city_name_translations) {
		this.city_name_translations = city_name_translations;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public float getGeo_latitude() {
		return latitude;
	}

	public void setGeo_latitude(float geo_latitude) {
		this.latitude = geo_latitude;
	}

	public float getGeo_longitude() {
		return longitude;
	}

	public void setGeo_longitude(float geo_longitude) {
		this.longitude = geo_longitude;
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
		return "City [city_id=" + city_id + ", wwwapiid=" + wwwapiid + ", api_parent_id="
				+ api_parent_id + ", city_name=" + cityname + ", city_name_translations="
				+ city_name_translations + ", countrycode=" + countrycode + ", geo_latitude="
				+ latitude + ", geo_longitude=" + longitude + ", population=" + population
				+ ", stations_count=" + stations_count + "]";
	}

}
