package view;

import controler.GestionBaseDatos;
import controler.Videoclub;
import model.Cancion;
import model.Constantes;
import model.Multimedia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaListar extends JFrame {
    private JButton btnAtras, btnListarMultimedias, btnListarPeliculasPorTitulo,
            btnListarCancionesDiscoPorDuracion, btnListarVideojuegosPorAnyo,
            btnAlquilerActualSocio, btnListarCancionesPorTitulo;
    private JList<String> lista;
    private JScrollPane scrollListado;

    public VentanaListar() {
        super("BLOCKBUSTER - LISTAR");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 400, (Constantes.ALTO_PANTALLA / 2) - 300, 800, 600);

        JLabel lblTitulo = new JLabel("LISTAR CONTENIDO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds((super.getWidth() / 2) - 150, 0, 300, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        lista = new JList<>();
        scrollListado = new JScrollPane(lista);
        panel.add(scrollListado);
        scrollListado.setBounds(25, 250, 725, 300);

        crearBotones(panel);
        eventos();
    }

    private void crearBotones(JPanel panel) {
        btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        btnListarMultimedias = new JButton("TODOS LOS MULTIMEDIAS");
        panel.add(btnListarMultimedias);
        btnListarMultimedias.setFont(Constantes.FUENTE_BOTON);
        btnListarMultimedias.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnListarMultimedias.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnListarMultimedias.setBounds(25, 100, 350, 30);

        btnListarPeliculasPorTitulo = new JButton("PELÍCULAS ORDENADAS POR TÍTULO");
        panel.add(btnListarPeliculasPorTitulo);
        btnListarPeliculasPorTitulo.setFont(Constantes.FUENTE_BOTON);
        btnListarPeliculasPorTitulo.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnListarPeliculasPorTitulo.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnListarPeliculasPorTitulo.setBounds(400, 100, 350, 30);

        btnListarCancionesDiscoPorDuracion = new JButton("CANCIONES DE UN DISCO ORDENADAS POR DURACIÓN");
        panel.add(btnListarCancionesDiscoPorDuracion);
        btnListarCancionesDiscoPorDuracion.setFont(new Font("Boton", Font.BOLD, 12));
        btnListarCancionesDiscoPorDuracion.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnListarCancionesDiscoPorDuracion.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnListarCancionesDiscoPorDuracion.setBounds(25, 150, 350, 30);

        btnListarVideojuegosPorAnyo = new JButton("VIDEOJUEGOS ORDENADOS POR AÑO");
        panel.add(btnListarVideojuegosPorAnyo);
        btnListarVideojuegosPorAnyo.setFont(Constantes.FUENTE_BOTON);
        btnListarVideojuegosPorAnyo.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnListarVideojuegosPorAnyo.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnListarVideojuegosPorAnyo.setBounds(400, 150, 350, 30);

        btnAlquilerActualSocio = new JButton("ALQUILERES ACTUALES DE UN SOCIO");
        panel.add(btnAlquilerActualSocio);
        btnAlquilerActualSocio.setFont(Constantes.FUENTE_BOTON);
        btnAlquilerActualSocio.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnAlquilerActualSocio.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnAlquilerActualSocio.setBounds(25, 200, 350, 30);

        btnListarCancionesPorTitulo = new JButton("CANCIONES ORDENADAS POR TÍTULO");
        panel.add(btnListarCancionesPorTitulo);
        btnListarCancionesPorTitulo.setFont(Constantes.FUENTE_BOTON);
        btnListarCancionesPorTitulo.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnListarCancionesPorTitulo.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnListarCancionesPorTitulo.setBounds(400, 200, 350, 30);
    }

    private void eventos() {
        DefaultListModel<String> modelLista = new DefaultListModel<>();

        btnAtras.addActionListener(evento -> {
            Videoclub.cerrarVentanas();
            Videoclub.ventanaPrincipal.setVisible(true);
        });

        btnListarMultimedias.addActionListener(evento -> {
            ArrayList<Multimedia> multimedias = Videoclub.getMultimedias();
            modelLista.clear();

            for (Multimedia multimedia : multimedias)
                modelLista.addElement(multimedia.toString());

            lista.setModel(modelLista);
        });

        btnListarPeliculasPorTitulo.addActionListener(evento -> {
            ArrayList<Multimedia> peliculasOrdenadas = GestionBaseDatos.peliculasOrdenadasPorTitulo();
            modelLista.clear();

            for (Multimedia multimedia : peliculasOrdenadas)
                modelLista.addElement(multimedia.toString());

            lista.setModel(modelLista);
        });

        btnListarVideojuegosPorAnyo.addActionListener(evento -> {
            ArrayList<Multimedia> videojuegosOrdenados = GestionBaseDatos.videojuegosOrdenadosPorAnyo();
            modelLista.clear();

            for (Multimedia multimedia : videojuegosOrdenados)
                modelLista.addElement(multimedia.toString());

            lista.setModel(modelLista);
        });

        btnListarCancionesDiscoPorDuracion.addActionListener(evento -> {
            VentanaSeleccionarDisco.actualizarLista();
            Videoclub.ventanaSeleccionarDisco.setVisible(true);
            modelLista.clear();

            if (Videoclub.getDiscoSeleccionado() != null) {
                ArrayList<Cancion> canciones = Videoclub.getDiscoSeleccionado().getCanciones();
                canciones.sort((cancion1, cancion2) -> Double.compare(cancion2.getDuracion(), cancion1.getDuracion()));

                for (Cancion cancion : canciones)
                    modelLista.addElement(cancion.toString());

                lista.setModel(modelLista);
            }
        });

        btnAlquilerActualSocio.addActionListener(evento -> {
            VentanaSeleccionarSocio.actualizarLista();
            Videoclub.ventanaSeleccionarSocio.setVisible(true);
            modelLista.clear();

            if (Videoclub.getSocioSeleccionado() != null) {
                ArrayList<Multimedia> multimediasAlquiladas = Videoclub.getSocioSeleccionado().getMultimediasAlquiladas();

                for (Multimedia multimedia : multimediasAlquiladas)
                    modelLista.addElement(multimedia.toString());

                lista.setModel(modelLista);
            }
        });

        btnListarCancionesPorTitulo.addActionListener(evento -> {
            ArrayList<Cancion> cancionesOrdenadas = GestionBaseDatos.cancionesOrdenadasPorTitulo();
            modelLista.clear();

            for (Cancion cancion : cancionesOrdenadas)
                modelLista.addElement(cancion.toString());

            lista.setModel(modelLista);
        });
    }
}
