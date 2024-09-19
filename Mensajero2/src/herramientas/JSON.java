/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author sebastian
 */
public class JSON {
    public static String mensajeAJSON(Mensaje mensaje){
        String resultado;
        ObjectMapper mapeadorJSON = new ObjectMapper();
            
        try {
            resultado = mapeadorJSON.writeValueAsString(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "ERROR";
        }
        return resultado;
    }
    
    public static Mensaje jsonAMensaje(String json){
        Mensaje resultado;
        
        ObjectMapper mapeadorJSON = new ObjectMapper();
        try {
            resultado = mapeadorJSON.readValue(json, Mensaje.class);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = null;
        }
        
        return resultado;
    }
    
    
    
}
