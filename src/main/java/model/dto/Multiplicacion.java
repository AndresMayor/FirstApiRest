package dto;

public class Multiplicacion {

    private String uid;
    private int a ;
    private int b;


    public Multiplicacion() {
    }

    public Multiplicacion(String uid, int a, int b) {
        this.uid = uid;
        this.a = a;
        this.b = b;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
