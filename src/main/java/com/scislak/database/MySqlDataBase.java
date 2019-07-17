package com.scislak.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySqlDataBase {
	private static final String DB = "jdbc:mysql://localhost:3306/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static String user = "root";
	private static String password = "root";
	
	private static String selectedDB;
	
	private static Connection conn = null;
	private static Statement stmt = null;

	protected abstract void queryDB(Statement stmt, String sql) throws SQLException;
	
	public void executeDataBase(String sql) {
		try {
			Class.forName(DRIVER);
			System.out.println("connecting...");
			conn = DriverManager.getConnection(DB + getSelectedDB(), user, password);
			stmt = conn.createStatement();
			
			queryDB(stmt, sql);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	
	public static void setSelectedDB(String selectedDB) {
		MySqlDataBase.selectedDB = selectedDB;
	}
	
	public static String getSelectedDB() {
		if(selectedDB == null || selectedDB.isEmpty())
			return "";
		return selectedDB;
	}
}
