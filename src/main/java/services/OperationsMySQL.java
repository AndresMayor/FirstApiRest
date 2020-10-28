package services;


import db.ConnectionDBIcesis;
import dto.Materia;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("operations")
public class OperationsMySQL {

    @POST
    @Consumes("application/json")
    //@Produces("application/json")
    //servicio especifico
    @Path("insert")
    public  String insertMateria(Materia obj){
        ConnectionDBIcesis connection  = new ConnectionDBIcesis();
        System.out.println(">>>>oeee"+obj.getId()+obj.getNombre()+obj.getNrc());
        connection.insertMateria(obj);
        return "Se pudo";
    }


}
