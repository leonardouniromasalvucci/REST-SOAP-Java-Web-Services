/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jmsserver;

import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MessageConverter;

public class ExampleMessageReceiver{

    static Context ictx = null;
    MessageConverter messageConverter;
    JmsTemplate jmsTemplate; 
    
    public static void main(String[] args) throws JMSException, InterruptedException {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
       
            ictx = new InitialContext(props);
            Queue queue = (Queue) ictx.lookup("dynamicQueues/firstQueue");
            QueueConnectionFactory qcf = (QueueConnectionFactory) ictx.lookup("ConnectionFactory");
            ictx.close();

            QueueConnection qc = qcf.createQueueConnection();
            QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueReceiver qsrec = qs.createReceiver(queue);
            qc.start(); //starting session
            
            TextMessage mess;// = (TextMessage)msg;
            int i = 0;
            while (true && i<4) {
                i++;               
                mess = (TextMessage) qsrec.receive();     
                Enumeration enumeration = mess.getPropertyNames();
                //while(enumeration.hasMoreElements()){
                    //if(mess.getStringProperty(enumeration.nextElement().toString()).equals("Price")){
                    System.out.println("Student"+i);     
                    System.out.println(mess.getStringProperty("Name"));  
                    System.out.println(mess.getStringProperty("Surname"));
                    System.out.println("==========\n");
                    //}
                // System.out.print(mess.getStringProperty(enumeration.nextElement().toString())+ " - ");                                 
           //   }
            }       
                       
                      
            //TextMessage msg;  
            /*  int i = 0;
            while (true && i < 10) {
                i++;
                msg = (TextMessage) qsrec.receive();
                System.out.print("Message: " + msg.getText() + "\nId: " + msg.getJMSMessageID());
                System.out.println("wainting for a message... ");
                Thread.sleep(5000);
            }*/

            qc.close();
        } catch (NamingException ex) {
            Logger.getLogger(ExampleMessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}