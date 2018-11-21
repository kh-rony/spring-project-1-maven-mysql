package com.khrony.springproject1mavenmysql.models;

import javax.persistence.*;

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

	public Developer(Long id, String email)
	{
		this.id = id;
		this.email = email;
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
		return "Developer [id=" + id + ", email=" + email + "]";
	}
}