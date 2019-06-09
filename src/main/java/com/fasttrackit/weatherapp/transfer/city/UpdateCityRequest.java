package com.fasttrackit.weatherapp.transfer.city;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class UpdateCityRequest extends CreateCityRequest {

	public UpdateCityRequest() {
		super();
	}

	private long city_id;
	private long wwwapiid;
	private long api_parent_id;
	private String city_name;
	private String city_name_translations;
	private String countrycode;
	private float geo_latitude;
	private float geo_longitude;
	private long population;
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

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
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
		return "UpdateCityRequest [city_id=" + city_id + ", wwwapiid=" + wwwapiid
				+ ", api_parent_id=" + api_parent_id + ", city_name=" + city_name
				+ ", city_name_translations=" + city_name_translations + ", countrycode="
				+ countrycode + ", geo_latitude=" + geo_latitude + ", geo_longitude="
				+ geo_longitude + ", population=" + population + ", stations_count="
				+ stations_count + "]";
	}

}
