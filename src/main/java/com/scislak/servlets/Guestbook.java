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
		
		out.println(GeneratorHTML.preHtml());
		
		out.println("<form action = \"guestbook\" method = \"POST\">\r\n" + 
				"         First Name: <input type = \"text\" name = \"first_name\">\r\n" + 
				"         <br />\r\n" + 
				"         Last Name: <input type = \"text\" name = \"last_name\" />\r\n" +
				"         <br />\r\n" + 
				"         Pseudonim: <input type = \"text\" name = \"nick\" />\r\n" +
				"         <br />\r\n" + 
				"         <input type = \"submit\" value = \"Submit\" />\r\n" + 
				"         <br />\r\n" + 
				"         <br />\r\n" + 
				"         <br />\r\n" + 
				"      </form>");
		
		for(int i = 0; i < LocalDataBase.getSizeGuest(); i++) {
			Guest guest = LocalDataBase.getGuest(i);
			out.println("<div style=\"border-style: solid; border-width: 2px 10px 4px 20px;\">");
			out.println("<h3>" + guest.getFirst_name() + " " + guest.getLast_name() + "</h3>");
			out.println("<h3>" + guest.getNick() + "</h3>");
			out.println("</div><br>");
		}
		out.println(GeneratorHTML.postHtml());
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String nick = req.getParameter("nick");
		
		InsertIntoTable.insertGuest(first_name, last_name, nick);
		
		doGet(req, res);
	}	
}
