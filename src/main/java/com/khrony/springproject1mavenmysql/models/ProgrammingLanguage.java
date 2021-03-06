package com.khrony.springproject1mavenmysql.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguage extends BaseModel<Long>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	public ProgrammingLanguage()
	{
		//
	}

	public ProgrammingLanguage(String name)
	{
		this.name = name;
	}


	@ManyToMany(mappedBy = "programmingLanguageSet")
	private Set<Developer> developerSet = new HashSet<Developer>(0);

	public Set<Developer> getDeveloperSet()
	{
		return this.developerSet;
	}

	public void setDeveloperSet(Set<Developer> developerSet)
	{
		this.developerSet = developerSet;
	}


	@Override
	public Long getID()
	{
		return id;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "ProgrammingLanguage [id = " + id + ", name = " + name + "]";
	}
}