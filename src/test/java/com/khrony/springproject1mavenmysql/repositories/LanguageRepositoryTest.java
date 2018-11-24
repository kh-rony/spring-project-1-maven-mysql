package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.SimpleSearchApplication;
import com.khrony.springproject1mavenmysql.models.Language;
import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SimpleSearchApplication.class)
@WebAppConfiguration
public class LanguageRepositoryTest
{
	@Autowired
	public LanguageRepository languageRepository;

	@Test
	public void findByEmailTest()
	{
		Language l1 = new Language("Bangla");
		Language l2 = new Language("English");
		Language l3 = new Language("Japanese");
		Language l4 = new Language("Arabic");
		Language l5 = new Language("Spanish");

		languageRepository.save(l1);
		languageRepository.save(l2);
		languageRepository.save(l3);
		languageRepository.save(l4);
		languageRepository.save(l5);


		List<Language> languageList = languageRepository.findAll();

		for( Language language : languageList )
		{
			System.out.println(language);
		}
	}
}
