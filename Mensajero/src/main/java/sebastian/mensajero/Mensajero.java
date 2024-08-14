/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sebastian.mensajero;

import sebastian.mensajero.red.Cliente;
import sebastian.mensajero.red.Servidor;

/**
 *
 * @author luiss
 */
public class Mensajero {

    public static void main(String[] args) {
        
        if (args.length>0) {
            switch (args[0]) {
            case "-c":
                Cliente cliente = new Cliente();
                try {
                    cliente.iniciarConexion("127.0.0.1", 6200);
                } catch (Exception e) {
                    System.out.println("ERROR: "+e.getMessage());
                }
                
                
                break;
            default:
                Servidor servidor = new Servidor(6200);
                try {
                    servidor.start();
                } catch (Exception e) {
                }
        }
        }
        
        
        
        
        
    }
}
