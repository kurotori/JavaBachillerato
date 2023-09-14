/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import pruebadejuego.Juego;

/**
 *
 * @author sebastian
 */
public class Mapa_swing extends javax.swing.JFrame{
    
    int dimX;
    int dimY;
    int lado;
    Juego juego;
    
    JPanel panelMapa;
    JPanel panelHerramientas;
    
    public Mapa_swing(int tamanio){
        switch (tamanio) {
            case 0 -> {
                dimX = 15;
                dimY = 9;
                lado = 48;
            }
            case 1 -> {
                dimX = 25;
                dimY = 15;
                lado = 30;
            }
            case 2 -> {
                dimX = 42;
                dimY = 25;
                lado = 18;
            }
            default -> throw new AssertionError();
        }
        
        juego = new Juego(dimX, dimY);
        configurar();
    }
    
    
    private void configurar(){
        int tableroX=(dimX*lado);
        int tableroY=(dimY*lado);
        
        this.setSize(tableroX+20,tableroY +150);
        System.out.println("x:"+(this.getWidth()) + " y:" +(this.getHeight() ));
        this.setLayout(null);
        
        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        panelMapa.setBounds(10, 10, tableroX, tableroY);
        panelMapa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        for (int posY = 0; posY < dimY; posY++) {
            
            int y = (posY==0)? (0) : (posY*lado);
            
            for (int posX = 0; posX < dimX; posX++) {
                int x = (posX==0)? (0) : (posX*lado);
           
                int valor = juego.valorDeCasillero(posX, posY);
                Casillero cas = new Casillero(valor,lado,x,y);
                panelMapa.add(cas);
            }
        }
        
        this.getContentPane().add(panelMapa);
        
        panelHerramientas = new PanelHerramientas();
        panelHerramientas.setBounds(10, (tableroY+15), 580, 100);
        panelHerramientas.setVisible(true);
        panelHerramientas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.getContentPane().add(panelHerramientas);
        
        //pack();
    }
    
    
    
}
