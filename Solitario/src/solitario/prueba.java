/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solitario;

import java.util.logging.Level;
import java.util.logging.Logger;
import jexer.TAction;
import jexer.TApplication;
import jexer.TButton;
import jexer.TWindow;

/**
 *
 * @author sebastian
 */
public class prueba extends TApplication {

    public prueba() throws Exception {
        //super(BackendType.ECMA48);
        super(BackendType.ECMA48, 80, 30, 0);
        addToolMenu();
        addFileMenu();

    }

    public static void main(String[] args) {
        try {
            prueba p = new prueba();
            TWindow w = p.addWindow("algo", 80, 25);

            int x = 0;
            int y = 0;

            for (int i = 0; i < 4; i++) {
                x = 10 * i;
                y = 0;
                String texto = x + "\t" + y;
                TButton bt1 = new TButton(w, x+" "+y, x, y, new TAction() {
                    @Override
                    public void DO() {
                        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                });
            }
            
            

            p.run();

        } catch (Exception ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
