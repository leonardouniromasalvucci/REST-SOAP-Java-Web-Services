/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.bankws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService(endpointInterface = "edu.softeng.bankws.RepoClientsInterface")
public class RepoClients {
    
    List<Clients> l = new ArrayList<Clients>();
    
    public RepoClients(){      
        l.add(new Clients(1,"Massimo Mecella"));
        l.add(new Clients(2,"Camil Demetrescu"));
        l.add(new Clients(3,"Fabrizio D'amore"));
        l.add(new Clients(4,"Stefano Leonardi"));
        l.add(new Clients(5,"Giorgio Grisetti"));
        l.add(new Clients(6,"Tiziana Catarci"));        
    }
    
    public String[] getClients(){
        String[] arr = new String[100];
        int k=0;
        for(int i=0; i<l.size(); i++){
            arr[k] = ""+l.get(i).getId();System.out.println(arr[k]+"\n");k++;
            arr[k] = l.get(i).getName();System.out.println(arr[k]+"\n");k++;   
            
        }
        return arr;        
    }
}
