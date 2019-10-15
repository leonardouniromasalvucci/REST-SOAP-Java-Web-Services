/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.map_json;

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
      
        Student s = new Student("Leonardo", "Salvucci");
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(s);
        
        Type listType = new TypeToken<Student>(){}.getType(); 
        Student clonedStudent = gson.fromJson(json, listType);
        
        System.out.println(clonedStudent.getName());
        System.out.println(clonedStudent.getSurname());      

    }   
    
}
