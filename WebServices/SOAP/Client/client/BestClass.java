/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.wstest;



import java.util.Iterator;
import java.util.List;

public class BestClass {
             
    private static String hello(String name){
        BaeldungImplService service = new BaeldungImplService();
        Baeldung port = service.getBaeldungImplPort();
        return port.hello(name);
    }

    private static String helloStudent(Student student){
        BaeldungImplService service = new BaeldungImplService();
        Baeldung port = service.getBaeldungImplPort();
        return port.helloStudent(student);
    }
    
    private static List<Student> getListStudents(){
        BaeldungImplService service = new BaeldungImplService();
        Baeldung port = service.getBaeldungImplPort();
        return port.getListStudents();
    }       
    
    private static StudentMap getStudents() {
        BaeldungImplService service = new BaeldungImplService();
        Baeldung port = service.getBaeldungImplPort();
        return port.getStudents();
    }

    private static StudentMapAge getStudentAge() {
        BaeldungImplService service = new BaeldungImplService();
        Baeldung port = service.getBaeldungImplPort();
        return port.getStudentAge();
    }
    
    
    public static void main(String[] args) {

        try {
            Student s1 = new Student();
            s1.setName("Leonardo");
            
            Student s2 = new Student();
            s2.setName("Filippo");
           
            String first = hello("Francesco");       
            System.out.println(first);
            
            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("\n");
            
            String second1 = helloStudent(s1);
            System.out.println(second1);
            String second2 = helloStudent(s2);
            System.out.println(second2);
            
            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("\n");
            
            StudentMap map = getStudents();
            Iterator<StudentEntry> it=map.getEntry().iterator();
     
            while(it.hasNext()){
                StudentEntry entry= it.next();
                System.out.println(entry.getId()+ " " + entry.getStudent().getName());
            }                
            
            
            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("\n");
            
            List<Student> ll = getListStudents();
            Iterator<Student> it2= ll.iterator();
     
            while(it2.hasNext()){
                Student entry2 = it2.next();
                System.out.println(entry2.getName());
            }    
            
            
            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("\n");
            
            StudentMapAge map2 = getStudentAge();
            Iterator<StudentAgeEntry> it3 = map2.getEntry().iterator();
     
            while(it3.hasNext()){
                StudentAgeEntry entry3= it3.next();
                System.out.println(entry3.getStudent()+ " " + entry3.getAge());
            }    
            
            System.out.println("\n");
            System.out.println("--------------");
            System.out.println("\n");
            
	}catch (Exception e){
            e.printStackTrace();
	}
    }
}

