/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import mensajero2.Usuario;
import mensajero2.herramientas.JSON;
import mensajero2.herramientas.Notificaciones;
import mensajero2.herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class GestorDeClientes implements Runnable {

    private Cliente cliente;
    private Servidor servidor;

    public GestorDeClientes(Cliente cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        boolean sinNombre = true;
        try {
            //Se establece una conexión con el cliente para acceder a sus mensajes
            InputStreamReader receptorDeMensajes
                    = new InputStreamReader(cliente.obtenerConexion().getInputStream());
            //Creamos un objeto BufferedReader para que lleguen los mensajes del cliente
            BufferedReader entradaDeMensajes = new BufferedReader(receptorDeMensajes);

            //Le pedimos al usuario que ingrese su nombre
            servidor.enviarMensajeAUsuarioSRV(
                    "nombreU:" + cliente.getUsuario().getNombre(), 
                    Mensaje.MENSAJE_DE_CONTROL, 
                    cliente.getUsuario());
            
            servidor.enviarMensajeAUsuarioSRV(
                    "Te damos la bienvenida al Servidor",
                    Mensaje.MENSAJE_DEL_SERVIDOR, 
                    cliente.getUsuario());
            servidor.enviarMensajeAUsuarioSRV(
                    "Por favor ingresa un nombre de usuario",
                    Mensaje.MENSAJE_DEL_SERVIDOR, 
                    cliente.getUsuario());
           
            String mensaje;

            while (sinNombre
                    && (mensaje = entradaDeMensajes.readLine()) != null) {
                //enviarMensajeAUsuario("Por favor ingresa un nombre de usuario:");

                if (servidor.nombreEnUso(mensaje)) {
                    servidor.enviarMensajeAUsuarioSRV(
                        "Ese nombre ya esta en uso, intenta de nuevo",
                        Mensaje.MENSAJE_DEL_SERVIDOR, 
                        cliente.getUsuario());

                } else {

                    sinNombre = false;
                    servidor.enviarMensajeAUsuarioSRV(
                            "Hola "+mensaje, 
                            Mensaje.MENSAJE_DEL_SERVIDOR, 
                            cliente.getUsuario());
                    servidor.enviarMensajeAUsuarioSRV(
                            "En este momento hay "
                            + servidor.usuariosConectados()
                            + " usuarios conectados", 
                            Mensaje.MENSAJE_DEL_SERVIDOR, 
                            cliente.getUsuario());
                    
                    servidor.mostrarEvento(
                            "El nombre de " + cliente.getUsuario().getNombre()
                            + " ha cambiado a: " + mensaje
                    );
                    
                    servidor.enviarMensajeGeneral(mensaje + " acaba de conectarse");
                    cliente.getUsuario().setNombre(mensaje);
                }
            }

            while ((mensaje = entradaDeMensajes.readLine()) != null // Chequeamos que no haya mensajes del usuario
                    ) {
                System.out.println(cliente.getUsuario().getNombre() + " dice: " + mensaje);
                servidor.enviarMensajeATodos(mensaje, cliente);
            }

        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            servidor.rechazarCliente(cliente);
            try {
                cliente.obtenerConexion().close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
