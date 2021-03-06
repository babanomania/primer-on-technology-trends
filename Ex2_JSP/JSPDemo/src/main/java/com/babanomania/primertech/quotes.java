package com.babanomania.primertech;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class quotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuotesDB quotes = QuotesDB.getInstance();
	    Map<String, String> quotesMap = quotes.getAllQuotes();
	    String[] types = quotes.getAllTypes();
	    
	    request.setAttribute("quotes", quotesMap); 
	    request.setAttribute("types", types); 
		
	    request.getRequestDispatcher("quotes.jsp").forward(request, response);
	}

}
