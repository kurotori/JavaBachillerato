package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ficha extends JPanel {
    JLabel imagen;

    public Ficha(String idImagen){
        setSize(50, 50);
        
        setVisible(true);
        imagen = new JLabel();

        try {
            Image img = ImageIO.read( getClass().getResource("/imagen/11.png") );
            Image imgR = img.getScaledInstance(49, 49, Image.SCALE_SMOOTH);
            imagen.setIcon( new ImageIcon(imgR));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            imagen.setText("Error al cargar la imagen");
        }


        imagen.setBounds(0, 0, 49, 49);
        add(imagen);
        
        

       
        
        
        
    }
}
