package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bdd.Conexion;

public class Inicio extends JFrame{

    Conexion conexion;
    JLabel lblBase;
    JLabel lblUsuario;
    JLabel lblContrasenia;
    JTextField txtfBase;
    JTextField txtfUsuario;
    JPasswordField txtfContrasenia;

    public Inicio() {
        configurar();
    }

    private void configurar(){
        setSize(640,480);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        lblBase = new JLabel("Base de Datos: ");
        lblUsuario = new JLabel("Usuario: ");
        lblContrasenia = new JLabel("Contraseña: ");
        txtfBase = new JTextField();
        txtfUsuario = new JTextField();
        txtfContrasenia = new JPasswordField();

        lblBase.setBounds(20, 20, 100, 30);
        lblBase.setHorizontalAlignment(SwingConstants.RIGHT);

        txtfBase.setBounds(130, 20, 200, 30);

        lblUsuario.setBounds(20, 49, 100, 30);
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);

        txtfUsuario.setBounds(130, 49, 200, 30);

        lblContrasenia.setBounds(20, 78, 100, 30);
        lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);

        txtfContrasenia.setFont(Font.getFont(Font.MONOSPACED));
        txtfBase.setFont(Font.getFont(Font.MONOSPACED));

        txtfContrasenia.setBounds(130, 78, 200, 30);

        getContentPane().add(lblBase);
        getContentPane().add(lblUsuario);
        getContentPane().add(lblContrasenia);
        getContentPane().add(txtfBase);
        getContentPane().add(txtfUsuario);
        getContentPane().add(txtfContrasenia);

        getContentPane().setBackground(Color.WHITE);
        
    }

}
