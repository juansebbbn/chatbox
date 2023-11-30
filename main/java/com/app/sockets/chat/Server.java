package com.app.sockets.chat;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Server extends Observable implements Runnable {

    private int puerto;

    public Server(int puerto) {
        this.puerto = puerto;
    }
    
    @Override
    public void run() {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream entrada;

        try {
            //creamos el servidor del socket
            server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //siempre estara escuchando peticiones
            while (true) {
                socket = server.accept();
                System.out.println("--------");
                System.out.println("Cliente conectado...");
                entrada = new DataInputStream(socket.getInputStream());

                //leemos el mensaje
                String mensaje = entrada.readUTF();
                System.out.println("MENSAJE ENVIADO: " + mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                socket.close();
                System.out.println("Cliente desconectado...");
                System.out.println("--------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
