package it.fi.itismeucci;

public class Thread1 extends Thread{
    Comunica comunica;
    public Thread1(Comunica comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Input();
        } catch (Exception e) {}
    }
}