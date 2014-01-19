package fr.ingesup.vroumvroum.ws.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import fr.ingesup.vroumvroum.ws.hibernate.crud.MenuCRUDService;
import fr.ingesup.vroumvroum.ws.models.Event;

@Path("/events")
public class EventService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getAllEvents() {
		System.out.println("In get JSON for /view/{restaurantKey}/all");

		List<Event> allEvents = MenuCRUDService.findAllEvents();
		JSONArray allEventsArray = new JSONArray();
		for(Event event : allEvents) {
			allEventsArray.put(event.toJSON());
		}
		return allEventsArray;
	}
}