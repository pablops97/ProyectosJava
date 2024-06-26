/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ConsultaManga;
import Controlador.MError;
import Controlador.MiExcepcion;
import Modelo.Manga;
import Modelo.MangaDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ConoMaster
 */
public class PanelListaMangas extends javax.swing.JPanel {

    /**
     * Creates new form PanelCarrito
     */
    ArrayList<Manga> elementos = new ArrayList<Manga>();
    MangaDB mangaDB = new MangaDB(new ConsultaManga().getRs());
    DefaultListModel modelo;
    PanelBotones panelBotones;
    
    static float precioTotal;
    
    public PanelListaMangas() {
        
        initComponents();
        try {
            elementos = mangaDB.getMangas();
        } catch (MiExcepcion ex) {
            Logger.getLogger(PanelListaMangas.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo = modelListManga(elementos);
        listaCarrito.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaCarrito = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        botonRevisarCarrito = new javax.swing.JButton();

        listaCarrito.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCarrito.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCarritoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCarrito);

        jLabel1.setFont(new java.awt.Font("Unispace", 2, 18)); // NOI18N
        jLabel1.setText("LISTA MANGAS");

        botonRevisarCarrito.setText("REVISAR CARRITO");
        botonRevisarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRevisarCarritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRevisarCarrito)
                            .addComponent(jLabel1))
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(botonRevisarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonRevisarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRevisarCarritoActionPerformed

        //Este boton lo que hace es mandar al jtable con todos los elementos de la tabla compra
    }//GEN-LAST:event_botonRevisarCarritoActionPerformed

    private void listaCarritoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCarritoValueChanged





        Manga manga = obtenerMangaSeleccionado();
//Gestionamos el manejo de botones y mandarle el manga al otro panel
    if (manga != null) {
        // Pasa el manga al otro panel y muestra los datos
        panelBotones.setManga(manga);
        panelBotones.mostrarDatos();
        if(listaCarrito.getSelectedIndex() == listaCarrito.getFirstVisibleIndex()){
            panelBotones.getBotonAtras().setEnabled(false);
            panelBotones.getBotonPrimero().setEnabled(false);
            panelBotones.getBotonSiguiente().setEnabled(true);
            panelBotones.getBotonUltimo().setEnabled(true);
        }else if(listaCarrito.getSelectedIndex() == listaCarrito.getLastVisibleIndex()){
            panelBotones.getBotonSiguiente().setEnabled(false);
            panelBotones.getBotonUltimo().setEnabled(false);
            panelBotones.getBotonPrimero().setEnabled(true);
            panelBotones.getBotonAtras().setEnabled(true);
        }else{
            panelBotones.getBotonAtras().setEnabled(true);
            panelBotones.getBotonSiguiente().setEnabled(true);
            panelBotones.getBotonPrimero().setEnabled(true);
            panelBotones.getBotonUltimo().setEnabled(true);
        }
    }

    }//GEN-LAST:event_listaCarritoValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRevisarCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaCarrito;
    // End of variables declaration//GEN-END:variables

    public JList<String> getListaCarrito() {
        return listaCarrito;
    }

    public void setListaCarrito(JList<String> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }


    public void inicializarLista(){
        listaCarrito.setModel(modelListManga(elementos));
        jScrollPane1.setViewportView(listaCarrito);
    }

    public ArrayList<Manga> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Manga> elementos) {
        this.elementos = elementos;
    }
    
    public boolean comprobarExistencia(Manga m){
        for(Manga manga : elementos){
            if(manga == m){
                return true;
            }
        }
        return false;
    }

    private DefaultListModel modelListManga(ArrayList<Manga> mangas){
        DefaultListModel model = new DefaultListModel<>();
        for (Manga manga : mangas) {
            model.addElement(manga);
        }
        return model;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }


    private Manga obtenerMangaSeleccionado() {
    int indiceSeleccionado = listaCarrito.getSelectedIndex();

    if (indiceSeleccionado != -1) {
        Manga mangaSeleccionado =(Manga) modelo.getElementAt(indiceSeleccionado);
        return mangaSeleccionado;
    } else {
        return null; // No hay ningún elemento seleccionado
    }
    
    
}

    public void setPanelBotones(PanelBotones panelBotones) {
        this.panelBotones = panelBotones;
    }
    
    
}
