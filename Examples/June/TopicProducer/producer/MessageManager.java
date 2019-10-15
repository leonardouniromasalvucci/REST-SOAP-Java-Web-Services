
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import javax.jms.JMSException;
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
import org.springframework.messaging.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leona
 */
public class MessageManager implements MessageListener{
    
    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private Topic dest = null;
    private TopicPublisher producer = null;

    public MessageManager() {
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            dest = (Topic) jndiContext.lookup("dynamicTopics/professors");        
           
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);         
            producer = session.createPublisher(dest);

            connection.start();
        } catch (Exception e){
            e.printStackTrace();
        }   
    }
    
    public void startMessages() throws Exception{
        final String quotations[] = {"1","2","6"};
       
        while(true){
            TextMessage reply = session.createTextMessage();
            
            int min = 1, max=50;
            Random r = new Random();
            float random = min + r.nextFloat() * (max - min);

            reply.setStringProperty("ID", quotations[r.nextInt(quotations.length)]);
            reply.setFloatProperty("RANKING", random);
            producer.send(reply);  
            Thread.sleep(6000);
        }
    }

    @Override
    public void onMessage(javax.jms.Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
