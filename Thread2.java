package it.fi.itismeucci;

public class Thread2 extends Thread {
    Comunica comunica;
    public Thread2(Comunica comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Output();
        } catch (Exception e) {}
    }
}