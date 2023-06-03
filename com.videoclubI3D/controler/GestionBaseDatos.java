package controler;

import model.*;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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

    public static ArrayList<Multimedia> peliculasOrdenadasPorTitulo() {
        ArrayList<Multimedia> peliculasOrdenadas = new ArrayList<>();
        Connection con = conectarBaseDatos();

        try {
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM pelicula ORDER BY titulo");

            while (resultSet.next()) {
                int id_pelicula = resultSet.getInt("id_multimedia");

                for (Multimedia multimedia : Videoclub.sacarPeliculas())
                    if (id_pelicula == multimedia.getIdMultimedia())
                        peliculasOrdenadas.add(multimedia);
            }

            con.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }

        return peliculasOrdenadas;
    }

    public static ArrayList<Multimedia> videojuegosOrdenadosPorAnyo() {
        ArrayList<Multimedia> videojuegosOrdenados = new ArrayList<>();
        Connection con = conectarBaseDatos();

        try {
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM videojuego ORDER BY anio DESC");

            while (resultSet.next()) {
                int id_videojuego = resultSet.getInt("id_multimedia");

                for (Multimedia multimedia : Videoclub.sacarVideojuegos())
                    if (id_videojuego == multimedia.getIdMultimedia())
                        videojuegosOrdenados.add(multimedia);
            }

            con.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }

        return videojuegosOrdenados;
    }

    public static ArrayList<Cancion> cancionesOrdenadasPorTitulo() {
        ArrayList<Cancion> cancionesOrdenadas = new ArrayList<>();
        Connection con = conectarBaseDatos();

        try {
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM cancion ORDER BY nombre");

            while (resultSet.next()) {
                String titulo = resultSet.getString("nombre");

                for (Cancion cancion : Videoclub.getCanciones())
                    if (titulo.equals(cancion.getNombre()))
                        cancionesOrdenadas.add(cancion);
            }

            con.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }

        return cancionesOrdenadas;
    }

    public static void cargarDatos() {
        cargarMultimedias();
        cargarCanciones();
        cargarSocioConMultimediasAlquiladas();
        JOptionPane.showMessageDialog(null, "Los datos han sido cargados de forma correcta");
        JOptionPane.showMessageDialog(null, "Recuerda guardar los datos cada vez que " +
                "realices un insert.");
    }

    public static void cargarMultimedias() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
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
            rs.close();
            rs = st.executeQuery("select * from videojuego");
            while (rs.next()) {
                String tituloV = rs.getString("titulo");
                String autorV = rs.getString("autor");
                Formato formatoV = Formato.valueOf(rs.getString("formato"));
                int anioV = rs.getInt("anio");
                String plataformasV = rs.getString("plataformas");

                String[] plataformasV2 = plataformasV.split(",");
                Plataforma[] plataformas = new Plataforma[4];
                for (int i = 0; i < plataformasV2.length; i++) {
                    plataformasV2[i] = plataformasV2[i].trim();
                    if (!plataformasV2[i].equals("")) {
                        plataformas[i] = Plataforma.valueOf(plataformasV2[i]);
                    }
                }

                Videoclub.guardarMultimedia(new Videojuego(tituloV, autorV, formatoV, anioV, plataformas));
            }
            rs.close();

            rs = st.executeQuery("select * from disco");
            while (rs.next()) {
                int idDisco = rs.getInt("id_multimedia");
                String tituloD = rs.getString("titulo");
                String autorD = rs.getString("autor");
                Formato formatoD = Formato.valueOf(rs.getString("formato"));
                int anioD = rs.getInt("anio");
                ArrayList<Cancion> canciones = new ArrayList<>();
                ResultSet rs3 = st2.executeQuery("select * from cancion where nombre in (select nombre_cancion from canciones_disco where id_disco = " + idDisco + ")");
                while (rs3.next()) {
                    String nombre = rs3.getString("nombre");
                    int duracionC = rs3.getInt("duracion");

                    canciones.add(new Cancion(nombre, duracionC));
                }
                Videoclub.guardarMultimedia(new Disco(tituloD, autorD, formatoD, anioD, canciones));
                rs3.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void cargarCanciones() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from cancion");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int duracion = rs.getInt("duracion");

                Videoclub.getCanciones().add(new Cancion(nombre, duracion));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargarSocioConMultimediasAlquiladas() {
        Connection con = conectarBaseDatos();
        try {
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet rs = st.executeQuery("select * from socio");
            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String poblacion = rs.getString("poblacion");
                Date fecha = rs.getDate("fecha_nacimiento");
                LocalDate fecha2 = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDay());

                ResultSet rs2 = st2.executeQuery("select * from multimedias_socio where nif_socio = '" + nif + "'");
                ArrayList<Multimedia> multimediaAlquilada = new ArrayList<>();
                while (rs2.next()) {
                    String titulo_multimedia = rs2.getString("titulo_multimedia");

                    for (Multimedia multimedia : Videoclub.getMultimedias()) {
                        if (multimedia.getTitulo().equals(titulo_multimedia))
                            multimediaAlquilada.add(multimedia);
                    }
                }
                Videoclub.guardarSocio(new Socio(fecha2, nombre, poblacion, nif));
                for (Socio socio : Videoclub.getSocios()) {
                    if (socio.getNIF().equals(nif)) {
                        for (Multimedia multimedia : multimediaAlquilada) {
                            socio.alquilarMultimedia(multimedia);
                        }
                    }
                }
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
