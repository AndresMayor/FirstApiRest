package services;


import db.ConnectionDBIcesis;
import dto.Response;

import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("db")
public class DataBaseServices {


    @POST
    @Path("create")
    @Produces("application/json")
    public Response createDB(){
        ConnectionDBIcesis connection = new ConnectionDBIcesis();
        if( connection.createDB()){
            return  new Response("Base de datos creada ");

        }else{
            return  new Response("Error construyendo base de datos");
        }

    }
}
