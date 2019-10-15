/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.map_json;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author leona
 */
public class MainClass {
    
    public static void main(String[] args){
      
        List<Student> l = new ArrayList<Student>();
        l.add(new Student("Mario", "Rossi"));
        l.add(new Student("Franco", "Betti"));
        
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(l);
        
        Type listType = new TypeToken<List<Student>>(){}.getType(); 
        List<Student> clonedMap = gson.fromJson(json, listType);
        
        for(int k=0; k<clonedMap.size(); k++){
            System.out.println(clonedMap.get(k).getName());  
            System.out.println(clonedMap.get(k).getSurname()); 
            System.out.println("\n"); 
        }
    }    
    
}
