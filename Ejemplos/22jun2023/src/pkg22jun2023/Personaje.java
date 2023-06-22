/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg22jun2023;

/**
 *
 * @author sebastian
 */
public class Personaje {
    private int pv;
    private int pAtaqueF;
    private int pDefensaF;
    private String nombre;
    
    public Personaje(int pv, 
            int pAtaqueF, 
            int pDefensaF,
            String nombre){
        this.pv = pv;
        this.pAtaqueF = pAtaqueF;
        this.pDefensaF = pDefensaF;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public void Atacar(Personaje otro){
        System.out.println(this.nombre +
                " ataca a " + otro.getNombre());
        System.out.println(otro.getNombre() + 
                ": AY!! Me Dolió");
    }
    
    public void Atacar(Personaje otro, Arma armaEquipada){
        System.out.println(this.nombre +
                " ataca a " + otro.getNombre() +
                " con " + armaEquipada.nombre);
        System.out.println(otro.getNombre() + 
                ": UUUUY!! Me Dolió Mucho");
    }
    
}
