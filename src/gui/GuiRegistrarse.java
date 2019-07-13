/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datos.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Controlador;
import modelos.TextPrompt;

/**
 *
 * @author Thesiz
 */
public class GuiRegistrarse extends javax.swing.JFrame {

    /**
     * Creates new form GuiRegistrarse
     */
    String nombre;
    String usuario;
    String contrasena;

    public GuiRegistrarse() {
        initComponents();
        TextPrompt placeholder = new TextPrompt("Nombre y Apellido", txtNombreYApellido);
        TextPrompt placeholder1 = new TextPrompt("Nombre de Usuario", txtUsuario);
        TextPrompt placeholder2 = new TextPrompt("Nueva Contraseña", txtConstrasena);

        setLocationRelativeTo(null);
        getContentPane().requestFocusInWindow();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void crearUsuario() {
        boolean usuarioExiste = false;

        nombre = txtNombreYApellido.getText();
        usuario = txtUsuario.getText();
        contrasena = txtConstrasena.getText();

        for (Usuario element : Controlador.listaUsuarios) {
            if (usuario.equals(element.getUsuario())) {
                usuarioExiste = true;
                break;
            }
        }

        if (nombre.equals("") || usuario.equals("") || contrasena.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Los campos no pueden ir vacíos",
                    "Remit", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/./recursos/img/x.png")));

        } else if (usuarioExiste) {
            JOptionPane.showMessageDialog(rootPane, "El nombre de usuario ya se encuentra registrado",
                    "Remit", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/./recursos/img/x.png")));

        } else {
            Usuario usuarioCreado = new Usuario(nombre, usuario, contrasena, false);

            JOptionPane.showMessageDialog(rootPane, "Registro correcto !",
                    "Remit", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/./recursos/img/x.png")));
            this.dispose();

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreYApellido = new javax.swing.JTextField();
        txtConstrasena = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel1.setBackground(new java.awt.Color(4, 154, 201));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Remit");

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registrate en Remit");

        txtNombreYApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreYApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreYApellidoActionPerformed(evt);
            }
        });

        txtConstrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtConstrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConstrasenaActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("¡Tu nombre de usuario debe ser único!");

        btnRegistrate.setBackground(new java.awt.Color(4, 126, 179));
        btnRegistrate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrate.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrate.setText("Registrate");
        btnRegistrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreYApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConstrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombreYApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addComponent(txtConstrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConstrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConstrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConstrasenaActionPerformed

    private void txtNombreYApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreYApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreYApellidoActionPerformed

    private void btnRegistrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrateActionPerformed

        crearUsuario();


    }//GEN-LAST:event_btnRegistrateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void runRegistrarse() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiRegistrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiRegistrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPasswordField txtConstrasena;
    private javax.swing.JTextField txtNombreYApellido;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
