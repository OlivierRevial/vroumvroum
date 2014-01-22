package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.TypeMismatchException;

import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.utils.Log;

public class EventCRUDService {
	private static final String EVENT_TABLE = "Event";
	
	public static List<Event> findAll()
	{
		return CRUDUtils.getResults("from " + EVENT_TABLE);
	}
	
	public static Event findById(int id) throws NoSuchIdException
	{
		try {
			return CRUDUtils.findById(id, Event.class);
		} catch (TypeMismatchException e) {
			Log.error(e);
			return null;
		}
	}
	
	public static int save(Event event) {
		return CRUDUtils.save(event).getId();
	}
	
	public static Event update(Event event) throws NoSuchIdException {
		try {
			return CRUDUtils.update(event);
		} catch (HibernateException e) {
			throw new NoSuchIdException(event.getId());
		}
	}
	
	public static void delete(int eventId) throws NoSuchIdException {
		CRUDUtils.delete("Event", eventId);
	}
}
