package com.fasttrackit.weatherapp.domain;

import java.io.Serializable;


/**
 * IdClass for {@link City} class.
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class CityId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long city_id;
	private long www_api_id;

	
	
	public CityId() {
		
	}
	public CityId(long id, long www_api_id) {
		this.city_id = id;
		this.www_api_id = www_api_id;
	}

	
	
	
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
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
 
		if (this == obj) {
			return true;
		}
 
		if(obj instanceof CityId) {
			CityId otherCityId = (CityId) obj;
			if(otherCityId.getCity_id() == this.getCity_id()) {
				if(otherCityId.getWww_api_id() == this.getWww_api_id()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
 
	@Override
	public int hashCode() {
		//TODO observe
		int result = 0;
		result = (int) (www_api_id / city_id);
		return result;
	}

}
