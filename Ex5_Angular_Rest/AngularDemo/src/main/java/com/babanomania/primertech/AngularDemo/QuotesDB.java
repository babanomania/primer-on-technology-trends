package com.babanomania.primertech.AngularDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class QuotesDB {

private Map<String, QuoteBean> quotesByType = new HashMap<String, QuoteBean>();
	
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
			QuoteBean qbData = new QuoteBean( quote, quoteType );
			quotesByType.put( quoteType, qbData );
		}
	}
	
	public Map<String, QuoteBean> getAllQuotes(){
		return quotesByType;
	}
	
	public Set<String> getAllTypes(){
		return quotesByType.keySet();
	}
	
	public QuoteBean getQuote( String quoteType ){
		return quotesByType.get(quoteType);
	}
	
}
