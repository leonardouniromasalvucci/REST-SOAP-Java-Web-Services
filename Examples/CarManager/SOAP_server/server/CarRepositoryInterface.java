/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author leona
 */
@WebService
public interface CarRepositoryInterface {
    
    public List<String> getAllListOfCarsByLicensePlate();
    
    public Car getCarByLicensePlate(String licensePlate);
    
    public List<Car> getAllListOfCars();
    
    @XmlJavaTypeAdapter(CarMapAdapter.class)
    public Map<String,Car> getAllListOfCarsWithLicensePlate();   
    
}
