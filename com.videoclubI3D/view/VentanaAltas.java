package view;

import javax.swing.*;
import java.awt.*;

public class VentanaAltas extends JFrame{

    private JPanel panel;
    private JLabel lblTitulo;
    private JButton btnAltaSocio, btnAltaPelicula,
            btnAltaVideojuego, btnAltaDisco;

    public VentanaAltas() {
        super("Videoclub I3D - Altas");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setSize(600, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblTitulo = new JLabel("Altas");
        panel.add(lblTitulo);
        lblTitulo.setFont(new Font("Titulo", Font.BOLD, 30));
        lblTitulo.setBounds((super.getWidth() / 2) - 37, 15, 74, 100);

        btnAltaSocio = new JButton("Altas");
        panel.add(btnAltaSocio);
        btnAltaSocio.setFont(new Font("Titulo", Font.BOLD, 25));
        btnAltaSocio.setBounds((super.getWidth() / 2) - 150, 140, 300, 40);

        btnAltaPelicula = new JButton("Alquilar multimedia a socio");
        panel.add(btnAltaPelicula);
        btnAltaPelicula.setFont(new Font("Titulo", Font.BOLD, 20));
        btnAltaPelicula.setBounds((super.getWidth() / 2) - 150, 220, 300, 40);

        btnAltaVideojuego = new JButton("Devolver multimedia de socio");
        panel.add(btnAltaVideojuego);
        btnAltaVideojuego.setFont(new Font("Titulo", Font.BOLD, 15));
        btnAltaVideojuego.setBounds((super.getWidth() / 2) - 150, 300, 300, 40);

        btnAltaDisco = new JButton("Listar");
        panel.add(btnAltaDisco);
        btnAltaDisco.setFont(new Font("Titulo", Font.BOLD, 30));
        btnAltaDisco.setBounds((super.getWidth() / 2) - 150, 380, 300, 40);

        super.setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaAltas();
    }
}

