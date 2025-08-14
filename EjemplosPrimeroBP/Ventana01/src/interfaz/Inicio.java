package interfaz;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Inicio extends JFrame{

    Ficha panel;

    public Inicio() {
        configurar();
    }

    private void configurar(){
        int ancho = 600;
        int alto = 500;
        setSize(ancho, alto);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        panel = new Ficha("11");
        //panel.setBounds(295,215,50,50);
        //panel.setBorder( BorderFactory.createLineBorder(Color.BLACK) );
        panel.setLocation(10, 10);
        getContentPane().add(panel);

        JSeparator lh = new JSeparator(SwingConstants.HORIZONTAL);
        lh.setBounds(0,10,ancho,1);
        lh.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 1, 5,5, true));
        getContentPane().add(lh);

        repaint();

        addMouseMotionListener(
            new MouseMotionListener() {

                @Override
                public void mouseDragged(MouseEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    // TODO Auto-generated method stub
                    System.out.println(e.getX() + "," + e.getY());
                }
                   
            }
        );

        addKeyListener(
            new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            moverPanelArriba(e);
                            break;
                        case KeyEvent.VK_DOWN:
                            moverPanelAbajo(e);
                            break;
                        default:
                            break;
                    }
                }   
                @Override
                public void keyReleased(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub
                    
                }
            }
        );

       
    }

    private void moverPanelArriba(KeyEvent evento){
        int pX = (int)panel.getLocation().getX();
        int pY = (int)panel.getLocation().getY() - 25;

        if (pY < 0) {
            pY = 1;
        }
        panel.setLocation(pX, pY);
    }

    private void moverPanelAbajo(KeyEvent evento){
        int pX = (int)panel.getLocation().getX();
        int pY = (int)panel.getLocation().getY() + 25;

        if (pY > this.getContentPane().getHeight() - panel.getHeight()) {
            pY = this.getContentPane().getHeight() - panel.getHeight();
        }
        panel.setLocation(pX, pY);
    }
   

}
