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
        super("Videoclub I3D - Inicio");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 300, (Constantes.ALTO_PANTALLA / 2) - 250, 600, 500);

        Rectangle rectangle = new Rectangle((super.getWidth() / 2) - 175, 140, 350, 40);
        lblTitulo = new JLabel("Videoclub I3D");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds((super.getWidth() / 2) - 100, 15, 200, 100);

        btnAltas = new JButton("Altas");
        panel.add(btnAltas);
        btnAltas.setFont(Constantes.FUENTE_BOTON);
        btnAltas.setBounds(rectangle);
        rectangle.y += 80;

        btnAlquilarMultimedaSocio = new JButton("Alquilar multimedia a socio");
        panel.add(btnAlquilarMultimedaSocio);
        btnAlquilarMultimedaSocio.setFont(Constantes.FUENTE_BOTON);
        btnAlquilarMultimedaSocio.setBounds(rectangle);
        rectangle.y += 80;

        btnDevolverMultimedia = new JButton("Devolver multimedia de socio");
        panel.add(btnDevolverMultimedia);
        btnDevolverMultimedia.setFont(Constantes.FUENTE_BOTON);
        btnDevolverMultimedia.setBounds(rectangle);
        rectangle.y += 80;

        btnListar = new JButton("Listar");
        panel.add(btnListar);
        btnListar.setFont(Constantes.FUENTE_BOTON);
        btnListar.setBounds(rectangle);

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
    }
}
