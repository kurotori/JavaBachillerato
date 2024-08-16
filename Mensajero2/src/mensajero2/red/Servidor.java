/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2.red;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    /**
     * Lee una propiedad de 
     * @param propiedad
     * @return 
     */
    private String leerConfiguración(String propiedad, String archivoIni){
        String valor = "";
        try {
            Properties propiedades = new Properties();
            FileInputStream archivoConfig = new FileInputStream(archivoIni);//("servidor.ini");
            propiedades.load(archivoConfig);
            valor = propiedades.getProperty(propiedad);
        } catch (Exception e) {
        }
        
        
        return valor;
    }
    
    
    /**
     * Creación del Servidor con el pozo de hilos
     */
    public Servidor(){
        try {
            
        } catch (Exception e) {
        }
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
            servidor.iniciar();
            
            
        } catch (IOException error) {
            error.getMessage();
        }
    }
    
    /**
     * Arranque del servidor
     */
    public void iniciar(){
        try (ServerSocket socketServidor = new ServerSocket(puerto)){
             System.out.println("Iniciando el servidor en el puerto " + puerto);
             while (true) {                
                Socket socketCliente = socketServidor.accept();
                 System.out.println("Se ha conectado un cliente al sistema");
                 //pozoDeHilos.submit(n)
                 GestorDeClientes gestorCliente = new GestorDeClientes(socketCliente);
                 pozoDeHilos.submit(gestorCliente);
                 
            }
            
            
        } catch (IOException e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
    
    
}
