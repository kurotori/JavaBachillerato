/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastian
 */
public class Casillero extends JPanel {
    public int valor;
    private int lado;
    private int posX;
    private int posY;
    public int coordX;
    public int coordY;
    private JLabel lblImagen;
    
    public Casillero(int valor, int lado, 
            int posX, int posY, int coordX, int coordY){
        this.valor = valor;
        this.lado = lado;
        this.posX = posX;
        this.posY = posY;
        this.coordX = coordX;
        this.coordY = coordY;
        Rectangle limites = 
            new Rectangle(posX, posY, lado, lado);
        this.setBounds(limites);
        this.setBackground(Color.white);
        
        this.setLayout(null);
        
        lblImagen = new JLabel();
        lblImagen.setBounds(0, 0, lado, lado);
        
        this.add(lblImagen);
        cambiarImagen();
    }
    
    public void cambiarImagen(){
        String ruta = "/imagen/"+this.valor+".png";
        System.out.println(ruta);
        try {
            Image img = ImageIO.read(
                    getClass().getResource(ruta)
            );
            
            img = img.
                    getScaledInstance(lado, lado, 
                            Image.SCALE_SMOOTH);
            lblImagen.setIcon( new ImageIcon(img) );
            
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }
    
    public void cambiarImagen(int valor){
        this.valor = valor;
        cambiarImagen();
    }
    
}
