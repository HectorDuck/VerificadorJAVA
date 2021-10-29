package VerificadorPack;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoEncontrado extends javax.swing.JFrame implements ActionListener {

    Timer t = null;
    Principal p = null;

    public ProductoEncontrado(String nombre, double precio, int cantidad, String imagen) {
        initComponents();
        t=null;
        this.setSize(966, 511);
        this.setLocationRelativeTo(null);
        FotoProducto.setText("");
        FotoProducto.setSize(572, 360);
        FotoProducto.setLocation(83, 70);
        this.getContentPane().setBackground(Color.green);
        try {
            URL url = new URL(imagen);
            BufferedImage image = ImageIO.read(url);
            FotoProducto.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(346, 352, Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            FotoProducto.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\hecto\\Desktop\\UNISON\\Septimo semestre\\Ingenieria de Software III\\Verificador\\src\\main\\java\\VerificadorPack\\img\\placeholder.png").getImage().getScaledInstance(346, 352, Image.SCALE_DEFAULT)));
        }
        NombreProducto.setSize(160, 20);
        NombreProducto.setLocation(544, 112);
        NombreProducto.setText("NOMBRE: " + nombre);
        Precio.setSize(101, 20);
        Precio.setLocation(544, 201);
        Precio.setText("PRECIO: $" + precio);
        Cantidad.setSize(101, 20);
        Cantidad.setLocation(544, 332);
        Cantidad.setText("CANTIDAD: " + cantidad);
        t = new Timer(10000, this);
        t.start();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FotoProducto = new javax.swing.JLabel();
        NombreProducto = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        FotoProducto.setText("Fotito");
        getContentPane().add(FotoProducto);
        FotoProducto.setBounds(90, 90, 80, 20);
        getContentPane().add(NombreProducto);
        NombreProducto.setBounds(680, 90, 110, 50);
        getContentPane().add(Precio);
        Precio.setBounds(710, 160, 80, 30);
        getContentPane().add(Cantidad);
        Cantidad.setBounds(700, 220, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel FotoProducto;
    private javax.swing.JLabel NombreProducto;
    private javax.swing.JLabel Precio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t) {
            p = new Principal();
            p.setVisible(true);
            t.stop();
            this.dispose();            
        }
    }
}
