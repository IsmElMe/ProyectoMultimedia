package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaAlquilarMultimedia extends JFrame {
    public VentanaAlquilarMultimedia() {
        super("BLOCKBUSTER - ALQUILAR MULTIMEDIA");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 215, (Constantes.ALTO_PANTALLA / 2) - 200, 430, 400);

        crearLabel(panel);
        crearRadioButton(panel);

        JButton btnAlquilar = new JButton("ALQUILAR");
        panel.add(btnAlquilar);
        btnAlquilar.setFont(Constantes.FUENTE_BOTON);
        btnAlquilar.setForeground(Color.decode("#1f4489"));
        btnAlquilar.setBackground(Color.decode("#fcc139"));
        btnAlquilar.setBounds(160, 300, 120, 25);

        JTextField txtNif = new JTextField();
        panel.add(txtNif);
        txtNif.setBounds(80, 86, 150, 20);

        JTextField txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(120, 250, 200, 20);
    }

    private void crearLabel(JPanel panel) {
        JLabel lblTituloVentana = new JLabel("ALQUILAR MULTIMEDIA");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(60, 0, 300, 100);
        lblTituloVentana.setForeground(Color.decode("#fcc139"));

        JLabel lblNif = new JLabel("NIF");
        panel.add(lblNif);
        lblNif.setFont(Constantes.FUENTE_LABEL);
        lblNif.setBounds(40, 75, 200, 40);
        lblNif.setForeground(Color.decode("#fcc139"));

        JLabel lblTipoMultimedia = new JLabel("TIPO DE MULTIMEDIA");
        panel.add(lblTipoMultimedia);
        lblTipoMultimedia.setFont(Constantes.FUENTE_LABEL);
        lblTipoMultimedia.setBounds(40, 120, 200, 40);
        lblTipoMultimedia.setForeground(Color.decode("#fcc139"));

        JLabel lblTitulo = new JLabel("TÍTULO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(40, 240, 100, 40);
        lblTitulo.setForeground(Color.decode("#fcc139"));
    }

    private void crearRadioButton(JPanel panel) {
        Rectangle rectangle = new Rectangle(150, 160, 150, 20);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton rdbPelicula = new JRadioButton("PELÍCULA");
        rdbPelicula.setFont(Constantes.FUENTE_LABEL);
        rdbPelicula.setBackground(Color.decode("#1f4489"));
        rdbPelicula.setForeground(Color.WHITE);
        rdbPelicula.setBounds(rectangle);
        rectangle.y += 25;

        JRadioButton rdbVideojuego = new JRadioButton("VIDEOJUEGO");
        rdbVideojuego.setFont(Constantes.FUENTE_LABEL);
        rdbVideojuego.setBackground(Color.decode("#1f4489"));
        rdbVideojuego.setForeground(Color.WHITE);
        rdbVideojuego.setBounds(rectangle);
        rectangle.y += 25;

        JRadioButton rdbDisco = new JRadioButton("DISCO");
        rdbDisco.setFont(Constantes.FUENTE_LABEL);
        rdbDisco.setBackground(Color.decode("#1f4489"));
        rdbDisco.setForeground(Color.WHITE);
        rdbDisco.setBounds(rectangle);

        buttonGroup.add(rdbPelicula);
        buttonGroup.add(rdbVideojuego);
        buttonGroup.add(rdbDisco);
        panel.add(rdbPelicula);
        panel.add(rdbVideojuego);
        panel.add(rdbDisco);

        rdbPelicula.setSelected(true);
    }
}
