/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author leona
 */
@XmlType(name = "CarMap")
public class CarMap {
    private List<CarEntry> entries = new ArrayList<CarEntry>();

    @XmlElement(nillable = false, name = "entry")
    public List<CarEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "CarEntry")
    public static class CarEntry {
        private String licensePlate;
        private Car car;

        public void setLicensePlate (String licensePlate) {
            this.licensePlate = licensePlate;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Car getCar() {
            return car;
        }
    }
}
