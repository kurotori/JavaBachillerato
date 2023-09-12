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
    
    
    public Partida(int x, int y){
        this.casillero = new int[x][y];
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                casillero[j][i]=varias.alAzarEntre(0, 13);
            }
        }
    }
    
}
