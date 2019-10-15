/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_server;

import javax.ws.rs.PathParam;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author leona
 */
public class RestfulServer {
    
     public static void main(String args[]) throws Exception {
        
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(FlightRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new FlightRepository()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();
        System.out.println("Server ready...");
    
    }
    
}
