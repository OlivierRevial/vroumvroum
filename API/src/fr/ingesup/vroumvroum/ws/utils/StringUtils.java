package fr.ingesup.vroumvroum.ws.utils;

public class StringUtils {
	public final static boolean isNotEmpty(String theString)
	{
		return (theString != null && !theString.isEmpty());
	}
	
	public final static boolean isNotNull(String theString)
	{
		return theString != null;
	}
	
	public final static boolean isNullOrEmpty(String theString)
	{
		return theString == null || theString.isEmpty();
	}
}
