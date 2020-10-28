package model.provider;

import db.ConnectionDBIcesis;
import entity.Profesor;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import javax.ws.rs.Produces;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorProvider {


    public ProfesorDTO getCompleteProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        CursoProvider cursoProvider = new CursoProvider();
        ConnectionDBIcesis connection = new ConnectionDBIcesis();
        try {
            String sql = "SELECT id,nombre,facultad  FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));
                ArrayList<CursoDTO> cursos = cursoProvider.getAllCursosByProfesor(profesorDTO.getId());
                profesorDTO.setCursos(cursos);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconect();
        return profesorDTO;

    }

    public ProfesorDTO getProfesorById(int id) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        CursoProvider cursoProvider = new CursoProvider();
        ConnectionDBIcesis connection = new ConnectionDBIcesis();
        try {
            String sql = "SELECT id,nombre,facultad  FROM profesores WHERE id=" + id;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                profesorDTO.setId(resultSet.getInt(1));
                profesorDTO.setNombre(resultSet.getString(2));
                profesorDTO.setFacultad(resultSet.getString(3));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconect();
        return profesorDTO;

    }



    public void getAllProfesores() {

    }


    public void insertProfesor(Profesor profesor) {
        ConnectionDBIcesis conection = new ConnectionDBIcesis();
        String sql = "INSERT INTO profesores(nombre,facultad) VALUES ('$NOMBRE','$FACULTAD')";
        sql = sql.replace("$NOMBRE", profesor.getNombre());
        sql = sql.replace("$FACULTAD", profesor.getFacultad());
        conection.executeSQL(sql);
    }

    public void updateProfesor() {

    }

    public void deleteProfesor() {

    }

    public Profesor mapFromDTO(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.getNombre());
        profesor.setFacultad(dto.getFacultad());
        return profesor;
    }

    public ProfesorDTO mapToDTO(Profesor profesor){
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setFacultad(profesor.getFacultad());
        return profesorDTO;
    }

}
