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
public interface OperationInterface {
    
    public int getClientID();
    public int getOperationID();
    public String getDate();
    public String getDescription();
    public double getAmount();    
    
}
