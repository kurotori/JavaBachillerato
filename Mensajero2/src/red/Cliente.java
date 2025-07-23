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
import ventanas.ClientePrincipal;

/**
 *
 * @author sebastian
 */
public class Cliente {
    private Usuario usuario;
    private String ipServidor;
    private String nombreServidor;
    private int puerto;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;
    
    
    /**
     * Método constructor para representar clientes conectados en el servidor
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
     * Método constructor para establecer el 'perfil público' del servidor
     * @param servidor 
     */
    public Cliente (String servidor){
        this.salida = null;
        this.entrada= null;
        this.usuario = new Usuario(servidor);
    }
    
    /**
     * Método constructor principal usado por los clientes al conectarse
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
            GestorDeMensajesDelCliente gestorSale = new GestorDeMensajesDelCliente(salida,usuario);
            
           
            //Creamos y abrimos la ventana principal
            ClientePrincipal principal = new ClientePrincipal(this, entrada, gestorSale);
            principal.setTitle(ipServidor);
            principal.setVisible(true);
            
            //new Thread(gestor).start();
            
//            String respuesta;
//            while (
//                    (respuesta = entrada.readLine()) != null
//                    ) {
//                
//                Mensaje recibido = JSON.jsonAMensaje(respuesta);
//                interpretarMensajeRecibido(recibido);
//                
//            }
            
            
        } catch (Exception e) {
        }
    }

    public PrintWriter obtenerSalida() {
        return salida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNombreServidor() {
        return nombreServidor;
    }
    
    public void actualizarUsuario(String nombre){
        if (this.usuario==null) {
            this.usuario = new Usuario(nombre);
        }
        else{
            this.usuario.setNombre(nombre);
        }
    }

    public Socket obtenerConexion() {
        return conexion;
    }
    
    public void actrualizarNombreServidor(String nombre){
        this.nombreServidor = nombre;
    } 
    
}

