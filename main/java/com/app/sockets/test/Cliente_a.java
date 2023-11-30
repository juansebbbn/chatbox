package com.app.sockets.test;

import com.app.sockets.chat.Cliente;
import com.app.sockets.chat.Server;
import com.app.sockets.dao.ConversacionDAO;
import com.app.sockets.dao.ConversacionIMPL;
import java.util.Observable;
import java.util.Observer;

public class Cliente_a extends javax.swing.JFrame implements Observer {

    ConversacionDAO converDAO = new ConversacionIMPL();

    public Cliente_a() {
        initComponents();
        this.getRootPane().setDefaultButton(this.btn_enviar);
        this.setTitle("Cliente A");
        Server server = new Server(5000);
        server.addObserver((Observer) this);
        Thread hilo = new Thread(server);
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        btn_borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mensaje = new javax.swing.JTextArea();
        txt_mensaje_enviar = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre.setText("Digite su nombre");

        txt_nombre.setBackground(new java.awt.Color(190, 190, 190));

        btn_borrar.setBackground(new java.awt.Color(190, 190, 190));
        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        txt_mensaje.setBackground(new java.awt.Color(246, 177, 177));
        txt_mensaje.setColumns(20);
        txt_mensaje.setRows(5);
        jScrollPane1.setViewportView(txt_mensaje);

        txt_mensaje_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mensaje_enviarActionPerformed(evt);
            }
        });

        btn_enviar.setBackground(new java.awt.Color(190, 190, 190));
        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_mensaje_enviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mensaje_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed

    }//GEN-LAST:event_btn_borrarActionPerformed

    private void txt_mensaje_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mensaje_enviarActionPerformed

    }//GEN-LAST:event_txt_mensaje_enviarActionPerformed

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        String mensaje = this.txt_nombre.getText() + ":" + this.txt_mensaje_enviar.getText() + "\n";
        this.txt_mensaje.append(mensaje);

        converDAO.registrarConversacionA(mensaje);

        Cliente cliente = new Cliente(6000, mensaje);
        Thread hilo = new Thread(cliente);
        hilo.start();
    }//GEN-LAST:event_btn_enviarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente_a().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextArea txt_mensaje;
    private javax.swing.JTextField txt_mensaje_enviar;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        txt_mensaje.append((String) arg);
    }
}
