/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.client_rest_jms;

import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 *
 * @author leona
 */
public class Client {
    
    WebClient client = WebClient.create("http://localhost:8080/grimaldi/");
    
    public void deleteBagaglio(int id, double peso){      
        
        Passeggero c = client.path("passeggero/1").accept("text/xml").get(Passeggero.class); 
        if(c!=null){
            System.out.print(c.getId()+ " \n");
            System.out.print(c.getName() + " \n"); 
            System.out.print(c.getSurname() + " \n"); 
            System.out.print(c.isHasCar() + " \n"); 
            List<Bagaglio> l = c.getL();
            for(int k=0; k<l.size(); k++){
               System.out.print(l.get(k).getPropertyId() + " \n"); 
               System.out.print(l.get(k).getPeso()+ " \n"); 
            }            
        }
        
        client.back(true);
        System.out.println(" \n\n");        
        
        Response r = client.path("passeggero/"+id+"/bagaglio/"+peso).accept("text/xml").delete();
        System.out.println(r.getStatus()+ " \n\n");    
        client.back(true);
        
        Passeggero c2 = client.path("passeggero/1").accept("text/xml").get(Passeggero.class); 
        if(c2!=null){
            System.out.print(c2.getId()+ " \n");
            System.out.print(c2.getName() + " \n"); 
            System.out.print(c2.getSurname() + " \n"); 
            System.out.print(c2.isHasCar() + " \n"); 
            List<Bagaglio> l2 = c2.getL();
            for(int k=0; k<l2.size(); k++){
               System.out.print(l2.get(k).getPropertyId() + " \n"); 
               System.out.print(l2.get(k).getPeso()+ " \n"); 
            }            
        }
        
        client.back(true);
        System.out.println(" \n\n");
    }
    
    public static void main(String[] args){
        
        Manager m = new Manager(); 
        
    }
   
}
