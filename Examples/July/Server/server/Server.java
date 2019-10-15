import javax.xml.ws.Endpoint;

public class Server {
    
    public static void main(String args[]) throws InterruptedException {
        MoviesCollection implementor = new MoviesCollection();
        String address = "http://localhost:8080/movies";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
    
}
