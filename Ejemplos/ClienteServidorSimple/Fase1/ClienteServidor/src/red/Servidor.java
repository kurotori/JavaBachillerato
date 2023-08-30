/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.net.*;
import java.io.*;

/**
 * Servidor base del sistema
 * @author Luis Sebastián de los Ángeles
 */
public class Servidor {
    //Creamos objetos auxiliares:
    //1: Un Socket para que el servidor envíe sus respuestas
    private ServerSocket socketServidor;
    
    //2: Un Socket para que los clientes envíen sus solicitudes
    private Socket socketCliente;
    
    //3: Un BufferedReader para las solicitudes de los clientes
    private BufferedReader entrada;
    
    //4: Un PrintWriter para las respuestas del servidor
    private PrintWriter salida;
    
    
    /**
     * Permite iniciar el servidor en el puerto indicado
     * @param puerto el puerto para abrir e iniciar el servidor
     */
    public void iniciar(int puerto){
        //Mensaje de inicio
        System.out.println("Iniciando el servidor en el puerto "+ puerto);
        
        try {
            //Se abre el socket del servidor en el puerto indicado
            socketServidor = new ServerSocket(puerto);
            
            //Mensajes de control
            System.out.println("Servidor iniciado");
            System.out.println("Esperando clientes...");
            
            //Se espera a que un cliente se conecte al servidor...
            socketCliente = socketServidor.accept();
            
            //...y cuando sucede se muestran sus datos
            System.out.println(
                    "Se ha conectado un cliente desde la IP: "+
                    socketCliente.getInetAddress().getHostAddress()
            );
            
            
            
        } catch (Exception e) {
        }
        
        
    }
}
