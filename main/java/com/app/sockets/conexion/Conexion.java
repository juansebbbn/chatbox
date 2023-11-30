package com.app.sockets.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
   private static final String url = "jdbc:mysql://localhost/chat";
   private static final String user = "root";
   private static final String password = "admin";
   private static Conexion instancia;
   
   public Connection conectar() throws SQLException {
       return DriverManager.getConnection(url, user , password);
   }
   
   public void cerrarResultado(ResultSet res){
       try {
           res.close();
       } catch (SQLException exc) {
           System.out.println(exc);
       }
   }
   
   public void desconectar(Connection conn){
       try {
           conn.close();
       } catch (SQLException exc) {
           System.out.println(exc);
       }
   }
   
   public static Conexion getInstance(){
       if(instancia == null){
           instancia = new Conexion();
       }
       return instancia;
   }
}

