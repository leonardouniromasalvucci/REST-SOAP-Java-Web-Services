/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author leona
 */
@Path("flights")
@Produces({MediaType.TEXT_XML}) 
public class FlightRepository {
    
    Map<String, Flight> listOfFlights = new HashMap<String, Flight>();
    List<Passenger> l1 = new ArrayList<Passenger>();
    List<Passenger> l2 = new ArrayList<Passenger>();
    List<Passenger> l3 = new ArrayList<Passenger>();
    
    public FlightRepository(){
        l1.add(new Passenger("IGH343JIU", "Leonardo", "Salvucci"));
        l1.add(new Passenger("UTVUYG1527", "Filippo", "Gemma"));
        
        l2.add(new Passenger("GHY6887OP", "Francesco", "Belli"));
        l2.add(new Passenger("WEN7363JM", "Martina", "Ribeca"));
        l2.add(new Passenger("PLI987JMJ", "Giulio", "Laureti"));
        
        l3.add(new Passenger("LPJ234234MJ", "Stefano", "Amici"));
        l3.add(new Passenger("ABH5263BHS", "Sebastiano", "Rivoli"));
        
        listOfFlights.put("JYB6738", new Flight("Rome","New York", 23, l1));
        listOfFlights.put("PIM8678", new Flight("London","Bali", 35, l2));
        listOfFlights.put("ERN67876", new Flight("Sicily","Milan", 3, l3));
        
    }
    
    @GET
    @Path("listofflights")
    public String getFlights() {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(listOfFlights);
        return json;
    }
    
    @DELETE
    @Path("listofflights/{flightId}")
    public Response deleteFlightById(@PathParam("flightId") String flightId) {
        Iterator<Map.Entry<String, Flight>> it = listOfFlights.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Flight> pair = it.next();
            if(pair.getKey().equals(flightId)){
                it.remove();
            }   
        }
        return Response.status(Status.OK).build();
    }
    
    @POST
    @Path("listofflights/{flightId}")
    public Response AddFlight(@PathParam("flightId") String flightId, Flight f) {
        listOfFlights.put(flightId,f);
        return Response.ok().build();
    }
    
    @PUT
    @Path("listofflights/{flightId}")
    public Response updateFlight(@PathParam("flightId") String flightId, Flight f) {
        if (listOfFlights.containsKey(flightId)) {
            listOfFlights.put(flightId,f);
            return Response.ok().build();
        }
        return Response.notModified().build();
    }
    

}