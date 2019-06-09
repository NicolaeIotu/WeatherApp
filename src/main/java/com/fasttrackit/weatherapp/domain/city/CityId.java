package com.fasttrackit.weatherapp.domain.city;

import java.io.Serializable;

/**
 * IdClass for {@link City} class.
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class CityId implements Serializable {

	private static final long serialVersionUID = -2825961735978191910L;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (city_id ^ (city_id >>> 32));
		result = prime * result + (int) (wwwapiid ^ (wwwapiid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityId other = (CityId) obj;
		if (city_id != other.city_id)
			return false;
		if (wwwapiid != other.wwwapiid)
			return false;
		return true;
	}

}
