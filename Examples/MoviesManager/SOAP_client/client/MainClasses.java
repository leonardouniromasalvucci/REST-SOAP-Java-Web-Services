/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_july_ex;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;

/**
 *
 * @author biar
 */
public class MainClasses {
    
    private static List<Movie> getAllListOfMovies(){
        MovieRepoService service = new MovieRepoService();
        MovieRepoInterface port = service.getMovieRepoPort();
        return port.getAllListOfMovie();
        
    }
    
    public static void main(String[] args){
        
        List<Movie> l = getAllListOfMovies();
        for(int k=0; k<l.size(); k++){
            System.out.println(l.get(k).getId());
            System.out.println(l.get(k).getTitle());
            
            JsonObject jsonObject = new JsonParser().parse(l.get(k).getDirector()).getAsJsonObject();
            String id = jsonObject.get("id").getAsString();
            String name = jsonObject.get("name").getAsString();
            String birth = jsonObject.get("birth").getAsString();
            System.out.println("DIRECTOR_ID= "+ id+", NAME= "+ name +", BIRTH= "+birth);
            
            
            System.out.println(l.get(k).getYear());
            
        }
        
        
        
    }
    
}
