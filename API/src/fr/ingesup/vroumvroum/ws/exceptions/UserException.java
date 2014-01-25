package fr.ingesup.vroumvroum.ws.exceptions;

public class UserException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Type exceptionType; 
	
	public enum Type {
		INCORRECT_EMAIL_PASSWORD, INVALID_USER_TOKEN, USER_ALREADY_EXISTS
	}

	public UserException(Type type) {
		this.exceptionType = type;
	}
	
	@Override
	public String getMessage() {
		switch(exceptionType) {
			case INCORRECT_EMAIL_PASSWORD:
				return "The pair email/password is incorrect";
			case INVALID_USER_TOKEN:
				return "The user token is invalid. Please authenticate to get your user token.";
			case USER_ALREADY_EXISTS:
				return "User already exists";
			default:
				return null;
		}
	}
}
