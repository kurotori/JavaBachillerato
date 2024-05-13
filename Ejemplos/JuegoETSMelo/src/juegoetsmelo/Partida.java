/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoetsmelo;

import herramientas.Varias;

/**
 *
 * @author sebastian
 */
public class Partida {
    
    herramientas.Varias varias = new Varias();
    public int[][] casillero;
    public int posJ_X=0;
    public int posJ_Y=0;
    
    public Partida(int x, int y){
        this.casillero = new int[x][y];
        
        for (int posY = 0; posY < y; posY++) {
            
            for (int posX = 0; posX < x; posX++) {
                casillero[posX][posY]=varias.alAzarEntre(1, 11);
            }
        }
        
        this.casillero[0][0]=0;//Casillero de inicio del personaje
    }
    
}
