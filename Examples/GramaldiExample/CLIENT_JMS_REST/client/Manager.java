/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.client_rest_jms;

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
public class Manager implements MessageListener{
    
    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null;
    private TopicPublisher producer = null;
    private TopicSubscriber o_sub=null, q_sub=null;
    private Client client = new Client();

    public Manager() {

        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            dest = (Topic) jndiContext.lookup("dynamicTopics/Grimaldi");
         
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
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
            
            System.out.println(mess.getIntProperty("ID"));  
            System.out.println(mess.getDoubleProperty("PESO"));  
            System.out.println();            
            
            client.deleteBagaglio(mess.getIntProperty("ID"),mess.getDoubleProperty("PESO"));
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}