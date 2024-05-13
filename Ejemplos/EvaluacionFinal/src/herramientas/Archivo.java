/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class Archivo {
    
    public String leerArchivo(File archivo){
        
        String datos="";
        
        try {
            Scanner lector = new Scanner(archivo,"UTF-8");
            
            while(lector.hasNextLine()){
                datos += lector.nextLine() + "\n";
            }
            
        } catch (IOException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN:Error al leer el archivo";
        }
        catch (NullPointerException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN: No se eligió ningún archivo";
        }
        return datos;
    }
    
    
    public boolean guardarArchivo(String texto, File archivo){
        boolean resultado = false;
        if ( ! (archivo == null) ) {
            try{
                FileOutputStream flujoSalida = 
                        new FileOutputStream(archivo);

                OutputStreamWriter escritorFlujoSalida = 
                        new OutputStreamWriter(flujoSalida, "UTF-8");

                BufferedWriter escritor = 
                        new BufferedWriter(escritorFlujoSalida);
                escritor.write(texto);
                escritor.close();
            } 
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        else{
            System.err.println("ERROR: Archivo nulo");
        }
        return resultado;
    }
    
    
    //BLOQUE 6
    public boolean archivoExiste(File archivo){
        boolean resultado = false;
        if(archivo.exists() && ! archivo.isDirectory()){
            resultado = true;
        }
        return resultado;
    }
    //FIN DEL BLOQUE 6
    
}
