/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leona
 */
public class Course implements CourseInterface{
    
    private String id, name;
    private Teacher teacher;
    private List<Student> listOfStudents = new ArrayList<Student>();

    public Course(String id, String name, Teacher teacher, List<Student> listOfStudents) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.listOfStudents = listOfStudents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
}
