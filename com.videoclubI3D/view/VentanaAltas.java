package view;

import controler.Videoclub;
import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaAltas extends JFrame{

    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnAltaSocio, btnAltaPelicula,
            btnAltaVideojuego, btnAltaDisco;

    public VentanaAltas() {
        super("BLOCKBUSTER - ALTAS");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds(300, 200, 500, 370);

        lblTitulo = new JLabel("ALTAS");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(220, 0, 200, 100);
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
    }
}
