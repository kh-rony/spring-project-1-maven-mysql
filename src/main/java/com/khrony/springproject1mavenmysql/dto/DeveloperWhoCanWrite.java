package com.khrony.springproject1mavenmysql.dto;

import java.util.List;

public class DeveloperWhoCanWrite
{
	private String email;
	private List<String> programmingLanguageList;

	public DeveloperWhoCanWrite(String email, List<String> programmingLanguageList)
	{
		this.email = email;
		this.programmingLanguageList = programmingLanguageList;
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
}
