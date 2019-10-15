/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.juneexamserver;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author biar
 */
@WebService(endpointInterface = "edu.softeng.juneexamserver.ServiceInterface")
public class ProfessorService implements ServiceInterface{
    
    List<Professor> l = new ArrayList<Professor>();
    
    public ProfessorService(){
        l.add(new Professor("01","francesco","leonardi"));
        l.add(new Professor("02","giulio","frascarelli"));
        l.add(new Professor("03","giorgio","de toma"));
        l.add(new Professor("04","leonardo","dari"));
        l.add(new Professor("05","giulio","laureti"));
        l.add(new Professor("06","martina","ribeca"));
        l.add(new Professor("07","daniele","galli"));      
    }   
    
    public Professor getDetails(String id){
        for(int i=0; i<l.size(); i++){
            if(l.get(i).getId().equals(id)){
                return l.get(i);                
            }           
        }
        return null;
    }
}
