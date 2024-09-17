/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solitario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author sebastian
 */
public class prueba2 {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Solitario");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        Dimension tamanio = new Dimension(800, 600);
        ventana.setPreferredSize(tamanio);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        panel.setSize(tamanio);
        
        Color colorFondo = new Color(147, 184, 245);
        Color colorCartas = new Color(161, 163, 166);
        Border bordeCartas = BorderFactory.createLineBorder(Color.BLACK);
        
        panel.setBackground(colorFondo);
        
        JPanel carta = new JPanel();
        carta.setLayout(null);
        
        carta.setBounds(5, 5, 70, 100);
        carta.setBackground(colorCartas);
        carta.setBorder(bordeCartas);
        JLabel palo = new JLabel("A");
        JLabel numero = new JLabel("5");
        Font fuente = new Font("Arial",1,20);
        palo.setFont(fuente);
        numero.setFont(fuente);
        palo.setBounds(5, 5, 20, 20);
        numero.setBounds(45,5,20,20);
        carta.add(palo);
        carta.add(numero);
        
        panel.add(carta);
        
        
        ventana.add(panel);
        
        ventana.pack();
        ventana.setVisible(true);
    }

}
