/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author sebastian
 */
public class GestorDeMensajesDelCliente implements Runnable {
    private PrintWriter salida;
    
    public GestorDeMensajesDelCliente(PrintWriter salida){
        this.salida = salida;
    }
    
    @Override
    public void run(){
        InputStreamReader lectorDeEntrada = new InputStreamReader(System.in);
        BufferedReader lectorDeConsola = new BufferedReader(lectorDeEntrada);
        
        try {
            String entradaUsuario;
            while (
                (entradaUsuario = lectorDeConsola.readLine())!=null  
                  ) {                
                salida.println(entradaUsuario); //El dato se envía al servidor
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    
    
    private void interpretarMensajeAEnviar(String mensaje){
        
    }
}
