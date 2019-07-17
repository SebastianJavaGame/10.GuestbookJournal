package com.scislak.database;

import java.sql.Date;

public class Sentence {
	private int idGuest;
	private String description;
	private Date creationDate;
	
	public Sentence(int idGuest, String description, Date creationDate) {
		this.idGuest = idGuest;
		this.description = description;
		this.creationDate = creationDate;
	}

	public int getIdGuest() {
		return idGuest;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
