/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ConsultaOperaciones;
import Modelo.Compra;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ConoMaster
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    static Usuario usuarioPrincipal;
    
    //Paneles
    PanelInicioSesion panelInicioSesion;
    PanelPrincipal panelPrincipal = new PanelPrincipal();
    PanelUsuario panelUsuario;
    PanelManga panelManga;
    PanelListaMangas panelCarrito;
    PanelBotones panelBotones;
    PanelHistorial panelHistorial;
    PanelRegistro panelRegistro;
    JDialogAutor jDialogAutor;
    
    
    
    public FramePrincipal() {
        initComponents();
        botonSalir.setEnabled(false);
        botonHerramientas.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        botonInicio = new javax.swing.JMenu();
        botonIngresar = new javax.swing.JMenuItem();
        botonRegistro = new javax.swing.JMenuItem();
        botonSalir = new javax.swing.JMenuItem();
        botonHerramientas = new javax.swing.JMenu();
        botonComprar = new javax.swing.JMenuItem();
        botonHistorial = new javax.swing.JMenuItem();
        botonVerUsuario = new javax.swing.JMenuItem();
        botonEliminarUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        botonAcercaDe = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botonInicio.setText("Iniciar Sesion");

        botonIngresar.setText("Iniciar Sesion");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });
        botonInicio.add(botonIngresar);

        botonRegistro.setText("Registro");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });
        botonInicio.add(botonRegistro);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        botonInicio.add(botonSalir);

        jMenuBar1.add(botonInicio);

        botonHerramientas.setText("Herramientas");

        botonComprar.setText("Comprar");
        botonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprarActionPerformed(evt);
            }
        });
        botonHerramientas.add(botonComprar);

        botonHistorial.setText("Historial");
        botonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHistorialActionPerformed(evt);
            }
        });
        botonHerramientas.add(botonHistorial);

        botonVerUsuario.setText("Usuario");
        botonVerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerUsuarioActionPerformed(evt);
            }
        });
        botonHerramientas.add(botonVerUsuario);

        botonEliminarUsuario.setText("Eliminar Usuario");
        botonEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarUsuarioActionPerformed(evt);
            }
        });
        botonHerramientas.add(botonEliminarUsuario);

        jMenuBar1.add(botonHerramientas);

        jMenu2.setText("Información");

        botonAcercaDe.setText("Acerca de");
        botonAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(botonAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed

    panelInicioSesion = new PanelInicioSesion(this);
    setContentPane(panelInicioSesion);
    pack();
        
        
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
    
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que desea salir?");
    System.out.println(confirmacion);
    salir(confirmacion);
        
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonVerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerUsuarioActionPerformed
        panelUsuario = new PanelUsuario(usuarioPrincipal);
        setContentPane(panelUsuario);
        pack();
        this.setSize(800,700);
    }//GEN-LAST:event_botonVerUsuarioActionPerformed

    private void botonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprarActionPerformed
        
        panelManga = new PanelManga();
        panelCarrito = new PanelListaMangas();
        try {
            panelBotones = new PanelBotones(panelManga, panelCarrito);
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panelCarrito.setPanelBotones(panelBotones);
        
        setLayout(new BorderLayout());
        JPanel paneles = new JPanel();
        paneles.setLayout(new BorderLayout());
        paneles.add(panelManga, BorderLayout.CENTER);
        paneles.add(panelCarrito, BorderLayout.EAST);
        paneles.add(panelBotones, BorderLayout.SOUTH);
        this.setContentPane(paneles);
        pack();
        revalidate();
        
    }//GEN-LAST:event_botonComprarActionPerformed

    private void botonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHistorialActionPerformed

       panelHistorial = new PanelHistorial();
       setContentPane(panelHistorial);
       pack();
    }//GEN-LAST:event_botonHistorialActionPerformed
        
    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        panelRegistro = new PanelRegistro();
        setContentPane(panelRegistro);
        pack();
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void botonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarUsuarioActionPerformed

        if(JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas eliminar este usuario? Esta decision no tiene vuelta atrás") == 0){
            String confirmarContraseña = JOptionPane.showInputDialog(this, "Introduce la contraseña");
            if(confirmarContraseña.contains(usuarioPrincipal.getContrasenia())){
                ConsultaOperaciones operacion = new ConsultaOperaciones();
                JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito (Se han eliminado " + operacion.operacionDeleteUsuario(usuarioPrincipal.getNif())+ " registros)");
                salir(0);
                
            }
        }
    }//GEN-LAST:event_botonEliminarUsuarioActionPerformed

    private void botonAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAcercaDeActionPerformed
        jDialogAutor = new JDialogAutor(this, true);
        jDialogAutor.setVisible(true);
        this.pack();
    }//GEN-LAST:event_botonAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonAcercaDe;
    private javax.swing.JMenuItem botonComprar;
    private javax.swing.JMenuItem botonEliminarUsuario;
    private javax.swing.JMenu botonHerramientas;
    private javax.swing.JMenuItem botonHistorial;
    private javax.swing.JMenuItem botonIngresar;
    private javax.swing.JMenu botonInicio;
    private javax.swing.JMenuItem botonRegistro;
    private javax.swing.JMenuItem botonSalir;
    private javax.swing.JMenuItem botonVerUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
   
    
    
    class FondoPanel extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagen/cartelSeBusca.png")).getImage();
            g.drawImage(imagen,0,0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public PanelInicioSesion getPanelInicioSesion() {
        return panelInicioSesion;
    }

    public PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }

    public static Usuario getUsuarioPrincipal() {
        return usuarioPrincipal;
    }


    public JMenu getBotonHerramientas() {
        return botonHerramientas;
    }

    public JMenuItem getBotonIngresar() {
        return botonIngresar;
    }

    public JMenu getBotonInicio() {
        return botonInicio;
    }

    public JMenuItem getBotonJList() {
        return botonComprar;
    }

    public JMenuItem getBotonJTable() {
        return botonHistorial;
    }

    public JMenuItem getBotonModificacion() {
        return botonEliminarUsuario;
    }

    public JMenuItem getBotonSalir() {
        return botonSalir;
    }

    public JMenuItem getBotonVerUsuario() {
        return botonVerUsuario;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JMenuItem getBotonRegistro() {
        return botonRegistro;
    }
    
    
    
    public void salir(int confirmacion){
        if(confirmacion == 0){
            getContentPane().removeAll();
            validate();
            repaint();
            usuarioPrincipal = null;
            botonHerramientas.setEnabled(false);
            botonHerramientas.setVisible(false);
            botonSalir.setEnabled(false);
            botonIngresar.setEnabled(true);
            botonRegistro.setEnabled(true);
            this.setSize(800, 600);
        }
    }

}
