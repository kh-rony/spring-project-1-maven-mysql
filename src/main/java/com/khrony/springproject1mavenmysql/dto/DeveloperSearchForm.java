package com.khrony.springproject1mavenmysql.dto;

public class DeveloperSearchForm
{
	private String[] programmingLanguages;
	private String[] languages;

	public String[] getProgrammingLanguages()
	{
		return programmingLanguages;
	}

	public void setProgrammingLanguages(String[] programmingLanguages)
	{
		this.programmingLanguages = programmingLanguages;
	}

	public String[] getLanguages()
	{
		return languages;
	}

	public void setLanguages(String[] languages)
	{
		this.languages = languages;
	}
}