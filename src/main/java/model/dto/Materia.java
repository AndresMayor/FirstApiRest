package dto;

public class Materia {

    private String id;
    private String nombre;
    private String nrc;


    public Materia() {
    }

    public Materia(String id, String nombre, String nrc) {
        this.id = id;
        this.nombre = nombre;
        this.nrc = nrc;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNrc() {
        return nrc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }
}
