/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jms_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MessageConverter;
/**
 *
 * @author leona
 */
public class Receiver_queue {
    
    static Context ictx = null;
    MessageConverter messageConverter;
    JmsTemplate jmsTemplate; 
   
    
    public static void main(String[] args) throws JMSException, InterruptedException {   
       
        
        List<String> blackList = new ArrayList<String>(){};
        blackList.add("UTVUYG1527");        

        
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
       
            ictx = new InitialContext(props);
            Queue queue = (Queue) ictx.lookup("dynamicQueues/flights");
            Queue queue2 = (Queue) ictx.lookup("dynamicQueues/flights2");
            QueueConnectionFactory qcf = (QueueConnectionFactory) ictx.lookup("ConnectionFactory");
            ictx.close();

            QueueConnection qc = qcf.createQueueConnection();
            QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueReceiver qsrec = qs.createReceiver(queue);
            QueueSender qsrec_send = qs.createSender(queue2);
            qc.start(); //starting session
            
            TextMessage mess;// = (TextMessage)msg;

            while (true) {
       
                mess = (TextMessage) qsrec.receive();   
                if(blackList.contains(mess.getStringProperty("CF"))){
                    System.out.println("MINACCIA");
                    mess = qs.createTextMessage();
                    mess.setStringProperty("Response", "MINACCIA");
                    qsrec_send.send(mess);   
                    System.out.println("SEND_M");
                }else{
                    System.out.println("FREE");
                    mess = qs.createTextMessage();
                    mess.setStringProperty("Response", "FREE");
                    qsrec_send.send(mess);  
                    System.out.println("SEND_F");
                }
                System.out.println();
               
            }       

          //  qc.close();
        } catch (NamingException ex) {
            Logger.getLogger(Receiver_queue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
