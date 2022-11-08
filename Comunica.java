package it.fi.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

// Oggetto utilizzato per tutta la comunicazione e semplificare il codice in thread 1 e 2
public class Comunica {
    String nomeServer = "localhost";            // indirizzo server locale
    int portaServer = 6942;                     // porta x servizio data e ora
    Socket miosocket;                           // socket per salvare dati server
    BufferedReader tastiera;                    // buffer per l'input da tastiera
    String StringaUtenteID;                     // stringa inserita da utente
    String StringaRicevutaDalServer;            // stringa ricevuta dal server
    DataOutputStream outVersoServer;            // stream output
    BufferedReader inDalServer;                 // stream input
    Messaggio m;                                // Messaggio per salvare la comunicazione
    ArrayList<Biglietto> biglietti;             // Array utilizzato per biglietti
    ArrayList<Biglietto> richiesta;             // Array utilizzato 

    // 
    public Comunica() throws IOException{
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        miosocket = new Socket(nomeServer, portaServer);
        outVersoServer = new DataOutputStream(miosocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
    }
    // metodo in output dal client
    public void Output() throws IOException {
        System.out.println("Scegli ID");
        StringaUtenteID = tastiera.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        m = objectMapper.readValue(StringaRicevutaDalServer, Messaggio.class);

        for (int i = 0; i < biglietti.size(); i++) {
            if (biglietti.get(i).getIdentificativo() == (Integer.parseInt(StringaUtenteID))) {
                richiesta.add(biglietti.get(i));
            }
        }

        Messaggio m = new Messaggio(richiesta);

        String stringa = objectMapper.writeValueAsString(m);
        outVersoServer.writeBytes(stringa + '\n');
    }
    // metodo in input dal server
    public void Input() {
        try{
            StringaRicevutaDalServer = inDalServer.readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            m = objectMapper.readValue(StringaRicevutaDalServer, Messaggio.class);
            biglietti = m.getLista();
            System.out.println(m.getLista());
            if (StringaRicevutaDalServer.equals("spegni")) {
                miosocket.close();
                System.out.println("FINE");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}