import java.util.Enumeration;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

 public class MainClass implements MessageListener{
    
    private Properties props = new Properties();
    private InitialContext jndiContext = null;
    private TopicConnectionFactory cf = null;
    private TopicConnection connection = null;
    private TopicSession session = null;
    private TopicSubscriber o_sub=null;
    private Topic dest2=null;
    
    public MainClass(){
        props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        try {
            jndiContext = new InitialContext(props);
            cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
    
            dest2 = (Topic) jndiContext.lookup("dynamicTopics/professors");
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);                     
            
            o_sub = session.createSubscriber(dest2);
       
            o_sub.setMessageListener(this);
            connection.start();
            System.out.println("OK!");
        } catch (Exception e){
            e.printStackTrace();
        }           
    }
    
    @Override
    public void onMessage(Message msg) {
        TextMessage mess=(TextMessage) msg;   
   
        try {
            System.out.println("Sto leggendo gli elementi dalla coda AMQP\n");
            Professor p = getDetails(mess.getStringProperty("ID")); 
            if(p==null){
                System.out.println("Non ho trovato una corrispondenza");                
            }else{
                System.out.println("STAMPO GLI ELEMENTI DAL WEB SERVICE \n");
                System.out.println("Ricevuto id : "+p.getId()+" con ranking "+mess.getStringProperty("RANKING")+" bravo "+p.getName()+" "+p.getSurname());
            }       

        }catch(JMSException ex){
            ex.printStackTrace();
        }
    }
    
    
    private static Professor getDetails(String id){
        ProfessorServiceService service = new ProfessorServiceService();
        ServiceInterface port = service.getProfessorServicePort();
        return port.getDetails(id);
    }
    
    
    public static void main(String[] args){
        MainClass m = new MainClass();
    } 
    
}
