/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.bankws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author leona
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        RepoClients implementor = new RepoClients();
        String address = "http://localhost:8080/LabTest/AAAWS";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }    
    
}
