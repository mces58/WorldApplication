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

import com.mc_es.worldDataBase.dataAccess.abstracts.CityDAO;
import com.mc_es.worldDataBase.entities.concretes.City;

@Repository
public class HibernateCityDAO implements CityDAO {

	private EntityManager entityManager;
	private Session session;

	@Autowired
	public HibernateCityDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.session = this.entityManager.unwrap(Session.class);
	}

	@Override
	@Transactional
	public List<City> getCities() {
		List<City> cities = this.session.createQuery("FROM City", City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void insert(City city) {
		this.session.saveOrUpdate(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.session.saveOrUpdate(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		City deleteCity = this.session.get(City.class, city.getCityId());
		this.session.delete(deleteCity);
	}

	@Override
	@Transactional
	public City getById(int id) {
		City city = session.get(City.class, id);
		return city;
	}

	@Override
	@Transactional
	public List<City> getCitiesOrderBy() {
		List<City> cities = session.createQuery("FROM City ORDER BY Country_code, City_name", City.class).getResultList();
		return cities;
	}
}
