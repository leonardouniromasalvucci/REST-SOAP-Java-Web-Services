package edu.softeng.aaaws;

import javax.xml.ws.Endpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leona
 */
public class Server {
    
    public static void main(String args[]) throws InterruptedException {
        RepoOperation implementor = new RepoOperation();
        String address = "http://localhost:8081/LabTest/BankWS";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }    
    
}
