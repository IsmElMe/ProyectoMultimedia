package view;

import controler.GestionBaseDatos;
import model.Constantes;
import model.Multimedia;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VentanaDevolver extends JFrame {
    private JPanel panel;
    private JLabel lblTituloVentana, lblNIF, lblMultimedia, lblPrecio, lblDiasAlquiler;
    private JTextField txtNIF;
    private JSpinner jsDiasAlquiler;
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
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 245, (Constantes.ALTO_PANTALLA / 2) - 160, 490, 360);

        crearLabel();
        crearInput();

        btnAnalizar = new JButton("ANALIZAR");
        panel.add(btnAnalizar);
        btnAnalizar.setBounds(295, 90, 120, 25);
        btnAnalizar.setForeground(Color.decode("#1f4489"));
        btnAnalizar.setBackground(Color.decode("#fcc139"));

        btnCobrar = new JButton("COBRAR");
        panel.add(btnCobrar);
        btnCobrar.setBounds(295, 260, 120, 25);
        btnCobrar.setForeground(Color.decode("#1f4489"));
        btnCobrar.setBackground(Color.decode("#fcc139"));

        listaMultimediaSocio = new JComboBox<>();
        panel.add(listaMultimediaSocio);
        listaMultimediaSocio.setEditable(true);
        listaMultimediaSocio.setBounds(70, 165, 300, 20);

        jsDiasAlquiler = new JSpinner();
        panel.add(jsDiasAlquiler);
        jsDiasAlquiler.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        jsDiasAlquiler.setBounds(370, 215, 50, 20);

        eventos();
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

        lblDiasAlquiler = new JLabel("CUANTOS DIAS LO HAS ALQUILADO?");
        panel.add(lblDiasAlquiler);
        lblDiasAlquiler.setFont(Constantes.FUENTE_LABEL);
        lblDiasAlquiler.setBounds(70, 210, 300, 25);
        lblDiasAlquiler.setForeground(Color.decode("#fcc139"));

        lblPrecio = new JLabel("PRECIO €");
        panel.add(lblPrecio);
        lblPrecio.setFont(Constantes.FUENTE_LABEL);
        lblPrecio.setBounds(70, 260, 300, 25);
        lblPrecio.setForeground(Color.decode("#fcc139"));
    }

    private void crearInput() {
        txtNIF = new JTextField();
        panel.add(txtNIF);
        txtNIF.setBounds(105, 90, 150, 20);
    }

    private void eventos(){

    }
}
