package com.fasttrackit.weatherapp.domain.currentweather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "current_weather", schema = "weather_store")
public class CurrentWeather {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "bigint auto_increment", unique = true)
	private long current_weather_id;

	@Column(nullable = false)
	private String units_type;

	// @OneToOne(fetch = FetchType.LAZY)
	// @MapsId("wwwapiid")
	// private City city;

	@Column(nullable = false, unique = true)
	private long wwwapiid;

	@Column(nullable = false)
	private String city_name;

	@Column(nullable = false)
	private String countrycode;

	@Column(nullable = false)
	private float geo_latitude;

	@Column(nullable = false)
	private float geo_longitude;

	@Column(nullable = false)
	private int weather_condition_id;

	@Column(nullable = false)
	private String weather_condition_main;

	@Column(nullable = false)
	private String weather_condition_description;

	@Column(nullable = false)
	private String weather_condition_icon;

	@Column(nullable = false)
	private float main_temp;

	@Column(nullable = true)
	private float main_temp_min;

	@Column(nullable = true)
	private float main_temp_max;

	@Column(nullable = false)
	private int main_pressure;

	@Column(nullable = true)
	private int main_pressure_sea_level;

	@Column(nullable = true)
	private int main_pressure_grnd_level;

	@Column(nullable = false)
	private int main_humidity;

	@Column(nullable = false)
	private float wind_speed;

	@Column(nullable = false)
	private int wind_deg;

	@Column(nullable = false)
	private int clouds;
	
	@Column(nullable = false)
	private int visibility;

	@Column(nullable = false)
	private float rain_last_1_hr;

	@Column(nullable = false)
	private float rain_last_3_hr;

	@Column(nullable = false)
	private float snow_last_1_hr;

	@Column(nullable = false)
	private float snow_last_3_hr;

	@Column(nullable = false)
	private String calculation_timestamp_utc;

	@Column(nullable = false, length = 2)
	private String sys_country;

	@Column(nullable = false)
	private String sys_sunrise_timestamp_utc;

	@Column(nullable = false)
	private String sys_sunset_timestamp_utc;

	
	
	public CurrentWeather() {
		
	}
	
	
	
	
	public CurrentWeather(String units_type, long wwwapiid,
			String city_name, String countrycode, float geo_latitude, float geo_longitude,
			int weather_condition_id, String weather_condition_main,
			String weather_condition_description, String weather_condition_icon, float main_temp,
			float main_temp_min, float main_temp_max, int main_pressure,
			int main_pressure_sea_level, int main_pressure_grnd_level, int main_humidity,
			float wind_speed, int wind_deg, int clouds, int visibility, float rain_last_1_hr, float rain_last_3_hr,
			float snow_last_1_hr, float snow_last_3_hr, String calculation_timestamp_utc,
			String sys_country, String sys_sunrise_timestamp_utc, String sys_sunset_timestamp_utc) {
		//this.current_weather_id = current_weather_id;
		this.units_type = units_type;
		this.wwwapiid = wwwapiid;
		this.city_name = city_name;
		this.countrycode = countrycode;
		this.geo_latitude = geo_latitude;
		this.geo_longitude = geo_longitude;
		this.weather_condition_id = weather_condition_id;
		this.weather_condition_main = weather_condition_main;
		this.weather_condition_description = weather_condition_description;
		this.weather_condition_icon = weather_condition_icon;
		this.main_temp = main_temp;
		this.main_temp_min = main_temp_min;
		this.main_temp_max = main_temp_max;
		this.main_pressure = main_pressure;
		this.main_pressure_sea_level = main_pressure_sea_level;
		this.main_pressure_grnd_level = main_pressure_grnd_level;
		this.main_humidity = main_humidity;
		this.wind_speed = wind_speed;
		this.wind_deg = wind_deg;
		this.clouds = clouds;
		this.visibility = visibility;
		this.rain_last_1_hr = rain_last_1_hr;
		this.rain_last_3_hr = rain_last_3_hr;
		this.snow_last_1_hr = snow_last_1_hr;
		this.snow_last_3_hr = snow_last_3_hr;
		this.calculation_timestamp_utc = calculation_timestamp_utc;
		this.sys_country = sys_country;
		this.sys_sunrise_timestamp_utc = sys_sunrise_timestamp_utc;
		this.sys_sunset_timestamp_utc = sys_sunset_timestamp_utc;
	}

	public long getCurrent_weather_id() {
		return current_weather_id;
	}

	public void setCurrent_weather_id(long current_weather_id) {
		this.current_weather_id = current_weather_id;
	}

	public String getUnits_type() {
		return units_type;
	}

	public void setUnits_type(String units_type) {
		this.units_type = units_type;
	}

//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}

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

	public int getWeather_condition_id() {
		return weather_condition_id;
	}

	public void setWeather_condition_id(int weather_condition_id) {
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

	public int getMain_pressure() {
		return main_pressure;
	}

	public void setMain_pressure(int main_pressure) {
		this.main_pressure = main_pressure;
	}

	public int getMain_pressure_sea_level() {
		return main_pressure_sea_level;
	}

	public void setMain_pressure_sea_level(int main_pressure_sea_level) {
		this.main_pressure_sea_level = main_pressure_sea_level;
	}

	public int getMain_pressure_grnd_level() {
		return main_pressure_grnd_level;
	}

	public void setMain_pressure_grnd_level(int main_pressure_grnd_level) {
		this.main_pressure_grnd_level = main_pressure_grnd_level;
	}

	public int getMain_humidity() {
		return main_humidity;
	}

	public void setMain_humidity(int main_humidity) {
		this.main_humidity = main_humidity;
	}

	public float getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(float wind_speed) {
		this.wind_speed = wind_speed;
	}

	public int getWind_deg() {
		return wind_deg;
	}

	public void setWind_deg(int wind_deg) {
		this.wind_deg = wind_deg;
	}

	public int getClouds() {
		return clouds;
	}

	public void setClouds(int clouds) {
		this.clouds = clouds;
	}	

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
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
		return "CurrentWeather [current_weather_id=" + current_weather_id + ", units_type="
				+ units_type + ", wwwapiid=" + wwwapiid + ", city_name=" + city_name
				+ ", countrycode=" + countrycode + ", geo_latitude=" + geo_latitude
				+ ", geo_longitude=" + geo_longitude + ", weather_condition_id="
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
