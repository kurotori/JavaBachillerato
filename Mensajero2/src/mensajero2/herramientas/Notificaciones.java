/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2.herramientas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sebastian
 */
public class Notificaciones {
    
    /**
     * Formatea un evento para mostrar en la pantalla, agregando marca de tiempo
     * @param evento
     * @return 
     */
    public static String formatearEvento(String evento){
        DateTimeFormatter formateadorDeTiempo = DateTimeFormatter.ofPattern("dd-MM-yy|HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        String resultado = formateadorDeTiempo.format(ahora) + " > " + evento;
        return resultado;
    }
    
    public static void mostrarEventoConsola(String evento){
        
        System.out.println(
            formatearEvento(evento)
                );
    }
    
}
