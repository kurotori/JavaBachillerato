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
    private int valor;
    private int lado;
    private int posX;
    private int posY;
    private JLabel lblImagen;
    private boolean oculto = true;
    
    public Casillero(int valor, int lado, 
            int posX, int posY){
        
        this.valor = valor;
        this.lado = lado;
        this.posX = posX;
        this.posY = posY;
        
        if(this.valor < 4 || this.valor == 11){
            oculto = false;
        }
        
        Rectangle limites = 
            new Rectangle(posX, posY, lado, lado);
        this.setBounds(limites);
        this.setBackground(Color.white);
        
        //this.setBorder(
          //      BorderFactory.
            //        createLineBorder(Color.black));
        this.setLayout(null);
        
        lblImagen = new JLabel();
        lblImagen.setBounds(0, 0, lado, lado);
        this.add(lblImagen);
        cambiarImagen();
    }
    
    public void cambiarImagen(){
        int imagen;
        switch (this.valor) {
            case 1:
                imagen=this.valor;
                break;
            case 2:
                imagen=this.valor;
                break;
            case 3:
                imagen=this.valor;
                break;
            case 11:
                imagen=this.valor;
                break;
            default:
                if (! oculto) {
                    imagen=this.valor;
                }
                else{
                    imagen = 0;
                }
                
        }
        
        String ruta = "/imagen/"+imagen+".png";
        //System.out.println(ruta);
        try {
            Image img = ImageIO.read(
                    getClass().getResource(ruta)
            );
            
            img = img.
                    getScaledInstance(lado, lado, 
                            Image.SCALE_SMOOTH);
            lblImagen.setIcon( new ImageIcon(img) );
            
        } catch (Exception e) {
            cambiarImagen(0);
            
            System.out.println("ERROR:" + e.getMessage());
        }
    }
    
    public void cambiarImagen(int valor){
        this.valor = valor;
        cambiarImagen();
    }
    
    public void esOculto(boolean valor){
        this.oculto=valor;
    }
    
}
