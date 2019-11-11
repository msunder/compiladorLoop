/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurokitsune.main;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import informacion.*;
/**
 *
 * @author marcos
 */
public class cargar_archivo extends javax.swing.JPanel {
    
    private File archivo;
    private String direccionArchivo;
    private String pathArchivo;
    private JOptionPane mensaje;
    /**
     * Creates new form cargar_archivo
     */
    public cargar_archivo() {
        initComponents();
        this.setVisible(true);
        TextoArchivo.setEditable(false);
        jButton2.setEnabled(false);
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
        TextoArchivo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        notificaciones = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextoArchivo.setColumns(20);
        TextoArchivo.setRows(5);
        jScrollPane1.setViewportView(TextoArchivo);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 660, 340));

        notificaciones.setColumns(20);
        notificaciones.setRows(5);
        jScrollPane2.setViewportView(notificaciones);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 870, 150));

        jButton1.setText("Cargar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, 40));

        jButton2.setText("Compilar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 40));

        jLabel1.setText("Ruta: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 640, -1));

        jLabel2.setText("Notificaciones:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TextoArchivo = new javax.swing.JTextArea();

        TextoArchivo.setColumns(20);

        TextoArchivo.setRows(5);
        
        jScrollPane1.setViewportView(TextoArchivo);
         notificaciones = new javax.swing.JTextArea();
        notificaciones.setColumns(20);
        notificaciones.setRows(5);
        jScrollPane2.setViewportView(notificaciones);

        TextoArchivo.setEditable(false);
        JFileChooser selector = new JFileChooser("/home");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("loop", "Loop", "LOOP");
       
        selector.setFileFilter(filtro);
        int respuesta = selector.showOpenDialog(this);
        if(respuesta == JFileChooser.APPROVE_OPTION){
            
        
            String elemento;
            archivo = selector.getSelectedFile();
            if(archivo != null){

                direccionArchivo = archivo.getParent();
                pathArchivo = archivo.getAbsolutePath();
                jLabel1.setText("Ruta: " + archivo.getAbsolutePath());
                try{
                    int pos = 0;
                    String textoinsertar;
                    FileReader contenido = new FileReader(archivo);
                    BufferedReader lee = new BufferedReader(contenido);
                    while((elemento = lee.readLine())!=null){
                        textoinsertar = elemento + "\n";
                        TextoArchivo.insert(textoinsertar, pos);
                    }
                    TextoArchivo.setSize(220, 85);
                    jButton2.setEnabled(true);
                }catch (FileNotFoundException ex) {
                    Logger.getLogger(cargar_archivo.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex){

                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se selecciono ningun archivo","NOTIFICACION!!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        token.contadorGlobal = 0;
        token.contadorLocal = 0;
        notificaciones = new javax.swing.JTextArea();
        notificaciones.setColumns(20);
        notificaciones.setRows(5);
        this.escribirNotificacion("Iniciando Compilacion de archivo " + this.pathArchivo);
        jScrollPane2.setViewportView(notificaciones);
        try{
            AnalizadorLexico lex = new AnalizadorLexico(new FileReader(pathArchivo)); 
        } catch(java.lang.Exception el){
            
        } 
    }//GEN-LAST:event_jButton2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextoArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea notificaciones;
    // End of variables declaration//GEN-END:variables
    public void escribirNotificacion(String mensaje){
       
       notificaciones.insert(mensaje, 0);
    }
}
