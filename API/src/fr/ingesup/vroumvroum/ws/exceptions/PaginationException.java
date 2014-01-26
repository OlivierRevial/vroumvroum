package fr.ingesup.vroumvroum.ws.exceptions;


public class PaginationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Type exceptionType; 
	
	public enum Type {
		NO_SUCH_PAGE
	}

	public PaginationException(Type type) {
		this.exceptionType = type;
	}
	
	@Override
	public String getMessage() {
		switch(exceptionType) {
			case NO_SUCH_PAGE:
				return "The page you asked for does not exists";
			default:
				return null;
		}
	}
}
