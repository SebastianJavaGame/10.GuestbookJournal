package com.scislak.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scislak.database.Comment;
import com.scislak.database.Guest;
import com.scislak.database.InitLocalDataBase;
import com.scislak.database.InitializeDataBase;
import com.scislak.database.InsertIntoTable;
import com.scislak.database.LocalDataBase;
import com.scislak.database.Sentence;
import com.scislak.database.InitLocalDataBase.Tables;

public class Forum extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("Init server");
		InitializeDataBase.getInstance();
		InsertIntoTable.getInstance();
		InitLocalDataBase.getInstance();
		InitLocalDataBase.loadLocalDataBaseFromDataBase(Tables.COMMENT);
		InitLocalDataBase.loadLocalDataBaseFromDataBase(Tables.VOICE);
		InitLocalDataBase.loadLocalDataBaseFromDataBase(Tables.GUESTBOOK);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println(GeneratorHTML.preHtml());
		
		out.println("<form action = \"forum\" method = \"POST\">\r\n" + 
				"		  <textarea rows=\"4\" cols=\"50\" name=\"comment\"></textarea>\n" +
				"         <input type = \"submit\" value = \"Sentence\" />\r\n" + 
				" <input type = \"hidden\" name = \"isVoice\" value=\"true\"" +
				"    </form>");
		
		for(int i = 0; i < LocalDataBase.getSizeSentence(); i++) {
			Sentence sentence = LocalDataBase.getSentence(i);
			out.println("<div style=\"border-style: solid; border-width: 2px 10px 4px 20px;\">");
			out.println("<p>" + sentence.getDescription() + "</p>");
			out.println("<h5>" + LocalDataBase.getGuest(sentence.getIdGuest()-1).getNick() + " " + sentence.getCreationDate() + "</h5>");
			for(int j = 0; j < LocalDataBase.getSizeComment(); j++) {
				//or i+1
				if(i == LocalDataBase.getComment(j).getIdSentence()-1) {
					Comment comment = LocalDataBase.getComment(j);
					out.println("<div style=\"margin-left:50px; border-style: solid;\">");
					out.println("<p>" + comment.getDescription() + "</p>");
					out.println("<h5>" + LocalDataBase.getGuest(comment.getIDGuest()-1).getNick() + " " + comment.getCreationDate() + "</h5>");
					out.println("</div><br>");
				}
			}
			out.println("<form action = \"forum\" method = \"POST\">\r\n" + 
					"		  <textarea rows=\"4\" cols=\"50\" name=\"comment\"></textarea>\n" +
					"         <input type = \"submit\" value = \"Comment\" />\r\n" + 
					" <input type = \"hidden\" name = \"isVoice\" value=\"false\"" +
					" <input type = \"hidden\" name = \"numberSentence\" value=\"" + i+1 + "\"" +
					"    </form>");
			out.println("</div><br>");
		}
		out.println(GeneratorHTML.postHtml());
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String description = req.getParameter("comment");
		
		if(req.getParameter("isVoice").equals("true"))
			InsertIntoTable.insertSentence(1, description, new Date(Calendar.getInstance().getTimeInMillis()));
		else {
			int numberOfSentence = Integer.valueOf(req.getParameter("numberSentence"));
			InsertIntoTable.insertComment(1, numberOfSentence, description, new Date(Calendar.getInstance().getTimeInMillis()));
		}
		
		doGet(req, res);
	}
}
