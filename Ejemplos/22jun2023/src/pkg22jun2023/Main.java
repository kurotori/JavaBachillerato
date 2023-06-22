/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg22jun2023;

import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personaje p1 = new Personaje(10, 10, 10, "Pepito");
        Personaje p2 = new Personaje(10, 10, 10, "Carlitos");
        Arma a1 = new Arma("Garrote", 10);
        
        p1.Atacar(p2);
        p2.Atacar(p1, a1);
        
    }
    
}
