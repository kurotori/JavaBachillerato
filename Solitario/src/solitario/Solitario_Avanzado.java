/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solitario;

/**
 *
 * @author sebastian
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Solitario_Avanzado{

    
    private static final String[] tipos = 
        {"oro","espada","copa", "basto"};
    static int[][] baraja;
    static Dimension tamanioVentana = new Dimension(800, 600);
    static Border bordeCartas = BorderFactory.createLineBorder(Color.BLACK);
    static Color colorFondo = new Color(147, 184, 245);
    static Color colorCartas = new Color(161, 163, 166);
    static Font fuenteCartas = new Font("Arial",1,20);
    
    public Solitario_Avanzado(){
        
        configurarVentana();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random azar = new Random();

        baraja = new int[48][2];
        armarBaraja(baraja);
        barajar(baraja);
        
    }
    
    static void configurarVentana(){
        
        JFrame ventana = new JFrame("Solitario");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        
        ventana.setPreferredSize(tamanioVentana);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.setSize(tamanioVentana);
        panel.setBackground(colorFondo);

        
        for (int i = 0; i < 48; i++) {
            int carta[] = baraja[i];            
            int y=0;
            int x=0;
            
            if (i < 12) {
                y=5;
                x=(i*70)+5;
            }
            if( (i>=12) && (i<24) ){
                y=105;
                x=((i-12)*70)+5;
            }
            if( (i>=24) && (i<36) ){
                y=210;
                x=((i-24)*70)+5;
            }
            if( (i>=36) && (i<48) ){
                y=315;
                x=((i-36)*70)+5;
            }
            
            
                JPanel naipe = crearCarta(
                    tipos[carta[0]], 
                    carta[1],
                    0, 
                    y);
           
            
        }
        
    }
    
    
    
    
    static void armarBaraja(int[][] baraja){
        int numero = 0;
        for (int carta = 0; carta < 48; carta++) {
            int tipo=0;
            
            if (carta < 12) {
                tipo=0; //oro
            }
            if( (carta>=12) && (carta<24) ){
                tipo=1; //espada
            }
            if( (carta>=24) && (carta<36) ){
                tipo=2; //copa
            }
            if( (carta>=36) && (carta<48) ){
                tipo=3; //espada
            }
            
            numero++;
            if(numero>12){
                numero=1;
            }
            baraja[carta][1] = numero;
            baraja[carta][0] = tipo;   
        }
    }
    
    
    
    static void barajar(int[][] baraja){
        Random azar = new Random();
        int[] carta1 = {};
        int[] carta2 = {};
        
        for (int i = 0; i < baraja.length; i++) {
            int posicion = azar.nextInt(baraja.length);
            carta1 = baraja[i];
            baraja[i] = baraja[posicion];
            baraja[posicion] = carta1;
        }
    }

    
    static JPanel crearCarta(String palo, int numero, int posX, int posY){
        
        JPanel carta = new JPanel();
        carta.setLayout(null);
        
        carta.setBounds(5, 5, 70, 100);
        carta.setBackground(colorCartas);
        carta.setBorder(bordeCartas);
        JLabel lblPalo = new JLabel("A");
        JLabel lblNumero = new JLabel("5");
        
        lblPalo.setFont(fuenteCartas);
        lblNumero.setFont(fuenteCartas);
        lblPalo.setBounds(5, 5, 20, 20);
        lblNumero.setBounds(45,5,20,20);
        carta.add(lblPalo);
        carta.add(lblNumero);
        return carta;
    }
  
    
}
