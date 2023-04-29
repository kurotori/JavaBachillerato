/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author luiss
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private int ci;
    
    public Usuario(String nombre, String apellido, int ci){
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
    }
    
    public Usuario(){
        this.nombre = "";
        this.apellido = "";
        this.ci = 0;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the ci
     */
    public int getCi() {
        return ci;
    }
    
    
}
