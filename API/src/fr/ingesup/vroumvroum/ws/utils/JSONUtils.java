package fr.ingesup.vroumvroum.ws.utils;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
}
