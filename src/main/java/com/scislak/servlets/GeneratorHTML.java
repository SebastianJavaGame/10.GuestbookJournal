package com.scislak.servlets;

public class GeneratorHTML {
	
	public static String getGeneratedComment(String description) {
		return "";
	}
	
	public static String preHtml() {
		return "<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>Guestbook</title>\r\n" + 
				"	</head>\r\n" + 
				"	\r\n" + 
				"	<body>";
	}
	
	public static String postHtml() {
		return "</body>\r\n" + 
				"</html>";
	}
}
