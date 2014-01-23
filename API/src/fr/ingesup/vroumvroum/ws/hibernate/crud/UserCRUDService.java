package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.TypeMismatchException;

import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.models.user.User;
import fr.ingesup.vroumvroum.ws.utils.Log;

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
	
	public static int save(User User) {
		return CRUDUtils.save(User).getId();
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
}
