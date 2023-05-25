package view;

import controler.Videoclub;
import model.Constantes;
import model.Cancion;

import javax.swing.*;
import java.awt.Color;
import java.time.LocalDate;

public class VentanaAltaCancion extends JFrame {
    public VentanaAltaCancion() {
        super("BLOCKBUSTER - ALTA CANCIÓN");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 225, (Constantes.ALTO_PANTALLA / 2) - 200, 450, 400);
        panel.setBackground(Color.decode(Constantes.COLOR_AZUL));

        crearLabel(panel);
        crearInput(panel);

        JButton btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setFont(Constantes.FUENTE_BOTON);
        btnGuardar.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnGuardar.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnGuardar.setBounds((super.getWidth() / 2) - 75, super.getHeight() - 100, 150, 25);
    }

    private void crearLabel(JPanel panel) {
        JLabel lblTituloVentana = new JLabel("ALTA CANCIÓN");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds((super.getWidth() / 2) - 100, 0, 300, 100);
        lblTituloVentana.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblDisco = new JLabel("ID DISCO");
        panel.add(lblDisco);
        lblDisco.setFont(Constantes.FUENTE_LABEL);
        lblDisco.setBounds(50, 85, 100, 50);
        lblDisco.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblTitulo = new JLabel("TITULO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(50, 135, 100, 50);
        lblTitulo.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblAutor = new JLabel("AUTOR");
        panel.add(lblAutor);
        lblAutor.setFont(Constantes.FUENTE_LABEL);
        lblAutor.setBounds(50, 185, 100, 50);
        lblAutor.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblDuracion = new JLabel("DURACIÓN");
        panel.add(lblDuracion);
        lblDuracion.setFont(Constantes.FUENTE_LABEL);
        lblDuracion.setBounds(50, 235, 100, 50);
        lblDuracion.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblAnyo = new JLabel("AÑO");
        panel.add(lblAnyo);
        lblAnyo.setFont(Constantes.FUENTE_LABEL);
        lblAnyo.setBounds(250, 235, 100, 50);
        lblAnyo.setForeground(Color.decode(Constantes.COLOR_AMARILLO));
    }

    private void crearInput(JPanel panel) {

        JTextField txtIdDisco = new JTextField();
        panel.add(txtIdDisco);
        txtIdDisco.setBounds(130, 100, super.getWidth() - 175, 20);

        JTextField txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(130, 150, super.getWidth() - 175, 20);

        JTextField txtAutor = new JTextField();
        panel.add(txtAutor);
        txtAutor.setBounds(130, 200, super.getWidth() - 175, 20);

        JSpinner spnDuracion = new JSpinner();
        panel.add(spnDuracion);
        spnDuracion.setBounds(155, 250, 75, 20);
        spnDuracion.setModel(new SpinnerNumberModel(0.01, 0.01, 60.00, 0.01));

        JComboBox<Integer> cmbAnyo = new JComboBox<>();
        panel.add(cmbAnyo);
        cmbAnyo.setEditable(true);
        cmbAnyo.setBounds(305, 250, 75, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cmbAnyo.addItem(i);

        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);
    }
}