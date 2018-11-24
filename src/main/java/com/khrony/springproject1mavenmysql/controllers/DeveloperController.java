package com.khrony.springproject1mavenmysql.controllers;

import com.khrony.springproject1mavenmysql.dto.DeveloperSearchForm;
import com.khrony.springproject1mavenmysql.repositories.DeveloperRepository;
import com.khrony.springproject1mavenmysql.repositories.LanguageRepository;
import com.khrony.springproject1mavenmysql.repositories.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

	@RequestMapping(value = "/search-result", method = RequestMethod.POST)
	public String showSearchResultPage(@Valid DeveloperSearchForm developerSearchForm, BindingResult result, WebRequest request, RedirectAttributes redirectAttributes)
	{
		return "search-result";
	}
}
