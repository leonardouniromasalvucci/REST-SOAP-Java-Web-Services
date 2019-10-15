/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.aaaws;

/**
 *
 * @author leona
 */
public class Operation implements OperationInterface{
    
    private int clientID, operationID;
    private String date, description;
    private double amount;

    public Operation(int clientID, int operationID, String date, String description, double amount) {
        this.clientID = clientID;
        this.operationID = operationID;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    } 
    
}
