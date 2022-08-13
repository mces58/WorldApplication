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
import javax.persistence.UniqueConstraint;

@Entity(name = "Country")
@Table(name = "Countries", uniqueConstraints = { @UniqueConstraint(columnNames = { "Country_code" }) })
public class Country {
	@Id
	@Column(name = "Country_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryId;

	@Column(name = "Country_code", nullable = false)
	private String countryCode;

	@Column(name = "Country_name", nullable = false)
	private String countryName;

	@Column(name = "Continent", nullable = false)
	private String continent;

	@Column(name = "Region", nullable = false)
	private String region;

	@Column(name = "Population", nullable = false)
	private int population;

	@Column(name = "Surface_area", nullable = false)
	private double surfaceArea;

	@Column(name = "Government_form", nullable = false)
	private String governmentForm;

	public Country(int countryId, String countryCode, String countryName, String continent, String region,
			int population, double surfaceArea, String governmentForm) {
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.continent = continent;
		this.region = region;
		this.population = population;
		this.surfaceArea = surfaceArea;
		this.governmentForm = governmentForm;
	}

	public Country() {

	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
}
