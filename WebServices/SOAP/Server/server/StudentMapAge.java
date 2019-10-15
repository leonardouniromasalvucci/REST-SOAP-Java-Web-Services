/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.wstest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name = "StudentMapAge")
public class StudentMapAge {
    
    private List<StudentAgeEntry> entries = new ArrayList<StudentAgeEntry>();

    @XmlElement(nillable = false, name = "entry")
    public List<StudentAgeEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "StudentAgeEntry")
    public static class StudentAgeEntry {
        private Integer age;
        private String student;

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setStudent(String student) {
            this.student = student;
        }

        public String getStudent() {
            return student;
        }
    }
    
}
