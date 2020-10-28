package model.provider;

import db.ConnectionDBIcesis;
import entity.Curso;
import model.dto.CursoDTO;
import model.dto.ProfesorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoProvider {

    //provee informacion suficiente para nuestros servicios


    //provee acciones

    public ArrayList<CursoDTO> getAllCurso(){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();

        ConnectionDBIcesis connection = new ConnectionDBIcesis();

        ProfesorProvider profesorProvider = new ProfesorProvider();
        try {
            String sql = "SELECT nombre ,programa ,profesorID FROM cursos";
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setNombre(resultSet.getString(1));
                cursoDTO.setPrograma(resultSet.getString(2));
                ProfesorDTO profesorDTO = profesorProvider.getProfesorById(resultSet.getInt(3));
                cursoDTO.setProfesor(profesorDTO);
                cursoDTOS.add(cursoDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconect();
        return cursoDTOS;


    }

    public ArrayList<CursoDTO> getAllCursosByProfesor(int idProfesor){
        ArrayList<CursoDTO> cursoDTOS = new ArrayList<>();

        ConnectionDBIcesis connection = new ConnectionDBIcesis();
        try {
            String sql = "SELECT nombre ,programa FROM cursos WHERE profesorID="+idProfesor ;
            ResultSet resultSet = connection.query(sql);
            while (resultSet.next()) {
                CursoDTO curso = new CursoDTO();
                curso.setNombre(resultSet.getString(1));
                curso.setPrograma(resultSet.getString(2));
                cursoDTOS.add(curso);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.disconect();
        return cursoDTOS;
    }


    public void insertCurso(Curso curso){
        ConnectionDBIcesis connection =  new ConnectionDBIcesis();
        String sql = "INSERT INTO cursos (nombre,programa,profesorID) VALUES ('$NOMBRE' ,'$PROGRAMA' , $profesor )";
        sql = sql.replace("$NOMBRE",curso.getNombre());
        sql = sql.replace("$PROGRAMA",curso.getPrograma());
        sql = sql.replace( "$profesor",""+curso.getProfesorID());
        System.out.println(curso.getNombre()+curso.getPrograma()+curso.getProfesorID());
        connection.executeSQL(sql);
    }

    public  void updateCurso(){

    }

    public  void deleteCurso(){

    }

    public Curso mapFromCurso(CursoDTO dto){
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setPrograma(dto.getPrograma());
        curso.setProfesorID(dto.getProfesor().getId());

        return curso;

    }





}
