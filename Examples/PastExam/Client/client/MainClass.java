
import edu.softeng.aaaws.RepoOperationInterface;
import edu.softeng.aaaws.RepoOperationService;
import edu.softeng.bankws.RepoClientsInterface;
import edu.softeng.bankws.RepoClientsService;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leona
 */
public class MainClass {
    
    private static List<String> getOperationByClientID(int clientID){
        RepoOperationService service = new RepoOperationService();
        RepoOperationInterface port = service.getRepoOperationPort();
        return port.getOperationByClientID(clientID);
    }
    
    private static List<String> getOperationDetailsByID(int OpId){
        RepoOperationService service = new RepoOperationService();
        RepoOperationInterface port = service.getRepoOperationPort();
        return port.getOperationDetailsByID(OpId);
    }
    
    private static List<String> getClients(){
        RepoClientsService service = new RepoClientsService();
        RepoClientsInterface port = service.getRepoClientsPort();
        return port.getClients();
    }
    
    private static void search(int id){
        String s = ""+id;
        List<String> lista3 = getClients();
        for(int d=0; d<lista3.size()-1; d++){
            if(lista3.get(d).equals(s)){
                System.out.println("ID "+lista3.get(d)+", "+lista3.get(d+1)+"\n");                       
            }                    
        }    
    }
    
    public static void main(String[] args){
        
        System.out.println("Receive all list of clients");
        
        List<String> l = getOperationByClientID(1);
        for (int i=0; i<l.size(); i++){
           System.out.println(l.get(i));
        }
        System.out.println("\n");
        List<String> l2 = getOperationByClientID(2);
        for (int i=0; i<l2.size(); i++){
           System.out.println(l2.get(i));
        }
        System.out.println("\n");
        List<String> l3 = getOperationByClientID(3);
        for (int i=0; i<l3.size(); i++){
           System.out.println(l3.get(i));
        }
        System.out.println("\n");
        
        System.out.println("Receive all details of operation");
        List<String> l4 = getOperationDetailsByID(3);
        int k=0; String s="";
        for (int i=0; i<l4.size(); i++){
            if(k<5){
                s+= " "+l4.get(i)+" ";
            }else{
                s+="\n";
                k=-1;
            } 
            k++;           
        }
        System.out.println(s);
        
        System.out.println("\n");
        
        System.out.println("Receive all clients");
        List<String> l5 = getClients();
        int kk=0; String ss="";
        for (int j=0; j<l5.size()-1; j++){
            if(j%2==0){
                ss+= " "+l5.get(j)+","+ l5.get(j+1);
            }else{
                ss+="\n";
            }
        }
        System.out.println(ss);         
        
        System.out.println("\n");
        
                
        /* All the names of all clients who have perfermoed an operation in the last days with the description "Automobile" */
        
        int number_of_clients = 6;
        int p=1;
        String id="";
        while(p<number_of_clients){
            List<String> lista = getOperationByClientID(p);
            for(int i=0; i<lista.size(); i++){
              //  System.out.println(lista.get(i)+" ");
                List<String> lista2 = getOperationDetailsByID(Integer.parseInt(lista.get(i)));
                for(int y=0; y<lista2.size(); y++){
                    //System.out.println(lista2.get(y)+" ");
                    if(lista2.get(y).equals("Automobile") && lista2.get(y-4).equals(""+p)){
                        //System.out.println("Code "+p);  
                        search(p);                                 
                    }     
                }
            }
            p++;  
        }      
        
        /* All the names of all clients who have NOT perfermoed ANY operations in the last days */
        System.out.println("\n");
        
        
        p=1;
        id="";
        while(p<number_of_clients){
            List<String> lista = getOperationByClientID(p);
            if(lista.size()==0){
                search(p);
            }
            p++;  
        }     
        
        
        
    }   
}
