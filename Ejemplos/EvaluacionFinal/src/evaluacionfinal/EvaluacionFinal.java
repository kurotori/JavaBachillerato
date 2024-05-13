/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluacionfinal;

import herramientas.Archivo;
import java.io.File;
import ventanas.Inicio;

/**
 *
 * @author sebastian
 */
public class EvaluacionFinal {

    
    //BLOQUE 2
    public static void main(String[] args) {
        // TODO code application logic here
        herramientas.Archivo archivo = new Archivo();
        File archivoConfig = new File("config.txt");
        
        if (! archivo.archivoExiste(archivoConfig)) {
            archivo.guardarArchivo("...:0", archivoConfig);
        }
        
        ventanas.Inicio inicio = new Inicio();
        inicio.setVisible(true);
        
    }
    //FIN DEL BLOQUE 2
    
}
