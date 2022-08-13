/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.business.abstracts;

import java.util.List;

import com.mc_es.worldDataBase.entities.concretes.City;

public interface CityService {
	List<City> getCities();

	void insert(City city);

	void update(City city);

	void delete(City city);

	City getById(int id);

	List<City> getCitiesOrderBy();
}
