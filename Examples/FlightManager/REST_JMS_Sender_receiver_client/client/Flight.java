/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_client;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@XmlRootElement(name = "Flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {
    
    private String from, to;
    private double time;
    private List<Passenger> l;
    
    public Flight(){}
     
    public Flight(String from, String to, double time, List<Passenger> l) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.l = l;
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<Passenger> getL() {
        return l;
    }

    public void setL(List<Passenger> l) {
        this.l = l;
    }
    
}
