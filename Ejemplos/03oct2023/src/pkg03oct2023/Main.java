/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg03oct2023;


import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String dato="perro";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = 
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/pruebas",
                            "estudiante", "estudiante");
            String consulta = 
                    "select * from datos where info=?";
            
            PreparedStatement sentencia = 
                    conexion.prepareStatement(consulta);
            sentencia.setString(1, dato);
                    
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {                
                System.out.println(
                        resultado.getInt(1) + " - " +
                        resultado.getString(2));
            }
            conexion.close();
            
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }
    
}
