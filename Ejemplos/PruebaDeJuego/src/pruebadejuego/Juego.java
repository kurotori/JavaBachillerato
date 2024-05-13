/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebadejuego;

import herramientas.HerramientasVarias;

/**
 *
 * @author sebastian
 */
public class Juego {
    
    private int[][] casilleros;
    herramientas.HerramientasVarias varias = new HerramientasVarias();
    
    
    
    public Juego(int dimX,int dimY ){
        
        casilleros = new int[dimX][dimY];
        
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                casilleros[x][y]=varias.alAzarEntre(0, 10);
            }
        }
        
        //Posición de Inicio del Jugador
        casilleros[0][0]=11;
    }

    /**
     * @return the casilleros
     */
    public int valorDeCasillero(int x, int y) {
       return casilleros[x][y];
    }
}
