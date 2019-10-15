/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.july_soap_ws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        MovieRepo implementor = new MovieRepo();
        String address = "http://localhost:8080/repomovies";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }    
}
