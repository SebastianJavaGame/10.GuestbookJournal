package com.scislak.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadMySqlDataBase extends MySqlDataBase{
	
	private ResultSet rs;
	
	@Override
	protected void queryDB(Statement stmt, String sql) throws SQLException {
		rs = stmt.executeQuery(sql);
		
		switch(InitLocalDataBase.getSelectedTable()) {
		case GUESTBOOK:
			loadFromGuestbook();
			break;
		case VOICE:
			loadFromVoice();
			break;
		case COMMENT:
			loadFromComment();
			break;
	}
	}
	
	private void loadFromGuestbook() {
		try {
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String nick = rs.getString("nick");
				Guest guest = new Guest(first_name, last_name, nick);
				LocalDataBase.addGuest(guest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadFromVoice() {
	}
	
	private void loadFromComment() {
	}
}
