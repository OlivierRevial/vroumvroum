package fr.ingesup.vroumvroum.ws.hibernate.crud;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.TypeMismatchException;

import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.exceptions.PaginationException;
import fr.ingesup.vroumvroum.ws.exceptions.PaginationException.Type;
import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.utils.Log;

public class EventCRUDService {
	private static final String EVENT_TABLE = "Event";
	private static final int MAX_RESULTS_PER_PAGE = 50;
	
	public static List<Event> findAll()
	{
		return CRUDUtils.getResults("from " + EVENT_TABLE);
	}
	
	public static List<Event> findAllWithPagination(int resultsPerPage, int page) throws PaginationException
	{
		// TODO Do better pagination...
		int maxResultsPerPage = resultsPerPage > 0 && resultsPerPage < MAX_RESULTS_PER_PAGE ? resultsPerPage : MAX_RESULTS_PER_PAGE;
		List<Event> allEvents = CRUDUtils.getResults("from " + EVENT_TABLE);
		int maxPageIndex = (allEvents.size() -1)/maxResultsPerPage + 1;
		if(page > maxPageIndex || page <= 0) {
			throw new PaginationException(Type.NO_SUCH_PAGE);
		}
		int lastIndex = resultsPerPage * page;
		if(page == maxPageIndex) { 
			lastIndex = allEvents.size() - 1;
		}
		return allEvents.subList(resultsPerPage*(page-1), lastIndex);
	}
	
	public static Event findById(int id) throws NoSuchIdException
	{
		try {
			Event event = CRUDUtils.findById(id, Event.class);
			return event;
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
