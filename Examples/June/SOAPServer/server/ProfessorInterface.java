/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.juneexamserver;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */
@XmlJavaTypeAdapter(ProfessorAdapter.class)
public interface ProfessorInterface {
    
    public String getId();
    public String getName();
    public String getSurname();
    
}
