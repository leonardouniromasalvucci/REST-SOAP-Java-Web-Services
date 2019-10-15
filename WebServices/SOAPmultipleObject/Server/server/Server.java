/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author leona
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        University implementor = new University();
        String address = "http://localhost:8080/university";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }    
}
