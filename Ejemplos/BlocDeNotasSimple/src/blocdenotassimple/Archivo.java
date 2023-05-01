
package blocdenotassimple;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.util.Scanner;

/**
 * Contiene los métodos necesarios para el manejo de archivos en la aplicación.
 * @author Sebastián de los Ángeles
 * @version  1.0
 */
public class Archivo {
    
    /**
     * Crea un archivo de texto en la ruta especificada y devuelve el resultado de la operación
     * @param texto
     * @param archivo
     * @return true si la operación fue exitosa, false si hubo algún error
     */
    public boolean guardarArchivo(String texto, File archivo){
        //Creamos una variable para el resultado de la operación
        boolean resultado = false;
        
        //Chequeamos si el archivo entregado es nulo
        if ( ! (archivo == null) ) {
            
            //Si no lo es, iniciamos el proceso de guardado
            try{
                //Creamos un flujo de salida hacia la ubicación indicada en la ruta del archivo
                FileOutputStream flujoSalida = 
                        new FileOutputStream(archivo);

                //Con el flujo de salida, creamos un objeto para codificar los datos antes de guardarlos
                OutputStreamWriter escritorFlujoSalida = 
                        new OutputStreamWriter(flujoSalida, "UTF-8");

                //Creamos un objeto para vincular los datos codificados al archivo
                BufferedWriter escritor = 
                        new BufferedWriter(escritorFlujoSalida);

                //Escribimos los datos
                escritor.write(texto);

                //Cerramos el archivo
                escritor.close();
                
                //Establecemos el resultado en true (operación exitosa)
            } 
            catch (IOException e) {
            
                //En caso de un error, mostramos el mensaje en la salida estandar de errores
                System.err.println(e.getMessage());
            }
        }
        else{
            //Si el objeto archivo fuera nulo, enviamos un mensaje de error a la salida de errores
            System.err.println("ERROR: Archivo nulo");
        }
        
        return resultado;
        
    }
    
    
    /**
     * Muestra el diálogo "Guardar Cómo"
     * @param ventana ventana activa desde la cuál se abrirá el diálogo
     * @return un objeto File con los datos del archivo creado
     */
    public File dialogoGuardarComo(JFrame ventana){
        //Creamos un objeto para contener los datos del archivo
        File archivo=null;
        
        //Creamos un objeto para el diálogo...
        JFileChooser dlg_guardarComo = new JFileChooser(
                //...indicando que debe abrirse en la carpeta personal del usuario actual
                FileSystemView.getFileSystemView().getHomeDirectory()
            );
        
        //Creamos un int que almacenará el valor de salida del diálogo, para control
        // y lo asociamos al diálogo con su método para abrirse, vinculándolo a una ventana activa
        int valorSalida = dlg_guardarComo.showSaveDialog(ventana);
        
        //Si el valor de salida del diálogo coincide con el botón 'Aceptar'...
        if (valorSalida == JFileChooser.APPROVE_OPTION) {
            //...obtenemos los datos del archivo seleccionado y los agregamos al objeto archivo
            archivo = dlg_guardarComo.getSelectedFile();
	}
        
        //El método entrega el objeto archivo 
        return archivo;
    }
    
    /**
     * Abre un archivo y obtiene sus datos
     * @param archivo el objeto File con los datos del archivo
     * @return un objeto String con los datos del archivo, o mensajes de error
     */
    public String leerArchivo(File archivo){
        //Creamos una variable para los datos del archivo
        String datos="";
        
        //Iniciamos el proceso de lectura del archivo
        try {
            //Creamos un objeto Scanner para leer los datos del archivo,
            // indicando los datos del archivo y la codificación a utilizar.
            Scanner lector = new Scanner(archivo,"UTF-8");
            
            //Con un bucle, obtenemos las líneas del archivo una a una...
            while(lector.hasNextLine()){
                //... y las agregamos a la variable datos, 
                // con un salto de línea al final de cada una
                datos += lector.nextLine() + "\n";
            }
 
        //Si hay un error al leer el archivo, los datos serán un mensaje de error
        } catch (IOException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN:Error al leer el archivo";
        }
        
        //Si el archivo es nulo, significa que no se eligió ningún archivo, y los datos serán un mensaje de error
        catch (NullPointerException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN: No se eligió ningún archivo";
        }
        
        //El método entrega los datos obtenidos
        return datos;
    }
    
    
    /**
     * Abre el diálogo AbrirArchivo
     * @param ventana
     * @return un objeto File con los datos de acceso al archivo seleccionado
     */
    public File dialogoAbrirArchivo(JFrame ventana){
        //Creamos un objeto para el archivo
        File archivo=null;
        
        //Creamos un objeto para el diálogo...
        JFileChooser dlg_abrir = new JFileChooser(
            //...indicando que debe abrirse en la carpeta personal del usuario actual
            FileSystemView.getFileSystemView().getHomeDirectory()
        );
        
        //Creamos un int que almacenará el valor de salida del diálogo, para control
        // y lo asociamos al diálogo con su método para abrirse, vinculándolo a una ventana activa
        int valorSalida = dlg_abrir.showOpenDialog(ventana);
        
        //Si el valor de salida del diálogo coincide con el botón 'Aceptar'...
        if (valorSalida == JFileChooser.APPROVE_OPTION) {
            //...obtenemos los datos del archivo seleccionado y los agregamos al objeto archivo
            archivo = dlg_abrir.getSelectedFile();
	}
        
        
        //El método entrega el objeto archivo 
        return archivo;
    }
    
}
