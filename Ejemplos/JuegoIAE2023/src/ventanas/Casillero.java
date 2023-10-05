/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class Casillero extends JPanel {
    
    int posX;
    int posY;
    int coordX;
    int coordY;
    int lado;
    
    public Casillero(
            int posX, int posY, int coordX, int coordY, int lado){
        this.lado = lado;
        this.posX = posX;
        this.posY = posY;
        this.coordX = coordX;
        this.coordY = coordY;
        
        this.setBounds(this.posX, this.posY, this.lado, this.lado);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }
    
}
