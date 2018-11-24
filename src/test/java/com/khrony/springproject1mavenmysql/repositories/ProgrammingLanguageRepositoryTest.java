package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.SimpleSearchApplication;
import com.khrony.springproject1mavenmysql.models.Developer;
import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SimpleSearchApplication.class)
@WebAppConfiguration
public class ProgrammingLanguageRepositoryTest
{
	@Autowired
	public ProgrammingLanguageRepository programmingLanguageRepository;

	@Test
	public void findByEmailTest()
	{
		ProgrammingLanguage pl1 = new ProgrammingLanguage("Java");
		ProgrammingLanguage pl2 = new ProgrammingLanguage("python");
		ProgrammingLanguage pl3 = new ProgrammingLanguage("Go");
		ProgrammingLanguage pl4 = new ProgrammingLanguage("ruby");
		ProgrammingLanguage pl5 = new ProgrammingLanguage("JavaScript");

		programmingLanguageRepository.save(pl1);
		programmingLanguageRepository.save(pl2);
		programmingLanguageRepository.save(pl3);
		programmingLanguageRepository.save(pl4);
		programmingLanguageRepository.save(pl5);


		List<ProgrammingLanguage> programmingLanguageList = programmingLanguageRepository.findAll();

		for( ProgrammingLanguage pl : programmingLanguageList )
		{
			System.out.println(pl);
		}
	}
}
