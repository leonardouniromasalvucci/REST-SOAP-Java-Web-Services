/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jms2server;

/**
 *
 * @author leona
 */

import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author biar
 */
public class OrderProcessor implements MessageListener{

    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null, dest2=null;
    private TopicPublisher producer = null;
    private TopicSubscriber subscriber=null;

    public OrderProcessor() {
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");

            connection = cf.createTopicConnection();

            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = (Topic) jndiContext.lookup("dynamicTopics/Orders");
            producer = session.createPublisher(dest);
            subscriber= session.createSubscriber(dest);
            subscriber.setMessageListener(this);
            connection.start();
        } catch (Exception e){
            e.printStackTrace();
        }   
    }

    @Override
    public void onMessage(Message msg) {
        System.out.println("order received");
        TextMessage mess=(TextMessage) msg;
        Random randomGen=new Random();
    
        try{
            Enumeration props=mess.getPropertyNames();
            while(props.hasMoreElements()){
                System.out.print(mess.getStringProperty(props.nextElement().toString())+ " - ");  
                System.out.println();                              
            }            
        }catch(Exception e){
            System.out.println(e.getCause());
        }
        
       
       /* try {
            TextMessage reply=session.createTextMessage();
           // reply.setStringProperty("User", mess.getStringProperty("User"));
            reply.setStringProperty("Quotation", mess.getStringProperty("Quotation"));
          //  reply.setIntProperty("Amount", mess.getIntProperty("Amount"));
            reply.setDoubleProperty("Price", mess.getDoubleProperty("Price"));
           // reply.setBooleanProperty("Status", randomGen.nextFloat() < 0.5);
          //  producer.send(reply);
            System.out.println("send response");
         //   System.out.println("send response");
        } catch (JMSException ex) {
            ex.printStackTrace();
        }*/
    }
    
    
}
