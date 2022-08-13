/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "City")
@Table(name = "Cities")
public class City {
	@Id
	@Column(name = "City_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;

	@Column(name = "City_name", nullable = false)
	private String cityName;

	@Column(name = "Country_code", nullable = false)
	private String countryCode;

	@Column(name = "District", nullable = false)
	private String district;

	@Column(name = "Population", nullable = false)
	private int population;

	public City(int cityId, String cityName, String countryCode, String district, int population) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}

	public City() {

	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
