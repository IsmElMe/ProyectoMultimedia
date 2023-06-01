package view;

import controler.GestionBaseDatos;
import controler.Videoclub;
import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnAltas, btnAlquilarMultimedaSocio,
            btnDevolverMultimedia, btnListar, btnGuardarDatos;

    public VentanaPrincipal() {
        super("BLOCKBUSTER - INICIO");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 185, 500, 400);

        lblTitulo = new JLabel("BLOCKBUSTER");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(150, 0, 250, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        btnAltas = new JButton("ALTAS");
        panel.add(btnAltas);
        btnAltas.setFont(Constantes.FUENTE_BOTON);
        btnAltas.setBounds( 80, 100, 350, 25);
        btnAltas.setForeground(Color.decode("#1f4489"));
        btnAltas.setBackground(Color.decode("#fcc139"));

        btnAlquilarMultimedaSocio = new JButton("ALQUILAR MULTIMEDIA A SOCIO");
        panel.add(btnAlquilarMultimedaSocio);
        btnAlquilarMultimedaSocio.setFont(Constantes.FUENTE_BOTON);
        btnAlquilarMultimedaSocio.setBounds(80, 150, 350, 25);
        btnAlquilarMultimedaSocio.setForeground(Color.decode("#1f4489"));
        btnAlquilarMultimedaSocio.setBackground(Color.decode("#fcc139"));

        btnDevolverMultimedia = new JButton("DEVOLVER MULTIMEDIA DE SOCIO");
        panel.add(btnDevolverMultimedia);
        btnDevolverMultimedia.setFont(Constantes.FUENTE_BOTON);
        btnDevolverMultimedia.setBounds(80, 200, 350, 25);
        btnDevolverMultimedia.setForeground(Color.decode("#1f4489"));
        btnDevolverMultimedia.setBackground(Color.decode("#fcc139"));

        btnListar = new JButton("LISTAR");
        panel.add(btnListar);
        btnListar.setFont(Constantes.FUENTE_BOTON);
        btnListar.setBounds(80, 250, 350, 25);
        btnListar.setForeground(Color.decode("#1f4489"));
        btnListar.setBackground(Color.decode("#fcc139"));

        btnGuardarDatos = new JButton("GUARDAR DATOS");
        panel.add(btnGuardarDatos);
        btnGuardarDatos.setFont(Constantes.FUENTE_BOTON);
        btnGuardarDatos.setBounds(80, 300, 350, 25);
        btnGuardarDatos.setForeground(Color.decode("#1f4489"));
        btnGuardarDatos.setBackground(Color.decode("#fcc139"));

        eventos();
        super.setVisible(true);
    }

    private void eventos() {
        btnAltas.addActionListener(evento -> {
            if (!Videoclub.ventanaAltas.isVisible())
                Videoclub.ventanaAltas.setVisible(true);
        });

        btnAlquilarMultimedaSocio.addActionListener(evento -> {
            if (!Videoclub.ventanaAlquilarMultimedia.isVisible())
                Videoclub.ventanaAlquilarMultimedia.setVisible(true);
        });

        btnDevolverMultimedia.addActionListener(evento -> {
            if (!Videoclub.ventanaDevolver.isVisible())
                Videoclub.ventanaDevolver.setVisible(true);
        });

        btnListar.addActionListener(evento -> {
            if (!Videoclub.ventanaListar.isVisible())
                Videoclub.ventanaListar.setVisible(true);
        });
        btnGuardarDatos.addActionListener(evento -> {
            GestionBaseDatos.deleteTablaCancionesDisco();
            GestionBaseDatos.deleteTablaCancion();
            GestionBaseDatos.deleteTablaDisco();
            GestionBaseDatos.deleteTablaMultimediasSocio();
            GestionBaseDatos.deleteTablaSocio();
            GestionBaseDatos.actualizarTablaPelicula();
            GestionBaseDatos.actualizarTablaVideojuego();
            GestionBaseDatos.actualizarTablaDisco();
            GestionBaseDatos.actualizarTablaCancion();
            GestionBaseDatos.actualizarTablaCancionesDisco();
            GestionBaseDatos.actualizarTablaSocio();
            GestionBaseDatos.actualizarTablaMultimediasSocio();
        });
    }
}
