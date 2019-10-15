import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class Server {
    
    public static void main(String args[]) throws InterruptedException {
        ProfessorService implementor = new ProfessorService();
        String address = "http://localhost:8080/professorManagment";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
    
}
