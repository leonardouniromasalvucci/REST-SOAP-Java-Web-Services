import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import jdk.nashorn.internal.ir.Statement;
import java.sql.*;


public class MySqlite {
    
    Connection c = null;
    java.sql.Statement stmt = null;
    
    
    public void CreateDatabase(String nameDB){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Created database successfully");        
    }
    
    
    public void CreateTable(String nameDB){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
           
            stmt = c.createStatement();
            String sql1 = "CREATE TABLE MOVIES " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " TITLE           TEXT    NOT NULL, " + 
                        " YEAR            TEXT     NOT NULL, " + 
                        " DIRECTORID        INT " + 
                        " )"; 
            stmt.executeUpdate(sql1);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");        
    }
    
    public void InsertValues(String nameDB){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
            c.setAutoCommit(false);
           
            stmt = c.createStatement();
            String sql = "INSERT INTO MOVIES (ID,TITLE,YEAR,DIRECTORID) " +
                        "VALUES (6, 'Pinocchio', '1994', 1294);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO MOVIES (ID,TITLE,YEAR,DIRECTORID) " +
                        "VALUES (2, 'Come ti spaccio la famiglia', '20018', 1294);"; 
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");                
    }
    
    public void UpdatesValues(String nameDB){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
            c.setAutoCommit(false);
            
            stmt = c.createStatement();
            String sql = "UPDATE MOVIES SET TITLE='Occhio a quelli là' " +
                        "WHERE ID=6;"; 
            stmt.executeUpdate(sql);
                    
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records updated successfully");                
    }
    
    public void RetrieveData(String nameDB){
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
         
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + title );
                System.out.println( "AGE = " + y );
                System.out.println( "ADDRESS = " + dir_id );

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
    }
    
       
    public static void main(String[] args) throws Exception{
        
        String nameDB = "SoftEng";
        MySqlite db = new MySqlite();        
        
        db.CreateDatabase(nameDB);
        db.CreateTable(nameDB);
        db.InsertValues(nameDB);
        db.UpdatesValues(nameDB);
        db.RetrieveData(nameDB);
          
    }        
}
