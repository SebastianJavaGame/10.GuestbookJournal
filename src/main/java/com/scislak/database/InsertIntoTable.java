package com.scislak.database;

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
	
	public static void insertSentence() {
			
	}

	public static void insertComment() {
		
	}
}
