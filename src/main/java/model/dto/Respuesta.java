package dto;

public class Respuesta {

    private String uid;
    private double respuesta;

    //nuestra idea es emitir la respuesta en un objecto respuesta
    public Respuesta() {
    }

    public Respuesta(String uid, double respuesta) {
        this.uid = uid;
        this.respuesta = respuesta;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }
}
