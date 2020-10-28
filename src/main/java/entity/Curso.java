package entity;

public class Curso {

    private String nombre;
    private String programa;
    private int profesorID;

    public Curso() {
    }

    public Curso(String nombre, String programa, int profesorID) {

        this.nombre = nombre;
        this.programa = programa;
        this.profesorID = profesorID;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int  getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }
}
