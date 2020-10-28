package services;

import db.ConnectionDBIcesis;
import dto.Response;
import entity.Curso;
import model.dto.CursoDTO;
import model.provider.CursoProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("cursos")
@Stateless
public class CursoServices {


    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public dto.Response createCurso(CursoDTO cursoDTO){
        CursoProvider cursoProvider = new CursoProvider();
        Curso curso = cursoProvider.mapFromCurso(cursoDTO);
        cursoProvider.insertCurso(curso);
        return new Response("Operacion exitosa");

    }

    @GET
    @Path("all")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<CursoDTO> getAllCurso(CursoDTO cursoDTO){
        CursoProvider cursoProvider = new CursoProvider();
         ArrayList<CursoDTO> output = cursoProvider.getAllCurso();
        return output;

    }

}
