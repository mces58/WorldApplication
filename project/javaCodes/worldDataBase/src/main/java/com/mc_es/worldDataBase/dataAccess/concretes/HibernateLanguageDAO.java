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

import com.mc_es.worldDataBase.dataAccess.abstracts.LanguageDAO;
import com.mc_es.worldDataBase.entities.concretes.Language;

@Repository
public class HibernateLanguageDAO implements LanguageDAO {

	private EntityManager entityManager;
	private Session session;

	@Autowired
	public HibernateLanguageDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.session = this.entityManager.unwrap(Session.class);
	}

	@Override
	@Transactional
	public List<Language> getLanguages() {
		List<Language> languages = this.session.createQuery("FROM Language", Language.class).getResultList();
		return languages;
	}

	@Override
	@Transactional
	public void insert(Language language) {
		this.session.saveOrUpdate(language);
	}

	@Override
	@Transactional
	public void update(Language language) {
		this.session.saveOrUpdate(language);
	}

	@Override
	@Transactional
	public void delete(Language language) {
		Language deleteLanguage = this.session.get(Language.class, language.getLanguageId());
		this.session.delete(deleteLanguage);
	}

	@Override
	@Transactional
	public Language getById(int id) {
		Language language = this.session.get(Language.class, id);
		return language;
	}

	@Override
	@Transactional
	public List<Language> getLanguagesOrderBy() {
		List<Language> languages = this.session.createQuery("FROM Language ORDER BY 4", Language.class).getResultList();
		return languages;
	}
}
