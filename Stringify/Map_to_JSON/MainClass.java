/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.map_json;

import java.lang.reflect.Type;
import java.util.HashMap;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
/**
 *
 * @author leona
 */
public class MainClass {
    
    public static void main(String[] args){
        
        Map<String, Student> myMap = new HashMap<String, Student>();
        myMap.put("one", new Student("Mario", "Rossi"));
        myMap.put("two", new Student("Franco", "Betti"));

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(myMap);
        
        Type listType = new TypeToken<Map<String, Student>>(){}.getType(); 
        Map<String, Student> clonedMap = gson.fromJson(json, listType);
        
        for (Map.Entry<String, Student> entry : clonedMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue().getName());
        }

        

    }
    
    
}
