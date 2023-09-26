/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 *
 * @author sebastian
 */
public class Tablero extends javax.swing.JFrame {
    //Medidas del tablero: 15 casilleros de lado
    //Medidas del casillero: 48px --> 720px de lado
    
    public Tablero(){
        configurar();
    }
    
    private void configurar(){
        this.setSize(720, 750);
        this.setLayout(null);
        
        for (int y = 0; y < 15; y++) {
            int coordY = (y * 48)-2;
            for (int x = 0; x < 15; x++) {
                int coordX = (x * 48)-2;
                Casillero cas = new Casillero(coordX, coordY, 48);
                this.getContentPane().add(cas);
            }
        }
        
        
    }
}
