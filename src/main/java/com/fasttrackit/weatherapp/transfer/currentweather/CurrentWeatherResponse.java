package com.fasttrackit.weatherapp.transfer.currentweather;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true) // important
public class CurrentWeatherResponse {

	public static final int NO_INT_VALUE = -999999;
	public static final long NO_LONG_VALUE = -999999l;
	public static final float NO_FLOAT_VALUE = -999999f;
	public static final double NO_DOUBLE_VALUE = -999999d;
	public static final String NO_STRING_VALUE = "NIL";

	private String units_type = NO_STRING_VALUE;

	private long wwwapiid = NO_LONG_VALUE;

	private String city_name = "";
	private String countrycode = "";
	private float geo_latitude = NO_FLOAT_VALUE;
	private float geo_longitude = NO_FLOAT_VALUE;

	private float weather_condition_id = NO_INT_VALUE;
	private String weather_condition_main = "";
	private String weather_condition_description = "";
	private String weather_condition_icon = "";

	private float main_temp = NO_FLOAT_VALUE;
	private float main_temp_min = NO_FLOAT_VALUE;
	private float main_temp_max = NO_FLOAT_VALUE;
	private float main_pressure = NO_INT_VALUE;
	private float main_pressure_sea_level = NO_INT_VALUE;
	private float main_pressure_grnd_level = NO_INT_VALUE;
	private float main_humidity = NO_INT_VALUE;

	private float wind_speed = NO_FLOAT_VALUE;
	private float wind_deg = NO_INT_VALUE;

	private float clouds = NO_INT_VALUE;

	private float visibility = NO_INT_VALUE;

	private float rain_last_1_hr = NO_FLOAT_VALUE;
	private float rain_last_3_hr = NO_FLOAT_VALUE;

	private float snow_last_1_hr = NO_FLOAT_VALUE;
	private float snow_last_3_hr = NO_FLOAT_VALUE;

	private String calculation_timestamp_utc = "";

	private String sys_country = "";
	private String sys_sunrise_timestamp_utc = "";
	private String sys_sunset_timestamp_utc = "";

	public CurrentWeatherResponse() {

	}

	public CurrentWeather toCurrentWeather() throws NoSuchMethodException, SecurityException {

		return new CurrentWeather(this.units_type, this.wwwapiid, this.city_name, this.countrycode,
				this.geo_latitude, this.geo_longitude, this.weather_condition_id,
				this.weather_condition_main, this.weather_condition_description,
				this.weather_condition_icon, this.main_temp, this.main_temp_min, this.main_temp_max,
				this.main_pressure, this.main_pressure_sea_level, this.main_pressure_grnd_level,
				this.main_humidity, this.wind_speed, this.wind_deg, this.clouds, this.visibility,
				this.rain_last_1_hr, this.rain_last_3_hr, this.snow_last_1_hr, this.snow_last_3_hr,
				this.calculation_timestamp_utc, this.sys_country, this.sys_sunrise_timestamp_utc,
				this.sys_sunset_timestamp_utc);
	}

	// conversion utility for optional values
	private String getTrueString(Map<String, String> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return NO_STRING_VALUE;
		}
	}

	private Float getTrueFloat(Map<String, String> map, String key) {
		if (map.containsKey(key)) {
			return Float.parseFloat(map.get(key));
		} else {
			return NO_FLOAT_VALUE;
		}
	}

	// CONVERSION
	@JsonProperty("coord")
	private void unpackCoord(Map<String, String> coord) {
		this.geo_latitude = getTrueFloat(coord, "lat");
		this.geo_longitude = getTrueFloat(coord, "lon");
	}

	@JsonProperty("weather")
	private void unpackWeather(List<Map<String, String>> weather) {
		Map<String, String> weathermap = weather.get(0);
		this.weather_condition_id = getTrueFloat(weathermap, "id");
		this.weather_condition_main = getTrueString(weathermap, "main");
		this.weather_condition_description = getTrueString(weathermap, "description");
		this.weather_condition_icon = getTrueString(weathermap, "icon");
	}

	@JsonProperty("main")
	private void unpackMain(Map<String, String> main) {
		this.main_temp = getTrueFloat(main, "temp");
		this.main_temp_min = getTrueFloat(main, "temp_min");
		this.main_temp_max = getTrueFloat(main, "temp_max");
		this.main_pressure = getTrueFloat(main, "pressure");
		this.main_pressure_sea_level = getTrueFloat(main, "sea_level");
		this.main_pressure_grnd_level = getTrueFloat(main, "grnd_level");
		this.main_humidity = getTrueFloat(main, "humidity");
	}

	@JsonProperty("wind")
	private void unpackWind(Map<String, String> wind) {
		this.wind_speed = getTrueFloat(wind, "speed");
		this.wind_deg = getTrueFloat(wind, "deg");
	}

	@JsonProperty("clouds")
	private void unpackClouds(Map<String, String> clouds) {
		this.clouds = getTrueFloat(clouds, "all");
	}

	@JsonProperty("rain")
	private void unpackRain(Map<String, String> rain) {
		this.rain_last_1_hr = getTrueFloat(rain, "1h");
		this.rain_last_3_hr = getTrueFloat(rain, "3h");
	}

	@JsonProperty("snow")
	private void unpackSnow(Map<String, String> snow) {
		this.snow_last_1_hr = getTrueFloat(snow, "1h");
		this.snow_last_3_hr = getTrueFloat(snow, "3h");
	}

	@JsonProperty("dt")
	private void unpackDt(String dt) {
		this.calculation_timestamp_utc = dt;
	}

	@JsonProperty("sys")
	private void unpackSys(Map<String, String> sys) {
		this.countrycode = getTrueString(sys, "country");
		this.sys_sunrise_timestamp_utc = getTrueString(sys, "sunrise");
		this.sys_sunset_timestamp_utc = getTrueString(sys, "sunset");
	}

	@JsonProperty("id")
	private void unpackId(long id) {
		this.wwwapiid = id;
	}

	@JsonProperty("name")
	private void unpackName(String name) {
		this.city_name = name;
	}

	// GETTERS AND SETTERS
	public long getWwwapiid() {
		return wwwapiid;
	}

	public void setWwwapiid(long wwwapiid) {
		this.wwwapiid = wwwapiid;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
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

	public float getWeather_condition_id() {
		return weather_condition_id;
	}

	public void setWeather_condition_id(long weather_condition_id) {
		this.weather_condition_id = weather_condition_id;
	}

	public String getWeather_condition_main() {
		return weather_condition_main;
	}

	public void setWeather_condition_main(String weather_condition_main) {
		this.weather_condition_main = weather_condition_main;
	}

	public String getWeather_condition_description() {
		return weather_condition_description;
	}

	public void setWeather_condition_description(String weather_condition_description) {
		this.weather_condition_description = weather_condition_description;
	}

	public String getWeather_condition_icon() {
		return weather_condition_icon;
	}

	public void setWeather_condition_icon(String weather_condition_icon) {
		this.weather_condition_icon = weather_condition_icon;
	}

	public float getMain_temp() {
		return main_temp;
	}

	public void setMain_temp(float main_temp) {
		this.main_temp = main_temp;
	}

	public float getMain_temp_min() {
		return main_temp_min;
	}

	public void setMain_temp_min(float main_temp_min) {
		this.main_temp_min = main_temp_min;
	}

	public float getMain_temp_max() {
		return main_temp_max;
	}

	public void setMain_temp_max(float main_temp_max) {
		this.main_temp_max = main_temp_max;
	}

	public float getMain_pressure() {
		return main_pressure;
	}

	public void setMain_pressure(float main_pressure) {
		this.main_pressure = main_pressure;
	}

	public float getMain_pressure_sea_level() {
		return main_pressure_sea_level;
	}

	public void setMain_pressure_sea_level(float main_pressure_sea_level) {
		this.main_pressure_sea_level = main_pressure_sea_level;
	}

	public float getMain_pressure_grnd_level() {
		return main_pressure_grnd_level;
	}

	public void setMain_pressure_grnd_level(float main_pressure_grnd_level) {
		this.main_pressure_grnd_level = main_pressure_grnd_level;
	}

	public float getMain_humidity() {
		return main_humidity;
	}

	public void setMain_humidity(float main_humidity) {
		this.main_humidity = main_humidity;
	}

	public float getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(float wind_speed) {
		this.wind_speed = wind_speed;
	}

	public float getWind_deg() {
		return wind_deg;
	}

	public void setWind_deg(float wind_deg) {
		this.wind_deg = wind_deg;
	}

	public float getClouds() {
		return clouds;
	}

	public void setClouds(float clouds) {
		this.clouds = clouds;
	}

	public float getVisibility() {
		return visibility;
	}

	public void setVisibility(float visibility) {
		this.visibility = visibility;
	}

	public float getRain_last_1_hr() {
		return rain_last_1_hr;
	}

	public void setRain_last_1_hr(float rain_last_1_hr) {
		this.rain_last_1_hr = rain_last_1_hr;
	}

	public float getRain_last_3_hr() {
		return rain_last_3_hr;
	}

	public void setRain_last_3_hr(float rain_last_3_hr) {
		this.rain_last_3_hr = rain_last_3_hr;
	}

	public float getSnow_last_1_hr() {
		return snow_last_1_hr;
	}

	public void setSnow_last_1_hr(float snow_last_1_hr) {
		this.snow_last_1_hr = snow_last_1_hr;
	}

	public float getSnow_last_3_hr() {
		return snow_last_3_hr;
	}

	public void setSnow_last_3_hr(float snow_last_3_hr) {
		this.snow_last_3_hr = snow_last_3_hr;
	}

	public String getCalculation_timestamp_utc() {
		return calculation_timestamp_utc;
	}

	public void setCalculation_timestamp_utc(String calculation_timestamp_utc) {
		this.calculation_timestamp_utc = calculation_timestamp_utc;
	}

	public String getSys_country() {
		return sys_country;
	}

	public void setSys_country(String sys_country) {
		this.sys_country = sys_country;
	}

	public String getSys_sunrise_timestamp_utc() {
		return sys_sunrise_timestamp_utc;
	}

	public void setSys_sunrise_timestamp_utc(String sys_sunrise_timestamp_utc) {
		this.sys_sunrise_timestamp_utc = sys_sunrise_timestamp_utc;
	}

	public String getSys_sunset_timestamp_utc() {
		return sys_sunset_timestamp_utc;
	}

	public void setSys_sunset_timestamp_utc(String sys_sunset_timestamp_utc) {
		this.sys_sunset_timestamp_utc = sys_sunset_timestamp_utc;
	}

	@Override
	public String toString() {
		return "CurrentWeatherResponse [units_type=" + units_type + ", wwwapiid=" + wwwapiid
				+ ", city_name=" + city_name + ", countrycode=" + countrycode + ", geo_latitude="
				+ geo_latitude + ", geo_longitude=" + geo_longitude + ", weather_condition_id="
				+ weather_condition_id + ", weather_condition_main=" + weather_condition_main
				+ ", weather_condition_description=" + weather_condition_description
				+ ", weather_condition_icon=" + weather_condition_icon + ", main_temp=" + main_temp
				+ ", main_temp_min=" + main_temp_min + ", main_temp_max=" + main_temp_max
				+ ", main_pressure=" + main_pressure + ", main_pressure_sea_level="
				+ main_pressure_sea_level + ", main_pressure_grnd_level=" + main_pressure_grnd_level
				+ ", main_humidity=" + main_humidity + ", wind_speed=" + wind_speed + ", wind_deg="
				+ wind_deg + ", clouds=" + clouds + ", visibility=" + visibility
				+ ", rain_last_1_hr=" + rain_last_1_hr + ", rain_last_3_hr=" + rain_last_3_hr
				+ ", snow_last_1_hr=" + snow_last_1_hr + ", snow_last_3_hr=" + snow_last_3_hr
				+ ", calculation_timestamp_utc=" + calculation_timestamp_utc + ", sys_country="
				+ sys_country + ", sys_sunrise_timestamp_utc=" + sys_sunrise_timestamp_utc
				+ ", sys_sunset_timestamp_utc=" + sys_sunset_timestamp_utc + "]";
	}

}
