package services;


import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Stateless
//nombre del  primer servicio
@Path("echo")
public class EcoService {

    //primer servicio
    @GET
    //servicio especifico
    @Path("index")
    public  String index(){
        return "echo";
    }

}
