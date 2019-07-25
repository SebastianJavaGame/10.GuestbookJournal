package com.scislak.database;

import java.sql.Date;
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
			e.printStackTrace();
		}
	}
	
	private void loadFromVoice() {
		try {
			while(rs.next()) {
				int idGuest = rs.getInt("id_guest");
				String description = rs.getString("description");
				Date date = rs.getDate("date");
				Sentence sentence = new Sentence(idGuest, description, date);
				LocalDataBase.addSentence(sentence);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFromComment() {
		try {
			while(rs.next()) {
				int idGuest = rs.getInt("id_guest");
				int idVoice = rs.getInt("id_voice");
				String description = rs.getString("description");
				Date date = rs.getDate("date");
				Comment comment = new Comment(idGuest, idVoice, description, date);
				LocalDataBase.addComment(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
