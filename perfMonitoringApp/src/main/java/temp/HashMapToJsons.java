package temp;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapToJsons {
    public static  void main(String args[]){
        System.out.println("jar file"+org.apache.jmeter.functions.FileToString.class.getProtectionDomain().getCodeSource().toString());
    }


    public void hashMapToJsons(Object object, java.util.List<ArrayList<String>> keyList,
                               java.util.List<ArrayList<String>> valueList, Integer limit)
            throws JsonGenerationException, JsonMappingException, IOException {

        System.out.println("hashMapToJsons method invoked !!");
        ObjectMapper mapper = new ObjectMapper();

        java.util.List<Object> listOfJsonObjAndJsonArr = new ArrayList<Object>();

        java.util.List<String> keys = new ArrayList<String>();
        java.util.List<String> values = new ArrayList<String>();


        Integer i = 0;
        while (i < limit) {

            Integer k = 0;

            while (k < keyList.size()) {

                keys = keyList.get(k);
                values = valueList.get(k);
                Integer j = 0;
                listOfJsonObjAndJsonArr.clear();
                listOfJsonObjAndJsonArr.add(object);
                String var = "";

                while (j < keys.size() - 1) {

                    String[] varSplit = keys.get(j).split("-");
                    System.out.println("key = " + keys.get(j));

                    if (listOfJsonObjAndJsonArr.get(j) instanceof java.util.List<?>) {

                        System.out.println("given object is json Array = " + listOfJsonObjAndJsonArr.get(j) + "\n");
                        java.util.List<Object> jsonList = (java.util.List<Object>) listOfJsonObjAndJsonArr.get(j);

                        if (varSplit.length == 1) {

                            System.out.println("key = " + keys.get(j));
                            System.out.println("json = " + jsonList.get(Integer.valueOf(keys.get(j))));
                            listOfJsonObjAndJsonArr.add(jsonList.get(Integer.valueOf(keys.get(j))));

                        } else {

                            System.out.println("varSplit[1] = " + varSplit[1]);
                            System.out.println("json = " + jsonList.get(Integer.valueOf(varSplit[1])));
                            listOfJsonObjAndJsonArr.add(jsonList.get(Integer.valueOf(varSplit[1])));
                        }

                    } else {

                        System.out.println("given object is json Object = " + listOfJsonObjAndJsonArr.get(j));
                        Map<String, Object> jsonMap = (Map<String, Object>) listOfJsonObjAndJsonArr.get(j);

                        if (varSplit.length == 1) {

                            System.out.println("key = " + keys.get(j));
                            listOfJsonObjAndJsonArr.add(jsonMap.get(keys.get(j)));

                        } else {

                            List<Object> tempList = (List<Object>) jsonMap.get(varSplit[0]);
                            Map<String, Object> tempHashMap = (Map<String, Object>) tempList.get(Integer.valueOf(varSplit[1]));
                            listOfJsonObjAndJsonArr.add(tempHashMap);

                        }

                    }
                    j++;

                }
                System.out.println("key = " + keys.get(j) + " :: value = " + values.get(i));

                if (listOfJsonObjAndJsonArr.get(j) instanceof List<?>) {
                    System.out.println("it is JsonArray");
                    List<Object> jsonList = (List<Object>) listOfJsonObjAndJsonArr.get(j);
                    jsonList.add(values.get(i));

                } else if (listOfJsonObjAndJsonArr.get(j) instanceof Map<?, ?>) {
                    System.out.println("it is JsonObject");
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) listOfJsonObjAndJsonArr.get(j);
                    if (hashMap.get(keys.get(j)) instanceof List<?>) {
                        System.out.println("it is JsonArray");
                        /* List<Object> jsonList = (List<Object>) list.get(j); */
                        List<Object> jsonList = (List<Object>) hashMap.get(keys.get(j));
                        jsonList.clear();
                        jsonList.add(values.get(i));
                    } else {
                        System.out.println("it is JsonObject");
                        hashMap.put(keys.get(j), values.get(i));
                    }

                }

                k++;
            }
            i++;
            System.out.println("json Obect = " + object);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("results/output" + (i) + ".json"), object);
        }

    }

}
