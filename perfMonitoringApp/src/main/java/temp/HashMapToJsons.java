package temp;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapToJsons {

	public void hashMapToJsons(Object object, java.util.List<ArrayList<String>> keyList,
			java.util.List<ArrayList<String>> valueList)
			throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("hashMapToJsons method invoked !!");
		ObjectMapper mapper = new ObjectMapper();

		/*
		 * java.util.List<HashMap<String, Object>> mapList = new
		 * ArrayList<HashMap<String, Object>>(); mapList.add((HashMap<String, Object>)
		 * myMap);
		 */

		java.util.List<Object> list = new ArrayList<Object>();

		HashMap<String, Object> test = new HashMap<String, Object>();

		// java.util.List<ArrayList<String>> keyList = new
		// ArrayList<ArrayList<String>>();
		// java.util.List<ArrayList<Object>> valueList = new
		// ArrayList<ArrayList<Object>>();
		java.util.List<String> keys = new ArrayList<String>();
		java.util.List<String> values = new ArrayList<String>();

		System.out.println("keyList = " + keyList);
		System.out.println("valueList = " + valueList);

		Integer i = 0;
		// System.out.println("keySize = " + keyList.size());

		while (i < 20) {
			Integer k = 0;
			while (k < keyList.size()) {
				keys = keyList.get(k);
				values = valueList.get(k);
				Integer j = 0;
				/*
				 * mapList.clear(); mapList.add((HashMap<String, Object>) myMap);
				 */
			
				list.clear();
				list.add(object);
				String var = "";
				while (j < keys.size() - 1) {
					
					String[] varSplit = keys.get(j).split("-");
					System.out.println("key = "+keys.get(j));
					//System.out.println(varSplit[0]+" :: "+varSplit[1]);
					if (list.get(j) instanceof java.util.List<?>) {
						System.out.println("given object is json Array = " + list.get(j));
						java.util.List<Object> jsonList = new ArrayList<Object>();
						jsonList = (java.util.List<Object>) list.get(j);
						if(varSplit.length == 1) {
							System.out.println("key = "+keys.get(j));
							System.out.println("json = "+jsonList.get(Integer.valueOf(keys.get(j))));
							list.add(jsonList.get(Integer.valueOf(keys.get(j))));
						}else {
							System.out.println("varSplit[1] = "+varSplit[1]);
							System.out.println("json = "+jsonList.get(Integer.valueOf(varSplit[1])));
							list.add(jsonList.get(Integer.valueOf(varSplit[1])));
						}

					} else {
						System.out.println("given object is json Object = " + list.get(j));
						Map<String, Object> jsonMap = new HashMap<String, Object>();
						jsonMap = (Map<String, Object>) list.get(j);
						
						//System.out.println("json = "+jsonMap.get(Integer.valueOf(varSplit[0])));
						//list.add(jsonMap.get(varSplit[0]));
						
						if (varSplit.length == 1) {
							System.out.println("key = "+keys.get(j));
							list.add(jsonMap.get(keys.get(j)));
						} else {

							List<Object> tempList = new ArrayList<Object>();
							tempList = (List<Object>) jsonMap.get(varSplit[0]);
							Map<String, Object> tempHashMap = new HashMap<String, Object>();
							tempHashMap = (Map<String, Object>) tempList.get(Integer.valueOf(varSplit[1]));
							list.add(tempHashMap);
						}
						 
						
					}
					j++;
					
				}
				System.out.println("key = "+keys.get(j)+" :: value = "+values.get(i));
				
				/*
				 * if(hashMap == null) { System.out.println("hashMap is null"); }else {
				 * System.out.println("hashMap is not null"); hashMap.put(keys.get(j),
				 * values.get(i)); }
				 */
				
				
				if(list.get(j) instanceof List<?>) {
					System.out.println("it is JsonArray");
					List<Object> jsonList = (List<Object>) list.get(j);
					jsonList.add(values.get(i));
					
				}else if(list.get(j) instanceof Map<?, ?>) {
					System.out.println("it is JsonObject");
					HashMap<String, Object> hashMap = (HashMap<String, Object>) list.get(j);
					if(hashMap.get(keys.get(j)) instanceof List<?>){
						System.out.println("it is JsonArray");
						/* List<Object> jsonList = (List<Object>) list.get(j); */
						List<Object> jsonList = (List<Object>) hashMap.get(keys.get(j));
						jsonList.clear();
						jsonList.add(values.get(i));
					}else {
						System.out.println("it is JsonObject");
						hashMap.put(keys.get(j), values.get(i));
					}
					
					
				}
				
				k++;
			}
			i++;
			System.out.println("json Obect = "+object);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("results/output" + (i) + ".json"), object);
		}

	}

}
