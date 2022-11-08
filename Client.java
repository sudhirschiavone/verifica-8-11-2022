package it.fi.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    String nomeServer = "localhost"; // indirizzo server locale
    int portaServer = 12121; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtente; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input


    public void comunica() throws IOException {
        
        Comunica C1 = new Comunica();
        Thread1 tinThread1 = new Thread1(C1);
        Thread2 touThread2 = new Thread2(C1);

        touThread2.start();
        tinThread1.start();
    }
}