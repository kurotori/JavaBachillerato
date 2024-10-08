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
import herramientas.JSON;
import herramientas.Notificaciones;
import herramientas.Mensaje;

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
            //Se abre la conexión utilizando los datos provistos por el método constructor
            conexion = new Socket(ipServidor,puerto);
            
            Notificaciones.mostrarEventoConsola("Conectado al servidor en " + ipServidor);
            
            //Inicializamos los objetos para el envío y la recepción de solicitudes
            InputStreamReader lectorDeEntrada = new InputStreamReader(conexion.getInputStream());
            OutputStreamWriter escritorDeSalida = new OutputStreamWriter(conexion.getOutputStream());
            
            entrada = new BufferedReader(lectorDeEntrada);
            salida = new PrintWriter(escritorDeSalida,true);
            
            //Declaramos un objeto gestor para manejar el envío de mensajes del cliente
            GestorDeMensajesDelCliente gestor = new GestorDeMensajesDelCliente(salida,usuario);
            
            new Thread(gestor).start();
            
            String respuesta;
            while (
                    (respuesta = entrada.readLine()) != null
                    ) {
                
                Mensaje recibido = JSON.jsonAMensaje(respuesta);
                interpretarMensajeRecibido(recibido);
                
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
    
    /**
     * 
     * @param args 
     */
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
    public void interpretarMensajeRecibido(Mensaje msj){
        
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
            case 3000: //Mensaje de control / comando
                String[] comando = msj.mensaje.split(":");
                System.out.println("comando 0 : " + comando[0]);
                System.out.println("comando 1 : " + comando[1]);
                switch (comando[0]) {
                    case "nombreU":
                        System.out.println("comando nombreU");
                        this.usuario = new Usuario(comando[1]);
                        Notificaciones.mostrarEventoConsola(
                                "Identificado temporalmente como " +
                                this.usuario.getNombre()
                                        );
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

