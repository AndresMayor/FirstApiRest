package dto;

public class Division {

    private String uid;
    private int dividiendo;
    private int divisor;


    public Division() {
    }

    public Division(String uid, int dividiendo, int divisor) {
        this.uid = uid;
        this.dividiendo = dividiendo;
        this.divisor = divisor;
    }

    public String getUid() {
        return uid;
    }

    public int getDividiendo() {
        return dividiendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setDividiendo(int dividiendo) {
        this.dividiendo = dividiendo;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }


}

