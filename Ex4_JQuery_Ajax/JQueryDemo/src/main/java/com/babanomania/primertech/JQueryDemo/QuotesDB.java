package com.babanomania.primertech.JQueryDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class QuotesDB {

private Map<String, String> quotesByType = new HashMap<String, String>();
	
	public static String CONST = "123";
	public static QuotesDB _instance = null;
	
	private QuotesDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static QuotesDB getInstance() throws IOException {
		
		synchronized (CONST) {
		
			if( _instance == null ){
				_instance = new QuotesDB();
				_instance.init();
			}
		}
		
		return _instance;
	}
	
	private void init() throws IOException {
		
		ClassLoader classloader = this.getClass().getClassLoader();
		InputStream isQuotes = classloader.getResourceAsStream("quotes.properties");
		
		Properties propQuotes = new Properties();
		propQuotes.load(isQuotes);
		
		for (final String quoteType: propQuotes.stringPropertyNames()){
		
			String quote = propQuotes.getProperty(quoteType);
			quotesByType.put( quoteType, quote );
		}
	}
	
	public Map<String, String> getAllQuotes(){
		return quotesByType;
	}
	
	public Set<String> getAllTypes(){
		return quotesByType.keySet();
	}
	
	public String getQuote( String quoteType ){
		return quotesByType.get(quoteType);
	}
	
}
