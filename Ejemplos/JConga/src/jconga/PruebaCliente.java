/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jconga;

import java.io.IOException;
import jconga.red.Cliente;
import jconga.red.Herramientas;

/**
 *
 * @author luiss
 */
public class PruebaCliente {
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando cliente");
                //jconga.red.Herramientas h = new Herramientas();
                
                Cliente client = new Cliente();
                //client.DatosRed();
                //client.ListarInterfacesDeRed();
                //client.escanearRed();
                client.iniciarConexion("localhost", 6666);
                String response = client.sendMessage("hello server");
                System.out.println("Respuesta recibida:" + response);
    }
}
