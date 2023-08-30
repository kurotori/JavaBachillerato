/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarray01;

/**
 *
 * @author luiss
 */
public class EjemploArray01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] numerosA = new int[10];
        int[] numerosB = {10,11,12,13,14,15};
                        //0  1  2  3  4  5
        numerosA[5] = 1500;
        int resultado = numerosA[5] + numerosB[2];
        System.out.println( numerosB.length );
        System.out.println("El resultado de sumar" + numerosA[5] + " más " +numerosB[2] + " es: "+resultado);
    }
    
}
