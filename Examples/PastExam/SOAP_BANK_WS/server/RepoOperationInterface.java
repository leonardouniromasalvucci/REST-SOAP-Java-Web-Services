/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.aaaws;

import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService
public interface RepoOperationInterface {
    
    public String[] getOperationByClientID(int ClientID);    
    public String[] getOperationDetailsByID(int OpID);
    
}
