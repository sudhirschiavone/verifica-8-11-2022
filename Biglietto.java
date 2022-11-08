package it.fi.itismeucci;

public class Biglietto {

    private int identificativo;
    private String numerobiglietto;

    public Biglietto() {
    }

    public Biglietto(int identificativo, String numerobiglietto) {
        this.identificativo = identificativo;
        this.numerobiglietto = numerobiglietto;
    }

    public int getIdentificativo() {
        return identificativo;
    }
    public void setIdentificativo(int identificativo) {
        this.identificativo = identificativo;
    }
    public String getNumerobiglietto() {
        return numerobiglietto;
    }
    public void setNumerobiglietto(String numerobiglietto) {
        this.numerobiglietto = numerobiglietto;
    }
    // Stampa biglietto singolo
    public String toString() {
        return "(" + " ID='" + getIdentificativo() + "'" + ", numeroB='" + getNumerobiglietto() + "'" + ")";
    }
    
}
