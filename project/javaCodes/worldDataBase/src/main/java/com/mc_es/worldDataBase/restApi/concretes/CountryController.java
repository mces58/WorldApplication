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

import com.mc_es.worldDataBase.business.abstracts.CountryService;
import com.mc_es.worldDataBase.entities.concretes.Country;
import com.mc_es.worldDataBase.restApi.abstracts.CountryOperations;

@RestController
@RequestMapping(value = "/apiCountries", method = RequestMethod.GET)
public class CountryController implements CountryOperations{
	 
	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping(value = "/getCountries")
	public List<Country> getCountries(){
		return this.countryService.getCountries();
	}
	
	@PostMapping(value = "/insert")
	public void insert(@RequestBody Country country) {
		this.countryService.insert(country);
	}
	
	@PostMapping(value = "/update")
	public void update(@RequestBody Country country) {
		this.countryService.update(country);
	}
	
	@PostMapping(value = "/delete")
	public void delete(@RequestBody Country country) {
		this.countryService.delete(country);
	}
	
	@GetMapping(value = "/getCountries/{countryId}")
	public Country getById(@PathVariable(value = "countryId") int id) {
		return this.countryService.getById(id);
	}
	
	@GetMapping(value = "/getCountries/orderBy")
	public List<Country> getCountriesOrderBy(){
		return this.countryService.getCountriesOrderBy();
	}
}
