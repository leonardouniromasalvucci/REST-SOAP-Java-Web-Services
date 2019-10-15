/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.sqlite_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author biar
 */
public class Sqlite_database {
    
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
            String sql1 = "CREATE TABLE CARS " +
                        "(N_T TEXT PRIMARY KEY     NOT NULL," +
                        " MODEL           TEXT    NOT NULL, " + 
                        " COST            DOUBLE     NOT NULL, " + 
                        " YEAR        TEXT " + 
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
            String sql = "INSERT INTO CARS (N_T,MODEL,COST,YEAR) " +
                        "VALUES ('028430', 'Alfa Romeo', 34.5, '2006');"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO CARS (N_T,MODEL,COST,YEAR) " +
                        "VALUES ('4314325', 'Audi A3', 32.5, '2018');"; 
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
    
    
    public void RetrieveData(String nameDB){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/biar/Desktop/"+nameDB);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CARS;");
      
            while (rs.next()) {
                int n_t = rs.getInt("N_T");
                String  model = rs.getString("MODEL");
                String cost  = rs.getString("COST");
                int  year = rs.getInt("YEAR");  
         
                System.out.println( "N_T = " + n_t );
                System.out.println( "MODEL = " + model );
                System.out.println( "COST = " + cost );
                System.out.println( "YEAR = " + year );

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
        
        String nameDB = "Cars";
        Sqlite_database db = new Sqlite_database();        
        
        db.CreateDatabase(nameDB);
        db.CreateTable(nameDB);
        db.InsertValues(nameDB);
        db.RetrieveData(nameDB);
          
    }        
    
    
}
