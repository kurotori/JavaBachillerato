/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import herramientas.HerramientasVarias;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author luiss
 */
public class Casillero extends JPanel {
    
    herramientas.HerramientasVarias varias = new HerramientasVarias();
    
    
    int valor;
    
    
    
    public Casillero(Rectangle limites, int valor){
        //valor = varias.alAzarEntre(0, 10);
        //System.out.println("valor"+valor);
        this.valor = valor;
        this.setLayout(null);
        this.setBounds(limites);
        agregarComponentes();
    }
    
    private void agregarComponentes(){
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);
        
        JLabel lblImagen = new JLabel();
        Color colorBorde = new Color(244, 244, 244);
        lblImagen.setBorder(BorderFactory.createLineBorder(colorBorde));
        lblImagen.setBounds(0,0, this.getWidth(), this.getHeight());
        
        valor = (valor>3)?(0):(valor);
        String ruta;
        switch (valor) {
            case 0:
                ruta="/imagen/"+valor+".png";
                break;
            case 1:
                ruta="/imagen/"+valor+".png";
                break;
            case 2:
                ruta="/imagen/"+valor+".png";
                break;
            case 3:
                ruta="/imagen/"+valor+".png";
                break;
            default:
                ruta="/imagen/0.png";
        }
        
        
        try{
            Image img = ImageIO.read(getClass().getResource(ruta));
            
            img = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(img));
        }
        catch(IOException ex){
            System.out.println("ERROR: "+ex.getMessage() + ex.getLocalizedMessage());
        }
        
        this.add(lblImagen);
        
    }
    
}
