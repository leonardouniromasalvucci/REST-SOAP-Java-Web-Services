/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.soap_ws;

import java.util.List;

/**
 *
 * @author leona
 */
public class Car implements CarInterface{
    
    private String model, color, price;
    private List<Optional> listOfOptional;
    private Owner owner;

    public Car(String model, String color, String price, List<Optional> listOfOptional, Owner owner) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.listOfOptional = listOfOptional;
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Optional> getListOfOptional() {
        return listOfOptional;
    }

    public void setListOfOptional(List<Optional> listOfOptional) {
        this.listOfOptional = listOfOptional;
    }   
    
}
