/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;

@Path("baeldung")
@Produces({MediaType.TEXT_XML}) 
public class CourseRepository {
    private Map<Integer, Course> courses = new HashMap<>();

    {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setId(1);
        student1.setName("Leonardo Salvucci");
        student2.setId(2);
        student2.setName("Filippo Gemma");

        List<Student> course1Students = new ArrayList<>();
        course1Students.add(student1);
        course1Students.add(student2);

        Course course1 = new Course();
        Course course2 = new Course();
        course1.setId(1);
        course1.setName("Software Engineering");
        course1.setStudents(course1Students);
        course2.setId(2);
        course2.setName("Cyber security");

        courses.put(1, course1);
        courses.put(2, course2);
    }

    @GET
    @Path("courses/{courseId}")
    public Course getCourse(@PathParam("courseId") int courseId) {
        return findById(courseId);
    }

    @PUT
    @Path("courses/{courseId}")
    public Response updateCourse(@PathParam("courseId") int courseId, Course course) {
        Course existingCourse = findById(courseId);
        if (existingCourse == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existingCourse.equals(course)) {
            return Response.notModified().build();
        }
        courses.put(courseId, course);
        return Response.ok().build();
    }
    
    @POST
    @Path("courses/{courseId}")
    public Response addCourse(@PathParam("courseId") int courseId, Course course) {
        Course existingCourse = findById(courseId);
        if (existingCourse != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }      
        courses.put(courseId, course);
        return Response.ok().build();
    }
    
    /*@GET
    @Path("courses")    
    public Map<Integer, Course> getAllCourses(){
        return courses;
    }*/
    
    @GET
    @Path("courses/{courseId}/students")
    public List<Student> getAllStudentOfCourse(@PathParam("courseId") int courseId) {
        List<Student> l = new ArrayList<Student>();
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            if(entry.getValue().getId() == courseId){
                return entry.getValue().getStudents();                
            }
        }
        return null;
    }
    
    @POST
    @Path("courses/{courseId}/students")
    public Response AddStudentToCourse(@PathParam("courseId") int courseId, List<Student> l) {
        Course c = null;
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            if(entry.getValue().getId() == courseId){
                c = entry.getValue();                       
            }
        }
        
        for(int i=0; i<l.size();i++){
            c.addStudent(l.get(i));                    
        }   
        return Response.ok().build();
    }
    
    @DELETE
    @Path("courses/{courseId}")
    public Response DeleteCourse(@PathParam("courseId") int courseId) {
        Course c = null;
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            if(entry.getValue().getId() == courseId){
                courses.remove(entry);   
                return Response.ok().build();
            }
        }
        return Response.notModified().build();
    }
    
  /*  @GET
    @Path("courses/integermap")
    public List<Integer> getIntegerMap(){
        List<Integer> l = new ArrayList<Integer>();
       for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
           l.add(entry.getKey());
        }     
        return l;
    }
    
    @GET
    @Path("courses/coursemap")
    public List<Course> getCourseMap(){
        List<Course> l = new ArrayList<Course>();
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
           l.add(entry.getValue());
        }        
        return l;
    }*/
    
    
    @Path("courses/{courseId}/students")
    public Course pathToStudent(@PathParam("courseId") int courseId) {
        return findById(courseId);
    }

    private Course findById(int id) {
        for (Map.Entry<Integer, Course> course : courses.entrySet()) {
            if (course.getKey() == id) {
                return course.getValue();
            }
        }
        return null;
    }
    
}