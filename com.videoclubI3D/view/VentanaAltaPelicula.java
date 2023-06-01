package view;

import controler.Videoclub;
import model.Constantes;
import model.Formato;
import model.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public class VentanaAltaPelicula extends JFrame {
    private JPanel panel;
    private JLabel
            lblTituloVentana, lblTitulo, lblAutor,
            lblDuracion, lblAnyo, lblActorPrincipal,
            lblActrizPrincipal, lblFormato;
    private JTextField
            txtTitulo, txtAutor, txtActorPrincipal, txtActrizPrincipal;
    private JSpinner spnDuracion;
    private JComboBox<Integer> cmbAnyo;
    private ButtonGroup grupoRadioButton;
    private JRadioButton rdbCd, rdbDvd, rdbBluray, rdbArchivo;
    private JButton btnGuardar;

    public VentanaAltaPelicula() {
        super("BLOCKBUSTER - ALTA PELICULA");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 215, (Constantes.ALTO_PANTALLA / 2) - 245, 430, 490);

        crearLabel();
        crearInput();

        Rectangle rectangleRadioButton = new Rectangle(100, 290, 140,20);
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

        btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setFont(Constantes.FUENTE_BOTON);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));
        btnGuardar.setBounds(160, 390, 120, 25);

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        crearPelicula();
    }

    private void crearLabel() {

        lblTituloVentana = new JLabel("ALTA PELICULA");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(110, 0, 300, 100);
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

        lblDuracion = new JLabel("DURACIÓN");
        panel.add(lblDuracion);
        lblDuracion.setFont(Constantes.FUENTE_LABEL);
        lblDuracion.setBounds(40, 145, 200, 40);
        lblDuracion.setForeground(Color.decode("#fcc139"));

        lblAnyo = new JLabel("AÑO");
        panel.add(lblAnyo);
        lblAnyo.setFont(Constantes.FUENTE_LABEL);
        lblAnyo.setBounds(340, 145, 200, 40);
        lblAnyo.setBounds(240, 145, 200, 40);
        lblAnyo.setForeground(Color.decode("#fcc139"));

        lblActorPrincipal = new JLabel("ACTOR PRINCIPAL");
        panel.add(lblActorPrincipal);
        lblActorPrincipal.setFont(Constantes.FUENTE_LABEL);
        lblActorPrincipal.setBounds(40, 180, 200, 40);
        lblActorPrincipal.setForeground(Color.decode("#fcc139"));

        lblActrizPrincipal = new JLabel("ACTRIZ PRINCIPAL");
        panel.add(lblActrizPrincipal);
        lblActrizPrincipal.setFont(Constantes.FUENTE_LABEL);
        lblActrizPrincipal.setBounds(40, 215, 200, 40);
        lblActrizPrincipal.setForeground(Color.decode("#fcc139"));

        lblFormato = new JLabel("FORMATO");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setBounds(40, 250, 200, 40);
        lblFormato.setForeground(Color.decode("#fcc139"));
    }

    private void crearInput() {

        txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(120, 80, 200, 20);

        txtAutor = new JTextField();
        panel.add(txtAutor);
        txtAutor.setBounds(120, 120, 200, 20);

        spnDuracion = new JSpinner();
        panel.add(spnDuracion);
        spnDuracion.setModel(new SpinnerNumberModel(60, 60, 240, 1));
        spnDuracion.setBounds(150, 155, 50, 20);

        cmbAnyo = new JComboBox<>();
        panel.add(cmbAnyo);
        cmbAnyo.setEditable(true);
        cmbAnyo.setBounds(290, 155, 70, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cmbAnyo.addItem(i);

        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);

        txtActorPrincipal = new JTextField();
        panel.add(txtActorPrincipal);
        txtActorPrincipal.setBounds(200, 191, 160, 20);

        txtActrizPrincipal = new JTextField();
        panel.add(txtActrizPrincipal);
        txtActrizPrincipal.setBounds(200, 225, 160, 20);

    }

    private void crearPelicula() {
        btnGuardar.addActionListener(evento -> {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int duracion = Integer.parseInt(spnDuracion.getValue().toString());
            int anyo = 0;
            String actorPrincipal = txtActorPrincipal.getText();
            String actrizPrincipal = txtActrizPrincipal.getText();
            Formato formato;

            try {
                anyo = Integer.parseInt(Objects.requireNonNull(cmbAnyo.getSelectedItem()).toString());
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "EL AÑO NO ES VÁLIDO");
            }

            if (rdbCd.isSelected())
                formato = Formato.CD;
            else if (rdbDvd.isSelected())
                formato = Formato.DVD;
            else if (rdbBluray.isSelected())
                formato = Formato.BLU_RAY;
            else
                formato = Formato.ARCHIVO;

            titulo = titulo.trim();
            autor = autor.trim();
            actorPrincipal = actorPrincipal.trim();
            actrizPrincipal = actrizPrincipal.trim();

            if (titulo.equals(""))
                JOptionPane.showMessageDialog(null, "EL CAMPO TÍTULO ESTA VACÍO");
            else if (autor.equals(""))
                JOptionPane.showMessageDialog(null, "EL CAMPO AUTOR ESTA VACÍO");
            else if (anyo < 1940)
                JOptionPane.showMessageDialog(null, "NO SE PUEDEN INTRODUCIR MULTIMEDIAS ANTERIORES A 1940");
            else if (anyo > LocalDate.now().getYear())
                JOptionPane.showMessageDialog(null, "EL AÑO DEL MULTIMEDIA ES MAYOR AL AÑO ACTUAL");
            else if (actorPrincipal.equals(""))
                JOptionPane.showMessageDialog(null, "EL CAMPO ACTOR PRINCIPAL ESTA VACÍ0");
            else if (actrizPrincipal.equals(""))
                JOptionPane.showMessageDialog(null, "EL CAMPO ACTRIZ PRINCIPAL ESTA VACÍ0");
            else
                Videoclub.guardarMultimedia(new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal));
        });
    }
}
