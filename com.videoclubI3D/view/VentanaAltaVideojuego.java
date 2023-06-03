package view;

import controler.Videoclub;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public class VentanaAltaVideojuego extends JFrame {
    private JPanel panel;
    private JLabel
            lblTituloVentana, lblTitulo, lblAutor,
            lblAnyo, lblFormato, lblPlataforma;
    private JTextField txtTitulo, txtAutor;
    private JComboBox<Integer> cmbAnyo;
    private ButtonGroup grupoRadioButton;
    private JRadioButton rdbCd, rdbDvd, rdbBluray, rdbArchivo;
    private JCheckBox chkPs5, chkXbox, chkSwitch, chkPc;
    private JButton btnGuardar;

    public VentanaAltaVideojuego() {
        super("BLOCKBUSTER - ALTA VIDEOJUEGO");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 215, (Constantes.ALTO_PANTALLA / 2) - 220, 430, 440);

        crearLabel();
        crearInput();
        crearRadioButton();
        crearCheckBox();

        btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));
        btnGuardar.setBounds(160, 340, 120, 25);

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
            Videoclub.ventanaAltas.setVisible(true);
        });

        crearVideojuego();
    }

    private void crearLabel() {
        lblTituloVentana = new JLabel("ALTA VIDEOJUEGO");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(90, 0, 300, 100);
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
        cmbAnyo.setBounds(100, 160, 100, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cmbAnyo.addItem(i);

        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);
    }

    private void crearRadioButton() {
        Rectangle rectangleRadioButton = new Rectangle(50, 230, 150, 20);
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
        rdbBluray.setBackground(Color.decode("#1f4487"));
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
    }

    private void crearCheckBox() {
        Rectangle rectanglePlataforma = new Rectangle(200, 230, 100, 20);
        chkPc = new JCheckBox("PC");
        chkSwitch = new JCheckBox("SWITCH");
        chkPs5 = new JCheckBox("PS5");
        chkXbox = new JCheckBox("XBOX");
        panel.add(chkPc);
        panel.add(chkSwitch);
        panel.add(chkPs5);
        panel.add(chkXbox);

        chkPc.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        chkSwitch.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        chkPs5.setBounds(rectanglePlataforma);
        rectanglePlataforma.y += 20;
        chkXbox.setBounds(rectanglePlataforma);

        chkPs5.setFont(Constantes.FUENTE_LABEL);
        chkPs5.setBackground(Color.decode("#1f4489"));
        chkPs5.setForeground(Color.WHITE);
        chkXbox.setFont(Constantes.FUENTE_LABEL);
        chkXbox.setBackground(Color.decode("#1f4489"));
        chkXbox.setForeground(Color.WHITE);
        chkSwitch.setFont(Constantes.FUENTE_LABEL);
        chkSwitch.setBackground(Color.decode("#1f4489"));
        chkSwitch.setForeground(Color.WHITE);
        chkPc.setFont(Constantes.FUENTE_LABEL);
        chkPc.setBackground(Color.decode("#1f4489"));
        chkPc.setForeground(Color.WHITE);
    }

    private void crearVideojuego() {
        btnGuardar.addActionListener(evento -> {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int anyo = 0;
            Formato formato;
            Plataforma[] plataformas = new Plataforma[Constantes.MAX_PLATAFORMAS];

            try {
                anyo = Integer.parseInt(Objects.requireNonNull(cmbAnyo.getSelectedItem()).toString());
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "EL AÑO NO ES VÁLIDO");
            }

            titulo = titulo.trim();
            autor = autor.trim();

            if (rdbCd.isSelected())
                formato = Formato.CD;
            else if (rdbDvd.isSelected())
                formato = Formato.DVD;
            else if (rdbBluray.isSelected())
                formato = Formato.BLU_RAY;
            else
                formato = Formato.ARCHIVO;

            if (chkPc.isSelected())
                plataformas[0] = Plataforma.PC;
            if (chkSwitch.isSelected())
                plataformas[1] = Plataforma.NINTEND0_SWITCH;
            if (chkPs5.isSelected())
                plataformas[2] = Plataforma.PS5;
            if (chkXbox.isSelected())
                plataformas[3] = Plataforma.XBOX;

            byte contNull = 0;
            for (Plataforma plataforma : plataformas)
                if (plataforma == null)
                    contNull++;

            if (contNull != Constantes.MAX_PLATAFORMAS) {
                if (titulo.equals(""))
                    JOptionPane.showMessageDialog(null, "EL CAMPO TÍTULO ESTÁ VACÍO");
                else if (autor.equals(""))
                    JOptionPane.showMessageDialog(null, "EL CAMPO AUTOR ESTÁ VACÍO");
                else if (anyo < 1940)
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN INTRODUCIR MULTIMEDIAS ANTERIORES A 1940");
                else if (anyo > LocalDate.now().getYear())
                    JOptionPane.showMessageDialog(null, "EL AÑO DEL MULTIMEDIA ES MAYOR AL AÑO ACTUAL");
                else {
                    Videoclub.guardarMultimedia(new Videojuego(titulo, autor, formato, anyo, plataformas));
                    JOptionPane.showMessageDialog(null, "Se ha guardado el multimedia correctamente");
                    limpiarInput();
                }
            } else
                JOptionPane.showMessageDialog(null, "EL VIDEOJUEGO NO TIENE NINGUNA PLATAFORMA");
        });
    }

    private void limpiarInput() {
        txtTitulo.setText("");
        txtAutor.setText("");
        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);
        rdbCd.setSelected(true);
        chkPc.setSelected(false);
        chkSwitch.setSelected(false);
        chkPs5.setSelected(false);
        chkXbox.setSelected(false);
    }
}
