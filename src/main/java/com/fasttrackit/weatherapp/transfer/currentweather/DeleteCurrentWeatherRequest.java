package com.fasttrackit.weatherapp.transfer.currentweather;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class DeleteCurrentWeatherRequest {
	private long wwwapiid;

	public DeleteCurrentWeatherRequest() {

	}

	public long getWwwapiid() {
		return wwwapiid;
	}

	public void setWwwapiid(long wwwapiid) {
		this.wwwapiid = wwwapiid;
	}

	@Override
	public String toString() {
		return "DeleteCurrentWeatherRequest [wwwapiid=" + wwwapiid + "]";
	}

}
