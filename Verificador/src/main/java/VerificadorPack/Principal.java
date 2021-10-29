/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificadorPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class Principal extends javax.swing.JFrame {

    private String codigo = "";

    public Principal() {
        initComponents();
        this.getContentPane().setBackground(Color.GREEN);
        LogoEmpresa.setText("");
        CodigoDeBarras.setText("");
        this.setSize(966, 511);
        this.setLocationRelativeTo(null);
        LogoEmpresa.setLocation(78, 105);
        LogoEmpresa.setSize(388, 245);
        CodigoDeBarras.setLocation(566, 227);
        CodigoDeBarras.setSize(240, 163);
        Peticion.setSize(497, 24);
        Peticion.setLocation(567, 98);
        LogoEmpresa.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\hecto\\Desktop\\UNISON\\Septimo semestre\\Ingenieria de Software III\\Verificador\\src\\main\\java\\VerificadorPack\\img\\oxxo.png").getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT)));
        CodigoDeBarras.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\hecto\\Desktop\\UNISON\\Septimo semestre\\Ingenieria de Software III\\Verificador\\src\\main\\java\\VerificadorPack\\img\\barcode-scan.gif").getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Peticion = new javax.swing.JLabel();
        LogoEmpresa = new javax.swing.JLabel();
        CodigoDeBarras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(437, 98));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        Peticion.setText("Por favor pasa el código de barras por el escáner");
        getContentPane().add(Peticion);
        Peticion.setBounds(609, 124, 236, 14);

        LogoEmpresa.setText("Hola");
        getContentPane().add(LogoEmpresa);
        LogoEmpresa.setBounds(119, 124, 21, 14);

        CodigoDeBarras.setText("Codigito");
        getContentPane().add(CodigoDeBarras);
        CodigoDeBarras.setBounds(609, 144, 39, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() != 10) {
            codigo += evt.getKeyChar();
        } else {
            try {
                Connection con = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/verificador_de_precios", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT producto_nombre, producto_precio, producto_cantidad, producto_imagen FROM productos WHERE producto_codigo = " + codigo);
                //Aquí los índices empiezan en 1
                if (rs.next()) {
                    ProductoEncontrado PE = new ProductoEncontrado(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getString(4));
                    PE.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado, llame a personal autorizado");
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            codigo = "";
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodigoDeBarras;
    private javax.swing.JLabel LogoEmpresa;
    private javax.swing.JLabel Peticion;
    // End of variables declaration//GEN-END:variables
}
