/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solitario;

import javax.swing.JFrame;
import java.awt.Dimension;
/**
 *
 * @author sebastian
 */
public class Ventanas {
    
    static public JFrame crearVentana
        (int ancho, int alto){
        JFrame ventana = new JFrame();
        Dimension tamanio = new Dimension(ancho,alto);
        ventana.setSize(tamanio);
        ventana.setVisible(true);
        return ventana;
    }
}
