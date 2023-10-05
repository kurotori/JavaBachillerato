/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg03oct2023;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, user, password)
        } catch (Exception e) {
        }
    }
    
}
