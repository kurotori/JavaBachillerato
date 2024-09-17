/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2.herramientas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mensajero2.Usuario;

/**
 *
 * @author sebastian
 */
public class Mensaje {
    
    public String usuario_nombre;
    public String usuario_id;
    public String mensaje;
    public String marcaDeTiempo;
    public int tipo;
    
    // TIPOS DE MENSAJES
    public static int MENSAJE_DE_ESTADO = 3000;
    public static int MENSAJE_DE_ESTADO_CAMBIAR_NOMBRE = 3001;
    public static int MENSAJE_DEL_SERVIDOR = 3002;
    public static int MENSAJE_GENERAL = 3003;
    public static int MENSAJE_DIRECTO_AL_USUARIO = 3004;
    public static int MENSAJE_AL_SERVIDOR = 3005;
    public static int MENSAJE_DIRECTO_A_OTRO_USUARIO = 3006;
    // ----- //
    
    /**
     * 
     * @param usuario
     * @param mensaje
     * @param tipo 
     */
    public Mensaje(Usuario usuario, String mensaje, int tipo){
        this.usuario_nombre = usuario.getNombre();
        this.usuario_id = usuario.getId().toString();
        this.mensaje = mensaje;
        this.tipo = tipo;
        
        DateTimeFormatter formateadorDeTiempo = DateTimeFormatter.ofPattern("dd-MM-yy|HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        this.marcaDeTiempo = formateadorDeTiempo.format(ahora);
    }
    
    public Mensaje(){
    }
    
}
