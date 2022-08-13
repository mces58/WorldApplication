/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.restApi.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc_es.worldDataBase.business.abstracts.CityService;
import com.mc_es.worldDataBase.entities.concretes.City;
import com.mc_es.worldDataBase.restApi.abstracts.CityOperations;

@RestController
@RequestMapping(value = "/apiCities", method = RequestMethod.GET)
public class CityController implements CityOperations {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping(value = "/getCities")
	public List<City> getCities() {
		return this.cityService.getCities();
	}

	@PostMapping(value = "/insert")
	public void insert(@RequestBody City city) {
		this.cityService.insert(city);
	}

	@PostMapping(value = "/update")
	public void update(@RequestBody City city) {
		this.cityService.update(city);
	}

	@PostMapping(value = "/delete")
	public void delete(@RequestBody City city) {
		this.cityService.delete(city);
	}

	@GetMapping(value = "/getCities/{cityId}")
	public City getById(@PathVariable(value = "cityId") int id) {
		return this.cityService.getById(id);
	}

	@GetMapping(value = "getCities/orderBy")
	public List<City> getCitiesOrderBy() {
		return this.cityService.getCitiesOrderBy();
	}
}
