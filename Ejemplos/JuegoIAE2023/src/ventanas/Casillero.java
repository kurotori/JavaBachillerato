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
    
    int x;
    int y;
    int lado;
    
    public Casillero(int x, int y, int lado){
        this.lado = lado;
        this.x = x;
        this.y = y;
        
        this.setBounds(this.x, this.y, this.lado, this.lado);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }
    
}
