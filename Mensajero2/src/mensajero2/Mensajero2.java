/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mensajero2;

import red.Servidor;
import red.Cliente;
import herramientas.Mensaje;

/**
 *
 * @author sebastian
 */
public class Mensajero2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("" + (Mensaje.MENSAJE_DE_ESTADO + 10));
        if (args.length>0) {
            switch (args[0]) {
                case "-s":
                    System.out.println("Iniciando en modo servidor");
                    String[] a = {""};
                    Servidor.main(a);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        else{
            System.out.println("Iniciando en modo cliente");
            String[] a = {""};
            Cliente.main(a);
        }
    }
    
}
