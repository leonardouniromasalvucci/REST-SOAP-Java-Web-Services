/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws_client;

import java.util.List;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author leona
 */
public class CheckLicensePlate implements MessageListener{   
   
    private Properties props;
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null, dest2 = null;
    private TopicPublisher producer = null;
    private List<String> LicensePlate;
    private TopicSubscriber q_sub=null;
    
    public CheckLicensePlate(List<String> license) {
        this.LicensePlate = license;
        //look up for the connection factory
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");              
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void onMessage(Message msg) {
        System.out.println("Ho ricevuto un messaggio...");
        TextMessage mess=(TextMessage) msg;
        try {            
            /* Riceve e stampa un messaggio per volta */
            System.out.println(mess.getBooleanProperty("ResponseLicense"));  
            System.out.println();
            
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        try {
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = (Topic) jndiContext.lookup("dynamicTopics/Checklicense");
            dest2 = (Topic) jndiContext.lookup("dynamicTopics/ChecklicenseResponse");    
            q_sub = session.createSubscriber(dest2);            
            q_sub.setMessageListener(this);         
            producer = session.createPublisher(dest);
            connection.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            TextMessage mess = null;
            for(int k=0; k<LicensePlate.size(); k++){
                try {
                    mess = session.createTextMessage();
                    mess.setStringProperty("LicensePlate", LicensePlate.get(k));
                    try{
                        Thread.sleep(8000);
                        producer.send(mess);
                    }catch(Exception ex){}                  
                   
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
    }
}
