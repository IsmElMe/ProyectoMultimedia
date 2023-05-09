package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaAlquilarMultimedia extends JFrame {
    public VentanaAlquilarMultimedia() {
        super("Blockbuster - Alquilar multimedia a socio");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 300, (Constantes.ALTO_PANTALLA / 2) - 250, 600, 500);

        crearLabel(panel);
        crearRadioButton(panel);

        JButton btnAlquilar = new JButton("Alquilar");
        panel.add(btnAlquilar);
        btnAlquilar.setFont(Constantes.FUENTE_BOTON);
        btnAlquilar.setBounds((super.getHeight() / 2) - 50, super.getHeight() - 120, 200, 40);

        JTextField txtNif = new JTextField();
        panel.add(txtNif);
        txtNif.setBounds(100, 120, super.getWidth() - 150, 20);

        JTextField txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(120, 300, super.getWidth() - 170, 20);
    }

    private void crearLabel(JPanel panel) {
        Rectangle rectangle = new Rectangle(60, 110, 200, 40);
        JLabel lblTituloVentana = new JLabel("Alquilar multimedia");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds((Constantes.ANCHO_PANTALLA / 2) - 550, 30, 400, 60);

        JLabel lblNif = new JLabel("NIF:");
        panel.add(lblNif);
        lblNif.setFont(Constantes.FUENTE_LABEL);
        lblNif.setBounds(rectangle);
        rectangle.y += 50;

        JLabel lblTipoMultimedia = new JLabel("Tipo de multimedia:");
        panel.add(lblTipoMultimedia);
        lblTipoMultimedia.setFont(Constantes.FUENTE_LABEL);
        lblTipoMultimedia.setBounds(rectangle);
        rectangle.y += 130;

        JLabel lblTitulo = new JLabel("Título:");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(rectangle);
    }

    private void crearRadioButton(JPanel panel) {
        Rectangle rectangle = new Rectangle(220, 160, 200, 40);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton rdbPelicula = new JRadioButton("Película");
        rdbPelicula.setFont(Constantes.FUENTE_LABEL);
        rdbPelicula.setBounds(rectangle);
        rectangle.y += 30;

        JRadioButton rdbVideojuego = new JRadioButton("Videojuego");
        rdbVideojuego.setFont(Constantes.FUENTE_LABEL);
        rdbVideojuego.setBounds(rectangle);
        rectangle.y += 30;

        JRadioButton rdbDisco = new JRadioButton("Disco");
        rdbDisco.setFont(Constantes.FUENTE_LABEL);
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
