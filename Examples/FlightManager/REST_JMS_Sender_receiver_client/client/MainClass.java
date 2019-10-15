/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import javax.xml.bind.JAXBException;
import org.apache.cxf.jaxrs.client.WebClient;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class MainClass{    
   
    static Context ictx = null;        
   
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException, JMSException {               
        
        WebClient client = WebClient.create("http://localhost:8080/flights/");
        QueueSession qs = null; 
        QueueSender qsender = null;
        QueueReceiver qs_rec = null;       
        
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            
            //Creare il contesto
            ictx = new InitialContext(props);
            
            Queue queue, queue2 ;
            queue = (Queue) ictx.lookup("dynamicQueues/flights");
            queue2 = (Queue) ictx.lookup("dynamicQueues/flights2");
            
            QueueConnectionFactory qcf;
            qcf = (QueueConnectionFactory) ictx.lookup("ConnectionFactory");
            
            ictx.close();
            
            QueueConnection qc;
            qc = qcf.createQueueConnection();            
     
            qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            qsender = qs.createSender(queue);
            qs_rec = qs.createReceiver(queue2);
            qc.start();
            
        } catch (NamingException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        String res = client.path("listofflights").accept("text/xml").get(String.class); 
        
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<Map<String, Flight>>(){}.getType(); 
        Map<String, Flight> clonedMap = gson.fromJson(res, listType);
        
        for (Map.Entry<String, Flight> entry : clonedMap.entrySet()) {
            System.out.println("KEY "+entry.getKey());
            System.out.println("Flight info: ");
            System.out.println("FROM "+entry.getValue().getFrom());
            System.out.println("TO "+entry.getValue().getTo());
            System.out.println("TIME "+entry.getValue().getTime());
            List<Passenger> l = entry.getValue().getL();
            for(int k=0; k<l.size(); k++){
                System.out.println(l.get(k).getCF());
                System.out.println(l.get(k).getName());
                System.out.println(l.get(k).getSurname());     
                
                TextMessage mess = null, mess2 = null;
                mess = qs.createTextMessage();
                mess.setStringProperty("CF", l.get(k).getCF());
                qsender.send(mess);                  
                    
                mess2 = (TextMessage) qs_rec.receive();   
                System.out.println(mess2.getStringProperty("Response"));             
                
            }
            System.out.println("\n\n");
        }

        client.back(true);
        
        String code = "PIM8678";
        Response res1 = client.path("listofflights/"+code).accept("text/xml").delete();
        System.out.println(res1.getStatus()+"\n\n");
        
        client.back(true);
        
        String res2 = client.path("listofflights").accept("text/xml").get(String.class); 
        Map<String, Flight> clonedMap2 = gson.fromJson(res2, listType);
        
        for (Map.Entry<String, Flight> entry2 : clonedMap2.entrySet()) {
            System.out.println("KEY "+entry2.getKey());
            System.out.println("Flight info: ");
            System.out.println("FROM "+entry2.getValue().getFrom());
            System.out.println("TO "+entry2.getValue().getTo());
            System.out.println("TIME "+entry2.getValue().getTime());
            List<Passenger> l = entry2.getValue().getL();
            for(int k=0; k<l.size(); k++){
                System.out.println(l.get(k).getCF());
                System.out.println(l.get(k).getName());
                System.out.println(l.get(k).getSurname());                                 
            }
            System.out.println("\n\n");
        }
        
        client.back(true);
              
      
        String code2 = "TT9879OP";
        List<Passenger> l_p = new ArrayList<Passenger>();
        l_p.add(new Passenger("IGH343JIU", "Leonardo", "Salvucci"));
        l_p.add(new Passenger("UTVUYG1527", "Filippo", "Gemma"));
        Flight f1 = new Flight("Spoleto","Perugia",30,l_p);
        Response res3 = client.path("listofflights/"+code2).accept("text/xml").post(f1);
        System.out.println(res3.getStatus()+"\n\n");
     
        client.back(true);
        
        String code3 = "ERN67876";
        List<Passenger> l_p2 = new ArrayList<Passenger>();
        l_p2.add(new Passenger("IGH343JIU", "Leonardo", "Salvucci"));
        l_p2.add(new Passenger("UTVUYG1527", "Filippo", "Gemma"));
        Flight f2 = new Flight("Paris","Tunisi",180,l_p2);
        Response res4 = client.path("listofflights/"+code3).accept("text/xml").put(f2);
        System.out.println(res4.getStatus()+"\n\n");
        
        client.back(true);
        
        String res5 = client.path("listofflights").accept("text/xml").get(String.class); 
        Map<String, Flight> clonedMap3 = gson.fromJson(res5, listType);
        
        for (Map.Entry<String, Flight> entry3 : clonedMap3.entrySet()) {
            System.out.println("KEY "+entry3.getKey());
            System.out.println("Flight info: ");
            System.out.println("FROM "+entry3.getValue().getFrom());
            System.out.println("TO "+entry3.getValue().getTo());
            System.out.println("TIME "+entry3.getValue().getTime());
            List<Passenger> l3 = entry3.getValue().getL();
            for(int k=0; k<l3.size(); k++){
                System.out.println(l3.get(k).getCF());
                System.out.println(l3.get(k).getName());
                System.out.println(l3.get(k).getSurname());                                 
            }
            System.out.println("\n\n");
        }             
     }    
}       
