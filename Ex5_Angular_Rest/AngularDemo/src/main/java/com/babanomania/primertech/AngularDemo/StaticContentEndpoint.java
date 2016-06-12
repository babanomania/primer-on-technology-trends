package com.babanomania.primertech.AngularDemo;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("static")
public class StaticContentEndpoint {
  
    @GET
    @Path("{path:.*}")
    public File Get(@PathParam("path") String path) {
      return new File( "src/main/webapp/" + path );
    }
}