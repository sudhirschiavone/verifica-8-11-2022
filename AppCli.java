package it.fi.itismeucci;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class AppCli 
{
    public static void main( String[] args ) throws IOException
    {
        
        Client cliente= new Client();
        cliente.comunica();
    }
}
