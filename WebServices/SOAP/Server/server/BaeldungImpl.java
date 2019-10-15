/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.wstest;

/**
 *
 * @author biar
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

@WebService(endpointInterface = "edu.softeng.wstest.Baeldung")
public class BaeldungImpl implements Baeldung {
    
    
    private Map<String, Integer> student = new LinkedHashMap<String, Integer>();    
    private Map<Integer, Student> students = new LinkedHashMap<Integer, Student>();
    private List<Student> student_list = new ArrayList<Student>();
    
    BaeldungImpl(){
        student.put("kevin", 23);
        student.put("jhon", 48);
        student.put("bolt", 34);
        student.put("yuri", 21);    
    }    
     
    public String hello(String name) {
        return "Hello " + name;
    }
    
    public String helloStudent(Student student) {
        students.put(students.size() + 1, student);
        student_list.add(student);
        return "Hello " + student.getName();
    }
    
    public List<Student> getListStudents(){
        return student_list;
    }
    
    public Map<Integer,Student> getStudents() {
        return students;
    }
    
    public Map<String,Integer> getStudentAge() {
        return student;
    }
    
    
}
