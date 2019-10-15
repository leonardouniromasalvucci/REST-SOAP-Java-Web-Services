/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.july_soap_ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;


/**
 *
 * @author biar
 */
@WebService(endpointInterface = "edu.softeng.july_soap_ws.MovieRepoInterface")
public class MovieRepo implements MovieRepoInterface{
    
    List<Movie> listOfMovies = new ArrayList<Movie>();
    
    public MovieRepo(){}
    
    public List<Movie> getAllListOfMovie(){
        Connection c = null;
        java.sql.Statement stmt = null, stm2=null; 
        String nameDB = "SoftEng2";
        
         try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stm2 = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIES;");
      
            while (rs.next()) {
                
                int id = rs.getInt("ID");
                String  title = rs.getString("TITLE");
                String y  = rs.getString("YEAR");
                int  dir_id = rs.getInt("DIRECTORID");  
                
                
                ResultSet rs2 = stm2.executeQuery( "SELECT * FROM DIRECTORS WHERE ID="+ dir_id);
                
                while (rs2.next()) {    
                    int id_dire = rs2.getInt("ID");
                    String name_dir = rs2.getString("NAME");
                    String year_dir  = rs2.getString("YEAROFBIRTH");
                    
                    System.out.println("ID= "+id+", TITLE= "+ title+", YEAR="+y+ ", DIRECTOR ID="+dir_id);
                    System.out.println("ID= "+id_dire+", NAME= "+ name_dir+", YEAR_OF-BIRH="+year_dir);
                    System.out.println("\n\n");    
                    
                    String json = "{\"id\": "+id_dire+", \"name\":\""+name_dir+"\", \"birth\":\""+year_dir+"\"}";     
                    
                    listOfMovies.add(new Movie(id, title, json, y));                 
                    
                }                    
                
              
                System.out.println();
            }  
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
        }
        System.out.println("Operation done successfully");         
        return listOfMovies;        
    }
           
    
}   
