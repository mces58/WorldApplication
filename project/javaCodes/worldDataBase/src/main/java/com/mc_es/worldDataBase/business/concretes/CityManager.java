/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc_es.worldDataBase.business.abstracts.CityService;
import com.mc_es.worldDataBase.dataAccess.abstracts.CityDAO;
import com.mc_es.worldDataBase.entities.concretes.City;

@Service(value = "CityManager")
public class CityManager implements CityService {
	private CityDAO cityDao;

	@Autowired
	public CityManager(CityDAO cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	@Transactional
	public List<City> getCities() {
		return this.cityDao.getCities();
	}

	@Override
	@Transactional
	public void insert(City city) {
		this.cityDao.insert(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDao.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDao.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDao.getById(id);
	}

	@Override
	@Transactional
	public List<City> getCitiesOrderBy() {
		return this.cityDao.getCitiesOrderBy();
	}
}
