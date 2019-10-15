/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws_client_2;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author leona
 */
public class MainClass {
     
    private static List<Car> getAllListOfCars(){
        CarRepositoryService service = new CarRepositoryService();
        CarRepositoryInterface port = service.getCarRepositoryPort();
        return port.getAllListOfCars();
    }   

    private static Car getCarByLicensePlate(String licensePlate){
        CarRepositoryService service = new CarRepositoryService();
        CarRepositoryInterface port = service.getCarRepositoryPort();
        return port.getCarByLicensePlate(licensePlate);
    }      
    
    public static List<String> getAllListOfCarsByLicensePlate(){
        CarRepositoryService service = new CarRepositoryService();
        CarRepositoryInterface port = service.getCarRepositoryPort();
        return port.getAllListOfCarsByLicensePlate();
    }
    
    public static CarMap getAllListOfCarsWithLicensePlate(){
        CarRepositoryService service = new CarRepositoryService();
        CarRepositoryInterface port = service.getCarRepositoryPort();
        return port.getAllListOfCarsWithLicensePlate();
    }
     
    public static void main(String[] args){
        
        System.out.println("Receive all list of cars");
        List<Car> l = getAllListOfCars();
        for (int i=0; i<l.size(); i++){
            System.out.println("Model "+ l.get(i).getModel());
            System.out.println("Price "+l.get(i).getPrice());
            System.out.println("Color "+l.get(i).getColor()); 
            System.out.println("OPTIONALS:"); 
            List<Optional> ll = l.get(i).getListOfOptional();
            for(int k=0; k<ll.size(); k++){
                System.out.println(ll.get(k).getName());
                System.out.println(ll.get(k).getPrice());                 
            }            
            System.out.println("OWNER:"); 
            System.out.println("CF "+l.get(i).getOwner().getCF());
            System.out.println("Name "+l.get(i).getOwner().getName());
            System.out.println("Surname "+l.get(i).getOwner().getSurname());            
        }
        
        System.out.println("\n\n");
        
        System.out.println("Receive all info about a specific car");
        Car c = getCarByLicensePlate("DD062WL");
        if (c != null){
            System.out.println(c.getModel());
            System.out.println(c.getPrice());
            System.out.println(c.getColor());                
        }
        
        System.out.println("\n\n");
        
        System.out.println("Receive all list of cars by license plate");
        List<String> l2 = getAllListOfCarsByLicensePlate();
        for (int i=0; i<l2.size(); i++){
            System.out.println(l2.get(i));        
        }
        
        System.out.println("\n\n");
        
        System.out.println("Check License Plate through JMS");
        CheckLicensePlate check = new CheckLicensePlate(l2);
        check.start();
        
        System.out.println("\n\n");
        
        
        System.out.println("Receive global list of cars");
        CarMap map = getAllListOfCarsWithLicensePlate();
        Iterator<CarEntry> it=map.getEntry().iterator();
     
        while(it.hasNext()){
            CarEntry entry = it.next();
            System.out.println(entry.getLicensePlate()+ " " + entry.getCar().getModel());
        }           
               
    }
    
}
