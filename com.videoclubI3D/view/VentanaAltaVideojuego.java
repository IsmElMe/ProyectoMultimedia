package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class VentanaAltaVideojuego extends JFrame {
    private JPanel panel;
    private JLabel
            lblTituloVentana, lblTitulo, lblAutor,
            lblAnyo, lblFormato, lblPlataforma;
    private JTextField
            txtTitulo, txtAutor;
    private JComboBox<Integer> cmbAnyo;
    private ButtonGroup grupoRadioButton;
    private JRadioButton rdbCd, rdbDvd, rdbBluray, rdbArchivo, rdbPs5, rdbXbox, rdbSwitch, rdbPc;
    private JButton btnGuardar;

    public VentanaAltaVideojuego() {
        super("BLOCKBUSTER - ALTA VIDEOJUEGO");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds(300, 250, 430, 440);

        crearLabel();
        crearInput();

        Rectangle rectangleRadioButton = new Rectangle(50, 230, 150,20);
        grupoRadioButton = new ButtonGroup();
        rdbCd = new JRadioButton("CD");
        rdbDvd = new JRadioButton("DVD");
        rdbBluray = new JRadioButton("BLUE-RAY");
        rdbArchivo = new JRadioButton("ARCHIVO");
        grupoRadioButton.add(rdbCd);
        grupoRadioButton.add(rdbDvd);
        grupoRadioButton.add(rdbBluray);
        grupoRadioButton.add(rdbArchivo);
        panel.add(rdbCd);
        panel.add(rdbDvd);
        panel.add(rdbBluray);
        panel.add(rdbArchivo);
        rdbCd.setSelected(true);

        rdbCd.setFont(Constantes.FUENTE_LABEL);
        rdbCd.setBackground(Color.decode("#1f4489"));
        rdbCd.setForeground(Color.WHITE);
        rdbDvd.setFont(Constantes.FUENTE_LABEL);
        rdbDvd.setBackground(Color.decode("#1f4489"));
        rdbDvd.setForeground(Color.WHITE);
        rdbBluray.setFont(Constantes.FUENTE_LABEL);
        rdbBluray.setBackground(Color.decode("#1f4489"));
        rdbBluray.setForeground(Color.WHITE);
        rdbArchivo.setFont(Constantes.FUENTE_LABEL);
        rdbArchivo.setBackground(Color.decode("#1f4489"));
        rdbArchivo.setForeground(Color.WHITE);

        rdbCd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbDvd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbBluray.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbArchivo.setBounds(rectangleRadioButton);

        Rectangle rectanglePlataforma = new Rectangle(200, 230, 100,20);
        grupoRadioButton = new ButtonGroup();
        rdbPs5 = new JRadioButton("PS5");
        rdbXbox = new JRadioButton("XBOX");
        rdbSwitch = new JRadioButton("SWITCH");
        rdbPc = new JRadioButton("PC");
        grupoRadioButton.add(rdbPs5);
        grupoRadioButton.add(rdbXbox);
        grupoRadioButton.add(rdbSwitch);
        grupoRadioButton.add(rdbPc);
        panel.add(rdbPs5);
        panel.add(rdbXbox);
        panel.add(rdbSwitch);
        panel.add(rdbPc);
        rdbPs5.setSelected(true);

        rdbPs5.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        rdbXbox.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        rdbSwitch.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        rdbPc.setBounds(rectanglePlataforma);

        rdbPs5.setFont(Constantes.FUENTE_LABEL);
        rdbPs5.setBackground(Color.decode("#1f4489"));
        rdbPs5.setForeground(Color.WHITE);
        rdbXbox.setFont(Constantes.FUENTE_LABEL);
        rdbXbox.setBackground(Color.decode("#1f4489"));
        rdbXbox.setForeground(Color.WHITE);
        rdbSwitch.setFont(Constantes.FUENTE_LABEL);
        rdbSwitch.setBackground(Color.decode("#1f4489"));
        rdbSwitch.setForeground(Color.WHITE);
        rdbPc.setFont(Constantes.FUENTE_LABEL);
        rdbPc.setBackground(Color.decode("#1f4489"));
        rdbPc.setForeground(Color.WHITE);

        btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));
        btnGuardar.setBounds(160, 340, 120, 25);
    }

    private void crearLabel() {
        lblTituloVentana = new JLabel("ALTA PELÍCULA");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(120, 0, 300, 100);
        lblTituloVentana.setForeground(Color.decode("#fcc139"));

        lblTitulo = new JLabel("TÍTULO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(40, 70, 200, 40);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        lblAutor = new JLabel("AUTOR");
        panel.add(lblAutor);
        lblAutor.setFont(Constantes.FUENTE_LABEL);
        lblAutor.setBounds(40, 110, 200, 40);
        lblAutor.setForeground(Color.decode("#fcc139"));

        lblAnyo = new JLabel("AÑO");
        panel.add(lblAnyo);
        lblAnyo.setFont(Constantes.FUENTE_LABEL);
        lblAnyo.setBounds(40, 150, 200, 40);
        lblAnyo.setForeground(Color.decode("#fcc139"));

        lblFormato = new JLabel("FORMATO");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setForeground(Color.decode("#fcc139"));
        lblFormato.setBounds(40, 200, 150, 20);

        lblPlataforma = new JLabel("PLATAFORMA");
        panel.add(lblPlataforma);
        lblPlataforma.setFont(Constantes.FUENTE_LABEL);
        lblPlataforma.setForeground(Color.decode("#fcc139"));
        lblPlataforma.setBounds(200, 200, 150, 20);
    }

    private void crearInput() {

        txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(120, 80, 200, 20);

        txtAutor = new JTextField();
        panel.add(txtAutor);
        txtAutor.setBounds(120, 120, 200, 20);

        cmbAnyo = new JComboBox<>();
        panel.add(cmbAnyo);
        cmbAnyo.setEditable(true);
        cmbAnyo.setBounds(100, 160, 50, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cmbAnyo.addItem(i);

        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);
    }

    public static void main(String[] args) {
        VentanaAltaVideojuego gui = new VentanaAltaVideojuego();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
