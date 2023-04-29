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
public class Usuario {
    
    private String nombre;
    private String apellido;
    private int puntaje;
    
    public Usuario(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntaje = 0;
    }
    
    public Usuario(){
        this.nombre = "";
        this.apellido = "";
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
