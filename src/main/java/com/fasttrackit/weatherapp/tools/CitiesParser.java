package com.fasttrackit.weatherapp.tools;

import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.fasttrackit.weatherapp.transfer.city.CreateCityRequest;

public class CitiesParser {

	/**
	 * This constant is used when populating, or updating `cities` table and
	 * represents the maximum number of entries used per query when inserting or
	 * updating.
	 */
	public static final int MAXCITIES_CREATE_UPDATE = 100;

	/**
	 * Used for tests in order to limit the number of entries to parse.</br>
	 * Set to 0 to parse all cities
	 */
	public final int MAXCITIES_TO_PARSE = 89;

	/**
	 * Stores the number of cities found in the data from the API provider.</br>
	 * Used for tests as well.
	 */
	private int countCities = 0;

	/**
	 * Stores as JsonArray the cities retrieved from API provider data.
	 */
	private JsonArray citiesJsonArray;

	public CitiesParser() throws SecurityException, IOException {
		try {
			loadCitiesJSON();
		} catch (SecurityException | IOException e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unused")
	public int getMaxCitiesToParse() {
		if(countCities == 0 || countCities < MAXCITIES_TO_PARSE) {
			return 0;
		} else {
			if (MAXCITIES_TO_PARSE == 0) {
				return countCities;
			} else {
				return Math.min(countCities, MAXCITIES_TO_PARSE);
			}
		}
	}

	public CreateCityRequest getCreateCityRequestById(int index) throws IndexOutOfBoundsException {
		if (getCountCities() == 0) {
			throw new IndexOutOfBoundsException("No cities found");
		}
		if (index > (getCountCities() - 1)) {
			throw new IndexOutOfBoundsException("Found only " + getCountCities() + " cities.");
		}

		CreateCityRequest createCityRequest = new CreateCityRequest();

		final JsonObject cityJson = citiesJsonArray.get(index).asJsonObject();

		// errors occurred during tests and 
		// too many entries to check if all fields are present
		// so I'm going use an approach using default values
		JsonArray emptyJsonArray = Json.createArrayBuilder().build();

		// api_id
		createCityRequest.setWwwapiid(string2long(cityJson.get("id").toString()));
		// api_parent_id
		createCityRequest.setApi_parent_id(string2long(cityJson.getJsonObject("geoname").get("parent").toString()));
		// city_name
		createCityRequest.setCity_name(cityJson.getString("name"));
		// city_name_translations
		createCityRequest.setCity_name_translations(cityJson.getOrDefault("langs", emptyJsonArray).asJsonArray().toString());
		// countrycode
		createCityRequest.setCountrycode(cityJson.getString("country"));
		// geo_latitude
		createCityRequest.setGeo_latitude(Float.parseFloat(cityJson.getJsonObject("coord").get("lat").toString()));
		// geo_longitude
		createCityRequest.setGeo_longitude(Float.parseFloat(cityJson.getJsonObject("coord").get("lon").toString()));
		// population
		createCityRequest.setPopulation(string2long(cityJson.getJsonObject("stat").get("population").toString()));
		// stations_count
		createCityRequest.setStations_count(cityJson.getOrDefault("stations", emptyJsonArray).asJsonArray().size());

		return createCityRequest;
	}
	
	private long string2long(String input) {
		long result = -1L;
		try {
			result = Long.parseLong(input);
		} catch (NumberFormatException  e) {
			try {
				result = Math.round(Float.parseFloat(input));
			} catch (NumberFormatException e2) {
				result = -1L;
			}
		}
		return result;
	}

	public void loadCitiesJSON() throws SecurityException, IOException {
		try (InputStream inputStream = CitiesParser.class.getClassLoader().getResourceAsStream("openweathermap/current.city.list.json")) {

			JsonReader reader = Json.createReader(inputStream);
			setCitiesJsonArray(reader.readArray());

			setCountCities(citiesJsonArray.size());

		} catch (SecurityException | IOException e) {
			throw e;
		}
	}

	public int getCountCities() {
		return countCities;
	}

	public void setCountCities(int countCities) {
		this.countCities = countCities;
	}

	public JsonArray getCitiesJsonArray() {
		return citiesJsonArray;
	}

	private void setCitiesJsonArray(JsonArray citiesJsonArray) {
		this.citiesJsonArray = citiesJsonArray;
	}

}
