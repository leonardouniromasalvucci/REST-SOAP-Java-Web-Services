package edu.softeng.julyexamserver;

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
@WebService(endpointInterface = "edu.softeng.julyexamserver.ServiceInterface")
public class MoviesCollection implements ServiceInterface{
    
    private List<Movie> l = new ArrayList<Movie>();
    
    public MoviesCollection(){
        
    }
    
    public List<Movie> getAllMovies(){  
        Connection c = null;
        java.sql.Statement stmt = null;     
        
        try {            
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/JULYEXAM");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES;" );
      
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String y = rs.getString("YEAR");
                int dir_id = rs.getInt("DIRECTORID");
                String d = dir_id+"";
                
                l.add(new Movie(id, title, d, y));
                System.out.println();
            }
            rs.close();           
            
            ResultSet rs1 = stmt.executeQuery( "SELECT * FROM DIRECTORS;" );
      
            while (rs1.next()) {
                int id = rs1.getInt("ID");
                String  name = rs1.getString("NAME");
                String b  = rs1.getString("BIRTH");
                
                for(int p=0; p<l.size(); p++){
                    String id_d = id+"";
                    if(id_d.equals(l.get(p).getDirector())){        
                        String json = "{\"id\": "+id+", \"name\":\""+name+"\", \"birth\":\""+b+"\"}";        
                        l.get(p).setDirector(json);                                            
                    }                    
                }              
            }
            
            rs.close();
            stmt.close();
            c.close();
            
        } catch (Exception e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
	}
        
        return l;
    }
    
}

/*

 public List<Movie> getAllListOfMovies(){
        Connection c = null;
        java.sql.Statement stmt = null; 
        String nameDB = "SoftEng2";
        
         try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM MOVIES;" );
      
            while (rs.next()) {
                
                int id = rs.getInt("ID");
                String  title = rs.getString("TITLE");
                String y  = rs.getString("YEAR");
                
                int  dir_id = rs.getInt("DIRECTORID");  
                
                ResultSet rs2 = stmt.executeQuery( "SELECT * FROM DIRECTORS WHERE ID="+ dir_id);
                
                String  name = rs2.getString("NAME");
                String yearOfBirth  = rs2.getString("YEAROFBIRTH");
                
                String json = "{\"name\": \""+name+"\", \"yearofbirth\":\""+yearOfBirth+"\"}";
                listOfMovies.add(new Movie(id, title, json, y));     
                
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
*/
