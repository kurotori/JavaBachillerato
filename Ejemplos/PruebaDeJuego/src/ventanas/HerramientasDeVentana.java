/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author luiss
 */
public class HerramientasDeVentana {
    
    public JPanel crearCasillero(int posX, int posY, int dimX, int dimY){
        JPanel panel = new JPanel();
        
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.gray));
        
        Rectangle r = new Rectangle(posX, posY, dimX, dimY);
        panel.setBounds(r);
        
        
        return panel;
    }
    
}
