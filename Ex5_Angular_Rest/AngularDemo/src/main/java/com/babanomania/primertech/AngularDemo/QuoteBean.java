package com.babanomania.primertech.AngularDemo;

public class QuoteBean {

	private String quote;
	private String type;
	
	public QuoteBean( String pQuote, String pType ) {
		this.quote = pQuote;
		this.type = pType;
	}
	
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
