package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.TypeMismatchException;

import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.exceptions.UserException;
import fr.ingesup.vroumvroum.ws.exceptions.UserException.Type;
import fr.ingesup.vroumvroum.ws.models.user.User;
import fr.ingesup.vroumvroum.ws.utils.Log;
import fr.ingesup.vroumvroum.ws.utils.Validator;

public class UserCRUDService {
	private static final String USER_TABLE = "User";
	
	public static List<User> findAll()
	{
		return CRUDUtils.getResults("from " + USER_TABLE);
	}
	
	public static User findById(int id) throws NoSuchIdException
	{
		try {
			return CRUDUtils.findById(id, User.class);
		} catch (TypeMismatchException e) {
			Log.error(e);
			return null;
		}
	}
	
	public static User findByToken(String userToken) throws UserException {
		String query = "from User user where user.userToken ='" + userToken+ "'";
		List<User> users = CRUDUtils.getResults(query);
		if(Validator.isNullOrEmpty(users)) {
			throw new UserException(Type.INVALID_USER_TOKEN);
		}
		return users.get(0);
	}
	
	public static String getUserToken(String email, String password) throws UserException {
		String query = "from User user where user.email ='" + email + "' AND user.password = '" + password + "'";
		List<User> users = CRUDUtils.getResults(query);
		if(Validator.isNullOrEmpty(users)) {
			throw new UserException(Type.INCORRECT_EMAIL_PASSWORD);
		}
		return users.get(0).getUserToken();
	}
	
	public static boolean doesUserExists(String email) {
		String query = "from User user where user.email ='" + email + "'";
		return Validator.isNotNullOrEmpty(CRUDUtils.getResults(query));
	}
	
	public static int save(User user) throws UserException {
		if(doesUserExists(user.getEmail())) {
			throw new UserException(Type.USER_ALREADY_EXISTS);
		}
		return CRUDUtils.save(user).getId();
	}
	
	public static User update(User User) throws NoSuchIdException {
		try {
			return CRUDUtils.update(User);
		} catch (HibernateException e) {
			throw new NoSuchIdException(User.getId());
		}
	}
	
	public static void delete(int UserId) throws NoSuchIdException {
		CRUDUtils.delete("User", UserId);
	}
	
	public static boolean hasEventRight(String eventId, String userToken) {
		String query = "from Event as event join event.owner as user where user.userToken ='" + userToken + "' AND event.id = " + eventId;
		return Validator.isNotNullOrEmpty(CRUDUtils.getResults(query));
	}
}
