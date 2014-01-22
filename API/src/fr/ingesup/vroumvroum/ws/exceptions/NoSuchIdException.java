package fr.ingesup.vroumvroum.ws.exceptions;

public class NoSuchIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSuchIdException(int id) {
		super("ID not found : " + id);
	}
	
	public NoSuchIdException(long id) {
		super("ID not found : " + id);
	}
	
	public NoSuchIdException(String id) {
		super("ID not found : " + id);
	}
}
