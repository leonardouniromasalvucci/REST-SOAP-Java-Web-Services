/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest_server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leona
 */
@XmlRootElement(name = "Passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {
    
    private String CF, name, surname;
    
    public Passenger(){}

    public Passenger(String CF, String name, String surname) {
        this.CF = CF;
        this.name = name;
        this.surname = surname;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}
