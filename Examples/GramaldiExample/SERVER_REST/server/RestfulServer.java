/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_grimaldi_server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cxf.endpoint.Server;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
/**
 *
 * @author leona
 */
public class RestfulServer {
    public static void main(String args[]) throws Exception {
        
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(RepoPasseggieri.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new RepoPasseggieri()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();
        System.out.println("Server ready...");    
    }
    
}
