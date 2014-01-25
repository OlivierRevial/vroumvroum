package fr.ingesup.vroumvroum.ws.utils;

import fr.ingesup.vroumvroum.ws.hibernate.crud.UserCRUDService;

public class RightsUtils {
	public static boolean hasEventRight(String eventId, String userToken) {
		return UserCRUDService.hasEventRight(eventId, userToken);
	}
}
