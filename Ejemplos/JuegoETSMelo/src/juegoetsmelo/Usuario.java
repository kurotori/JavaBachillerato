/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoetsmelo;

/**
 *
 * @author sebastian
 */
public class Usuario {
    private String nombre;
    private String clavePub;
    private int rango;
    
    private Personaje personaje;
    
    public Usuario(String nombre, int rango){
        this.nombre = nombre;
        this.rango = rango;
        personaje = new Personaje("", 0, 0, 0);
    }
    
    
}
