/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jmsclient;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ExampleMessageSender {

  static Context ictx = null;

    public static void main(String[] args) throws JMSException {
        
        
        
        List<Student> l = new ArrayList<Student>();
        l.add(new Student("leonardo","salvucci"));
        l.add(new Student("filippo","gemma"));
        l.add(new Student("sebastiano","rivoli"));
        l.add(new Student("giulio","laureti"));
        
    
        
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            
            //Creare il contesto
            ictx = new InitialContext(props);
            
            Queue queue ;
            queue = (Queue) ictx.lookup("dynamicQueues/firstQueue");
            
            QueueConnectionFactory qcf;
            qcf = (QueueConnectionFactory) ictx.lookup("ConnectionFactory");
            
            ictx.close();
            
            QueueConnection qc;
            qc = qcf.createQueueConnection();
            
            QueueSession qs;  
            qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            
            QueueSender qsender;
            qsender = qs.createSender(queue);
            
           /* Student s = new Student("Leonardo","Salvucci");
            ObjectMessage message = qs.createObjectMessage(s);
            qsender.send(message);*/
            
            /*  TextMessage mess = null;
            int i=0;
            while(i<5){
                i++;
                mess = qs.createTextMessage();
                mess.setStringProperty("Quotation", "hno");
                mess.setDoubleProperty("Price", i);
                mess.setStringProperty("Test", "ciaoo");
                qsender.send(mess);            
            }*/
            
            TextMessage mess = null;
            for (int i = 0; i < l.size(); i++) {
                mess = qs.createTextMessage();
                mess.setStringProperty("Name", l.get(i).getName());
                mess.setStringProperty("Surname", l.get(i).getSurname());
                qsender.send(mess);
            }
                       
            
            /*  TextMessage msg;
            int i=0;
            while(i<20){
                i++;
                msg = qs.createTextMessage();
                msg.setText("TESTO"+i);
                qsender.send(msg);
                System.out.print("\nInviato messaggio:\t"+msg.getText()+"\n");
            
            }*/            
            System.out.println("VERY GOOD");
            System.exit(0);
        } catch (NamingException ex) {
            Logger.getLogger(ExampleMessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}