/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datos.Categoria;
import datos.Publicacion;
import datos.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import modelos.Estetica;
import modelos.TextPrompt;

public class GuiVentanaPrincipal extends javax.swing.JFrame {

    public static boolean pop;
    public GuiVentanaPrincipal() {
        initComponents();
        Estetica logo = new Estetica ();
        logo.logoVentana(this);
        setResizable(false);
        setLocationRelativeTo(null);
        TextPrompt placeholder = new TextPrompt("Buscar...", txtBuscar);
        getContentPane().requestFocusInWindow();
        pop = false;
        Estetica.formatoFechaVentana(lblFecha);
        int locY = 0;
        for (int i = 0; i < 10; i++) {
            locY = nuevoText(Color.WHITE, locY);
            locY = nuevoText(Color.WHITE, locY);
            locY = nuevoText(Color.WHITE, locY);
        }
    }

    public int nuevoText(Color color, int y) {
        Date fecha = new Date();
        Publicacion pub = new Publicacion ((new Categoria ("Tutoria", 01)), (new Usuario ("a", "a", "a", "a", true)),
                fecha, "Tengo que pasar el parcial de calculo", "Tas tas tas"); 
        PanelPublicacion pruebita = new PanelPublicacion(pub);
        pruebita.setSize(600, 300);
        pruebita.setLocation(150, y);
        pruebita.setBackground(color);
        int locY = (int) pruebita.getY() + pruebita.getHeight() + 10;

        jPanelPublicacion.setPreferredSize(new Dimension(jPanelPublicacion.getWidth(),
                locY));
        jPanelPublicacion.add(pruebita);

        System.out.println(locY);
        return locY;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        jPanelRegistrarme = new javax.swing.JPanel();
        btnRegistrarme = new javax.swing.JButton();
        jPanelIniciarSesion = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPublicacion = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 154, 201));

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Viernes 12 de Julio del 2019");

        jPanelRegistrarme.setBackground(new java.awt.Color(4, 154, 201));
        jPanelRegistrarme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelRegistrarme.setMinimumSize(new java.awt.Dimension(121, 19));
        jPanelRegistrarme.setPreferredSize(new java.awt.Dimension(121, 29));
        jPanelRegistrarme.setLayout(null);

        btnRegistrarme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarme.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarme.setText("REGISTRARME");
        btnRegistrarme.setBorderPainted(false);
        btnRegistrarme.setContentAreaFilled(false);
        btnRegistrarme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarme.setFocusPainted(false);
        btnRegistrarme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarmeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarmeMouseExited(evt);
            }
        });
        btnRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarmeActionPerformed(evt);
            }
        });
        jPanelRegistrarme.add(btnRegistrarme);
        btnRegistrarme.setBounds(0, 0, 120, 30);

        jPanelIniciarSesion.setBackground(new java.awt.Color(4, 154, 201));
        jPanelIniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelIniciarSesion.setMinimumSize(new java.awt.Dimension(127, 29));
        jPanelIniciarSesion.setPreferredSize(new java.awt.Dimension(127, 29));
        jPanelIniciarSesion.setLayout(null);

        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("INICIAR SESION");
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseExited(evt);
            }
        });
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanelIniciarSesion.add(btnIniciarSesion);
        btnIniciarSesion.setBounds(0, 0, 130, 28);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelRegistrarme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRegistrarme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelPublicacionLayout = new javax.swing.GroupLayout(jPanelPublicacion);
        jPanelPublicacion.setLayout(jPanelPublicacionLayout);
        jPanelPublicacionLayout.setHorizontalGroup(
            jPanelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1157, Short.MAX_VALUE)
        );
        jPanelPublicacionLayout.setVerticalGroup(
            jPanelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelPublicacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        deshabilitarOpciones();
        GuiRegistrarse.runRegistrarse();
        pop = true;
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void deshabilitarOpciones() {
        ArrayList<Component> componentes = new ArrayList<>();
        componentes.add(txtBuscar);
        componentes.add(btnIniciarSesion);
        componentes.add(btnRegistrarme);
        Estetica.habDeshabComponentes(componentes, false);
    }

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        deshabilitarOpciones();
        GuiIniciarSesion.runIniciarSesion();
        pop = true;
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarmeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarmeMouseEntered
        if (!pop) {
            jPanelRegistrarme.setBackground(Color.white);
            btnRegistrarme.setForeground(new java.awt.Color(4, 155, 201));
        }
    }//GEN-LAST:event_btnRegistrarmeMouseEntered

    private void btnRegistrarmeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarmeMouseExited
        jPanelRegistrarme.setBackground(new java.awt.Color(4, 155, 201));
        btnRegistrarme.setForeground(Color.white);
    }//GEN-LAST:event_btnRegistrarmeMouseExited

    private void btnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseEntered
         if (!pop) {
            jPanelIniciarSesion.setBackground(Color.white);
            btnIniciarSesion.setForeground(new java.awt.Color(4, 155, 201));
        }
    }//GEN-LAST:event_btnIniciarSesionMouseEntered

    private void btnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseExited
        jPanelIniciarSesion.setBackground(new java.awt.Color(4, 155, 201));
        btnIniciarSesion.setForeground(Color.white);
    }//GEN-LAST:event_btnIniciarSesionMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        Estetica.lookAndFeel();
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton btnRegistrarme1;
    private javax.swing.JButton btnRegistrarme2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelIniciarSesion;
    private javax.swing.JPanel jPanelPublicacion;
    private javax.swing.JPanel jPanelRegistrarme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
