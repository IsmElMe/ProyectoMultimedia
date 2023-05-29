package view;

import controler.Videoclub;
import model.Constantes;
import model.Cancion;
import model.Disco;
import model.Multimedia;

import javax.swing.*;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Objects;

public class VentanaAltaCancion extends JFrame {
    public VentanaAltaCancion() {
        super("BLOCKBUSTER - ALTA CANCIÓN");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 225, (Constantes.ALTO_PANTALLA / 2) - 200, 450, 300);
        panel.setBackground(Color.decode(Constantes.COLOR_AZUL));

        crearLabel(panel);

        JButton btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setFont(Constantes.FUENTE_BOTON);
        btnGuardar.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnGuardar.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnGuardar.setBounds((super.getWidth() / 2) - 75, super.getHeight() - 100, 150, 25);
        crearInput(panel,btnGuardar);
    }

    private void crearLabel(JPanel panel) {
        JLabel lblTituloVentana = new JLabel("ALTA CANCIÓN");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds((super.getWidth() / 2) - 100, 0, 300, 100);
        lblTituloVentana.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblTitulo = new JLabel("TITULO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(50, 85, 100, 50);
        lblTitulo.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

        JLabel lblDuracion = new JLabel("DURACIÓN");
        panel.add(lblDuracion);
        lblDuracion.setFont(Constantes.FUENTE_LABEL);
        lblDuracion.setBounds(50, 135, 100, 50);
        lblDuracion.setForeground(Color.decode(Constantes.COLOR_AMARILLO));

    }

    private void crearInput(JPanel panel, JButton btnGuardar) {

        JTextField txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(130, 100, super.getWidth() - 175, 20);

        JSpinner spnDuracion = new JSpinner();
        panel.add(spnDuracion);
        spnDuracion.setBounds(155, 150, 75, 20);
        spnDuracion.setModel(new SpinnerNumberModel(0.01, 0.01, 60.00, 0.01));

        btnGuardar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            Double duracion = Double.parseDouble(spnDuracion.getValue().toString());

            titulo = titulo.trim();

            if (titulo.equals(""))
                JOptionPane.showMessageDialog(null, "EL CAMPO TÍTULO ESTA VACÍO");
            else {
                Videoclub.getCanciones().add(new Cancion(titulo, duracion));
                JOptionPane.showMessageDialog(null, "CANCION REGISTRADA CORRECTAMENTE");
            }
        });
    }
}