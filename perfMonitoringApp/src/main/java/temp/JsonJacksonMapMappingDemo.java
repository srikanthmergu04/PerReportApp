package temp;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class JsonJacksonMapMappingDemo {

	/*
	 * public static void main(String args[]) {
	 * 
	 * jsonToHashMap(); List<String> list = new ArrayList<String>(); Map<String,
	 * String> map = new HashMap<String, String>(); Object object = new Object();
	 * checkObjectType(object); }
	 * 
	 * private static void checkObjectType(Object object) { // TODO Auto-generated
	 * method stub if(object instanceof List<?>) {
	 * System.out.println(" given Object is of  List type"); }else if(object
	 * instanceof Map<?, ?>){ System.out.println("given Object is  Map type"); }
	 * else { System.out.println("given object neither list nor map"); }
	 * 
	 * }
	 */

	public Object jsonToHashMap() {

		System.out.println("in jsonToHashMap method");

		ObjectMapper mapper = new ObjectMapper();
		try {

			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader("results/input.json"));
		
			if (object instanceof org.json.simple.JSONObject) {
				System.out.println("In JsonToHashMap Method :: given json is json Object");
				Map<String, Object> myMap = mapper.readValue(new File("results/input.json"),
						new TypeReference<Map<String, Object>>() {
						});
				System.out.println("json Object is returned");
				return myMap;
			} else if (object instanceof JSONArray) {
				System.out.println("In JsonToHashMap Method :: given json is json Array");
				List<Object> jsonList = mapper.readValue(new File("results/input.json"),
						new TypeReference<List<Object>>() {
						});

				System.out.println("json Array is returned");
				return jsonList;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
