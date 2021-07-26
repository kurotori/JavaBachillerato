/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sobrecarga;

/**
 * El comando 'import' nos permite añadir librerías con 
 * funcionalidades prediseñadas a nuestra aplicación.
 * 
 * La librería 'java.util.Scanner' permite obtener datos
 * desde diferentes fuentes, como ser el teclado, archivos, etc.
 */
import java.util.Scanner;

/**
 *
 * @author Luis Sebastián de los Ángeles
 */
public class Usuario {
    
    //Declaración de Atributos
    public String nombre = "";
    public String apellido = "";
    public int ci = 0;
    public String direccion = "";
    public int telefono = 0;
    
    /**
     * Declaración del Método Constructor
     * Un Método Constructor es un método que se ejecuta cuando se
     * crea un objeto nuevo de la clase.
     * /
    
    /**
     * Este método constructor requiere todos los datos necesarios
     * para completar los atributos del nuevo objeto.
     * @param nombre
     * @param apellido
     * @param ci
     * @param direccion
     * @param telefono 
     */
    public Usuario(String nombre,String apellido,
            int ci, String direccion, int telefono)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    /**
     * Método constructor 2: Este método esta en sobrecarga con el
     * primero. Este método permite definir los datos de los 
     * atributos del objeto de forma interactiva solicitando
     * los mismos al usuario.
     */
    public Usuario(){
        /**
         * Creamos un objeto de la clase Scanner llamado 'teclado'
         * para obtener los datos que se ingresen en el teclado.
         * 'System.in' representa la entrada de datos estandar para
         * el sistema, o sea el teclado.
         */
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Escriba un nombre:");
        this.nombre = teclado.nextLine();
        /**
         * El método 'nextLine()' del objeto Scanner, obtiene los
         * datos del teclado en forma de String.
         */
        
        System.out.println("Escriba un apellido:");
        this.apellido = teclado.nextLine();
        System.out.println("Escriba una dirección:");
        this.direccion = teclado.nextLine();
        
        System.out.println("Escriba la CI:");
        this.ci = teclado.nextInt();
        /**
         * El método 'NextInt()' del objeto Scanner, obtiene los
         * datos del teclado en forma de int.
         */
        
        
        System.out.println("Escriba el Teléfono:");
        this.telefono = teclado.nextInt();
        
        teclado.close();
        /**
         * El método 'close()' del objeto Scanner permite cerrar la
         * entrada de datos establecida por el mismo.
         */
    }
    
}
