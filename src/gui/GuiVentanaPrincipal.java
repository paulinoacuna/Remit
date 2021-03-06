/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datos.Archivo;
import datos.Categoria;
import datos.Publicacion;
import datos.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import logica.Controlador;
import modelos.Estetica;
import modelos.TextPrompt;

public class GuiVentanaPrincipal extends javax.swing.JFrame {

    public static boolean pop;
    private JPanel contentPane;

    public GuiVentanaPrincipal() {
        initComponents();
        Estetica logo = new Estetica();
        logo.logoVentana(this);
        setResizable(false);
        setLocationRelativeTo(null);
        logo.logoImagen1(lblLogo, "img/logoremit.png");
        //Busca si hay un usuario activo
        boolean usuarioActivo = false;
        for (Usuario usu : Controlador.listaUsuarios) {
            if (usu.getActivo()) {
                usuarioActivo = true;
                Estetica.mostrarOcultarComponente(lblNombreUsuario, usu.getNombre() + " " + usu.getApellido(), true);
                break;
            }
        }
        if (usuarioActivo) {
            ocultarBotones();
            mostrarBotones();
            Estetica.mostrarOcultarBotones(Estetica.botonesOcultar, Estetica.botonesMostrar);
        } else {
            jPanelMisPublicaciones.setVisible(false);
            jPanelRemit.setVisible(false);
            jPanelCerrarSesion.setVisible(false);
            Estetica.mostrarOcultarComponente(lblNombreUsuario, null, true);
        }
        //termina de buscar usuarios activos
        TextPrompt placeholder = new TextPrompt("Buscar...", txtBuscar);
        getContentPane().requestFocusInWindow();
        pop = false;
        Estetica.formatoFechaVentana(lblFecha);

        int locY = 0;
        Date fecha = new Date();

        cargarPublicaciones();
    }

    public void cargarPublicaciones() {
        int locY = 0;
        for (int i = Controlador.listaPublicaciones.size() - 1; i >= 0; i--) {
            locY = analisisPublicacion(locY, Controlador.listaPublicaciones.get(i));
        }
        jPanelPublicacion.scrollRectToVisible(new Rectangle(900, 470));
    }

    public void cargarPublicaciones(String filtro, int tipo) {
        int locY = 0;
        jPanelPublicacion.setPreferredSize(new Dimension(900, 470));
        if (tipo == 1) {
            for (int i = Controlador.listaPublicaciones.size() - 1; i >= 0; i--) {
                if (Controlador.listaPublicaciones.get(i).getCategoria().getNombre().equals(filtro)) {
                    locY = analisisPublicacion(locY, Controlador.listaPublicaciones.get(i));
                }
            }
        } else {
            for (int i = Controlador.listaPublicaciones.size() - 1; i >= 0; i--) {
                if (Controlador.listaPublicaciones.get(i).getTitulo().toLowerCase().contains(filtro.toLowerCase())
                        || Controlador.listaPublicaciones.get(i).getDescripcion().toLowerCase().contains(filtro.toLowerCase())) {
                    locY = analisisPublicacion(locY, Controlador.listaPublicaciones.get(i));
                }
            }
        }
        jPanelPublicacion.scrollRectToVisible(new Rectangle(900, 470));
    }

    public int analisisPublicacion(int y, Publicacion publicacion) {
        int tipo = 1, ancho = 0, alto = 0;
        String nomImagen = publicacion.getNombreImagen();
        if (nomImagen != null) {
            try {
                Image imagen = new ImageIcon(nomImagen).getImage();
                ancho = imagen.getWidth(this);
                alto = imagen.getHeight(this);
                System.out.println("IMAGEN: " + imagen.getWidth(this));
                if (ancho >= alto) {
                    tipo = 2;
                } else {
                    tipo = 3;
                }
            } catch (NullPointerException e) {
                tipo = 1;
                System.err.println("soy un error");
            }
        }
        PanelPublicacion pruebita = new PanelPublicacion(tipo, ancho, alto, publicacion);
        pruebita.setSize(600, PanelPublicacion.tamañoPanel);
        pruebita.setLocation(225, y);
        int locY = (int) pruebita.getY() + pruebita.getHeight() + 10;
        if (locY > jPanelPublicacion.getHeight()) {
            jPanelPublicacion.setPreferredSize(new Dimension(jPanelPublicacion.getWidth(), locY));
        }
        jPanelPublicacion.add(pruebita);
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
        lblFecha = new javax.swing.JLabel();
        jPanelRegistrarme = new javax.swing.JPanel();
        btnRegistrarme = new javax.swing.JButton();
        jPanelIniciarSesion = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jPanelCerrarSesion = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        jPanelRemit = new javax.swing.JPanel();
        btnRemit = new javax.swing.JButton();
        jPanelMisPublicaciones = new javax.swing.JPanel();
        btnMisPublicaciones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPublicacion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRecargar = new javax.swing.JButton();
        cbxCategorias = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

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
        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(4, 154, 201));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Miercoles 30 de Septiembre del 2019");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

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
        btnIniciarSesion.setText("INICIAR SESIÓN");
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

        jPanelCerrarSesion.setBackground(new java.awt.Color(4, 154, 201));
        jPanelCerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelCerrarSesion.setPreferredSize(new java.awt.Dimension(131, 29));

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCerrarSesionLayout = new javax.swing.GroupLayout(jPanelCerrarSesion);
        jPanelCerrarSesion.setLayout(jPanelCerrarSesionLayout);
        jPanelCerrarSesionLayout.setHorizontalGroup(
            jPanelCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCerrarSesionLayout.setVerticalGroup(
            jPanelCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelRemit.setBackground(new java.awt.Color(237, 191, 23));
        jPanelRemit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelRemit.setPreferredSize(new java.awt.Dimension(71, 29));
        jPanelRemit.setLayout(null);

        btnRemit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRemit.setText("Remit");
        btnRemit.setBorderPainted(false);
        btnRemit.setContentAreaFilled(false);
        btnRemit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemit.setFocusPainted(false);
        btnRemit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemitMouseExited(evt);
            }
        });
        btnRemit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemitActionPerformed(evt);
            }
        });
        jPanelRemit.add(btnRemit);
        btnRemit.setBounds(0, 0, 70, 30);

        jPanelMisPublicaciones.setBackground(new java.awt.Color(209, 207, 194));
        jPanelMisPublicaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelMisPublicaciones.setPreferredSize(new java.awt.Dimension(121, 29));
        jPanelMisPublicaciones.setLayout(null);

        btnMisPublicaciones.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMisPublicaciones.setText("Mis publicaciones");
        btnMisPublicaciones.setBorderPainted(false);
        btnMisPublicaciones.setContentAreaFilled(false);
        btnMisPublicaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMisPublicaciones.setFocusPainted(false);
        btnMisPublicaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMisPublicacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMisPublicacionesMouseExited(evt);
            }
        });
        btnMisPublicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisPublicacionesActionPerformed(evt);
            }
        });
        jPanelMisPublicaciones.add(btnMisPublicaciones);
        btnMisPublicaciones.setBounds(0, 0, 160, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMisPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRemit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRegistrarme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMisPublicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRemit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelRegistrarme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 500));
        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jPanelPublicacion.setBackground(new java.awt.Color(230, 236, 240));
        jPanelPublicacion.setPreferredSize(new java.awt.Dimension(900, 470));
        jPanelPublicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanelPublicacionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPublicacionLayout = new javax.swing.GroupLayout(jPanelPublicacion);
        jPanelPublicacion.setLayout(jPanelPublicacionLayout);
        jPanelPublicacionLayout.setHorizontalGroup(
            jPanelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1053, Short.MAX_VALUE)
        );
        jPanelPublicacionLayout.setVerticalGroup(
            jPanelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelPublicacion);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        lblLogo.setText("Logo");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 154, 201));
        jLabel1.setText("Remit");

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        lblNombreUsuario.setText("Nombre del usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblNombreUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });

        btnRecargar.setBackground(new java.awt.Color(0, 0, 0));
        btnRecargar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnRecargar.setText("Ver todas las publicaciones");
        btnRecargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecargar.setFocusPainted(false);
        btnRecargar.setFocusable(false);
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });
        btnRecargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRecargarKeyPressed(evt);
            }
        });

        cbxCategorias.setBackground(new java.awt.Color(0, 0, 0));
        cbxCategorias.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutoría", "Grupo de estudio autónomo", "Evento estudiantil", "Venta y/o servicio" }));
        cbxCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxCategorias.setFocusable(false);
        cbxCategorias.setPreferredSize(new java.awt.Dimension(69, 24));

        btnFiltrar.setBackground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.setFocusPainted(false);
        btnFiltrar.setFocusable(false);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(btnRecargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        deshabilitarOpciones();
        ocultarBotones();
        mostrarBotones();
        GuiRegistrarse.runRegistrarse();
        pop = true;
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String busqueda = txtBuscar.getText();
            int aux = 3;
            if (jPanelPublicacion.getHeight() > 470) {
                aux = 2;
            }
            for (int i = 0; i < aux; i++) {
                jPanelPublicacion.removeAll();
                jPanelPublicacion.repaint();
                cargarPublicaciones(busqueda, 2);
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void deshabilitarOpciones() {
        ArrayList<Component> componentes = new ArrayList<>();
        componentes.add(txtBuscar);
        componentes.add(btnIniciarSesion);
        componentes.add(btnRegistrarme);
        componentes.add(btnCerrarSesion);
        componentes.add(btnRemit);
        componentes.add(btnMisPublicaciones);
        Estetica.habDeshabComponentes(componentes, false);
    }

    private void ocultarBotones() {
        ArrayList<Component> componentes = new ArrayList<>();
        componentes.add(jPanelMisPublicaciones);
        componentes.add(jPanelRemit);
        componentes.add(jPanelCerrarSesion);
        Estetica.botonesOcultar = componentes;
        Estetica.mostrarOcultarBotones(false);
    }

    private void mostrarBotones() {
        ArrayList<Component> componentes = new ArrayList<>();
        componentes.add(jPanelIniciarSesion);
        componentes.add(jPanelRegistrarme);
        Estetica.botonesMostrar = componentes;
        Estetica.mostrarOcultarBotones(true);
    }

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        deshabilitarOpciones();
        ocultarBotones();
        mostrarBotones();
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

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        if (!pop) {
            jPanelCerrarSesion.setBackground(Color.white);
            btnCerrarSesion.setForeground(new java.awt.Color(4, 155, 201));
        }
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        if (!pop) {
            jPanelCerrarSesion.setBackground(new java.awt.Color(4, 155, 201));
            btnCerrarSesion.setForeground(Color.white);
        }
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void btnRemitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemitMouseEntered
        if (!pop) {
            jPanelRemit.setBackground(new java.awt.Color(237, 177, 15));
        }
    }//GEN-LAST:event_btnRemitMouseEntered

    private void btnRemitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemitMouseExited
        if (!pop) {
            jPanelRemit.setBackground(new java.awt.Color(237, 191, 23));
        }
    }//GEN-LAST:event_btnRemitMouseExited

    private void btnMisPublicacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisPublicacionesMouseEntered
        if (!pop) {
            jPanelMisPublicaciones.setBackground(new java.awt.Color(209, 195, 188));
        }
    }//GEN-LAST:event_btnMisPublicacionesMouseEntered

    private void btnMisPublicacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisPublicacionesMouseExited
        if (!pop) {
            jPanelMisPublicaciones.setBackground(new java.awt.Color(209, 207, 194));
        }
    }//GEN-LAST:event_btnMisPublicacionesMouseExited

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        pop = true;
        deshabilitarOpciones();
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Se va a cerrar la sesión \n"
                + "¿Quieres continuar?", "Remit", 0, 0,
                new ImageIcon(getClass().getResource("/recursos/img/exit.png")));
        if (opcion == 0) {
            for (Usuario usu : Controlador.listaUsuarios) {
                if (usu.getActivo()) {
                    usu.setActivo(false);

                    lblNombreUsuario.setVisible(false);
                    Archivo.guardarUsuarios(Controlador.listaUsuarios);
                    break;
                }
            }
            Estetica.mostrarOcultarBotones(Estetica.botonesMostrar, Estetica.botonesOcultar);
            Estetica.habDeshabComponentes(Estetica.componentesEntrantes, true);
            GuiVentanaPrincipal.pop = false;
        } else {
            Estetica.habDeshabComponentes(Estetica.componentesEntrantes, true);
            GuiVentanaPrincipal.pop = false;
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnRemitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemitActionPerformed
        pop = true;
        deshabilitarOpciones();
        GuiCrearPublicacion.llamaCrearPublicacion();
    }//GEN-LAST:event_btnRemitActionPerformed

    private void btnMisPublicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisPublicacionesActionPerformed
        pop = true;
        deshabilitarOpciones();
        GuiMisPublicaciones.main(null);
    }//GEN-LAST:event_btnMisPublicacionesActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        jPanelPublicacion.removeAll();
        jPanelPublicacion.repaint();
        cargarPublicaciones();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cargarPublicaciones();
        }
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void jPanelPublicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelPublicacionKeyPressed
    }//GEN-LAST:event_jPanelPublicacionKeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5KeyPressed

    private void btnRecargarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRecargarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecargarKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String categoría = cbxCategorias.getSelectedItem().toString();
        int aux = 3;
        if (jPanelPublicacion.getHeight() > 470) {
            aux = 2;
        }
        for (int i = 0; i < aux; i++) {
            jPanelPublicacion.removeAll();
            jPanelPublicacion.repaint();
            cargarPublicaciones(categoría, 1);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
                try {
                    new GuiVentanaPrincipal().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnMisPublicaciones;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton btnRemit;
    private javax.swing.JComboBox<String> cbxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCerrarSesion;
    private javax.swing.JPanel jPanelIniciarSesion;
    private javax.swing.JPanel jPanelMisPublicaciones;
    private javax.swing.JPanel jPanelPublicacion;
    private javax.swing.JPanel jPanelRegistrarme;
    private javax.swing.JPanel jPanelRemit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
