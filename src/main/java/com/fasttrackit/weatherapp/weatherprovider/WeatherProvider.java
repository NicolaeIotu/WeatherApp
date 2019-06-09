package com.fasttrackit.weatherapp.weatherprovider;

import java.util.Map;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class WeatherProvider {
	// info
	private String name;
	private String url;

	// endpoint url
	private String endpoint;

	// query components
	private Map<String, String> queryComponents;

	// utilities
	private String query = "";
	private String callUri;

	public WeatherProvider() {

	}

	public WeatherProvider(String name, String url, String endpoint,
			Map<String, String> queryComponents) {
		setupProperties(name, url, endpoint, queryComponents);
	}

	public String getName() {
		return this.name;
	}

	public String getUrl() {
		return this.url;
	}

	public String getCallUri() {
		return this.callUri;
	}

	public Map<String, String> getQueryComponents() {
		return queryComponents;
	}

	public WeatherProvider setQueryComponents(Map<String, String> queryComponents) {
		setupProperties(this.name, this.url, this.endpoint, queryComponents);
		return this;
	}

	public void setupProperties(String name, String url, String endpoint,
			Map<String, String> queryComponents) {
		this.name = name;
		this.url = url;
		this.endpoint = endpoint;
		this.queryComponents = queryComponents;

		buildQuery();
		buildCallUri();
	}

	private void buildCallUri() {
		if (this.query.length() > 0) {
			this.callUri = endpoint + "?" + this.query;
		} else {
			this.callUri = endpoint;
		}
	}

	private void buildQuery() {
		this.query = "";
		String value = "";
		for (String key : queryComponents.keySet()) {
			value = queryComponents.get(key);
			if (value.length() != 0) {
				if (query.length() != 0) {
					this.query += "&";
				}
				this.query += key + "=" + value;
			}
		}
	}

}
