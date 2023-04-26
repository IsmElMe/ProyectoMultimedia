package view;

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
        super.setSize(600, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Width y Font se pondrá en constantes más tarde
        lblTitulo = new JLabel("Videoclub I3D");
        panel.add(lblTitulo);
        lblTitulo.setFont(new Font("Titulo", Font.BOLD, 30));
        lblTitulo.setBounds((super.getWidth() / 2) - 100, 15, 200, 100);

        btnAltas = new JButton("Altas");
        panel.add(btnAltas);
        btnAltas.setFont(new Font("Titulo", Font.BOLD, 25));
        btnAltas.setBounds((super.getWidth() / 2) - 150, 140, 300, 40);

        btnAlquilarMultimedaSocio = new JButton("Alquilar multimedia a socio");
        panel.add(btnAlquilarMultimedaSocio);
        btnAlquilarMultimedaSocio.setFont(new Font("Titulo", Font.BOLD, 20));
        btnAlquilarMultimedaSocio.setBounds((super.getWidth() / 2) - 150, 220, 300, 40);

        btnDevolverMultimedia = new JButton("Devolver multimedia de socio");
        panel.add(btnDevolverMultimedia);
        btnDevolverMultimedia.setFont(new Font("Titulo", Font.BOLD, 15));
        btnDevolverMultimedia.setBounds((super.getWidth() / 2) - 150, 300, 300, 40);

        btnListar = new JButton("Listar");
        panel.add(btnListar);
        btnListar.setFont(new Font("Titulo", Font.BOLD, 30));
        btnListar.setBounds((super.getWidth() / 2) - 150, 380, 300, 40);

        super.setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
