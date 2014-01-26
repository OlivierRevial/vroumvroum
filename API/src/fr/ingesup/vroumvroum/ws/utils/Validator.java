package fr.ingesup.vroumvroum.ws.utils;

import java.util.List;

public class Validator {
	public static boolean isNull(Object object)
	{
		return object == null;
	}

	public static boolean isNotNull(Object object)
	{
		return object != null;
	}
	
	public static <T> boolean isNotNullOrEmpty(List<T> list) {
		return list != null && list.size() != 0;
	}
	
	public static <T> boolean isNullOrEmpty(List<T> list) {
		return list == null || list.size() == 0;
	}
}
