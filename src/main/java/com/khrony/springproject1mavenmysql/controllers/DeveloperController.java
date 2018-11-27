package com.khrony.springproject1mavenmysql.controllers;

import com.khrony.springproject1mavenmysql.dto.DeveloperWhoCanWrite;
import com.khrony.springproject1mavenmysql.models.Developer;
import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
import com.khrony.springproject1mavenmysql.repositories.DeveloperRepository;
import com.khrony.springproject1mavenmysql.repositories.LanguageRepository;
import com.khrony.springproject1mavenmysql.repositories.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperController
{
	@Autowired
	private DeveloperRepository developerRepository;

	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	private LanguageRepository languageRepository;


	@RequestMapping("/")
	public String showHomePage()
	{
		return "home";
	}

	@RequestMapping(value = "/search-developer", method = RequestMethod.GET)
	public String showSearchDeveloperPage(Model model)
	{
		model.addAttribute("programmingLanguages", programmingLanguageRepository.findAll());
		model.addAttribute("languages", languageRepository.findAll());

		return "search-developer";
	}

	@RequestMapping(value = "/search-developer-who-can-write", method = RequestMethod.POST)
	public String showSearchResultPage(@RequestParam("selectedOnlyProgrammingLanguages[]") List<String> selectedProgrammingLanguages, Model model)
	{
		System.out.println(selectedProgrammingLanguages);

		List<Developer> developerList = developerRepository.findAll();
		List<DeveloperWhoCanWrite> developerWhoCanWriteList = new ArrayList<>();

		List<String> programmingLanguageStringsOfDeveloper = new ArrayList<>();


		for(Developer developer : developerList)
		{
			programmingLanguageStringsOfDeveloper.clear();

			for( ProgrammingLanguage pl : developer.getProgrammingLanguageSet() )
			{
				programmingLanguageStringsOfDeveloper.add(pl.getName());
			}


			if( programmingLanguageStringsOfDeveloper.containsAll(selectedProgrammingLanguages) )
			{
				developerWhoCanWriteList.add(new DeveloperWhoCanWrite(developer.getEmail(), selectedProgrammingLanguages));
			}
		}

		model.addAttribute("developerWhoCanWriteList", developerWhoCanWriteList);

		return "developers-who-can-write";
	}

	@RequestMapping(value = "/search-developer-who-can-write-and-speak", method = RequestMethod.POST)
	public String showSearchResultPage(@RequestParam("selectedProgrammingLanguages[]") List<String> selectedProgrammingLanguages, @RequestParam("selectedLanguages[]") List<String> selectedLanguages)
	{
		System.out.println(selectedProgrammingLanguages);
		System.out.println(selectedLanguages);

		return "developers-who-can-write-and-speak";
	}
}