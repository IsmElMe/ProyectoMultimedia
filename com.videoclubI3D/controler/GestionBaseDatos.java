package controler;

import model.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GestionBaseDatos {
    public static Connection conectarBaseDatos() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String pass = "2711ir783"; //Cada uno usa su contraseña.
        String bd = "Proyecto_Multimedia_BD"; //Hay que poner este nombre a la base de datos para que sea igual en todos.
        String driver = "org.postgresql.Driver";
        String user = "postgres"; //Este es el usuario por defecto.

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user, pass);

            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void actualizarTablaPelicula() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from pelicula");
            for (Multimedia multimedia : Videoclub.getMultimedias()) {
                if (multimedia instanceof Pelicula) {
                    int id_multimedia = multimedia.getIdMultimedia();
                    String titulo = multimedia.getTitulo();
                    String autor = multimedia.getAutor();
                    String formato = multimedia.getFormato().toString();
                    int anio = multimedia.getAnio();
                    int precio = multimedia.getPrecio();
                    int duracion = ((Pelicula) multimedia).getDuracion();
                    String actorP = ((Pelicula) multimedia).getActorPrincipal();
                    String actrizP = ((Pelicula) multimedia).getActrizPrincipal();

                    PreparedStatement ps = con.prepareStatement("insert into pelicula values ("+id_multimedia+", '"+titulo+"', '"+autor+"', '"+
                            formato+"', "+anio+", "+precio+", "+duracion+", '"+actorP+"', '"+actrizP+"');");

                    ps.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void actualizarTablaVideojuego() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from videojuego");
            for (Multimedia multimedia : Videoclub.getMultimedias()) {
                if (multimedia instanceof Videojuego) {
                    int id_multimedia = multimedia.getIdMultimedia();
                    String titulo = multimedia.getTitulo();
                    String autor = multimedia.getAutor();
                    String formato = multimedia.getFormato().toString();
                    int anio = multimedia.getAnio();
                    int precio = multimedia.getPrecio();
                    String plataformas = "";
                    for (Plataforma plataforma: ((Videojuego)multimedia).getPlataformas()){
                        plataformas += plataforma.toString()+", ";
                    }


                    PreparedStatement ps = con.prepareStatement("insert into videojuego values ("+id_multimedia+", '"+titulo+"', '"+autor+"', '"+
                            formato+"', "+anio+", "+precio+", '"+plataformas+"');");

                    ps.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void actualizarTablaDisco() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from disco");
            for (Multimedia multimedia : Videoclub.getMultimedias()) {
                if (multimedia instanceof Disco) {
                    int id_multimedia = multimedia.getIdMultimedia();
                    String titulo = multimedia.getTitulo();
                    String autor = multimedia.getAutor();
                    String formato = multimedia.getFormato().toString();
                    int anio = multimedia.getAnio();
                    int precio = multimedia.getPrecio();
                    double duracion = ((Disco) multimedia).getDuracion();


                    PreparedStatement ps = con.prepareStatement("insert into disco values ("+id_multimedia+", '"+titulo+"', '"+autor+"', '"+
                            formato+"', "+anio+", "+precio+", "+duracion+");");

                    ps.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }
}
