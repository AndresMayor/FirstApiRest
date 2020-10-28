package services;


import dto.Division;
import dto.Multiplicacion;
import dto.Respuesta;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("cal")
public class CalculoService {

    @GET
    @Path("sum")
    //el queryparam es para meter informacion atraves de http por medio de la url ?a=25&b=40
    //la info que meto por el get es atraves de la url
    public String suma(@QueryParam("a") String a, @QueryParam("b") String b) {
        return "" + (Integer.parseInt(a) + Integer.parseInt(b));
    }

    @GET
    @Path("resta/{A}/{B}")
    //con el pathparam relacionamos la variable de la url con la variable del metodo la url se escribe ...resta/40/30
    public String resta(@PathParam("A") String a, @PathParam("B") String b) {
        return "" + (Integer.parseInt(a) - Integer.parseInt(b));
    }

    @POST
    @Path("multiplicacion")
    //los post solo reciben un dato, un solo parametro que es el body
    public String multi(String body){
        String[] partes = body.split("\\*");
        int a = Integer.parseInt(partes[0]);
        int b = Integer.parseInt(partes[1]);
        int resultado = a*b;
        return ""+resultado;
    }

    //Nuevo Metodo multiplicacion mejorado

    @POST
    @Path("multiplicacion2")
    @Consumes("application/json")
    @Produces("application/json")
    public Respuesta multi2 (Multiplicacion obj){
        int res = obj.getA()*obj.getB();
        Respuesta respuesta = new Respuesta(obj.getUid(),res);
        return respuesta;
    }

    @PUT
    //para poder recibir un objeto (obj) tenemos que poner la sgte linea
    //para esto necesitamos utilizar un header  en postman y debemos agregarlo se llama Content-type y le damos el  valor de applications/json
    @Consumes("application/json")
    //como decidimos restornar un Json entonces debemos hacer la sgte linea para que pueda retornar el json
    @Produces("application/json")
    //lo que hace es que automaticamente en el metodo entra el objecto Division pero en formato json
    @Path("division")
    public Respuesta div(Division obj){
        double rest = obj.getDividiendo()/(double)obj.getDivisor();
        Respuesta respuesta = new Respuesta(obj.getUid(),rest);
        return respuesta;
    }

}
