package com.fasttrackit.weatherapp.domain.city;

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
	private long wwwapiid;

	
	
	public CityId() {
		
	}
	public CityId(long id, long wwwapiid) {
		this.city_id = id;
		this.wwwapiid = wwwapiid;
	}

	
	
	
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
				if(otherCityId.getWwwapiid() == this.getWwwapiid()) {
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
		result = (int) (wwwapiid / city_id);
		return result;
	}

}
