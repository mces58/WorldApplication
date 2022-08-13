/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc_es.worldDataBase.business.abstracts.LanguageService;
import com.mc_es.worldDataBase.dataAccess.abstracts.LanguageDAO;
import com.mc_es.worldDataBase.entities.concretes.Language;

@Service(value = "LanguageManager")
public class LanguageManager implements LanguageService {

	private LanguageDAO languageDao;

	@Autowired
	public LanguageManager(LanguageDAO languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	@Transactional
	public List<Language> getLanguages() {
		return this.languageDao.getLanguages();
	}

	@Override
	@Transactional
	public void insert(Language language) {
		this.languageDao.insert(language);
	}

	@Override
	@Transactional
	public void update(Language language) {
		this.languageDao.update(language);
	}

	@Override
	@Transactional
	public void delete(Language language) {
		this.languageDao.delete(language);
	}

	@Override
	@Transactional
	public Language getById(int id) {
		return this.languageDao.getById(id);
	}

	@Override
	@Transactional
	public List<Language> getLanguagesOrderBy() {
		return this.languageDao.getLanguagesOrderBy();
	}
}
