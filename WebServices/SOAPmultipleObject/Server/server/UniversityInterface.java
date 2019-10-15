/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

import java.util.List;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author leona
 */
@WebService
public interface UniversityInterface {
    
    public List<Course> getCoursesList();
    
}
