/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;
import java.sql.*;

/**
 *
 * @author sebastian
 */
public class herramientasBD {
    
    public Connection crearConexion(
            String usuario,
            String contrasenia,
            String servidor,
            String bdd
    ){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql//:"+servidor+"/"+bdd,
                    usuario,
                    contrasenia
            );
        } catch (Exception error) {
            System.err.println("ERROR:" + error.getMessage());
        }
        
        return conexion;
    }
}
