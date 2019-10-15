/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService(endpointInterface = "edu.softeng.soap_ws.CarRepositoryInterface")
public class CarRepository implements CarRepositoryInterface{
    
    private Map<String, Car> cars = new LinkedHashMap<String, Car>();   
    List<Optional> l1 = new ArrayList<Optional>();
    List<Optional> l2 = new ArrayList<Optional>();
    List<Optional> l3 = new ArrayList<Optional>();
    
            
    public CarRepository(){
        l1.add(new Optional("Tettino", 500));
        l1.add(new Optional("Colore metallizzato", 200));
        l1.add(new Optional("Cerchi in lega", 800));
        
        l2.add(new Optional("Tettino", 1000));
        l2.add(new Optional("Colore metallizzato", 3000));
        l2.add(new Optional("Cerchi in lega", 1800));
        
        l3.add(new Optional("Tettino", 900));
        l3.add(new Optional("Colore metallizzato", 4000));
        l3.add(new Optional("Cerchi in lega", 2300));
        
        cars.put("DD062WL", new Car("Micra", "Beige", "1400", l1, new Owner("UG6889RGS", "Franco", "Belli")));
        cars.put("DD543AD", new Car("Audi", "Green", "3400", l2, new Owner("FG2355KEFF", "Fabio", "Salvucci")));
        cars.put("ED643WD", new Car("Volvo", "Blue", "4100", l3, new Owner("AS3435RGHR", "Marco", "Rossi")));        
    }
    
    public List<String> getAllListOfCarsByLicensePlate(){
        List<String> carLicensePlate = new ArrayList<String>();
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            carLicensePlate.add(entry.getKey());
        }
        return carLicensePlate;
    }
    
    public Car getCarByLicensePlate(String LicensePlate){
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            if(entry.getKey().equals(LicensePlate)){
                return entry.getValue();
            }
        }
        return null;        
    }
    
    public List<Car> getAllListOfCars(){
        List<Car> listOfCars = new ArrayList<Car>();
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            listOfCars.add(entry.getValue());
        }
        return listOfCars;   
    }
    
    public Map<String,Car> getAllListOfCarsWithLicensePlate(){
        return cars;
    }
    
    
    
    
    
    
    
}
