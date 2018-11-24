package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.SimpleSearchApplication;
import com.khrony.springproject1mavenmysql.models.Developer;
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
public class DeveloperRepositoryTest
{
	@Autowired
	public DeveloperRepository developerRepository;

	@Test
	public void findByEmailTest()
	{
		Developer developer1 = new Developer("dev1@gmail.com");
		Developer developer2 = new Developer("dev2@gmail.com");
		Developer developer3 = new Developer("dev3@gmail.com");
		Developer developer4 = new Developer("dev4@gmail.com");
		Developer developer5 = new Developer("dev5@gmail.com");

		developerRepository.save(developer1);
		developerRepository.save(developer2);
		developerRepository.save(developer3);
		developerRepository.save(developer4);
		developerRepository.save(developer5);


		List<Developer> developerList = developerRepository.findAll();

		for( Developer developer : developerList )
		{
			System.out.println(developer);
		}
	}
}
