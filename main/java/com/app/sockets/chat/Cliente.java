package com.app.sockets.chat;

import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente implements Runnable{
    
    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        //HOST
        final String HOST = "127.0.0.1";
        
        //PUERTO
        DataOutputStream salida;
        
        try {
            //creo el socket
            Socket socket = new Socket(HOST, puerto);
            //guardo la info q le voy a enviar al otro cliente
            salida = new DataOutputStream(socket.getOutputStream());
            //envio el mensaje
            salida.writeUTF(mensaje);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        
    }
    
}
