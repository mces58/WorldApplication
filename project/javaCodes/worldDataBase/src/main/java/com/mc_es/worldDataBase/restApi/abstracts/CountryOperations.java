/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.restApi.abstracts;

import java.util.List;

import com.mc_es.worldDataBase.entities.concretes.Country;

public interface CountryOperations {
	List<Country> getCountries();

	void insert(Country country);

	void update(Country country);

	void delete(Country country);

	Country getById(int id);

	List<Country> getCountriesOrderBy();
}
