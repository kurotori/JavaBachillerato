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
        
        Casillero cas = null;
        
        for (int y = 0; y < 13; y++) {
            int posY = (y * 48)-2;
            
            for (int x = 0; x < 13; x++) {
                
                int posX = (x * 48)-2;
                
                if ( !(x<5 && y<5) && !(x>7 && y>7)
                  && !(x<5 && y>7) && !(x>7 && y<5)
                   ) 
                {
                    cas = new Casillero(posX, posY,x,y, 48);
                }
                
                if ( (x==0 && y==0) ) {
                    
                    cas = new Casillero(x, y,x,y, 48*5);
                    
                }
                
                if (cas != null) {
                    this.getContentPane().add(cas);
                }
            }
        }
    }
}
