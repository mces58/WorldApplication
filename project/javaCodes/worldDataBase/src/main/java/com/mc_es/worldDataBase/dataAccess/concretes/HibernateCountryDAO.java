/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.dataAccess.concretes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mc_es.worldDataBase.dataAccess.abstracts.CountryDAO;
import com.mc_es.worldDataBase.entities.concretes.Country;

@Repository
public class HibernateCountryDAO implements CountryDAO {

	private EntityManager entityManager;
	private Session session;

	@Autowired
	public HibernateCountryDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.session = this.entityManager.unwrap(Session.class);
	}

	@Override
	@Transactional
	public List<Country> getCountries() {
		List<Country> countries = this.session.createQuery("FROM Country", Country.class).getResultList();
		return countries;
	}

	@Override
	@Transactional
	public void insert(Country country) {
		this.session.saveOrUpdate(country);
	}

	@Override
	@Transactional
	public void update(Country country) {
		this.session.saveOrUpdate(country);
	}

	@Override
	@Transactional
	public void delete(Country country) {
		Country deleteCountry = this.session.get(Country.class, country.getCountryId());
		this.session.delete(deleteCountry);
	}

	@Override
	@Transactional
	public Country getById(int id) {
		Country country = this.session.get(Country.class, id);
		return country;
	}

	@Override
	@Transactional
	public List<Country> getCountriesOrderBy() {
		List<Country> countries = this.session.createQuery("FROM Country ORDER BY Country_name", Country.class).getResultList();
		return countries;
	}
}
