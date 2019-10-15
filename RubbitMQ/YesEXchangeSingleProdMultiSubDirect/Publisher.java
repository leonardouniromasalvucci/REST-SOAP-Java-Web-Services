import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author biar
 */
public class Publisher {    
   
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            String message = "Hi baby, I'm Leonardo";
            String message2 = "Hi baby, I'm Francesco";

            channel.basicPublish(EXCHANGE_NAME, "info", null, message.getBytes("UTF-8")); // [info] [warning] [error]
            System.out.println(" [x] Sent '" + "info" + "':'" + message + "'");
            
            channel.basicPublish(EXCHANGE_NAME, "warning", null, message2.getBytes("UTF-8")); // [info] [warning] [error]            
            System.out.println(" [x] Sent '" + "warning" + "':'" + message2 + "'");
        }
    }    
}
