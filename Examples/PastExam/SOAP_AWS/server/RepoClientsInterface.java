/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.bankws;

import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService
public interface RepoClientsInterface {
    
    public String[] getClients();
    
}
