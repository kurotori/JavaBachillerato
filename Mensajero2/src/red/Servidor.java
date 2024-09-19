/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mensajero2.Usuario;
import herramientas.JSON;
import herramientas.Notificaciones;
import herramientas.Propiedades;
import herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class Servidor {
    private static int puerto;
    private static int CAPACIDAD_DE_POZO;
    private ExecutorService pozoDeHilos;
    
    //Estado de ejecución de la aplicación
    private volatile boolean activo = true;
    //Lista de clientes conectados
    private List<Cliente> clientes =  new CopyOnWriteArrayList<>();
    private Cliente clServidor;
    
    
    
    Propiedades configuracion;
    Notificaciones notificaciones = new Notificaciones();
    
    
    /**
     * Método constructor para iniciar un servidor
     * @param archivoIni Ruta al archivo donde se encuentra el archivo INI con 
     * la configuración.
     */
    public Servidor(String archivoIni){
        //1 - Inicializar el objeto configuración para acceder a esos datos
        configuracion = new Propiedades(archivoIni);
        
        //2 - Obtener y convertir los datos del archivo INI 
        puerto = Integer.parseInt( configuracion.verPropiedad("puerto", "12345") );
        CAPACIDAD_DE_POZO = Integer.parseInt( configuracion.verPropiedad("maxConexiones", "10") );
        
        String nombreServer = configuracion.verPropiedad("nombreServidor", "MensajeroServer");
        clServidor = new Cliente(nombreServer);
        
        //3 - crear una cola de ejecución para las conexiones entrantes en espera
        BlockingQueue<Runnable> colaDeEjecucion = new ArrayBlockingQueue<>(50);
        
        //4 - Crear un pozo de hilos para las conexiones aceptadas
        pozoDeHilos = new ThreadPoolExecutor(
                10, //Capacidad base del pozo de hilos
                CAPACIDAD_DE_POZO, //Capacidad máxima del pozo de hilos
                1L, //Tiempo máximo de espera, la 'L' indica que debe transformarse de 'int' a 'long' 
                TimeUnit.SECONDS, //Unidad utilizada para el tiempo de espera
                colaDeEjecucion, //Cola de ejecución hacia donde se dirijirán solicitudes entrantes superada la capacidad tope
                new ThreadPoolExecutor.AbortPolicy() //Acción a desarrollar si la cola entrante esta llena
        );
    }
    
    /**
     * Permite ejecutar el servidor
     * @param args 
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor("servidor.ini");
        servidor.iniciar();
    }
    
    /**
     * Permite iniciar el servidor
     */
    public void iniciar(){
        //Abro un bloque try-with-resources con la conexión abierta del servidor
        try (
            ServerSocket conexionServidor = new ServerSocket(puerto)
            )
        {
            //Mensaje de control
            System.out.println("Servidor iniciado en el puerto " + puerto);
            
            //Gestión de usuarios entrantes
            while(activo){
                //Esperamos una conexión cliente mediante un objeto Socket
                Socket conexionCliente = conexionServidor.accept();
                mostrarEvento(
                        "Se ha conectado un cliente desde " + 
                                conexionCliente.getInetAddress().getCanonicalHostName()
                );
                //Creamos un usuario con datos temporales para aceptar la conexión
                Usuario nuevoUsuario = new Usuario("anon" + clientes.size());
                //Creamos un objeto PrintWriter para los mensajes enviados por el cliente
                PrintWriter salidaCliente = new PrintWriter(conexionCliente.getOutputStream(),true);
                //Creamos el objeto cliente para controlar la conexión
                Cliente nuevoCliente = new Cliente(salidaCliente, nuevoUsuario, conexionCliente);
                
                clientes.add(nuevoCliente);
                //Creamos un gestor de clientes para gestionar el acceso
                GestorDeClientes gestorCliente = new GestorDeClientes(nuevoCliente, this);
                //Enviamos al gestor al pozo de hilos
                pozoDeHilos.submit(gestorCliente);
                //Tras esto el servidor queda libre para aceptar otra conexión
            }
            
        } catch (Exception error) {
            error.printStackTrace();
        }
        finally{
            
        }
    }
    
    /**
     * Permite enviar un mensaje a todos los demás clientes conectados
     * @param mensaje
     */
    public void enviarMensajeGeneral(String mensaje){
        for (Cliente cliente : clientes) {
            Mensaje msj = new Mensaje(clServidor.getUsuario(), mensaje, Mensaje.MENSAJE_GENERAL);
            //cliente.obtenerSalida().println("EL SERVIDOR dice: "+mensaje);
            }
    }
    
    /**
     * Permite a un usuario enviar un mensaje a todos los demás clientes conectados
     * @param mensaje
     * @param emisor 
     */
    public void enviarMensajeATodos(String mensaje, Cliente emisor){
        for (Cliente cliente : clientes) {
            if (cliente!=emisor) {
                System.out.println("Enviando a todos: "+emisor.getUsuario().getNombre() + ": "+mensaje);
                Mensaje msj = new Mensaje(emisor.getUsuario(), mensaje, Mensaje.MENSAJE_GENERAL);
                
                cliente.obtenerSalida().println(
                        JSON.mensajeAJSON(msj)
                );
            }
        }
    }
    
    /**
     * Permite al servidor enviarle un mensaje a un usuario específico
     * @param msj 
     * @param tipo
     * @param receptor
     */
    public void enviarMensajeAUsuarioSRV(String msj, int tipo, Usuario receptor){
        UUID idReceptor = receptor.getId();
        
        for (Cliente cliente : clientes) {
            if ( cliente.getUsuario().getId().equals(idReceptor) ) {
                Mensaje mensaje = new Mensaje(this.clServidor.getUsuario(), msj, tipo);
                String datoAEnviar = JSON.mensajeAJSON(mensaje);
                cliente.obtenerSalida().println(datoAEnviar);
            }
        }
    }
    
    /**
     * Permite enviar un mensaje de un usuario a otro usuario específico
     * @param mensaje
     * @param emisor
     * @param idReceptor 
     */
    public void enviarMensajeAUsuario(String mensaje, Cliente emisor, UUID idReceptor){
        
        for (Cliente cliente : clientes) {
            if (cliente.getUsuario().getId().equals(idReceptor)) {
                cliente.obtenerSalida().println(
                        "MD>>"+
                        emisor.getUsuario().getNombre()+" dice:"+
                        mensaje
                );
            }
            break;
        }
    }
    
    /**
     * Permite expulsar un cliente del servidor
     * @param expulsado 
     */
    public void rechazarCliente(Cliente expulsado){
        expulsado.obtenerSalida().println("Has sido expulsado del servidor");
        clientes.remove(expulsado);
    }
    
    /**
     * Permite chequear si un nombre de usuario ya esta tomado
     * @param nombre
     * @return <b>true</b> si ya hay un usuario con ese nombre
     * <b>false</b> si ningun usuario tiene ese nombre
     */
    public boolean nombreEnUso(String nombre){
        for (Cliente cliente : clientes) {
            if (cliente.getUsuario().getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarEvento(String evento){
        System.out.println(Notificaciones.formatearEvento(evento));
    }
    
    /**
     * Permite ver la cantidad de clientes conectados
     * @return el número de clientes conectados
     */
    public int usuariosConectados(){
        return clientes.size();
    }
    
    /**
     * Permite detener el servidor
     */
    private void detener() {
        enviarMensajeGeneral("El servidor va a cerrarse. Hasta la próxima");
        pozoDeHilos.shutdown();
        try {
            if (!pozoDeHilos.awaitTermination(60, TimeUnit.SECONDS)) {
                pozoDeHilos.shutdownNow();
            }
        } catch (InterruptedException e) {
            pozoDeHilos.shutdownNow();
        }
        System.out.println("Servidor detenido.");
    }
}
