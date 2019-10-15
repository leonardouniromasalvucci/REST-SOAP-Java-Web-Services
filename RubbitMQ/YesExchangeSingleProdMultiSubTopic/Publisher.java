import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author biar
 */
public class Publisher {   
   
    private static final String EXCHANGE_NAME = "topic_xxx";
    private static final String routingKey = "coda.first";
    private static final String routingKey2 = "coda.second";
    private static final String routingKey3 = "coda.third";
    
    public static void main(String[] args) throws Exception{  

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            
            try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {

                channel.exchangeDeclare(EXCHANGE_NAME, "topic");             
                
                String message1= "Hi, this message is for the FIRST";             
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message1.getBytes("UTF-8"));
                System.out.println(" [x] Sent for the FIRST'" + routingKey + "':'" + message1 + "'");
                
                String message2= "Hi, this message is for the SECOND";
                channel.basicPublish(EXCHANGE_NAME, routingKey2, null, message2.getBytes("UTF-8"));
                System.out.println(" [x] Sent for the SECOND" + routingKey2 + "':'" + message2 + "'");
                
                String message3= "Hi, this message is for the THIRD";
                channel.basicPublish(EXCHANGE_NAME, routingKey3, null, message3.getBytes("UTF-8"));
                System.out.println(" [x] Sent for the THIRD" + routingKey3 + "':'" + message3 + "'");

            } catch (IOException ex) {
                Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TimeoutException ex) {
                Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }

}
