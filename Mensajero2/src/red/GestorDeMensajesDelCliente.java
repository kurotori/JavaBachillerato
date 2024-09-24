/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import mensajero2.Usuario;
import herramientas.JSON;
import herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class GestorDeMensajesDelCliente {

    private PrintWriter salida;
    private Usuario usuario;

    public GestorDeMensajesDelCliente(PrintWriter salida, Usuario usuario) {
        this.salida = salida;
        this.usuario = usuario;
    }

    /**
     * Interpreta el mensaje ingresado por el usuario y lo prepara para ser
     * enviado
     *
     * @param mensaje
     */
    private Mensaje interpretarMensaje(String mensaje) {

        Mensaje msj = null;
        int tipo = 0;

        //Extraemos el primer caracter del mensaje
        char caracter = mensaje.charAt(0);
        //Obtenemos 
        String cuerpo = mensaje.substring(1, mensaje.length() - 1);
        //Procesamos el mensaje
        switch (caracter) {
            case '@':
                tipo = Mensaje.MENSAJE_DIRECTO_A_OTRO_USUARIO;
                //msj = new Mensaje(usuario, cuerpo, Mensaje.MENSAJE_DIRECTO_A_OTRO_USUARIO);
                break;
            case ':':
                tipo = Mensaje.MENSAJE_AL_SERVIDOR;
                //msj = new Mensaje(usuario, cuerpo, Mensaje.MENSAJE_AL_SERVIDOR);
                break;
            default:
                tipo = Mensaje.MENSAJE_GENERAL;
            //System.out.println("Caso por descarte");
            //msj = new Mensaje(usuario, cuerpo, Mensaje.MENSAJE_GENERAL);

        }

        //Creamos el mensaje
        msj = new Mensaje(usuario, cuerpo, tipo);

        return msj;
    }

    /**
     * Envía el mensaje al servidor
     *
     * @param mensaje
     */
    public void enviarMensaje(String mensaje) {
        //analizamos los datos de entrada para evitar mensajes vacíos
        if ((mensaje != null) && !(mensaje.trim().isEmpty())) {

            //Analizamos y convertimos el mensaje
            Mensaje msj = interpretarMensaje(mensaje);

            //Obtenemos el string JSON para enviar
            String dato = JSON.mensajeAJSON(msj);

            //Enviamos el mensaje
            try {
                salida.println(msj);
                salida.flush();
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
    }
}
