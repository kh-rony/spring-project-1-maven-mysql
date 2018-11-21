package com.khrony.springproject1mavenmysql.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel<ID>
{
	@Version
	private Long version;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "last_modified_date", nullable = false)
	private Date lastModifiedDate;


	public abstract ID getID();

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate()
	{
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}

	@PrePersist
	public void prePersist()
	{
		this.createdDate = new Date();
		this.lastModifiedDate = new Date();
	}

	@PreUpdate
	public void preUpdate()
	{
		this.lastModifiedDate = new Date();
	}
}