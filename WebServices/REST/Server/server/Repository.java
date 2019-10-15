package edu.softeng.rest2;

import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("risorse")
@Produces({MediaType.TEXT_XML}) 
public class Repository {
    private List<Risorsa> data = new LinkedList<>();

    public Repository() {
        Risorsa r = new Risorsa();
        r.setId("uno");
        r.setName("risorsa normale");
        data.add(r);
        
        Risorsa r1 = new Risorsa();
        r1.setId("due");
        r1.setName("risorsa speciale");
        data.add(r1);
        
        Risorsa r2 = new Risorsa();
        r2.setId("tre");
        r2.setName("tua madre a pecora");
        data.add(r2);      
    }
    
    @GET
    @Path("{rid}")
    public Risorsa getRisorsa(@PathParam("rid") String id){
        for(Risorsa r: this.data){
            if(r.getId().equals(id) ){
                System.out.print("return the result");
                 return r;
            }           
        }
        System.out.print("returning null.\nId passed:\t"+id);
        return new Risorsa();
    }
    
    
    @GET
    @Path("")
    public List<Risorsa> getAllRisorse(){
        return this.data;
    }
    
    @POST
    @Path("")
    public Response addRisorsa(Risorsa r){
        for(Risorsa res: this.data){
            if(res.getId().equals(r.getId())){ 
                return Response.status(Response.Status.CONFLICT).build(); 
            }          
        }
        this.data.add(r);
        return Response.ok().build();
    }
    
    @PUT
    @Path("{rid}")
    public Response updateRisorsa(@PathParam("rid") String id, Risorsa newRes){
        for(Risorsa res: this.data){
            if(res.getId().equals(id)){
                if(res.equals(newRes)){
                    return Response.status(Response.Status.NOT_MODIFIED).build(); 
                }
                res.setId(newRes.getId());
                res.setName(newRes.getName());
                System.out.println("RISORSA AGGIORNATA: "+newRes.getName());
                return Response.ok().build(); 
            }          
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("{rid}")
    public Response deleteRisorsa(@PathParam("rid") String id){
        for(Risorsa res: this.data){
            if(res.getId().equals(id)){
                this.data.remove(res);
                System.out.println("ELIMANTO");
                return Response.ok().build();                 
            }          
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}