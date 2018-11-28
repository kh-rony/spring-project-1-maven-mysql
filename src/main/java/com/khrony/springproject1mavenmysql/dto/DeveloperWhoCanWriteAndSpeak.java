package com.khrony.springproject1mavenmysql.dto;

import java.util.List;

public class DeveloperWhoCanWriteAndSpeak
{
	private String email;
	private List<String> programmingLanguageList;
	private List<String> languageList;

	public DeveloperWhoCanWriteAndSpeak()
	{
		//
	}

	public DeveloperWhoCanWriteAndSpeak(String email, List<String> programmingLanguageList, List<String> languageList)
	{
		this.email = email;
		this.programmingLanguageList = programmingLanguageList;
		this.languageList = languageList;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<String> getProgrammingLanguageList()
	{
		return programmingLanguageList;
	}

	public void setProgrammingLanguageList(List<String> programmingLanguageList)
	{
		this.programmingLanguageList = programmingLanguageList;
	}

	public List<String> getLanguageList()
	{
		return languageList;
	}

	public void setLanguageList(List<String> languageList)
	{
		this.languageList = languageList;
	}
}
