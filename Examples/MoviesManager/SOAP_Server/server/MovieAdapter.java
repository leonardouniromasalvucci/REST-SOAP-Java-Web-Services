/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.july_soap_ws;


import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class MovieAdapter extends XmlAdapter<Movie, MovieInterface> {
    
    public Movie marshal(MovieInterface m) throws Exception {
        if (m instanceof Movie) {
            return (Movie) m;
        }
        return new Movie(m.getId(), m.getTitle(), m.getDirector(), m.getYear());
    }

    public MovieInterface unmarshal(Movie m) throws Exception {
        return m;
    }
}