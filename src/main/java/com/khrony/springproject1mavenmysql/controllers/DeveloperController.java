package com.khrony.springproject1mavenmysql.controllers;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public String showSearchResultPage(@RequestParam("selectedOnlyProgrammingLanguages[]") List<String> selectedProgrammingLanguages)
	{
		System.out.println(selectedProgrammingLanguages);

		List<ProgrammingLanguage> programmingLanguageList = new ArrayList<>();
		ProgrammingLanguage programmingLanguage;

		Set<Developer> developerSet = new HashSet<Developer>(0);

		for( String string : selectedProgrammingLanguages )
		{
			programmingLanguage = programmingLanguageRepository.findByNameIgnoreCase(string);
			programmingLanguageList.add(programmingLanguage);
			developerSet.addAll(programmingLanguage.getDeveloperSet());
		}

		System.out.println(developerSet);

		return "search-result";
	}

	@RequestMapping(value = "/search-developer-who-can-write-and-speak", method = RequestMethod.POST)
	public String showSearchResultPage(@RequestParam("selectedProgrammingLanguages[]") List<String> selectedProgrammingLanguages, @RequestParam("selectedLanguages[]") List<String> selectedLanguages)
	{
		System.out.println(selectedProgrammingLanguages);
		System.out.println(selectedLanguages);

		return "search-result";
	}
}