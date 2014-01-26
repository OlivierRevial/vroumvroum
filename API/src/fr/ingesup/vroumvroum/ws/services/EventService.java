package fr.ingesup.vroumvroum.ws.services;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.ingesup.vroumvroum.ws.exceptions.JsonException;
import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.exceptions.PaginationException;
import fr.ingesup.vroumvroum.ws.exceptions.UserException;
import fr.ingesup.vroumvroum.ws.hibernate.crud.EventCRUDService;
import fr.ingesup.vroumvroum.ws.hibernate.crud.UserCRUDService;
import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.models.user.User;
import fr.ingesup.vroumvroum.ws.utils.JSONUtils;
import fr.ingesup.vroumvroum.ws.utils.Log;
import fr.ingesup.vroumvroum.ws.utils.RightsUtils;
import fr.ingesup.vroumvroum.ws.utils.URLUtils;

@Path(URLUtils.SERVICE_EVENT_URL)
public class EventService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents(@QueryParam("resultsPerPage") int resultsPerPage, @QueryParam("page") int page) {
		try {
			return Response.ok(JSONUtils.convertListToJSON(EventCRUDService.findAllWithPagination(resultsPerPage, page))).build();
		} catch (PaginationException e) {
			Log.error(e);
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEvent(String eventStr, @QueryParam("userToken") String userToken) throws URISyntaxException {
		try {
			User owner = UserCRUDService.findByToken(userToken);
			Event event = JSONUtils.convertJSONToObject(eventStr, Event.class);
			event.setOwner(owner);
			int insertedId = EventCRUDService.save(event);
			return Response.created(new URI(String.valueOf(insertedId))).build();
		} catch (JsonException e) {
			Log.error(e);
			return Response.status(e.getStatusCode()).build();
		} catch (UserException e) {
			Log.error(e);
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("{id}")
	public Response getEvent(@PathParam("id") int id) {
		try {
			Event event = EventCRUDService.findById(id);
			return Response.ok(event.toJSON()).build();
		} catch (NoSuchIdException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEvent(String eventStr, @PathParam("id") int id, @QueryParam("userToken") String userToken) {
		try {
			if(RightsUtils.hasEventRight(String.valueOf(id), userToken)) {
				System.out.println("User has right");
				Event event = JSONUtils.convertJSONToObject(eventStr, Event.class);
				event.setId(id);
				event = EventCRUDService.update(event);
				return Response.ok(event).build();
			}
			else {
				System.out.println("User has not right");
				return Response.status(Status.FORBIDDEN).build();
			}
		} catch (JsonException e) {
			return Response.status(e.getStatusCode()).build();
		} catch (NoSuchIdException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEvent(@PathParam("id") int id, @QueryParam("userToken") String userToken) {
		try {
			if(RightsUtils.hasEventRight(String.valueOf(id), userToken)) {
				System.out.println("User has right");
				EventCRUDService.delete(id);;
				return Response.ok().build();
			}
			else {
				System.out.println("User has not right");
				return Response.status(Status.FORBIDDEN).build();
			}
		} catch (NoSuchIdException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}