package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.ingesup.vroumvroum.ws.hibernate.HibernateUtils;
import fr.ingesup.vroumvroum.ws.models.Event;

public class MenuCRUDService {
	public static List<Event> findAllEvents()
	{
		// Ouverture d'une session Hibernate
		Session session = HibernateUtils.getSession();

		// R�cup�ration de tous les plats possibles d'un restaurant d'apr�s la cl� restaurant
		Query q = session.createQuery("from Event");

		try {
			List<Event> allEvents = q.list();
			
			session.close();
			
			return allEvents;
		} catch (HibernateException e)
		{
			session.close();
			return null;
		}
	}
}
