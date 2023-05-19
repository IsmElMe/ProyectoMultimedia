package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;

public class VentanaDevolver extends JFrame {
    private JPanel panel;
    private JLabel lblTituloVentana, lblNIF, lblMultimedia, lblPrecio;
    private JTextField txtNIF;

    private JComboBox<String> listaMultimediaSocio; //Lista de objetos que tiene que devolver el socio
    private JButton btnAnalizar, btnCobrar;

    public VentanaDevolver() {
        super("BLOCKBUSTER - DEVOLUCIONES");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 245, (Constantes.ALTO_PANTALLA / 2) - 160, 490, 320);

        crearLabel();
        crearInput();

        btnAnalizar = new JButton("ANALIZAR");
        panel.add(btnAnalizar);
        btnAnalizar.setBounds(295, 90, 120, 25);
        btnAnalizar.setForeground(Color.decode("#1f4489"));
        btnAnalizar.setBackground(Color.decode("#fcc139"));

        btnCobrar = new JButton("COBRAR");
        panel.add(btnCobrar);
        btnCobrar.setBounds(295, 220, 120, 25);
        btnCobrar.setForeground(Color.decode("#1f4489"));
        btnCobrar.setBackground(Color.decode("#fcc139"));

        listaMultimediaSocio = new JComboBox<>();
        panel.add(listaMultimediaSocio);
        listaMultimediaSocio.setEditable(true);
        listaMultimediaSocio.setBounds(70, 165, 300, 20);
    }

    private void crearLabel() {
        lblTituloVentana = new JLabel("DEVOLUCIONES");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(140, 15, 250, 60);
        lblTituloVentana.setForeground(Color.decode("#fcc139"));

        lblNIF = new JLabel("NIF");
        panel.add(lblNIF);
        lblNIF.setFont(Constantes.FUENTE_LABEL);
        lblNIF.setBounds(70, 86, 35, 25);
        lblNIF.setForeground(Color.decode("#fcc139"));

        lblMultimedia = new JLabel("MULTIMEDIAS A DEVOLVER");
        panel.add(lblMultimedia);
        lblMultimedia.setFont(Constantes.FUENTE_LABEL);
        lblMultimedia.setBounds(70, 135, 300, 25);
        lblMultimedia.setForeground(Color.decode("#fcc139"));

        lblPrecio = new JLabel("PRECIO €");
        panel.add(lblPrecio);
        lblPrecio.setFont(Constantes.FUENTE_LABEL);
        lblPrecio.setBounds(70, 220, 300, 25);
        lblPrecio.setForeground(Color.decode("#fcc139"));
    }

    private void crearInput() {
        txtNIF = new JTextField();
        panel.add(txtNIF);
        txtNIF.setBounds(105, 90, 150, 20);
    }
}
