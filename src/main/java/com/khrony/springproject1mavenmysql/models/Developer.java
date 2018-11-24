package com.khrony.springproject1mavenmysql.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer extends BaseModel<Long>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	public Developer()
	{
		//
	}

	public Developer(String email)
	{
		this.email = email;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "developers_programming_languages", joinColumns = {@JoinColumn(name = "developer_id")}, inverseJoinColumns = {@JoinColumn(name = "programming_language_id")})

	private Set<ProgrammingLanguage> programmingLanguageSet = new HashSet<ProgrammingLanguage>(0);

	public Set<ProgrammingLanguage> getProgrammingLanguageSet()
	{
		return this.programmingLanguageSet;
	}

	public void setProgrammingLanguageSet(Set<ProgrammingLanguage> programmingLanguageSet)
	{
		this.programmingLanguageSet = programmingLanguageSet;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "developers_languages", joinColumns = {@JoinColumn(name = "developer_id")}, inverseJoinColumns = {@JoinColumn(name = "language_id")})

	private Set<Language> languageSet = new HashSet<Language>(0);

	public Set<Language> getLanguageSet()
	{
		return this.languageSet;
	}

	public void setLanguageSet(Set<Language> languageSet)
	{
		this.languageSet = languageSet;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Developer [id = " + id + ", email = " + email + "]";
	}
}