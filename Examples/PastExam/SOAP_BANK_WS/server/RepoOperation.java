/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.aaaws;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService(endpointInterface = "edu.softeng.aaaws.RepoOperationInterface")
public class RepoOperation {
  
    List<Operation> l;
    
    public RepoOperation(){                
        l = new ArrayList<Operation>();        
        Operation o1 = new Operation(1,1,"23/08/2019", "Cena al ristorante", 250);
        Operation o2 = new Operation(1,2,"2/09/2019", "Benzina autostrada", 50);
        Operation o3 = new Operation(1,3,"19/08/2019", "Automobile", 150);
        Operation o4 = new Operation(2,1,"3/09/2019", "Abbigliamento", 450);
        Operation o5 = new Operation(3,1,"21/08/2016", "Aperitivo", 40);
        Operation o6 = new Operation(3,2,"15/08/2017", "Automobile", 4250);
        Operation o7 = new Operation(4,1,"21/08/2014", "Aperitivo", 40);
        Operation o8 = new Operation(5,1,"15/08/2016", "Automobile", 4250);
        
        l.add(o1);l.add(o2);l.add(o3);l.add(o4);l.add(o5);l.add(o6);l.add(o7);l.add(o8);    
    }
    
    public String[] getOperationByClientID(int ClientID){
        String[] listOfOperations = new String[100];
        int k=0;
        for (int i=0; i<l.size(); i++){
            if(l.get(i).getClientID() == ClientID){
                try{
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String inputString1 = l.get(i).getDate();
                    String inputString2 = "8/09/2019";
                    Date date1 = myFormat.parse(inputString1);
                    Date date2 = myFormat.parse(inputString2);
                    long diff = date2.getTime() - date1.getTime();
                    if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)<30){
                        listOfOperations[k] = ""+l.get(i).getOperationID();
                        k++;
                    }
                }catch(Exception e){} 
            }          
        }
        return listOfOperations;
    }
    
    public String[] getOperationDetailsByID(int OpID){
        String[] listOfOperations = new String[100];
        int k=0;
        for(int i=0; i<l.size(); i++){
            if(l.get(i).getOperationID() == OpID){
               // listOfOperations[k] = ""+l.get(i).getClientID()+","+l.get(i).getOperationID()+","+l.get(i).getDate()+","+l.get(i).getAmount()+","+l.get(i).getDescription();
                listOfOperations[k] = ""+l.get(i).getClientID();k++;          
                listOfOperations[k] = ""+l.get(i).getOperationID();k++; 
                listOfOperations[k] = l.get(i).getDate();k++;    
                listOfOperations[k] = ""+l.get(i).getAmount();k++;
                listOfOperations[k] = l.get(i).getDescription();k++;         
            }                       
        }
        return listOfOperations;
    }
    
}
