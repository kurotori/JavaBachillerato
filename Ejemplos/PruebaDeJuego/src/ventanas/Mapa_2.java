/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class Mapa_2 extends JFrame {

    int dimX;
    int dimY;

    JPanel areaJuego;
    JPanel areaHerramientas;

    public Mapa_2(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        configurarVentana();
    }

    private void configurarVentana() {
        this.setSize(dimX, dimY);
        this.setTitle("Mapa 2");
        
        BoxLayout layCaja = 
                new BoxLayout(
                        this, BoxLayout.Y_AXIS);
        
        this.setLayout(layCaja);
        
        areaJuego = new JPanel();
        areaJuego.setSize(dimX-10, dimY-10);
        areaJuego.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaJuego.setAlignmentX(CENTER_ALIGNMENT);
        this.getContentPane().add(areaJuego);
        
    }

}
