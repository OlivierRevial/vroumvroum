package fr.ingesup.vroumvroum.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class JsonException extends Exception {
	private static final long serialVersionUID = 1L;
	private Response.Status statusCode;
	
	public JsonException(String message, Status statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public Response.Status getStatusCode() {
		return statusCode;
	}
}
