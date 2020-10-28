package db;

import dto.Materia;

import javax.ejb.Stateless;
import java.sql.*;

public class ConnectionDBIcesis {

    private Connection connection;


    public ConnectionDBIcesis() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void conect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void disconect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public boolean createDB() {
        boolean create = false;
        conect();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS profesores(id INT PRIMARY KEY AUTO_INCREMENT ,nombre VARCHAR (100),facultad VARCHAR (100))  ");
            statement.execute("CREATE TABLE IF NOT EXISTS cursos(id INT PRIMARY KEY AUTO_INCREMENT ,nombre VARCHAR (100),programa VARCHAR (100),profesorID INT," +
                    "FOREIGN KEY(profesorID) REFERENCES profesores(id))  ");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes(id INT PRIMARY KEY AUTO_INCREMENT ,nombre VARCHAR (100),codigo VARCHAR (100))  ");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes_cursos  (id INT PRIMARY KEY AUTO_INCREMENT ,estudianteID INT ,profesorID INT," +
                    "FOREIGN KEY (estudianteID) REFERENCES estudiantes(id)," +
                    "FOREIGN KEY(profesorID) REFERENCES profesores(id))  ");

            create = true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            create = false;
        } finally {
            disconect();
        }
        return create;
    }

    public void insertMateria(Materia materia) {

        try {
            Statement statement = connection.createStatement();
            String sql = ("INSERT  INTO materias (id,nombre,NRC) VALUES ('$ID','$NOMBRE','$NRC')")
                    .replace("$ID", materia.getId())
                    .replace("$NOMBRE", materia.getNombre())
                    .replace("$NRC", materia.getNrc());
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //para realizar las acciones el CRUD De cada provedor
    public void executeSQL(String sql) {
        conect();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconect();
        }
    }


    public ResultSet query(String sql) {
        ResultSet output =null;
        conect();
        try {

            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }


}

