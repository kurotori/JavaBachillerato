package bdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String servidor;
    private String base;
    private String usuario;
    private String contrasenia;

    private Connection conexion;

    public Conexion( 
            String servidor, 
            String base, 
            String usuario, 
            String contrasenia
            ) {
        this.servidor = servidor;
        this.base = base;
        this.usuario = usuario;
        this.contrasenia = contrasenia;

        try {
            this.conexion = DriverManager.getConnection(servidor, usuario, contrasenia);
        } 
        catch (Exception e) {
           System.out.println("ERROR: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion(){
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
