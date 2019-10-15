/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jms2client;

/**
 *
 * @author leona
 */

import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author biar
 */
public class OrderManager implements MessageListener{
    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null, dest2=null;
    private TopicPublisher producer = null;
    private TopicSubscriber o_sub=null, q_sub=null;
    String user;

    public OrderManager(String user) {
        this.user=user;
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            dest = (Topic) jndiContext.lookup("dynamicTopics/Quotations");
         
            dest2 = (Topic) jndiContext.lookup("dynamicTopics/Orders");
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
         
            producer = session.createPublisher(dest2);
            q_sub = session.createSubscriber(dest);         
            
            o_sub = session.createSubscriber(dest2);
            q_sub.setMessageListener(this);         
            o_sub.setMessageListener(this);
            connection.start();
        } catch (Exception e){
            e.printStackTrace();
        }   
    }

    @Override
    public void onMessage(Message msg) {
        TextMessage mess=(TextMessage) msg;
        Random randomGen=new Random();
        try {
            
            /* Riceve e stampa un messaggio per volta */
            System.out.println(mess.getStringProperty("Name"));  
            System.out.println(mess.getStringProperty("Surname"));  
            System.out.println();
            
            Enumeration props=mess.getPropertyNames();
            while(props.hasMoreElements()){
                System.out.print(mess.getStringProperty(props.nextElement().toString())+ " - ");  
                System.out.println();
                /*  if(mess.getStringProperty(props.nextElement().toString()).equals("ciaoo")){
                    System.out.print("eccomi");                       
                }*/                                
            }
            
            System.out.println();
            if(mess.propertyExists("Quotation") && mess.getStringProperty("Quotation").equals("Barilla")){
                TextMessage reply = session.createTextMessage();
                reply.setStringProperty("Quotation", mess.getStringProperty("Quotation"));
                reply.setDoubleProperty("Price", mess.getDoubleProperty("Price"));
                producer.send(reply);
                System.out.println("sent order");
            }
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
