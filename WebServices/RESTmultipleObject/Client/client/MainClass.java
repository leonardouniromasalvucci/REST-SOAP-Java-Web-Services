/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.restclient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 *
 * @author biar
 */
public class MainClass {  
   
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {               
        
        WebClient client = WebClient.create("http://localhost:8080/baeldung/");
        
        
        /*  GET COURSE BY ID */
        
        Course c = client.path("courses/1").accept("text/xml").get(Course.class); 
        System.out.print(c.getId()+ " \n");
        System.out.print(c.getName() + " \n"); 
        List<Student> l = c.getStudents();
        for(int i=0; i<l.size(); i++){
            System.out.println(l.get(i).getName());            
        }
        System.out.println(" \n");    
               
        client.back(true);
        System.out.println(" \n\n");       
        
        
        /* UPDATE COURSE BY ID */
        
        List<Student> list = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setId(3);
        s1.setName("Franco Prendusci");
        list.add(s1);
        
        Course c1 = new Course();
        c1.setId(1);
        c1.setName("Embedeed System");
        c1.setStudents(list);        
        
        Response r1 = client.path("courses/1").accept("text/xml").put(c1);
        System.out.println(r1.getStatusInfo().getStatusCode());
        
        client.back(true);
        System.out.println(" \n\n");        
        
        /*  GET COURSE BY ID */
        
        Course c2 = client.path("courses/1").accept("text/xml").get(Course.class); 
        System.out.print(c2.getId()+ " \n");
        System.out.print(c2.getName() + " \n"); 
        List<Student> l2 = c2.getStudents();
        for(int i=0; i<l2.size(); i++){
            System.out.println(l2.get(i).getName());            
        } 
               
        client.back(true);
        System.out.println(" \n\n");      
        
        
        /* ADD NEW COURSE */
        
        List<Student> list2 = new ArrayList<Student>();
        Student s2 = new Student();
        s2.setId(3);
        s2.setName("Luca Recchi");
        Student s3 = new Student();
        s3.setId(4);
        s3.setName("Marco Cimarelli");
        list2.add(s2);
        list2.add(s3);
        
        Course c3 = new Course();
        c3.setId(4);
        c3.setName("Distributed System");
        c3.setStudents(list2);        
        
        Response r2 = client.path("courses/4").accept("text/xml").post(c3);
        System.out.println(r2.getStatusInfo().getStatusCode());
        
        client.back(true);
        System.out.println(" \n\n");           
        
        /*  GET COURSE BY ID */        
        
        Course c4 = client.path("courses/4").accept("text/xml").get(Course.class); 
        System.out.print(c4.getId()+ " \n");
        System.out.print(c4.getName() + " \n"); 
        List<Student> l3 = c4.getStudents();
        for(int i=0; i<l3.size(); i++){
            System.out.println(l3.get(i).getName());            
        }    
               
        client.back(true);
        System.out.println(" \n\n");     
        
        /*  GET ALL STUDENTS OF COURSE BY ID */
        
        List<Student> listOfStudentsForCourse = (List<Student>)client.path("courses/4/students").accept("text/xml").getCollection(Student.class);
        for(int k=0; k<listOfStudentsForCourse.size(); k++){
            System.out.println(listOfStudentsForCourse.get(k).getName());            
        }
                        
        client.back(true);
        System.out.println(" \n\n");             
       
        
        /*  ADD STUDENTS TO A COURSE */
        
        List<Student> list3 = new ArrayList<Student>();
        Student s4 = new Student();
        s4.setId(3);
        s4.setName("Simone Casella");
        Student s5 = new Student();
        s5.setId(4);
        s5.setName("Marco Ceasaetti");
        list3.add(s4);
        list3.add(s5);        
        
        Response r3 = client.path("courses/4/students").accept("text/xml").postCollection(list3,Student.class);
        System.out.println(r3.getStatusInfo().getStatusCode());
        
        client.back(true);
        System.out.println(" \n\n");
        
        /*  GET COURSE BY ID */
        
        List<Student> listOfStudentsForCourse2 = (List<Student>)client.path("courses/4/students").accept("text/xml").getCollection(Student.class);
        for(int k=0; k<listOfStudentsForCourse2.size(); k++){
            System.out.println(listOfStudentsForCourse2.get(k).getName());            
        }
        
        client.back(true);
        System.out.println(" \n\n");
        
        /* DELETE COURSE BY ID */
        
      
        Response r4 = client.path("courses/4").accept("text/xml").delete();
        System.out.println(r4.getStatusInfo().getStatusCode());
     
        client.back(true);
        System.out.println(" \n\n");
        
    }   
    
}
