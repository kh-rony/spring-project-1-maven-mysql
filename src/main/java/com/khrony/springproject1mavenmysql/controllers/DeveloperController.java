package com.khrony.springproject1mavenmysql.controllers;

import com.khrony.springproject1mavenmysql.dto.DeveloperWhoCanWrite;
import com.khrony.springproject1mavenmysql.dto.DeveloperWhoCanWriteAndSpeak;
import com.khrony.springproject1mavenmysql.models.Developer;
import com.khrony.springproject1mavenmysql.models.Language;
import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
import com.khrony.springproject1mavenmysql.repositories.DeveloperRepository;
import com.khrony.springproject1mavenmysql.repositories.LanguageRepository;
import com.khrony.springproject1mavenmysql.repositories.ProgrammingLanguageRepository;
import com.khrony.springproject1mavenmysql.services.DeveloperService;
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

	private DeveloperService developerService = new DeveloperService();


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
		List<Developer> developerList = developerRepository.findAll();
		List<DeveloperWhoCanWrite> developerWhoCanWriteList = new ArrayList<>();

		List<String> programmingLanguageStringsOfDeveloper = new ArrayList<>();


		for(Developer developer : developerList)
		{
			programmingLanguageStringsOfDeveloper.clear();
			programmingLanguageStringsOfDeveloper.addAll(developerService.findProgrammingLanguageNameStringListFromSetOfObjects(developer.getProgrammingLanguageSet()));

			if( programmingLanguageStringsOfDeveloper.containsAll(selectedProgrammingLanguages) )
			{
				developerWhoCanWriteList.add(new DeveloperWhoCanWrite(developer.getEmail(), new ArrayList<String>(programmingLanguageStringsOfDeveloper)));
			}
		}

		model.addAttribute("developerWhoCanWriteList", developerWhoCanWriteList);

		return "developers-who-can-write";
	}

	@RequestMapping(value = "/search-developer-who-can-write-and-speak", method = RequestMethod.POST)
	public String showSearchResultPage(
			@RequestParam("selectedProgrammingLanguages[]") List<String> selectedProgrammingLanguages,
			@RequestParam("selectedLanguages[]") List<String> selectedLanguages,
			Model model)
	{
		List<Developer> developerList = developerRepository.findAll();
		List<DeveloperWhoCanWriteAndSpeak> developerWhoCanWriteAndSpeakList = new ArrayList<>();

		List<String> programmingLanguageStringsOfDeveloper = new ArrayList<>();
		List<String> languageStringsOfDeveloper = new ArrayList<>();

		DeveloperWhoCanWriteAndSpeak developerWhoCanWriteAndSpeak;
		boolean flag1;
		boolean flag2;


		for(Developer developer : developerList)
		{
			developerWhoCanWriteAndSpeak = new DeveloperWhoCanWriteAndSpeak();
			flag1 = false;
			flag2 = false;

			programmingLanguageStringsOfDeveloper.clear();
			programmingLanguageStringsOfDeveloper.addAll(developerService.findProgrammingLanguageNameStringListFromSetOfObjects(developer.getProgrammingLanguageSet()));

			if( programmingLanguageStringsOfDeveloper.containsAll(selectedProgrammingLanguages) )
			{
				flag1 = true;
				developerWhoCanWriteAndSpeak.setEmail(developer.getEmail());
				developerWhoCanWriteAndSpeak.setProgrammingLanguageList(new ArrayList<String>(programmingLanguageStringsOfDeveloper));
			}

			languageStringsOfDeveloper.clear();
			languageStringsOfDeveloper.addAll(developerService.findLanguageNameStringListFromSetOfObjects(developer.getLanguageSet()));

			if( languageStringsOfDeveloper.containsAll(selectedLanguages) )
			{
				flag2 = true;
				developerWhoCanWriteAndSpeak.setLanguageList(new ArrayList<String>(languageStringsOfDeveloper));
			}

			if( flag1 && flag2 )
			{
				developerWhoCanWriteAndSpeakList.add(developerWhoCanWriteAndSpeak);
			}
		}

		model.addAttribute("developerWhoCanWriteAndSpeakList", developerWhoCanWriteAndSpeakList);

		return "developers-who-can-write-and-speak";
	}

	@RequestMapping(value = "/all-developers", method = RequestMethod.GET)
	public String showAllDevelopersPage(Model model)
	{
		List<Developer> developerList = developerRepository.findAll();
		List<DeveloperWhoCanWriteAndSpeak> developerWhoCanWriteAndSpeakList = new ArrayList<>();

		List<String> programmingLanguageStringsOfDeveloper = new ArrayList<>();
		List<String> languageStringsOfDeveloper = new ArrayList<>();

		DeveloperWhoCanWriteAndSpeak developerWhoCanWriteAndSpeak;


		for(Developer developer : developerList)
		{
			developerWhoCanWriteAndSpeak = new DeveloperWhoCanWriteAndSpeak();

			programmingLanguageStringsOfDeveloper.clear();
			languageStringsOfDeveloper.clear();

			for( ProgrammingLanguage pl : developer.getProgrammingLanguageSet() )
			{
				programmingLanguageStringsOfDeveloper.add(pl.getName());
			}
			for( Language l : developer.getLanguageSet() )
			{
				languageStringsOfDeveloper.add(l.getName());
			}

			developerWhoCanWriteAndSpeak.setEmail(developer.getEmail());
			developerWhoCanWriteAndSpeak.setProgrammingLanguageList(new ArrayList<String>(programmingLanguageStringsOfDeveloper));
			developerWhoCanWriteAndSpeak.setLanguageList(new ArrayList<String>(languageStringsOfDeveloper));

			developerWhoCanWriteAndSpeakList.add(developerWhoCanWriteAndSpeak);
		}

		model.addAttribute("developerWhoCanWriteAndSpeakList", developerWhoCanWriteAndSpeakList);

		return "all-developers";
	}

	@RequestMapping(value = "/seed", method = RequestMethod.GET)
	public String seedDB(Model model)
	{
		return "all-developers";
	}
}