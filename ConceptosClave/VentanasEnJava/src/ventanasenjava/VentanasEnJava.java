/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanasenjava;

/**
 *
 * @author luiss
 */

import java.util.Scanner;
public class VentanasEnJava {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String[] usuarios = new String[5];
        int[] puntajes = new int[5];
        
        for (int posicion = 0; posicion < usuarios.length; posicion++) {
            System.out.println("Escriba el nombre del jugador " + (posicion+1) + ":");
            usuarios[posicion] = teclado.nextLine();
            puntajes[posicion] = 0;
        }
        
        
        
        for (int posicion = 0; posicion < usuarios.length; posicion++) {
            System.out.println("Jugador:" + usuarios[posicion]);
            System.out.println("Puntaje:" + puntajes[posicion]);
        }
    }
}
