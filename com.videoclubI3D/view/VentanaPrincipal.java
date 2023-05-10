package view;

import controler.Videoclub;
import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnAltas, btnAlquilarMultimedaSocio,
            btnDevolverMultimedia, btnListar;

    public VentanaPrincipal() {
        super("BLOCKBUSTER - INICIO");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds(300, 200, 500, 370);


        lblTitulo = new JLabel("BLOCKBUSTER");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(150, 0, 200, 100);
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
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
