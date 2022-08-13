/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc_es.worldDataBase.business.abstracts.CountryService;
import com.mc_es.worldDataBase.dataAccess.abstracts.CountryDAO;
import com.mc_es.worldDataBase.entities.concretes.Country;

@Service(value = "CountryManager")
public class CountryManager implements CountryService {

	private CountryDAO countryDao;

	@Autowired
	public CountryManager(CountryDAO countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	@Transactional
	public List<Country> getCountries() {
		return this.countryDao.getCountries();
	}

	@Override
	@Transactional
	public void insert(Country country) {
		this.countryDao.insert(country);
	}

	@Override
	@Transactional
	public void update(Country country) {
		this.countryDao.update(country);
	}

	@Override
	@Transactional
	public void delete(Country country) {
		this.countryDao.delete(country);
	}

	@Override
	@Transactional
	public Country getById(int id) {
		return this.countryDao.getById(id);
	}

	@Override
	@Transactional
	public List<Country> getCountriesOrderBy() {
		return this.countryDao.getCountriesOrderBy();
	}
}
