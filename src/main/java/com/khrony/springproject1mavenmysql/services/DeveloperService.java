package com.khrony.springproject1mavenmysql.services;

import com.khrony.springproject1mavenmysql.models.Language;
import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DeveloperService
{
	public List<String> findProgrammingLanguageNameStringListFromSetOfObjects(Set<ProgrammingLanguage> programmingLanguageSet)
	{
		List<String> stringList = new ArrayList<>();

		for( ProgrammingLanguage pl : programmingLanguageSet )
		{
			stringList.add(pl.getName());
		}

		return stringList;
	}

	public List<String> findLanguageNameStringListFromSetOfObjects(Set<Language> languageSet)
	{
		List<String> stringList = new ArrayList<>();

		for( Language l : languageSet )
		{
			stringList.add(l.getName());
		}

		return stringList;
	}
}
