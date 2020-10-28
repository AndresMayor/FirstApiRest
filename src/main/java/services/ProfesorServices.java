package services;


import dto.Response;
import model.dto.ProfesorDTO;
import model.provider.ProfesorProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("profesores")
@Stateless
public class ProfesorServices {


    @POST
    @Consumes("application/json")
    @Path("create")
    public dto.Response createProfesor(ProfesorDTO profesorDTO){
        ProfesorProvider profesorProvider = new ProfesorProvider();
        profesorProvider.insertProfesor(profesorProvider.mapFromDTO(profesorDTO));
        return new Response("Operacion Exitosa");
    }

    @GET
    @Consumes("application/json")
    @Path("{id}")
    @Produces("application/json")
    public ProfesorDTO getProfesor(@PathParam("id") String id ){
        ProfesorProvider profesorProvider = new ProfesorProvider();
        ProfesorDTO profesorDTO= profesorProvider.getCompleteProfesorById(Integer.parseInt(id));
        return profesorDTO;
    }


}
