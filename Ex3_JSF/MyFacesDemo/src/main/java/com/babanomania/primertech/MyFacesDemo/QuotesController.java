package com.babanomania.primertech.MyFacesDemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "quotes")
@RequestScoped
public class QuotesController {

	private String quoteTxt = null;
	private String quoteType = null;

	private static Map<String, String> allQuoteTypes = new HashMap<String, String>();
	
	static{
		init();
	}
	
	public QuotesController() throws Exception {
		
		QuotesDB quotesDb = QuotesDB.getInstance();
		
		if( quoteType == null ){
    		Set<String> allTypes = quotesDb.getAllTypes();
    		Iterator<String> iter = allTypes.iterator();
    		quoteType = iter.next();
    	}
		

    	quoteTxt = quotesDb.getAllQuotes().get(quoteType);
	}
	
	private static void init() {
		
		try
		{
			QuotesDB quotesDb = QuotesDB.getInstance();
			Set<String> allTypes = quotesDb.getAllTypes();
		
			for (String aQuoteType : allTypes)
				allQuoteTypes.put(aQuoteType, aQuoteType);
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getQuoteTxt() {
		return quoteTxt;
	}
	public void setQuoteTxt(String quoteTxt) {
		this.quoteTxt = quoteTxt;
	}
	public String getQuoteType() {
		return quoteType;
	}
	public void setQuoteType(String quoteType) {
		this.quoteType = quoteType;
	}
	
    public String getQuote() throws IOException
    {
    	QuotesDB quotesDb = QuotesDB.getInstance();
    	
    	if( quoteType == null ){
    		Set<String> allTypes = quotesDb.getAllTypes();
    		Iterator<String> iter = allTypes.iterator();
    		quoteType = iter.next();
    	}
    	
    	quoteTxt = quotesDb.getAllQuotes().get(quoteType);
        return "quotes.xhtml";
    }
    
	public Map<String, String> getAllQuoteTypes() {
		return allQuoteTypes;
	}

}
