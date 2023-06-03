package controler;

import model.*;
import view.*;

import java.time.*;
import java.util.*;
import javax.swing.*;

public class Videoclub {
    private static ArrayList<Socio> socios = new ArrayList<>();
    private static ArrayList<Multimedia> multimedias = new ArrayList<>();
    private static ArrayList<Cancion> canciones = new ArrayList<>();
    private static Disco discoSeleccionado = null;
    private static Socio socioSeleccionado = null;

    public static final VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    public static final VentanaAltas ventanaAltas = new VentanaAltas();
    public static final VentanaAltaSocio ventanaAltaSocio = new VentanaAltaSocio();
    public static final VentanaAltaPelicula ventanaAltaPelicula = new VentanaAltaPelicula();
    public static final VentanaAltaVideojuego ventanaAltaVideojuego = new VentanaAltaVideojuego();
    public static final VentanaAltaCancion ventanaAltaCancion = new VentanaAltaCancion();
    public static final VentanaAltaDisco ventanaAltaDisco = new VentanaAltaDisco();
    public static final VentanaAlquilarMultimedia ventanaAlquilarMultimedia = new VentanaAlquilarMultimedia();
    public static final VentanaDevolver ventanaDevolver = new VentanaDevolver();
    public static final VentanaListar ventanaListar = new VentanaListar();
    public static final VentanaSeleccionarDisco ventanaSeleccionarDisco = new VentanaSeleccionarDisco();
    public static final VentanaSeleccionarSocio ventanaSeleccionarSocio = new VentanaSeleccionarSocio();

    public static ArrayList<Socio> getSocios() {
        return socios;
    }

    public static ArrayList<Multimedia> getMultimedias() {
        return multimedias;
    }

    public static ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public static Disco getDiscoSeleccionado() {
        return discoSeleccionado;
    }

    public static void setDiscoSeleccionado(Disco disco) {
        discoSeleccionado = disco;
    }

    public static Socio getSocioSeleccionado() {
        return socioSeleccionado;
    }

    public static void setSocioSeleccionado(Socio socioSeleccionado) {
        Videoclub.socioSeleccionado = socioSeleccionado;
    }

    public static void main(String[] args) {
        ventanaPrincipal.setVisible(true);
    }

    public static void guardarSocio(Socio socio) {
        socios.add(socio);
    }

    public static void guardarMultimedia(Multimedia multimedia) {
        multimedias.add(multimedia);
    }

    public static void cerrarVentanas() {
        ventanaPrincipal.setVisible(false);
        ventanaAltas.setVisible(false);
        ventanaAltaSocio.setVisible(false);
        ventanaAltaPelicula.setVisible(false);
        ventanaAltaVideojuego.setVisible(false);
        ventanaAltaDisco.setVisible(false);
        ventanaAltaCancion.setVisible(false);
        ventanaAlquilarMultimedia.setVisible(false);
        ventanaDevolver.setVisible(false);
        ventanaListar.setVisible(false);
        ventanaSeleccionarDisco.setVisible(false);
    }

    public static ArrayList<Multimedia> sacarPeliculas() {
        ArrayList<Multimedia> peliculas = new ArrayList<>();

        for (Multimedia multimedia : multimedias)
            if (multimedia instanceof Pelicula)
                peliculas.add(multimedia);

        return peliculas;
    }

    public static ArrayList<Multimedia> sacarVideojuegos() {
        ArrayList<Multimedia> videojuegos = new ArrayList<>();

        for (Multimedia multimedia : multimedias)
            if (multimedia instanceof Videojuego)
                videojuegos.add(multimedia);

        return videojuegos;
    }

    public static ArrayList<Multimedia> sacarDiscos() {
        ArrayList<Multimedia> discos = new ArrayList<>();

        for (Multimedia multimedia : multimedias)
            if (multimedia instanceof Disco)
                discos.add(multimedia);

        return discos;
    }
}
