package com.scislak.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scislak.database.Guest;
import com.scislak.database.InitLocalDataBase;
import com.scislak.database.InitializeDataBase;
import com.scislak.database.InsertIntoTable;
import com.scislak.database.LocalDataBase;
import com.scislak.database.InitLocalDataBase.Tables;

public class Guestbook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("Init server");
		InitializeDataBase.getInstance();
		InsertIntoTable.getInstance();
		InitLocalDataBase.getInstance();
		InitLocalDataBase.loadLocalDataBaseFromDataBase(Tables.GUESTBOOK);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		InsertIntoTable.insertGuest("Sebastian", "Scislak", "Protected300");
		
		out.println(preHtml());
		for(int i = 0; i < LocalDataBase.getSizeGuest(); i++) {
			Guest guest = LocalDataBase.getGuest(i);
			out.println("<div style=\"border-style: solid; border-width: 2px 10px 4px 20px;\">");
			out.println("<h3>" + guest.getFirst_name() + " " + guest.getLast_name() + "</h3>");
			out.println("<h3>" + guest.getNick() + "</h3>");
			out.println("</div><br>");
		}
		out.println(postHtml());
	}
	
	private String preHtml() {
		return "<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>Guestbook</title>\r\n" + 
				"	</head>\r\n" + 
				"	\r\n" + 
				"	<body>";
	}
	
	private String postHtml() {
		return "</body>\r\n" + 
				"</html>";
	}
	
}
