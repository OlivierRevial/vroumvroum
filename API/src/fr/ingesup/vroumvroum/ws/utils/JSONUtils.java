package fr.ingesup.vroumvroum.ws.utils;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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

//	Event testEvent = EventCRUDService.findAll().get(0);
//	ObjectMapper objectMapper = new ObjectMapper();
//	Event result = null;
//	String testStr = "{\"id\":\"12\",\"name\":\"Nom de test\", \"description\":\"Description de test\"}";
//	String resultStr = "";
//	try {
//		result = objectMapper.readValue(testStr, Event.class);
//		resultStr = objectMapper.writeValueAsString(testEvent);
//		System.out.println(resultStr);
//	} catch (JsonParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (JsonMappingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	// TODO Implement
//	System.out.println(result.toString());
//	return new JSONObject();
}
