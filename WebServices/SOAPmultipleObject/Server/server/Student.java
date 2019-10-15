/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.augustws;

/**
 *
 * @author leona
 */
public class Student implements StudentInterface{
    
    private String name, surname, matricola;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Student(String name, String surname, String matricola) {
        this.name = name;
        this.surname = surname;
        this.matricola = matricola;
    }
    
}
