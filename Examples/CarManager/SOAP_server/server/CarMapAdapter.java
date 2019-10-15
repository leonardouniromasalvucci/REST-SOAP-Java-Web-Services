/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author leona
 */
public class CarMapAdapter extends XmlAdapter<CarMap, Map<String, CarInterface>> {
    public CarMap marshal(Map<String, CarInterface> boundMap) throws Exception {
        CarMap valueMap = new CarMap();
        for (Map.Entry<String, CarInterface> boundEntry : boundMap.entrySet()) {
            CarMap.CarEntry valueEntry = new CarMap.CarEntry();
            valueEntry.setCar((Car)boundEntry.getValue());
            valueEntry.setLicensePlate(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }

    public Map<String, CarInterface> unmarshal(CarMap valueMap) throws Exception {
        Map<String, CarInterface> boundMap = new LinkedHashMap<String, CarInterface>();
        for (CarMap.CarEntry carEntry : valueMap.getEntries()) {
            boundMap.put(carEntry.getLicensePlate(), carEntry.getCar());
        }
        return boundMap;
    }
}