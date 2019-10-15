/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jms_receiver;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;


/**
 *
 * @author leona
 */
public class Manager implements MessageListener{
    
    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null, dest2=null;
    private TopicPublisher producer = null;
    private TopicSubscriber q_sub=null;

    public Manager() {

        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            dest = (Topic) jndiContext.lookup("dynamicTopics/Checklicense");         
            dest2 = (Topic) jndiContext.lookup("dynamicTopics/ChecklicenseResponse");
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
         
            producer = session.createPublisher(dest2);
            q_sub = session.createSubscriber(dest);            
            q_sub.setMessageListener(this);         
            
            connection.start();
        } catch (Exception e){
            e.printStackTrace();
        }   
    }

    @Override
    public void onMessage(Message msg) {
        TextMessage mess=(TextMessage) msg;
        try {            
            /* Riceve e stampa un messaggio per volta */
            System.out.println(mess.getStringProperty("LicensePlate"));  
            System.out.println();
            
            TextMessage reply = session.createTextMessage();
            
            if(mess.getStringProperty("LicensePlate").equals("DD062WL")){
                reply.setBooleanProperty("ResponseLicense", true);
                producer.send(reply);
                System.out.println("sent response");
            }else{
                reply.setBooleanProperty("ResponseLicense", false);
                producer.send(reply);
                System.out.println("sent response");
            }            
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}