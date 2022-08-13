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

import com.mc_es.worldDataBase.business.abstracts.LanguageService;
import com.mc_es.worldDataBase.entities.concretes.Language;
import com.mc_es.worldDataBase.restApi.abstracts.LanguageOperations;

@RestController
@RequestMapping(value = "/apiLanguages", method = RequestMethod.GET)
public class LanguageController implements LanguageOperations {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping(value = "/getLanguages")
	public List<Language> getLanguages() {
		return this.languageService.getLanguages();
	}

	@PostMapping(value = "/insert")
	public void insert(@RequestBody Language language) {
		this.languageService.insert(language);
	}

	@PostMapping(value = "/update")
	public void update(@RequestBody Language language) {
		this.languageService.update(language);
	}

	@PostMapping(value = "/delete")
	public void delete(@RequestBody Language language) {
		this.languageService.delete(language);
	}

	@GetMapping(value = "/getLanguages/{languageId}")
	public Language getById(@PathVariable(value = "languageId") int id) {
		return this.languageService.getById(id);
	}

	@GetMapping(value = "/getLanguages/orderBy")
	public List<Language> getLanguagesOrderBy() {
		return this.languageService.getLanguagesOrderBy();
	}
}
