package com.scislak.database;

import java.sql.Date;

public class InsertIntoTable {
	private static InsertIntoTable instance = null;
	
	private InsertIntoTable() {
		db = new AddMySqlDataBase();
		MySqlDataBase.setSelectedDB("FORUM");
	}
	
	public static InsertIntoTable getInstance() {
		if(instance == null)
			instance = new InsertIntoTable();
		return instance;
	}
	
	private static MySqlDataBase db;
	
	public static void insertGuest(String first_name, String last_name, String nick) {
		db.executeDataBase("INSERT INTO GUESTBOOK VALUES(NULL, '" + first_name + "', '" + last_name + "', '" + nick + "')");
		LocalDataBase.addGuest(new Guest(first_name, last_name, nick));
	}
	
	public static void insertSentence(int id_guest, String description, Date date) {
		db.executeDataBase("INSERT INTO VOICE VALUES(NULL, '" + id_guest + "', '" + description + "', '" + date + "')");
		LocalDataBase.addSentence(new Sentence(id_guest, description, date));
	}

	public static void insertComment(int id_guest, int id_voice, String description, Date date) {
		db.executeDataBase("INSERT INTO VOICE VALUES(NULL, '" + id_guest + "', '" + id_voice + "', '" + description + "', '" + date + "')");
	}
}
