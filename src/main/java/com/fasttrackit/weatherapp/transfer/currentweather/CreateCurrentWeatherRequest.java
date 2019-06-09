package com.fasttrackit.weatherapp.transfer.currentweather;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class CreateCurrentWeatherRequest {
	// https://openweathermap.org/current

	public CreateCurrentWeatherRequest() {

	}

	// default, metric, imperial
	// for some default is not the same with metric and/or imperial (e.g.
	// temperature)
	private String units_type;

	private long wwwapiid;

	private long weather_condition_id;
	private String weather_condition_main;
	private String weather_condition_description;
	private String weather_condition_icon;

	private float main_temp;
	private float main_temp_min;
	private float main_temp_max;
	private float main_pressure;
	private float main_pressure_sea_level;
	private float main_pressure_grnd_level;
	private float main_humidity;

	private float wind_speed;
	private float wind_deg;

	private float clouds;

	private float rain_last_1_hr;
	private float rain_last_3_hr;

	private float snow_last_1_hr;
	private float snow_last_3_hr;

	private String calculation_timestamp_utc;

	private String sys_country;
	private String sys_sunrise_timestamp_utc;
	private String sys_sunset_timestamp_utc;

	public String getUnits_type() {
		return units_type;
	}

	public void setUnits_type(String units_type) {
		this.units_type = units_type;
	}

	public long getWwwapiid() {
		return wwwapiid;
	}

	public void setWwwapiid(long wwwapiid) {
		this.wwwapiid = wwwapiid;
	}

	public long getWeather_condition_id() {
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
		return "CreateCurrentWeatherRequest [units_type=" + units_type + ", wwwapiid=" + wwwapiid
				+ ", weather_condition_id=" + weather_condition_id + ", weather_condition_main="
				+ weather_condition_main + ", weather_condition_description="
				+ weather_condition_description + ", weather_condition_icon="
				+ weather_condition_icon + ", main_temp=" + main_temp + ", main_temp_min="
				+ main_temp_min + ", main_temp_max=" + main_temp_max + ", main_pressure="
				+ main_pressure + ", main_pressure_sea_level=" + main_pressure_sea_level
				+ ", main_pressure_grnd_level=" + main_pressure_grnd_level + ", main_humidity="
				+ main_humidity + ", wind_speed=" + wind_speed + ", wind_deg=" + wind_deg
				+ ", clouds=" + clouds + ", rain_last_1_hr=" + rain_last_1_hr + ", rain_last_3_hr="
				+ rain_last_3_hr + ", snow_last_1_hr=" + snow_last_1_hr + ", snow_last_3_hr="
				+ snow_last_3_hr + ", calculation_timestamp_utc=" + calculation_timestamp_utc
				+ ", sys_country=" + sys_country + ", sys_sunrise_timestamp_utc="
				+ sys_sunrise_timestamp_utc + ", sys_sunset_timestamp_utc="
				+ sys_sunset_timestamp_utc + "]";
	}

}
