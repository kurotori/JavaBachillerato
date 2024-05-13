/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionabdd;

import java.sql.*;

/**
 *
 * @author sebastian
 */
public class ConexionABdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = 
                    DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mysql", 
                            "estudiante", "estudiante");
            
            String consulta = "show tables";
            
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while ( resultado.next() ) {                
                System.out.println(resultado.getString(1));
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
            
        } catch (Exception error) {
            System.out.println("ERROR:" + error.getMessage());
        }
    }
    
}
