/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.juneexamserver;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class ProfessorAdapter extends XmlAdapter<Professor, ProfessorInterface> {
    
    
    @Override
    public Professor marshal(ProfessorInterface professor) throws Exception {
        if (professor instanceof Professor) {
            return (Professor) professor;
        }
        return new Professor(professor.getId(),professor.getName(), professor.getSurname());
    }

    @Override
    public ProfessorInterface unmarshal(Professor professor) throws Exception {
        return professor;
    }
}