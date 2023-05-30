package view;

import controler.Videoclub;
import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaAltas extends JFrame{

    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnAltaSocio, btnAltaPelicula,
            btnAltaVideojuego, btnAltaDisco, btnAltaCancion;

    public VentanaAltas() {
        super("BLOCKBUSTER - ALTAS");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 215, 500, 430);

        lblTitulo = new JLabel("ALTAS");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(210, 0, 200, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        btnAltaSocio = new JButton("ALTA SOCIO");
        panel.add(btnAltaSocio);
        btnAltaSocio.setFont(Constantes.FUENTE_BOTON);
        btnAltaSocio.setBounds( 80, 100, 350, 25);
        btnAltaSocio.setForeground(Color.decode("#1f4489"));
        btnAltaSocio.setBackground(Color.decode("#fcc139"));

        btnAltaPelicula = new JButton("ALTA PELÍCULA");
        panel.add(btnAltaPelicula);
        btnAltaPelicula.setFont(Constantes.FUENTE_BOTON);
        btnAltaPelicula.setBounds(80, 150, 350, 25);
        btnAltaPelicula.setForeground(Color.decode("#1f4489"));
        btnAltaPelicula.setBackground(Color.decode("#fcc139"));

        btnAltaVideojuego = new JButton("ALTA VIDEOJUEGO");
        panel.add(btnAltaVideojuego);
        btnAltaVideojuego.setFont(Constantes.FUENTE_BOTON);
        btnAltaVideojuego.setBounds(80, 200, 350, 25);
        btnAltaVideojuego.setForeground(Color.decode("#1f4489"));
        btnAltaVideojuego.setBackground(Color.decode("#fcc139"));

        btnAltaDisco = new JButton("ALTA DISCO");
        panel.add(btnAltaDisco);
        btnAltaDisco.setFont(Constantes.FUENTE_BOTON);
        btnAltaDisco.setBounds(80, 250, 350, 25);
        btnAltaDisco.setForeground(Color.decode("#1f4489"));
        btnAltaDisco.setBackground(Color.decode("#fcc139"));

        btnAltaCancion = new JButton("ALTA CANCIÓN");
        panel.add(btnAltaCancion);
        btnAltaCancion.setFont(Constantes.FUENTE_BOTON);
        btnAltaCancion.setBounds(80, 300, 350, 25);
        btnAltaCancion.setForeground(Color.decode("#1f4489"));
        btnAltaCancion.setBackground(Color.decode("#fcc139"));

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        eventos();
    }

    private void eventos() {
        btnAltaSocio.addActionListener(evento -> {
            if (!Videoclub.ventanaAltaSocio.isVisible())
                Videoclub.ventanaAltaSocio.setVisible(true);
        });

        btnAltaPelicula.addActionListener(evento -> {
            if (!Videoclub.ventanaAltaPelicula.isVisible())
                Videoclub.ventanaAltaPelicula.setVisible(true);
        });

        btnAltaVideojuego.addActionListener(evento -> {
            if (!Videoclub.ventanaAltaVideojuego.isVisible())
                Videoclub.ventanaAltaVideojuego.setVisible(true);
        });

        btnAltaCancion.addActionListener(evento -> {
            if (!Videoclub.ventanaAltaCancion.isVisible())
                Videoclub.ventanaAltaCancion.setVisible(true);
        });

        btnAltaDisco.addActionListener(evento -> {
            if (!Videoclub.ventanaAltaDisco.isVisible())
                Videoclub.ventanaAltaDisco.setVisible(true);
        });
    }
}
