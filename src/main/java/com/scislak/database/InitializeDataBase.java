package com.scislak.database;

public class InitializeDataBase {
	private static InitializeDataBase instance = null;
	
	private InitializeDataBase() {
		init();
	}
	
	public static InitializeDataBase getInstance() {
		if(instance == null)
			instance = new InitializeDataBase();
		return instance;
	}
	
	private void init() {
		MySqlDataBase db = new CreateMySqlDataBase();
		db.executeDataBase("CREATE DATABASE IF NOT EXISTS FORUM");
		MySqlDataBase.setSelectedDB("FORUM");
		
		db.executeDataBase("CREATE TABLE IF NOT EXISTS GUESTBOOK " +
				   "(id INTEGER not NULL AUTO_INCREMENT, " + 
				   " first_name VARCHAR(255), " + 
				   " last_name VARCHAR(255), " + 
				   " nick VARCHAR(255), " + 
				   " PRIMARY KEY ( id ))");
		
		db.executeDataBase("CREATE TABLE IF NOT EXISTS VOICE " +
				   "(id INTEGER not NULL AUTO_INCREMENT, " + 
				   " id_guest INTEGER NOT NULL, " + 
				   " description TEXT, " + 
				   " date DATETIME, " + 
				   " PRIMARY KEY ( id ))");
		
		db.executeDataBase("CREATE TABLE IF NOT EXISTS COMMENT " +
				   "(id INTEGER not NULL AUTO_INCREMENT, " + 
				   " id_guest INTEGER NOT NULL, " + 
				   " id_voice INTEGER NOT NULL," +
				   " description TEXT, " + 
				   " date DATETIME, " + 
				   " PRIMARY KEY ( id ))");
	}
}
