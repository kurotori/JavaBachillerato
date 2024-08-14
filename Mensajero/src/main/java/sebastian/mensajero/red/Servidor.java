/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sebastian.mensajero.red;

/**
 *
 * @author luiss
 */

import java.io.IOException;

import java.net.*;
import java.io.*;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Servidor implements Runnable{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private AtomicBoolean activo = new AtomicBoolean(false);
    private Thread hilo;
    
    
    private int port;
    
    public Servidor(int port){
        this.port = port;
    }
    
    
    public void start() throws IOException{
        hilo = new Thread(this);
        hilo.start();
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Servidor Iniciado. Ingrese 'detener' para cerrarlo");
        while (isActivo()) {            
            String comando = teclado.nextLine();
            if (comando.equals("detener")) {
                hilo.interrupt();
                detener();
            }
            else{
                System.out.println("mal escrito");
            }
        }
    }
    
    @Override
    public void run(){
        activo.set(true);
        try {
            iniciarServidor();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Inicia el servidor en su 
     * @throws IOException 
     */
    public void iniciarServidor() throws IOException {
        System.out.println("Iniciando");
        
        //
        serverSocket = new ServerSocket(port);
        
        while (isActivo()) {
            System.out.println("corriendo");
            clientSocket = serverSocket.accept();
        
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
            String greeting = in.readLine();
            
            if (greeting.length()>0) {
                out.println("hello client");
                System.out.println("Se ha recibido un mensaje de:" + clientSocket.getInetAddress());
                System.out.println(clientSocket.getInetAddress() + ": "+greeting);
            }
            else {
                out.println("unrecognised greeting");
            }
        }
        
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    

    public void detener() throws IOException {
        System.out.println("Deteniendo...");
        activo.set(false);
       
            
    }
   

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo.get();
    }
}
