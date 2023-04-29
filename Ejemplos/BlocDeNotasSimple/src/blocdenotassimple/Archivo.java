/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Sebastian
 */
public class Archivo {
    
    /**
     * Crea un archivo de texto en la ruta especificada
     * @param texto
     * @param archivo 
     */
    public void guardarArchivo(String texto, File archivo){
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
    
    /**
     * Muestra el diálogo "Guardar Cómo"
     * @param ventana
     * @return 
     */
    public File dialogoGuardarComo(JFrame ventana){
        File archivo;
        JFileChooser dlg_guardarComo = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        int valorSalida = dlg_guardarComo.showSaveDialog(ventana);
        
        if (valorSalida == JFileChooser.APPROVE_OPTION) {
            archivo = dlg_guardarComo.getSelectedFile();
	}
        else{
            archivo = null;
        }
        return archivo;
    }
    
    /**
     * Abre un archivo
     * @param archivo
     * @return 
     */
    public String leerArchivo(File archivo){
        String datos="";
        try {
            Scanner lector = new Scanner(archivo,"UTF-8");
            while(lector.hasNextLine()){
                datos=datos+lector.nextLine()+"\n";
            }
 
        } catch (IOException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN: Error al leer el archivo";
        }
        catch (NullPointerException excepcion) {
            System.err.println(excepcion.getMessage());
            datos="ATENCIÓN: No se eligió ningùn archivo";
        }
        return datos;
    }
    
    
    /**
     * Abre el diálogo dialogoAbrirArchivo
     * @param ventana
     * @return 
     */
    public File dialogoAbrirArchivo(JFrame ventana){
        File archivo;
        
        JFileChooser dlg_abrir = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory());
        int valorSalida = dlg_abrir.showOpenDialog(ventana);
        
        if (valorSalida == JFileChooser.APPROVE_OPTION) {
            archivo = dlg_abrir.getSelectedFile();
            //System.out.println(selectedFile.getAbsolutePath());
	}
        else{
            archivo = null;
        }
        return archivo;
    }
    
}
