
package com.babanomania.primertech.JQueryDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/quotes")
public class QuotesResource {
	
	@GET 
    @Path("{quoteType}")
    @Produces(MediaType.TEXT_HTML)
    public String getQuote( @PathParam("quoteType") String quoteType ) throws Exception {
		
		QuotesDB quotesDb = QuotesDB.getInstance();
		return quotesDb.getQuote(quoteType);
		
    }
	
	@GET 
    @Path("types")
    @Produces(MediaType.APPLICATION_JSON)
	public String getTypes() throws Exception {
		
		QuotesDB quotesDb = QuotesDB.getInstance();
		List<String> types = new ArrayList<String>();
		
		Iterator<String> iter = quotesDb.getAllTypes().iterator();
		while (iter.hasNext()) {
			String type = (String) iter.next();
			types.add(type);
		}
		
		return new Gson().toJson(types);
	}
}
