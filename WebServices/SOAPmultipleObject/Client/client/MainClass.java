/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augusrwsclient;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author leona
 */
public class MainClass {
    
    private static List<Course> getCoursesList() {
        UniversityService service = new UniversityService();
        UniversityInterface port = service.getUniversityPort();
        return port.getCoursesList();
    }
    
    
    public static void main(String[] args) {

        try {
                        
            List<Course> ll = getCoursesList();
            Iterator<Course> it2= ll.iterator();
     
            while(it2.hasNext()){
                Course entry2 = it2.next();
                System.out.println(entry2.getId());
                System.out.println(entry2.getName());
                
                System.out.println("------------------------------------------");
                
                
                List<Student> l = entry2.getListOfStudents();
                for(int i=0; i<l.size(); i++){
                    System.out.println(l.get(i).getName()+","+l.get(i).getSurname()+","+l.get(i).getMatricola());                    
                }
                
                System.out.println("------------------------------------------");
                
                Teacher t = entry2.getTeacher();
                System.out.println(t.getName());
                System.out.println(t.getSurname());
                System.out.println("------------------------------------------");
                
            }    
           
            
	}catch (Exception e){
            e.printStackTrace();
	}
    }
    
    
    
}
