package fr.ingesup.vroumvroum.ws.utils;

public class Log {
	public static void log(String message) {
		System.out.println(message);
	}
	
	public static void error(String message) {
		System.out.println(message);
	}
	
	public static void error(String message, Exception exception) {
		System.out.println(message + " " + exception.getMessage());
	}
	
	public static void error(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
