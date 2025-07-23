/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import herramientas.Mensaje;

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

            //Identificación del servidor ante el cliente
            servidor.enviarMensajeAUsuarioSRV(
                    "nombreS:" + servidor.getClServidor().getUsuario().getNombre(),
                     Mensaje.MENSAJE_DE_CONTROL,
                    cliente.getUsuario());
            //Envío del nombre de usuario temporal al cliente
            servidor.enviarMensajeAUsuarioSRV(
                    "nombreU:" + cliente.getUsuario().getNombre(),
                    Mensaje.MENSAJE_DE_CONTROL,
                    cliente.getUsuario());
            //Mensaje de bienvenida
            servidor.enviarMensajeAUsuarioSRV(
                    "Te damos la bienvenida al Servidor " + servidor.getClServidor().getUsuario().getNombre(),
                    Mensaje.MENSAJE_DEL_SERVIDOR,
                    cliente.getUsuario());

            //Le pedimos al usuario que ingrese su nombre
            servidor.enviarMensajeAUsuarioSRV(
                    "Por favor ingresa un nombre de usuario",
                    Mensaje.MENSAJE_DEL_SERVIDOR,
                    cliente.getUsuario());

            //Mensaje de control para que el cliente le solicite al usuario un nombre
            servidor.enviarMensajeAUsuarioSRV(
                    "nombreU?",
                    Mensaje.MENSAJE_DE_CONTROL,
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
                    servidor.enviarMensajeAUsuarioSRV(
                            "nombreU?",
                            Mensaje.MENSAJE_DE_CONTROL,
                            cliente.getUsuario());

                } else {

                    sinNombre = false;
                    servidor.enviarMensajeAUsuarioSRV(
                            "Hola " + mensaje,
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
            //FIN DE BIENVENIDA AL USUARIO
            
            //Bucle de Conexión general
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
    
    /**
     * Permite interpretar las solicitudes de los clientes
     * @param solicitud 
     */
    public void interpretarSolicitud(Mensaje solicitud){
        
        switch (solicitud.tipo) {
            case 3005: //Mensajes al servidor, contienen comandos
                String[] comando = solicitud.mensaje.split(":");
                switch (comando[0]) {
                    case "nombreU":
                        String nombreActual = cliente.getUsuario().getNombre();
                        if (servidor.nombreEnUso(comando[1] )) {
                            servidor.enviarMensajeAUsuarioSRV(
                            "Ese nombre ya esta en uso, intenta de nuevo",
                            Mensaje.MENSAJE_DEL_SERVIDOR,
                            cliente.getUsuario());
                    servidor.enviarMensajeAUsuarioSRV(
                            "nombreU?",
                            Mensaje.MENSAJE_DE_CONTROL,
                            cliente.getUsuario());
                        }
                        else{
                            servidor.enviarMensajeGeneral(
                                    nombreActual+ " acaba de cambiar su nombre a " + 
                                    comando[1]);
                            cliente.getUsuario().setNombre(comando[1]);
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            default:
                throw new AssertionError();
        }
        
    }

}
