package entity;

public class CursoEstudianteRelationship {

    private int id;
    private int cursoID;
    private int profesorID;


    public CursoEstudianteRelationship() {
    }

    public CursoEstudianteRelationship(int id, int cursoID, int profesorID) {
        this.id = id;
        this.cursoID = cursoID;
        this.profesorID = profesorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public int getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }
}
