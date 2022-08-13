/**
 * @author mc_es
 *
 */
package com.mc_es.worldDataBase.restApi.abstracts;

import java.util.List;

import com.mc_es.worldDataBase.entities.concretes.Language;

public interface LanguageOperations {
	List<Language> getLanguages();

	void insert(Language language);

	void update(Language language);

	void delete(Language language);

	Language getById(int id);

	List<Language> getLanguagesOrderBy();
}
