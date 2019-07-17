package com.scislak.database;

public class Guest {
	private String first_name;
	private String last_name;
	private String nick;
	
	public Guest(String first_name, String last_name, String nick) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.nick = nick;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
}
