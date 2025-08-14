package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Segunda extends JFrame {

    JButton btnRecibir;
    JLabel lblDato;
    String dato = "";
    Inicio anterior;

    public Segunda(Inicio anterior, String dato) {
        this.dato = dato;
        this.anterior = anterior;
        configurar();
    }

    private void configurar() {
        setSize(640, 480);
        setPreferredSize(getSize());
        setLayout(null);
        setVisible(true);

        // Configuración del Label(etiqueta)
        lblDato = new JLabel("...");
        lblDato.setBounds(10, 10, 400, 30);
        getContentPane().add(lblDato);
        lblDato.setText(dato);

        // Configuración del Button(botón)
        btnRecibir = new JButton("Volver");
        btnRecibir.setBounds(10, 50, 120, 30);
        getContentPane().add(btnRecibir);

        btnRecibir.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        anterior.setVisible(true);
                        dispose();
                    }

                });

        // Actualización de los elementos en la ventana
        repaint();
        pack();
    }

}
