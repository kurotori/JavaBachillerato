/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mensajero2.red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase para la gestión de conexiones entrantes al servidor
 *
 * @author sebastian
 */
public class GestorDeClientes implements Runnable {

    //Creamos un objeto para la conexión entrante de los clientes
    private Socket socketCliente;

    /**
     * Método Constructor: Crea la instancia inicializando el socket
     * @param socketCliente Conexión para el cliente
     */
    public GestorDeClientes(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    /**
     * El mét
     */
    @Override
    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(
                                socketCliente.getInputStream()
                    )
                );
                PrintWriter salida = new PrintWriter(
                    socketCliente.getOutputStream(), true
                )
            )
        {
            String mensaje;
            while (
                    (mensaje = entrada.readLine()) != null
                    ) {                
                System.out.println("Mensaje Recibido:" + mensaje);
                salida.println("S:Recibido: " + mensaje);
            }
            
        } 
        catch (IOException error) {
            System.out.println("ERROR: "+error.getMessage());
        }
        finally{
            try {
                socketCliente.close();
            } catch (IOException error) {
                System.out.println("ERROR: "+error.getMessage());
            }
        }
    }

}
