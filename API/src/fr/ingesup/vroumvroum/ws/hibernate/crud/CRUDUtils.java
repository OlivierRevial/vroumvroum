package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TypeMismatchException;

import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.hibernate.HibernateUtils;
import fr.ingesup.vroumvroum.ws.utils.Validator;

public class CRUDUtils {
	@SuppressWarnings("unchecked")
	public static <T> List<T> getResults(String query)
	{
		// Open Hibernate session
		Session session = HibernateUtils.getSession();
		// Create query
		Query q = session.createQuery(query);
		try {
			// Get results list
			List<T> results = q.list();
			session.close();
			return results;
		} catch (HibernateException e)
		{
			session.close();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T findById(int id, Class<T> clasz) throws NoSuchIdException, TypeMismatchException {
		Session session = HibernateUtils.getSession();
		T obj = (T) session.get(clasz, id);
		if(Validator.isNull(obj)) {
			throw new NoSuchIdException(id);
		}
		if(obj.getClass() != clasz) {
			throw new TypeMismatchException("Cannot convert type " + clasz.toString() + " to type " + obj.getClass());
		}
		session.close();
		return obj;
	}
	
	public static <T> T save(T object) {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(object);
		
		tx.commit();
		
		session.close();
		
		return object;
	}
	
	public static <T> T update(T object) throws HibernateException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		session.update(object);
			
		tx.commit();
		
		return object;
	}

	public static void delete(String table, int id) throws NoSuchIdException {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Query q = session.createQuery("DELETE FROM " + table + " WHERE id = " + id);
		int nbRowsDeleted = q.executeUpdate();
		
		tx.commit();
		
		session.close();
		
		if(nbRowsDeleted == 0) {
			throw new NoSuchIdException(id);
		}
	}
}
