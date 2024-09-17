package mensajero2.herramientas;

/**
 *
 * @author sebastian
 */
import java.io.FileInputStream;
import java.util.Properties;

public class Propiedades {

    private String archivo;
    private Properties lectorDePropiedades;
    private FileInputStream lectorDeArchivos;
    
    public Propiedades(String archivo) {
        this.archivo = archivo;
        try {
            lectorDePropiedades = new Properties();
            lectorDeArchivos = new FileInputStream(archivo);
            lectorDePropiedades.load(lectorDeArchivos);
            
        } catch (Exception e) {
        }
        
    }
    
    public String verPropiedad(String propiedad, String valorPorDefecto) {
        String dato = "";
        dato = lectorDePropiedades.getProperty(dato, valorPorDefecto);
        return dato;
    }
}
