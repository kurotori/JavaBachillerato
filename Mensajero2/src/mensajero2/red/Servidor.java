/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2.red;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author sebastian
 */
public class Servidor {
    
    //Configuración del puerto
    private static int puerto;
    
    //Configuración del Pozo de hilos
    private static int TOPE_POZO_DE_HILOS = 10;
    private ExecutorService pozoDeHilos;
    
    private ServerSocket socketServidor;
    
    /**
     * Creación del Servidor con el pozo de hilos
     */
    public Servidor(){
        //Inicialización del pozo de hilos con la cantidad de hilos establecida
        this.pozoDeHilos = Executors.newFixedThreadPool(TOPE_POZO_DE_HILOS);
        
    }
    
    /**
     * Ejecución del servidor
     * @param args 
     */
    public static void main(String[] args) {
        try {
            
            System.out.println("Iniciando el servidor...");
            //Objeto para acceder a un archivo de configuración
            Properties propiedades = new Properties();
            //Objeto para leer el archivo de configuración
            FileInputStream archivoConfig = new FileInputStream("servidor.ini");
            propiedades.load(archivoConfig);
            
            System.out.println("Leyendo la configuración...");
            puerto = Integer.parseInt(propiedades.getProperty("puerto"));
            System.out.println("Puerto:" + puerto);
            
            Servidor servidor = new Servidor();
            
            
        } catch (IOException error) {
            error.getMessage();
        }
    }
    
    /**
     * Arranque del servidor
     */
    public void iniciar(){
        try {
            socketServidor = new ServerSocket(puerto);
            
            
        } catch (Exception e) {
        }
    }
    
    //
    //private Socket socketCliente;
    
     
    private BufferedReader entrada;
    private PrintWriter salida;
    
    
}
