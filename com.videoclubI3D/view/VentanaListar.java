package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaListar extends JFrame {
    public VentanaListar() {
        super("BLOCKBUSTER - ALTAS");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setVisible(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 215, 500, 430);

        JLabel lblTitulo = new JLabel("LISTAR CONTENIDO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(120, 0, 300, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));
    }

    public static void main(String[] args) {
        new VentanaListar();
    }

}

