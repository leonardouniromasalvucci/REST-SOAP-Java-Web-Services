/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.jms2server;

/**
 *
 * @author leona
 */
public class Server {
    
    public static void main(String[] args){
        
        //CONSUMERS
        OrderProcessor op=new OrderProcessor();
     
        //PRODUCERS
        QuotationPublisher qp=new QuotationPublisher();
        qp.start();
    }
}
