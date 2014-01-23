package fr.ingesup.vroumvroum.ws.services;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.ingesup.vroumvroum.ws.exceptions.JsonException;
import fr.ingesup.vroumvroum.ws.exceptions.NoSuchIdException;
import fr.ingesup.vroumvroum.ws.hibernate.crud.UserCRUDService;
import fr.ingesup.vroumvroum.ws.models.user.User;
import fr.ingesup.vroumvroum.ws.utils.JSONUtils;
import fr.ingesup.vroumvroum.ws.utils.URLUtils;

@Path(URLUtils.SERVICE_USER_URL)
public class UserService {
	@GET
	@Path("{id}")
	public Response getUser(@PathParam("id") int id) {
		try {
			User user = UserCRUDService.findById(id);
			return Response.ok(JSONUtils.convertObjectToJSON(user)).build();
		} catch (NoSuchIdException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (JsonException e) {
			return Response.status(e.getStatusCode()).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(String userStr) throws URISyntaxException {
		try {
			User user = JSONUtils.convertJSONToObject(userStr, User.class);
			user.setUserToken(user.getFacebookId()+user.getEmail());
			System.out.println("Generating user token : " + user.getUserToken());
			int insertedId = UserCRUDService.save(user);
			return Response.created(new URI(String.valueOf(insertedId))).build();
		} catch (JsonException e) {
			return Response.status(e.getStatusCode()).build();
		}
	}
}