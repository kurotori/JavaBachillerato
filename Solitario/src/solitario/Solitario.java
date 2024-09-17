/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solitario;

import java.util.Random;
/**
 *
 * @author sebastian
 */

public class Solitario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] tipos
                = {"oro", "espada", "copa", "basto"};

        int[][] baraja = new int[48][2];

        int numero = 0;
        for (int carta = 0; carta < 48; carta++) {
            int tipo = 0;

            if (carta < 12) {
                tipo = 0; //oro
            }
            if ((carta >= 12) && (carta < 24)) {
                tipo = 1; //espada
            }
            if ((carta >= 24) && (carta < 36)) {
                tipo = 2; //copa
            }
            if ((carta >= 36) && (carta < 48)) {
                tipo = 3; //espada
            }

            numero++;
            if (numero > 12) {
                numero = 1;
            }
            baraja[carta][1] = numero;
            baraja[carta][0] = tipo;
        }

        barajarMazo(baraja);
        for (int[] carta:baraja) {
            System.out.println( 
                    tipos[carta[0]] + "-" + carta[1]
            );
        }
    }
    
    static void barajarMazo(int[][] mazo){
        Random azar = new Random();    
        int[] carta1 = null;
        int posicion = 0;
        
        for (int i = 0; i < mazo.length; i++) {
            carta1 = mazo[i];
            posicion = azar.nextInt(mazo.length);
            mazo[i] = mazo[posicion];
            mazo[posicion] = carta1;
        }
        
    }

}
