
package ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;

/**
 *
 * @author Luis Sebastián de los Ángeles
 */
public class Ventana extends javax.swing.JFrame{
    
    //Declaración de elementos
    private JButton boton1;
    
    private String algo;
    
    /**
     * Método Constructor de la clase.
     */
    public Ventana(){
        //Se debe ejecutar la inicialización de los componentes
        // de lo contrario nuestra ventana no será utilizable.
        iniciarComponentes();
    }
    
    
    /**
     * Método para inicializar los componentes de la ventana
     */
    private void iniciarComponentes(){
        
        //Acción al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Establecer el layout de la ventana
        setLayout(null);
        
        //Determinación del tamaño inicial de la ventana:
            //1 - Dimensiones establecidas
        Dimension tamVentana = new Dimension(640, 480);
        setPreferredSize(tamVentana);
        
            //2 - Ventana Maximizada
        //setExtendedState(MAXIMIZED_BOTH);
        
        //Inicializar elementos...
        boton1 = new JButton();
        boton1.setText("Botón 1");
        boton1.setBounds(50, 50, 100, 100);
        
        //... y agregarlos al panel de contenidos
        getContentPane().add(boton1);
        
        
        //Aplicar las características a la ventana
        pack();
    }
    
    
    
    
    /**
     * Método principal para ejecutar la ventana
     * @param args 
     */
    public static void main(String[] args) {
        
        //Creamos un objeto ejecutor para la ventana, ya que debe
        // insertarse en una fila de ejecuciones para funcionar.
        Runnable ejecutor = 
            new Runnable() {
                @Override
                public void run() {
                    //Declaramos un 'objeto anónimo' para la ventana
                    // para permitir su ejecución individual, y la hacemos visible
                    new Ventana().setVisible(true);
                }
            };
        
        //Declaramos una ejecución tardía mediante el método invokeLater
        // que coloca la ejecución de la ventana en la cola de ejecución
        // de Java
        EventQueue.invokeLater(ejecutor);
    }
}
