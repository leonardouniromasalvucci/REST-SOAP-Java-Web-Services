/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.julyexamserver;

import java.util.List;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */
@WebService
public interface ServiceInterface {
    
    @XmlJavaTypeAdapter(MovieAdapter.class)
    public List<Movie> getAllMovies();
    
    
}
