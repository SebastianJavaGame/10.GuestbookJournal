package com.scislak.database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateMySqlDataBase extends MySqlDataBase{

	@Override
	protected void queryDB(Statement stmt, String sql) throws SQLException {
		stmt.executeUpdate(sql);
	}

}
