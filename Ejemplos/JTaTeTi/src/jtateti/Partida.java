/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtateti;

/**
 *
 * @author luiss
 */

import java.util.Scanner;

public class Partida {
    
    private String titulo;
    private Usuario propietario;
    private Usuario[] jugadores = new Usuario[3];
    
    public Partida(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Hola, ¿Cuál es tu nombre?");
        String nombre = teclado.nextLine();
        System.out.println("¿Cuál es tu apellido?");
        String apellido = teclado.nextLine();
        
        propietario = new Usuario(nombre, apellido);
        
        System.out.println("Agrega un título a la partida:");
        titulo = teclado.nextLine();
        
        System.out.println("Agrega los datos de los jugadores:");
        
        for (int posicion = 0; posicion < jugadores.length ; posicion++) {
            System.out.println("Jugador " + (posicion+1));
            System.out.println("Nombre:");
            String nombreJ = teclado.nextLine();
            
            System.out.println("Apellido:");
            String apellidoJ = teclado.nextLine();
            
            Usuario jugador = new Usuario(nombreJ, apellidoJ);
            jugadores[posicion] = jugador;
        }
        teclado.close();
    }
    
    public void VerPuntajes(){
        System.out.println("Propietario: ");
        System.out.println(propietario.getNombre());
        System.out.println(propietario.getPuntaje() + " puntos");
        for (int posicion = 0; posicion < jugadores.length ; posicion++) {
            System.out.println("Jugador " + (posicion+1));
            System.out.println(jugadores[posicion].getNombre());
            System.out.println(jugadores[posicion].getPuntaje() + " puntos");
        }
    }
}
