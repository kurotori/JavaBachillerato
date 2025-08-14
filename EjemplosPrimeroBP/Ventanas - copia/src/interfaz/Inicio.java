package interfaz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;


public class Inicio extends JFrame{
    public Inicio(){
        configurar();
    }

    private void configurar(){
        setSize(640,480);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        addMouseMotionListener(
            new MouseMotionListener(){

                @Override
                public void mouseDragged(MouseEvent e) {                    
                    
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    System.out.println(
                        "X: " + e.getX() + " Y:" + e.getY()
                    );
                }
                
            } 
        );
    }

    public static void main(String[] args) {
        Inicio v1 = new Inicio();
    }

}
