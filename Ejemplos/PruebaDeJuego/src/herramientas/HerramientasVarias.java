/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

/**
 *
 * @author luiss
 */
public class HerramientasVarias {
    
    public int alAzarEntre(int minimo, int maximo){
        int resultado = (int) Math.floor(Math.random() * (maximo - minimo +1) + minimo );
        return resultado;
    }
    
}
