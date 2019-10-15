/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author leona
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        CarRepository implementor = new CarRepository();
        String address = "http://localhost:8080/ferroni";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }    
}
