/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

import java.util.List;

/**
 *
 * @author leona
 */
public interface CourseInterface {
    
    public String getId();
    public String getName();
    public Teacher getTeacher();
    public List<Student> getListOfStudents();
    
}
