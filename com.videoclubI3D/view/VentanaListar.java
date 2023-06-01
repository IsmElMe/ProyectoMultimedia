package view;

import controler.Videoclub;
import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaListar extends JFrame {
    public VentanaListar() {
        super("BLOCKBUSTER - LISTAR");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 215, 500, 430);

        JLabel lblTitulo = new JLabel("LISTAR CONTENIDO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(120, 0, 300, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        btnAtras.addActionListener(evento -> {
            Videoclub.cerrarVentanas();
            Videoclub.ventanaPrincipal.setVisible(true);
        });
    }
}

