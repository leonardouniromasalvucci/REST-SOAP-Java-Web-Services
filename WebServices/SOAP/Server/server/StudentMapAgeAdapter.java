/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.wstest;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class StudentMapAgeAdapter extends XmlAdapter<StudentMapAge, Map<String,Integer>> {    
   
    public StudentMapAge marshal(Map<String,Integer> boundMap) throws Exception{
        StudentMapAge valueMap = new StudentMapAge();
        for (Map.Entry<String,Integer> boundEntry : boundMap.entrySet()) {
            StudentMapAge.StudentAgeEntry valueEntry = new StudentMapAge.StudentAgeEntry();
            valueEntry.setStudent(boundEntry.getKey());
            valueEntry.setAge(boundEntry.getValue());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }

    public Map<String, Integer> unmarshal(StudentMapAge valueMap) throws Exception {
        Map<String, Integer> boundMap = new LinkedHashMap<String, Integer>();
        for (StudentMapAge.StudentAgeEntry pizzaEntry : valueMap.getEntries()) {
            boundMap.put(pizzaEntry.getStudent(), pizzaEntry.getAge());
        }
        return boundMap;
    }
}
