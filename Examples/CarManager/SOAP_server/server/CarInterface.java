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
public interface CarInterface {
    public String getModel();
    public String getColor();
    public String getPrice(); 
    public List<Optional> getListOfOptional();
    public Owner getOwner();
}
