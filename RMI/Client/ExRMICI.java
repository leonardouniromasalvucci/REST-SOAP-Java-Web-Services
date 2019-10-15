import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;


public class ExRMICl {

    public static void main(String[] args) throws Exception {
        
        Registry registry = LocateRegistry.getRegistry("localhost", 5555);
        ServerInterface stub = (ServerInterface) registry.lookup("Server");
        int myID = stub.startTask();
        Thread.sleep(4500);
        
        while(stub.isReady(myID)){
            System.out.println("...I'm waiting...");
            Thread.sleep(4500);
        }
        
        System.out.println(Arrays.toString(stub.getResults(myID)));
        
    }
    
}
