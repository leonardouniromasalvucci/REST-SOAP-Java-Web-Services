/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_grimaldi_server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author biar
 */
@Path("grimaldi")
@Produces({MediaType.TEXT_XML}) 
public class RepoPasseggieri {
    
    List<Passeggero> listOfPasseggieri;
    List<Bagaglio> listOfBagagli_1;
    List<Bagaglio> listOfBagagli_2;
    
    public RepoPasseggieri(){
        Bagaglio b1 = new Bagaglio();
        b1.setPropertyId(1);
        b1.setPeso(23.6);
        
        Bagaglio b2 = new Bagaglio();
        b2.setPropertyId(1);
        b2.setPeso(53.6);
        
        Bagaglio b3 = new Bagaglio();
        b3.setPropertyId(2);
        b3.setPeso(13.6);
        
        listOfBagagli_1 = new ArrayList<Bagaglio>();
        listOfBagagli_1.add(b1);
        listOfBagagli_1.add(b2);
        
        listOfBagagli_2 = new ArrayList<Bagaglio>();
        listOfBagagli_2.add(b3);
        
        listOfPasseggieri = new ArrayList<Passeggero>();
        Passeggero p1 = new Passeggero();
        p1.setId(1);
        p1.setName("Leonardo");
        p1.setSurname("Salvucci");
        p1.setHasCar(true);
        p1.setL(listOfBagagli_1);
        
        Passeggero p2 = new Passeggero();
        p2.setId(2);
        p2.setName("Francesco");
        p2.setSurname("Oranelli");
        p2.setHasCar(false);
        p2.setL(listOfBagagli_2);
        
        listOfPasseggieri.add(p1);
        listOfPasseggieri.add(p2);
        
    }
    
    @GET
    @Path("passeggero/{passId}")
    public Passeggero getPasseggero(@PathParam("passId") int passId) {
        for(int i=0; i<listOfPasseggieri.size(); i++){
            if(listOfPasseggieri.get(i).getId()==passId){
                return listOfPasseggieri.get(i);               
            }            
        }
        return null;        
    }
    
    @GET
    @Path("passeggeri")
    public List<Passeggero> getListaPasseggeri() {
        return listOfPasseggieri;        
    }
    
    @DELETE
    @Path("passeggero/{passId}/bagaglio/{peso}")
    public Response deleteBagaglio(@PathParam("passId")int passId, @PathParam("peso") double peso) {
        for(int k=0; k<listOfPasseggieri.size(); k++){
           if(listOfPasseggieri.get(k).getId()==passId){
               for(int i=0; i<listOfBagagli_1.size(); i++){
                   if(listOfBagagli_1.get(i).getPeso()== peso){
                       listOfBagagli_1.remove(listOfBagagli_1.get(i));                       
                   }                   
               }               
           }
        }    
        return Response.ok().build();
    }
    
    
}
