package com.scislak.database;

import java.sql.Date;

public class Comment {
	private int id_guest;
	private int idSentence;
	private String description;
	private Date creationDate;
	
	public Comment(int id_guest, int idSentence, String description, Date creationDate) {
		this.id_guest = id_guest;
		this.idSentence = idSentence;
		this.description = description;
		this.creationDate = creationDate;
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
	
	public void setIdGuest(int id_guest) {
		this.id_guest = id_guest;
	}
	
	public int getIDGuest() {
		return id_guest;
	}

	public int getIdSentence() {
		return idSentence;
	}
}
