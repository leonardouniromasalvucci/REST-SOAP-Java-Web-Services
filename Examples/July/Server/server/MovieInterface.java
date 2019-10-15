/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.julyexamserver;

import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */
@XmlJavaTypeAdapter(MovieAdapter.class)
public interface MovieInterface {
    
    public int getId();
    public String getTitle();
    public String getDirector();
    public String getYear();
    
}
