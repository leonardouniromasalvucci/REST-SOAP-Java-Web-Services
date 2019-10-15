/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author leona
 */
@WebService(endpointInterface = "edu.softeng.augustws.UniversityInterface")
public class University implements UniversityInterface{
    
    private List<Course> listOfCourses;
    private List<Student> listOfStudents;
    
    public University(){
        listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student("leonardo","salvucci","1601998"));
        listOfStudents.add(new Student("filippo","gemma","1601958"));
        System.out.println("I've created the Students list, list size is: "+listOfStudents.size());
        
        
        listOfCourses = new ArrayList<Course>();
        listOfCourses.add(new Course("01","Software Engineering", new Teacher("Massimo", "Mecella"),listOfStudents));         
        System.out.println("I've added " +listOfCourses.size() +" the courses");
    }
    
    public List<Course> getCoursesList(){
        return listOfCourses;
    }
    
    
}
