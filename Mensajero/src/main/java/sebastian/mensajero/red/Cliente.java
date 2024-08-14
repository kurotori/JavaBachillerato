/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sebastian.mensajero.red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author luiss
 */
public class Cliente {
    private Socket socketCliente;
    private PrintWriter salida;
    private BufferedReader entrada;
    
    public void iniciarConexion(String ip, int port) throws IOException {
        try {
            socketCliente = new Socket(ip, port);
            salida = new PrintWriter(socketCliente.getOutputStream(), true);
            InputStreamReader lectorDeStream = new InputStreamReader(socketCliente.getInputStream());               
            entrada = new BufferedReader(lectorDeStream);
            
        } 
        catch (IOException e) {
            System.out.println("ERROR: Sin Conexión en "+ip+" - "+e.toString());
        }
    }
    
    public String sendMessage(String msg) throws IOException {
        salida.println(msg);
        String resp = entrada.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        entrada.close();
        salida.close();
        socketCliente.close();
    }
}
