package com.app.sockets.dao;

import com.app.sockets.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConversacionIMPL implements ConversacionDAO {

    Conexion instMySql = Conexion.getInstance();

    @Override
    public void registrarConversacionA(String mensaje) {
        PreparedStatement consulta = null;
        Connection conn = null;

        try {
            conn = instMySql.conectar();
            consulta = conn.prepareStatement("INSERT INTO conversaciones(usuarioA) VALUES(?)");

            consulta.setString(1, mensaje);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void registrarConversacionB(String mensaje) {
        PreparedStatement consulta = null;
        Connection conn = null;

        try {
            conn = instMySql.conectar();
            consulta = conn.prepareStatement("INSERT INTO conversaciones(usuarioB) VALUES(?)");

            consulta.setString(1, mensaje);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
