/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.july_soap_ws;

import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService
public interface MovieRepoInterface {
    
    public List<Movie> getAllListOfMovie();
    
}
