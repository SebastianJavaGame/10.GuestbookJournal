package com.scislak.database;

public class InitLocalDataBase {
	
	public enum Tables {GUESTBOOK, VOICE, COMMENT};
	private static Tables selectedTable;
	
	private static InitLocalDataBase instance = null;
	
	private InitLocalDataBase() {
		db = new LoadMySqlDataBase();
		MySqlDataBase.setSelectedDB("FORUM");
		selectedTable = Tables.GUESTBOOK;
	}
	
	public static InitLocalDataBase getInstance() {
		if(instance == null)
			instance = new InitLocalDataBase();
		return instance;
	}
	
	private static LoadMySqlDataBase db;
	
	public static void loadLocalDataBaseFromDataBase(Tables table) {
		selectedTable = table;
		switch(table) {
			case GUESTBOOK:
				db.executeDataBase("SELECT * FROM GUESTBOOK");
				break;
			case VOICE:
				db.executeDataBase("SELECT * FROM VOICE");
				break;
			case COMMENT:
				db.executeDataBase("SELECT * FROM COMMENT");
				break;
		}
	}
	
	public static Tables getSelectedTable() {
		return selectedTable;
	}
}
