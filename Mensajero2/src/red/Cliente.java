/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import mensajero2.Usuario;
import mensajero2.herramientas.JSON;
import mensajero2.herramientas.Notificaciones;
import mensajero2.herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class Cliente {
    private Usuario usuario;
    private String ipServidor;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;
    private int puerto;
    
    /**
     * Método constructor para su uso desde el servidor
     * @param salida
     * @param usuario
     * @param conexion 
     */
    public Cliente(PrintWriter salida, Usuario usuario, Socket conexion) {
        this.salida = salida;
        this.usuario = usuario;
        this.conexion = conexion;
        
    }
    
    /**
     * Método constructor para el cliente simbólico que representa al Servidor
     */
    public Cliente (String servidor){
        this.salida = null;
        this.entrada= null;
        this.usuario = new Usuario(servidor);
    }
    
    /**
     * Método constructor principal 
     * @param salida
     * @param usuario
     * @param conexion
     * @param ipServidor
     * @param puerto 
     */
    public Cliente(  
            String ipServidor,
            int puerto
            ) {
        this.ipServidor = ipServidor;
        this.puerto = puerto; 
    }
    
    /**
     * Inicia el cliente
     */
    public void iniciar(){
        try {
            conexion = new Socket(ipServidor,puerto);
            Notificaciones.mostrarEventoConsola("Conectado al servidor en " + ipServidor);
            
            InputStreamReader lectorDeEntrada = new InputStreamReader(conexion.getInputStream());
            OutputStreamWriter escritorDeSalida = new OutputStreamWriter(conexion.getOutputStream());
            
            entrada = new BufferedReader(lectorDeEntrada);
            salida = new PrintWriter(escritorDeSalida,true);
            
            GestorDeMensajesDelCliente gestor = new GestorDeMensajesDelCliente(salida);
            
            new Thread(gestor).start();
            
            String respuesta;
            while (
                    (respuesta = entrada.readLine()) != null
                    ) {
                
                Mensaje recibido = JSON.jsonAMensaje(respuesta);
                interpretarMensaje(recibido);
                //System.out.println(respuesta);
            }
            
            
        } catch (Exception e) {
        }
    }

    public PrintWriter obtenerSalida() {
        return salida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Socket obtenerConexion() {
        return conexion;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese la IP del servidor: ");
        String ipServidor = teclado.nextLine();
        System.out.print("Ingrese el puerto del servidor: ");
        int puerto = teclado.nextInt();
        Cliente cliente = new Cliente(ipServidor, puerto);
        cliente.iniciar();
        teclado.close();
    }
    
    /**
     * Permite interpretar el mensaje recibido
     * @param msj 
     */
    public static void interpretarMensaje(Mensaje msj){
        
        System.out.println();
        switch (msj.tipo) {
            case 3004: //Mensaje directo al usuario
                System.out.println(
                        msj.marcaDeTiempo + " > "+
                        msj.usuario_nombre +" me dice:  "+
                        msj.mensaje
                );
                break;
            case 3003: //Mensaje General
                System.out.println(
                        msj.marcaDeTiempo + " > "+
                        msj.usuario_nombre +" :  "+
                        msj.mensaje
                );
                break;
            case 3002: //Mensaje del Servidor
                System.out.println(
                        msj.marcaDeTiempo + " SRV > "+
                        msj.usuario_nombre +" : "+
                        msj.mensaje
                );
                break;
            default:
                System.out.println("No detallado");
        }
    }
}

