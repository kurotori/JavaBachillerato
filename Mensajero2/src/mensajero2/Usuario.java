/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2;

import java.util.UUID;

/**
 *
 * @author sebastian
 */
public class Usuario {
    private String nombre;
    private UUID id;
    private int estado;
    
    public static int ESTADO_CONECTADO=1001;
    
    
    public Usuario(String nombre){
        this.nombre = nombre;
        this.id = UUID.randomUUID();
        this.estado = Usuario.ESTADO_CONECTADO;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
