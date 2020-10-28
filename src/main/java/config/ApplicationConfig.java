package config;

import services.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;



//me abre la puerta para generar servicios sobre la pagina
@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    //metodo para agregar cada servicio
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new HashSet<>();
        //clases de nuestros recursos
        resources.add(EcoService.class);
        resources.add(CalculoService.class);
        resources.add(OperationsMySQL.class);
        resources.add(DataBaseServices.class);
        resources.add(ProfesorServices.class);
        resources.add(CursoServices.class);

        return  resources;
    }
}
