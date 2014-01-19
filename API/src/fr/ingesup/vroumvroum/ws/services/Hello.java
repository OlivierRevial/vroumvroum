package fr.ingesup.vroumvroum.ws.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  @GET
  @Path("{name}")
  @Produces(MediaType.TEXT_HTML)
  public String sayHelloToSomebodyGet(@PathParam("name") String name) {
    return "<html> " + "<title>" + "Hello World.</title>"
        + "<body><h1>" + "GET test : Hello <br />You are " + name + "</body></h1>" + "</html> ";
  }
  
  @POST
  @Produces(MediaType.TEXT_HTML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public String sayHelloToSomebodyPost(@FormParam("name") String name) throws IOException {
	    return "<html> " + "<title>" + "Hello World" + "</title>"
	            + "<body><h1>" + "POST test : Hello " + name + "</body></h1>" + "</html> ";
  }
} 