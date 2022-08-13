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

@Entity(name = "Language")
@Table(name = "Languages")
public class Language {
	@Id
	@Column(name = "Language_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int languageId;

	@Column(name = "Country_code", nullable = false)
	private String countryCode;

	@Column(name = "Language", nullable = false)
	private String language;

	@Column(name = "is_official", nullable = false)
	private String isOfficial;

	@Column(name = "Percentage", nullable = false)
	private double percentage;

	public Language(int languageId, String countryCode, String language, String isOfficial, double percentage) {
		this.languageId = languageId;
		this.countryCode = countryCode;
		this.language = language;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	public Language() {

	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}
