/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import mensajero2.Usuario;
import mensajero2.herramientas.JSON;
import mensajero2.herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class GestorDeMensajesDelCliente implements Runnable {

    private PrintWriter salida;
    private Usuario usuario;

    public GestorDeMensajesDelCliente(PrintWriter salida, Usuario usuario) {
        this.salida = salida;
        this.usuario = usuario;
    }

    @Override
    public void run() {
        InputStreamReader lectorDeEntrada = new InputStreamReader(System.in);
        BufferedReader lectorDeConsola = new BufferedReader(lectorDeEntrada);

        try {
            String entradaUsuario;
            
            while (
                    (entradaUsuario = lectorDeConsola.readLine()
                    ) != null
                    ) {
                System.out.println(entradaUsuario);
                //interpretarMensajeAEnviar(entradaUsuario);
                salida.println(entradaUsuario); //El dato se envía al servidor
            }
        } catch (Exception error) {
            System.out.println("ERROR:" + error.getLocalizedMessage());
            error.printStackTrace();
            
        }
    }

    private void interpretarMensajeAEnviar(String mensaje) {
        if (mensaje==null) {
            System.out.println("es null");
        }
        Mensaje msj = null;
        char caracter = mensaje.charAt(0);
        String datos = mensaje.substring(1, mensaje.length() - 1);
        //Mensaje directo a usuario
        switch (caracter) {
            case '@':
                msj = new Mensaje(usuario, datos, Mensaje.MENSAJE_DIRECTO_A_OTRO_USUARIO);
                break;
            case ':':
                msj = new Mensaje(usuario, datos, Mensaje.MENSAJE_AL_SERVIDOR);
                break;
            default:
                System.out.println("Caso por descarte");
                msj = new Mensaje(usuario, datos, Mensaje.MENSAJE_GENERAL);
                
        }
        String m = JSON.mensajeAJSON(msj);
        System.out.println("Enviando " + m);
        salida.println(m);
    }
}
