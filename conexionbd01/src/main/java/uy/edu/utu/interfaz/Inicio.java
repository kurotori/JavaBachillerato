package uy.edu.utu.interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Inicio extends JFrame {

    JButton btnProbar;

    public Inicio() {
        configurar();
    }

    private void configurar() {
        setSize(640, 480);
        setPreferredSize(getSize());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnProbar = new JButton("Probar Conexión");
        btnProbar.setBounds(10, 10, 130, 30);
        getContentPane().add(btnProbar);

        btnProbar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnProbar_click(e);
                    }
                });

    }

    public static void main(String[] args) {
        Inicio v1 = new Inicio();
    }

    private void btnProbar_click(ActionEvent e) {
        String consulta = "select version() as 'Servidor'";

        try {
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306",
                    "estudiante",
                    "estudiante");

            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                JOptionPane.showMessageDialog(null, resultado.getString(1));
            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
