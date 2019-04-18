package com.fasttrackit.weatherapp.weatherprovider;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class WeatherProvider {
	private String name;
	private String url;
	private String endpoint;
	private String api_key;
	//private String language = Language(LanguageType.ENGLISH);
	private String unitsType;
	
	private static long callsCount = 0;
	
	public WeatherProvider(String name, String url, String endpoint, String api_key) {
		this.setName(name);
		this.setUrl(url);
		this.setEndpoint(endpoint);
		this.setApi_key(api_key);
	}

	public String getCallURI(String query) {
		callsCount++;
		return (endpoint + query + api_key);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public static long getNumberOfCalls() {
		return callsCount;
	}

	public static void setNumberOfCalls(long numberOfCalls) {
		WeatherProvider.callsCount = numberOfCalls;
	}
	
	
}
