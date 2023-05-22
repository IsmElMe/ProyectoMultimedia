package controler;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionBaseDatos {
    public static Connection conectarBaseDatos(){
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String pass = ""; //Cada uno usa su contraseña.
        String bd = "Proyecto_Multimedia_BD";
        String driver = "org.postgresql.Driver";
        String user = "postgres"; //Este es el usuario por defecto.

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user, pass);

            return con;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
