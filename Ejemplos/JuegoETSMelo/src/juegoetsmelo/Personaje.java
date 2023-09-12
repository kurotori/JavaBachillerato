/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoetsmelo;

/**
 *
 * @author sebastian
 */
public class Personaje {
    private String nombre;
    private int vida;
    private int nivel;
    private int experiencia;
    
    public Personaje(
            String nombre, int vida,
            int nivel, int experiencia){
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        this.experiencia = experiencia;
    }
}
