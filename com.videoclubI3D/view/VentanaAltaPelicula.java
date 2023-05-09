package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

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
        super("Blockbuster - Alta película");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 235, 500, 470);

        crearLabel();
        crearInput();

        Rectangle rectangleRadioButton = new Rectangle(120, 300, 100,20);
        grupoRadioButton = new ButtonGroup();
        rdbCd = new JRadioButton("CD");
        rdbDvd = new JRadioButton("DVD");
        rdbBluray = new JRadioButton("BLUE-RAY");
        rdbArchivo = new JRadioButton("Archivo");
        grupoRadioButton.add(rdbCd);
        grupoRadioButton.add(rdbDvd);
        grupoRadioButton.add(rdbBluray);
        grupoRadioButton.add(rdbArchivo);
        panel.add(rdbCd);
        panel.add(rdbDvd);
        panel.add(rdbBluray);
        panel.add(rdbArchivo);
        rdbCd.setSelected(true);

        rdbCd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbDvd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbBluray.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rdbArchivo.setBounds(rectangleRadioButton);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        btnGuardar.setBounds(super.getWidth() - 150, super.getHeight() - 70, 100, 20);
    }

    private void crearLabel() {
        Rectangle rectangleLabel = new Rectangle(50, 100, 150, 20);

        lblTituloVentana = new JLabel("Alta película");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds((super.getWidth() / 2) - 100, 15, 200, 60);

        lblTitulo = new JLabel("Título:");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(rectangleLabel);
        rectangleLabel.y += 40;

        lblAutor = new JLabel("Autor:");
        panel.add(lblAutor);
        lblAutor.setFont(Constantes.FUENTE_LABEL);
        lblAutor.setBounds(rectangleLabel);
        rectangleLabel.y += 40;

        lblDuracion = new JLabel("Duración:");
        panel.add(lblDuracion);
        lblDuracion.setFont(Constantes.FUENTE_LABEL);
        lblDuracion.setBounds(rectangleLabel);

        rectangleLabel.x += 250;
        lblAnyo = new JLabel("Año:");
        panel.add(lblAnyo);
        lblAnyo.setFont(Constantes.FUENTE_LABEL);
        lblAnyo.setBounds(rectangleLabel);
        rectangleLabel.x -= 250;
        rectangleLabel.y += 40;

        lblActorPrincipal = new JLabel("Actor principal:");
        panel.add(lblActorPrincipal);
        lblActorPrincipal.setFont(Constantes.FUENTE_LABEL);
        lblActorPrincipal.setBounds(rectangleLabel);
        rectangleLabel.y += 40;

        lblActrizPrincipal = new JLabel("Actriz principal:");
        panel.add(lblActrizPrincipal);
        lblActrizPrincipal.setFont(Constantes.FUENTE_LABEL);
        lblActrizPrincipal.setBounds(rectangleLabel);
        rectangleLabel.y += 40;

        lblFormato = new JLabel("Formato:");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setBounds(rectangleLabel);
    }

    private void crearInput() {
        Rectangle rectangleTextField = new Rectangle(100, 100, super.getWidth() - 150, 20);

        txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(rectangleTextField);
        rectangleTextField.y += 40;

        txtAutor = new JTextField();
        panel.add(txtAutor);
        txtAutor.setBounds(rectangleTextField);

        spnDuracion = new JSpinner();
        panel.add(spnDuracion);
        spnDuracion.setModel(new SpinnerNumberModel(60, 60, 240, 1));
        spnDuracion.setBounds(130, 180, 50, 20);

        cmbAnyo = new JComboBox<>();
        panel.add(cmbAnyo);
        cmbAnyo.setEditable(true);
        cmbAnyo.setBounds(super.getWidth() - 150, 180, 100, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cmbAnyo.addItem(i);

        cmbAnyo.setSelectedIndex(cmbAnyo.getItemCount() - 1);

        rectangleTextField.width -= 60;
        rectangleTextField.x += 60;
        rectangleTextField.y += 80;
        txtActorPrincipal = new JTextField();
        panel.add(txtActorPrincipal);
        txtActorPrincipal.setBounds(rectangleTextField);
        rectangleTextField.y += 40;

        txtActrizPrincipal = new JTextField();
        panel.add(txtActrizPrincipal);
        txtActrizPrincipal.setBounds(rectangleTextField);
    }
}
