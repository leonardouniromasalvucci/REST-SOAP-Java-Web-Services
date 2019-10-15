/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softeng.rest2client;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.cxf.jaxrs.client.WebClient;


/**
 *
 * @author Nodes
 */
public class Client {  

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
       
       
        WebClient client = WebClient.create("http://localhost:8080/risorse/");
        
        Risorsa c = client.path("tre").accept("text/xml").get(Risorsa.class);   
        System.out.print(c.getName());         
        
        client.back(true);
        System.out.println(" \n\n"); 
        
         
        List<Risorsa> l = new ArrayList<Risorsa>(client.path("").accept("text/xml").getCollection(Risorsa.class));
        Iterator<Risorsa> iter = l.iterator(); 
        while (iter.hasNext()) { 
            System.out.print(iter.next().getName() + " \n"); 
        }
        
        client.back(true);
        System.out.println(" \n\n"); 
        
        
        Risorsa r = new Risorsa();
        r.setId("sei");
        r.setName("francesco");
        client.path("");
        client.post(r); 
        
        client.path("due");
        client.delete();
        
        client.back(true);
        System.out.println(" \n\n"); 
        
        List<Risorsa> l1 = new ArrayList<Risorsa>(client.path("").accept("text/xml").getCollection(Risorsa.class));
        Iterator<Risorsa> iter2 = l1.iterator(); 
        while (iter2.hasNext()) { 
            System.out.print(iter2.next().getName() + " \n"); 
        }
        
        client.back(true);
        System.out.println(" \n\n"); 
        
        Risorsa r2 = new Risorsa();
        r2.setId("tre");
        r2.setName("risorsass speciale");   
        client.path("tre");
        client.put(r2);// update book object
        
        client.back(true);
        System.out.println(" \n\n"); 
        
        List<Risorsa> l2 = new ArrayList<Risorsa>(client.path("").accept("text/xml").getCollection(Risorsa.class));
        Iterator<Risorsa> iter3 = l2.iterator(); 
        while (iter3.hasNext()) { 
            System.out.print(iter3.next().getName() + " \n"); 
        }
        
    }
        
        
        
        
        /*
         GET
         */
      /*  String nomeRisorsa = "tre";
        String geturi = "http://localhost:8080/risorse/"+nomeRisorsa;
        
        HttpGet httpGet = new HttpGet(geturi);
        httpGet.setHeader("Content-Type", "text/xml");
        //httpGet.setHeader("Accept", "text/xml");
        HttpResponse response = client.execute(httpGet);
        System.out.print("\nGet effettuata.\nRisposta:\n" + response.toString()+"\nResponse Entity:\t"+response.getEntity().getContent().toString() );
        Risorsa resFromGet = JAXB.unmarshal( response.getEntity().getContent(), Risorsa.class);
        System.out.print("\n\nUnmarshall:\t"+resFromGet.toString()+"\n\n");*/
        /*
         POST
         */
        /*Risorsa oggettoRisorsa = new Risorsa();
        oggettoRisorsa.setId("quattro");
        oggettoRisorsa.setName("chinotto");
        HttpPost httpPost = new HttpPost(BASE_URL  );
        //creazione dummy file
        JAXBContext jaxbContext = JAXBContext.newInstance(Risorsa.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();*/
      //  jaxbMarshaller.marshal(oggettoRisorsa, new File("res.xml"));
     //   File file = new File("res.xml");
      //  InputStream targetStream = new FileInputStream(file);

     //   httpPost.setEntity(new InputStreamEntity(targetStream)); //set the object as i

      /*  httpPost.setHeader("Content-Type", "text/xml");
        //httpPost.setHeader("Accept", "text/xml");
        response = client.execute(httpPost);
        System.out.print("\nPost con risorsa:\n"+oggettoRisorsa.toString()+"\neseguita con esito:\t"+response.getStatusLine() );
        */
        
        /*
         PUT
        */
    //    HttpPut httpPut = new HttpPut(BASE_URL + oggettoRisorsa.getId() ); 
        
    /*    oggettoRisorsa.setName("NOME DI RISORSA");
        jaxbContext = JAXBContext.newInstance(Risorsa.class);
        jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(oggettoRisorsa, new File("res.xml"));*/
      //  file = new File("res.xml");
      //  targetStream = new FileInputStream(file);

      //  httpPut.setEntity(new InputStreamEntity(targetStream));
    //    httpPut.setHeader("Content-Type", "text/xml");
        //httpPut.setHeader("Accept", "text/xml");
    //    response = client.execute(httpPut);
   //     System.out.print("\nPut con risorsa:\n"+oggettoRisorsa.toString()+"\neseguita con esito:\t"+response.getStatusLine() );
        
        /*
         DELETE
        */
   /*    HttpDelete httpDelete = new HttpDelete(BASE_URL + oggettoRisorsa.getId() );
        response = client.execute(httpDelete);
        System.out.print("\nDelete con risorsa:\n"+oggettoRisorsa.toString()+"\neseguita con esito:\t"+response.getStatusLine() );
        */
        
        /*
         GET deleted element
        */
      /*  geturi = "http://localhost:8080/risorse/"+oggettoRisorsa.getId();
        
        httpGet = new HttpGet(geturi);
        httpGet.setHeader("Content-Type", "text/xml");
        httpGet.setHeader("Accept", "text/xml");
        response = client.execute(httpGet);
        if(response == null){
           System.out.print("\nGet effettuata, risposta nulla.\nStato:\n" + response.getStatusLine() );
        }else{
            System.out.print("\nGet effettuata.\nClasse risposta:\n");
        }*/
        
        /*
         JSON Comunication using GSON from google
        */
     //  System.out.print("\n\n\n---------------------------------------\nJson Messages\n---------------------------------------\n\n\n");
        /*
         GET
         */
       
       /*  nomeRisorsa = "tre";
         geturi = "http://localhost:8080/risorse/"+nomeRisorsa;
        
        httpGet = new HttpGet(geturi);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");
        response = client.execute(httpGet);
        System.out.print("\nGet effettuata.\n"
                + "Content Type Risposta:\n" + response.getEntity().getContentType()
                + "\nResponse Entity:\t"+response.getEntity().getContent().toString() );
        
        Gson gson = new Gson();
        Risorsa resJSON = (Risorsa) gson.fromJson(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), Risorsa.class);
        System.out.print("\n\nrisorsa JSON:\t"+resJSON.toString());
*/
    
}