package controler;

import model.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestionBaseDatos {
    public static Connection conectarBaseDatos() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String pass = ""; //Cada uno usa su contraseña.
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

                    PreparedStatement ps = con.prepareStatement("insert into pelicula values (" + id_multimedia + ", '" + titulo + "', '" + autor + "', '" +
                            formato + "', " + anio + ", " + precio + ", " + duracion + ", '" + actorP + "', '" + actrizP + "');");

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
                    for (Plataforma plataforma : ((Videojuego) multimedia).getPlataformas()) {
                        if (plataforma != null) {
                            plataformas += plataforma.toString() + ", ";
                        }
                    }


                    PreparedStatement ps = con.prepareStatement("insert into videojuego values (" + id_multimedia + ", '" + titulo + "', '" + autor + "', '" +
                            formato + "', " + anio + ", " + precio + ", '" + plataformas + "');");

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
            for (Multimedia multimedia : Videoclub.getMultimedias()) {
                if (multimedia instanceof Disco) {
                    int id_multimedia = multimedia.getIdMultimedia();
                    String titulo = multimedia.getTitulo();
                    String autor = multimedia.getAutor();
                    String formato = multimedia.getFormato().toString();
                    int anio = multimedia.getAnio();
                    int precio = multimedia.getPrecio();
                    double duracion = ((Disco) multimedia).getDuracion();


                    PreparedStatement ps = con.prepareStatement("insert into disco values (" + id_multimedia + ", '" + titulo + "', '" + autor + "', '" +
                            formato + "', " + anio + ", " + precio + ", " + duracion + ");");

                    ps.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void actualizarTablaCancion() {
        Connection con = conectarBaseDatos();
        try {
            for (Cancion cancion : Videoclub.getCanciones()) {
                String nombre = cancion.getNombre();
                double duracion = cancion.getDuracion();


                PreparedStatement ps = con.prepareStatement("insert into cancion values ('" +
                        nombre + "', " + duracion + ");");

                ps.executeUpdate();
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void actualizarTablaCancionesDisco() {
        Connection con = conectarBaseDatos();
        try {
            for (Multimedia multimedia : Videoclub.getMultimedias()) {
                if (multimedia instanceof Disco) {
                    int idDisco = multimedia.getIdMultimedia();
                    ArrayList<Cancion> canciones = ((Disco) multimedia).getCanciones();

                    for (Cancion cancion : canciones) {
                        String nombre_cancion = cancion.getNombre();
                        PreparedStatement ps = con.prepareStatement("insert into canciones_disco values (" + idDisco +
                                ", '" + nombre_cancion + "');");
                        ps.executeUpdate();
                    }
                }
            }
            con.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    public static void actualizarTablaSocio() {
        Connection con = conectarBaseDatos();
        try {
            for (Socio socio : Videoclub.getSocios()) {
                String nif = socio.getNIF();
                String nombre = socio.getNombre();
                String poblacion = socio.getPoblacion();
                LocalDate fechaNac = socio.getFechaNacimiento();

                PreparedStatement ps = con.prepareStatement("insert into socio values ('" +
                        nif + "', '" + nombre + "', '" + poblacion + "', '" + fechaNac + "');");

                ps.executeUpdate();
            }
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }

    public static void deleteTablaCancionesDisco() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from canciones_disco");
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void deleteTablaCancion() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from cancion");
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void deleteTablaDisco() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from disco");
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void deleteTablaSocio() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from socio");
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void deleteTablaMultimediasSocio() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from multimedias_socio");
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void actualizarTablaMultimediasSocio() {
        Connection con = conectarBaseDatos();
        try {
            for (Socio socio : Videoclub.getSocios()) {
                String nif = socio.getNIF();
                ArrayList<Multimedia> multimediasAlquiladas = socio.getMultimediasAlquiladas();

                for (Multimedia multimedia : multimediasAlquiladas) {
                    String titulo = multimedia.getTitulo();

                    PreparedStatement ps = con.prepareStatement("insert into multimedias_socio values ('" +
                            nif + "', '" + titulo + "');");
                    ps.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }

    public static void cargarDatos() {
        cargarMultimedias();
    }

    public static void cargarMultimedias() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from pelicula");
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                Formato formato = Formato.valueOf(rs.getString("formato"));
                int anio = rs.getInt("anio");
                int duracion = rs.getInt("duracion");
                String actorP = rs.getString("actor_principal");
                String actrizP = rs.getString("actriz_principal");

                Videoclub.guardarMultimedia(new Pelicula(titulo, autor, formato, anio, duracion, actorP, actrizP));
            }
            rs = st.executeQuery("select * from videojuego");

            while (rs.next()) {
                String tituloV = rs.getString("titulo");
                String autorV = rs.getString("autor");
                Formato formatoV = Formato.valueOf(rs.getString("formato"));
                int anioV = rs.getInt("anio");
                String plataformasV = rs.getString("plataformas");
                plataformasV = plataformasV.trim();
                String[] plataformasV2 = plataformasV.split(",");
                Plataforma[] plataformas = new Plataforma[4];
                for (int i = 0; i < plataformasV2.length; i++) {

                    plataformas[i] = Plataforma.valueOf(plataformasV2[i]);
                }

                Videoclub.guardarMultimedia(new Videojuego(tituloV, autorV, formatoV, anioV, plataformas));
            }

            rs = st.executeQuery("select * from disco");
            while (rs.next()) {
                int idDisco = rs.getInt("id_multimedia");
                String tituloD = rs.getString("titulo");
                String autorD = rs.getString("autor");
                Formato formatoD = Formato.valueOf(rs.getString("formato"));
                int anioD = rs.getInt("anio");
                int precioD = rs.getInt("precio");
                int duracion = rs.getInt("duracion");
                ArrayList<Cancion> canciones = new ArrayList<>();
                ResultSet rs3 = st.executeQuery("select * from canciones where nombre = (select nombre_disco from canciones_disco where id_disco = " + idDisco + ")");
                while (rs3.next()) {
                    String nombre = rs3.getString("nombre");
                    int duracionC = rs3.getInt("duracion");

                    canciones.add(new Cancion(nombre, duracionC));
                }
                Videoclub.getMultimedias().add(new Disco(tituloD, autorD, formatoD, anioD, canciones));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
