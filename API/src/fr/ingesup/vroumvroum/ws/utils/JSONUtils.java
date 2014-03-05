package fr.ingesup.vroumvroum.ws.utils;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.property.PropertyAccessor;

import fr.ingesup.vroumvroum.ws.exceptions.JsonException;
import fr.ingesup.vroumvroum.ws.models.JSONAble;

public class JSONUtils {
	public static JSONObject getJSONObjectFromString(String jsonStr)
	{
		JSONObject jsonObject = null;
		try{
			jsonObject = new JSONObject(jsonStr);
			return jsonObject;
		} catch(JSONException e)
		{
			return null;
		}
	}
	
	public static JSONObject getJSONObjectFromKeyValue(String key, String value) throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject;
	}
	
	public static JSONArray getJSONArray(JSONObject uniqueJSONObject)
	{
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(uniqueJSONObject);
		
		return jsonArray;
	}
	
	public static JSONArray getJSONArray(List<JSONObject> allJSONObjects)
	{
		JSONArray jsonArray = new JSONArray();
		
		for(JSONObject obj : allJSONObjects) {
			jsonArray.put(obj);
		}
		
		return jsonArray;
	}
	
	public static <T extends JSONAble> JSONArray convertListToJSON(List<T> jsonList) {
		JSONArray array = new JSONArray();
		for(T obj : jsonList) {
			array.put(obj.toJSON());
		}
		return array;
	}
	
	public static <T> T convertJSONToObject(String json, Class<T> clasz) throws JsonException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clasz);
		} catch (JsonParseException e) {
			throw new JsonException("Json is malformed : " + json, Status.NOT_FOUND);
		} catch (JsonMappingException e) {
			throw new JsonException("Json is well-formed but not valid : " + json, Status.NOT_ACCEPTABLE);
		} catch (IOException e) {
			throw new JsonException("Internal servor error", Status.SERVICE_UNAVAILABLE);
		}
	}
	
	public static <T> String convertObjectToJSON(T object) throws JsonException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			throw new JsonException("Json could not be generated from object", Status.BAD_REQUEST);
		} catch (JsonMappingException e) {
			throw new JsonException("Object could not be mapped", Status.BAD_REQUEST);
		} catch (IOException e) {
			throw new JsonException("I/O exception", Status.SERVICE_UNAVAILABLE);
		}
	}
}
