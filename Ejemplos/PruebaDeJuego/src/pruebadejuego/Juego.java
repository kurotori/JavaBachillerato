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
    
    private int[] casilleros;
    herramientas.HerramientasVarias varias = new HerramientasVarias();
    
    
    
    public Juego(int dimX,int dimY ){
        
        casilleros = new int[dimX*dimY];
        
        for (int casN = 0; casN < dimX*dimY; casN++) {
            
                casilleros[casN]=varias.alAzarEntre(0, 10);
            
        }
        
        casilleros[0]=0;
    }

    /**
     * @return the casilleros
     */
    public int valorDeCasillero(int x, int y, int dimX) {
       return casilleros[x+(y*dimX)];
    }
}
