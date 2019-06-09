package com.fasttrackit.weatherapp.transfer.city;

import javax.persistence.Column;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public class GetFilteredCitiesRequest {
	@Column(name = "population")
	private Long minPopulation;
	@Column(name = "population")
	private Long maxPopulation;

	@Column(name = "geo_latitude")
	private Double minLatitude;
	@Column(name = "geo_latitude")
	private Double maxLatitude;

	@Column(name = "geo_longitude")
	private Double minLongitude;
	@Column(name = "geo_longitude")
	private Double maxLongitude;

	public Long getMinPopulation() {
		return minPopulation;
	}

	public void setMinPopulation(Long minPopulation) {
		this.minPopulation = minPopulation;
	}

	public Long getMaxPopulation() {
		return maxPopulation;
	}

	public void setMaxPopulation(Long maxPopulation) {
		this.maxPopulation = maxPopulation;
	}

	public Double getMinLatitude() {
		return minLatitude;
	}

	public void setMinLatitude(Double minLatitude) {
		this.minLatitude = minLatitude;
	}

	public Double getMaxLatitude() {
		return maxLatitude;
	}

	public void setMaxLatitude(Double maxLatitude) {
		this.maxLatitude = maxLatitude;
	}

	public Double getMinLongitude() {
		return minLongitude;
	}

	public void setMinLongitude(Double minLongitude) {
		this.minLongitude = minLongitude;
	}

	public Double getMaxLongitude() {
		return maxLongitude;
	}

	public void setMaxLongitude(Double maxLongitude) {
		this.maxLongitude = maxLongitude;
	}

	@Override
	public String toString() {
		return "GetCitiesRequest [minPopulation=" + minPopulation + ", maxPopulation="
				+ maxPopulation + ", minLatitude=" + minLatitude + ", maxLatitude=" + maxLatitude
				+ ", minLongitude=" + minLongitude + ", maxLongitude=" + maxLongitude + "]";
	}

}
