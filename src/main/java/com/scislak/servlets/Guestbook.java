package com.scislak.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scislak.database.CreateMySqlDataBase;

public class Guestbook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		CreateMySqlDataBase.createDataBase("FORUM");
		
		out.println("Hello World");
		out.println(CreateMySqlDataBase.getDataBaseName());
	}
	
}
