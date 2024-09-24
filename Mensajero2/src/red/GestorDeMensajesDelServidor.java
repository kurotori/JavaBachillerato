/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import herramientas.JSON;
import herramientas.Mensaje;
import herramientas.Notificaciones;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import mensajero2.Usuario;
import ventanas.ClientePrincipal;

/**
 *  Permite que el cliente reciba e interprete las respuestas del servidor
 * @author sebastian
 */
public class GestorDeMensajesDelServidor implements Runnable {

    private ClientePrincipal ventanaPrincipal;
    private BufferedReader entradaDeDatos;

    public GestorDeMensajesDelServidor(ClientePrincipal ventana, BufferedReader entrada) {
        this.ventanaPrincipal = ventana;
        this.entradaDeDatos = entrada;
    }

    @Override
    public void run() {

        try {
            String mensaje;

            while ((mensaje = entradaDeDatos.readLine()) != null) {
                //ventanaPrincipal.agregarMensaje(">>>", mensaje);
                Mensaje nuevo = JSON.jsonAMensaje(mensaje);
                interpretarMensajeRecibido(nuevo);

            }
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    /**
     * Permite interpretar el mensaje recibido desde el servidor
     *
     * @param msj
     */
    public void interpretarMensajeRecibido(Mensaje msj) {

        System.out.println();
        switch (msj.tipo) {
            case 3004: //Mensaje directo al usuario

                System.out.println(
                        msj.marcaDeTiempo + " > "
                        + msj.usuario_nombre + " me dice:  "
                        + msj.mensaje
                );
                break;
            case 3003: //Mensaje General
                ventanaPrincipal.agregarMensaje(
                        msj.usuario_nombre,
                        msj.marcaDeTiempo + " > " + msj.usuario_nombre
                );
                System.out.println(
                        msj.marcaDeTiempo + " > "
                        + msj.usuario_nombre + " :  "
                        + msj.mensaje
                );
                break;
            case 3002: //Mensaje del Servidor
                ventanaPrincipal.agregarMensaje(msj.usuario_nombre, msj.mensaje);
                System.out.println(
                        msj.marcaDeTiempo + " SRV > "
                        + msj.usuario_nombre + " : "
                        + msj.mensaje
                );
                break;
            case 3000: //Mensaje de control / comando
                String[] comando = msj.mensaje.split(":");
                System.out.println("comando 0 : " + comando[0]);
                System.out.println("comando 1 : " + comando[1]);
                switch (comando[0]) {
                    case "nombreU": //El servidor envía al cliente el nombre de usuario a utilizar
                        System.out.println("comando nombreU");
                        ventanaPrincipal.getCliente().actualizarUsuario(comando[1]);
                        ventanaPrincipal.setTitle(
                                ventanaPrincipal.getCliente().getUsuario().getNombre() +
                                "@" + 
                                ventanaPrincipal.getCliente().getNombreServidor()
                        );
//this.usuario = new Usuario(comando[1]);
                        Notificaciones.mostrarEventoConsola(
                                "Identificado temporalmente como "
                                + ventanaPrincipal.getCliente().getUsuario().getNombre()
                        );
                        break;
                        
                    case "nombreU?":
                        String nombre = JOptionPane.showInputDialog(
                                "Ingresa un nombre de usuario para usar en el servidor '"+
                                ventanaPrincipal.getCliente().getNombreServidor() + "'"
                        );
                        ventanaPrincipal.enviarMensaje(":nombreU:"+nombre);
                        break;
                    case "nombreS":
                        ventanaPrincipal.getCliente().actrualizarNombreServidor(comando[1]);
                        ventanaPrincipal.setTitle(ventanaPrincipal.getCliente().getNombreServidor());
                        break;

                    default:
                        throw new AssertionError();
                }

                break;
            default:
                System.out.println("No detallado");
        }
    }

}
