/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JTextField;

/**
 *
 * @author luiss
 */
public class Herramientas {
    
    /**
     * Función para chequear si el contenido de un campo de texto contiene solo espacios o es vacío
     * @param campo El campo cuyo contenido se quiere chequear.
     * @return false si el campo tiene un contenido de solo espacios, true si tiene otros caracteres
     */
    public boolean ChequearSoloEspacios(JTextField campo){
        boolean resultado = false;
        String datos = campo.getText();
        if (datos.length()>0) {
            for (char caracter : datos.toCharArray()) {
                if (caracter != ' ') {
                    resultado = true;
                    break;
                }
            }
        }
        
        return resultado;
    }
    

}
