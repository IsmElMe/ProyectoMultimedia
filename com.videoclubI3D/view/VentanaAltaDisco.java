package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class VentanaAltaDisco extends JFrame {

    private JPanel panel;
    private JLabel
            lblTituloVentana, lblTitulo, lblAutor,
            lblDuracion, lblAnyo, lblFormato,
            lblCanciones;
    private JTextField
            txtTitulo, txtAutor;
    private JSpinner spnDuracion;
    private JComboBox<Integer> cbAnyo, cbCanciones;
    private ButtonGroup bgFormato;
    private JRadioButton rbCd, rbDvd, rbBluray, rbArchivo;
    private JTextArea taCancionesDisco;
    private JButton btnGuardar, btnAnyadir, btnEliminar;

    public VentanaAltaDisco(){
        super("Blockbuster - Alta Disco");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 235, 500, 470);

        crearLabel();
        crearInput();

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        btnGuardar.setFont(Constantes.FUENTE_BOTON);
        btnGuardar.setBounds(super.getWidth() - 150, super.getHeight() - 70, 100, 20);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));

        btnAnyadir = new JButton("Añadir");
        panel.add(btnAnyadir);
        btnAnyadir.setFont(Constantes.FUENTE_BOTON);
        btnAnyadir.setBounds(super.getWidth() -140, 220, 100, 20);
        btnAnyadir.setForeground(Color.decode("#1f4489"));
        btnAnyadir.setBackground(Color.decode("#fcc139"));

        btnEliminar = new JButton("Eliminar");
        panel.add(btnEliminar);
        btnEliminar.setFont(Constantes.FUENTE_BOTON);
        btnEliminar.setBounds(super.getWidth() -140, 250, 100, 20);
        btnEliminar.setForeground(Color.decode("#1f4489"));
        btnEliminar.setBackground(Color.decode("#fcc139"));

    }

    public void crearLabel(){
        Rectangle rectangleLabel = new Rectangle(50, 100, 150, 20);

        lblTituloVentana = new JLabel("Alta Disco");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds((super.getWidth() / 2) - 60, 15, 200, 60);
        lblTituloVentana.setForeground(Color.decode("#fcc139"));

        lblTitulo = new JLabel("Título:");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(rectangleLabel);
        lblTitulo.setForeground(Color.decode("#fcc139"));
        rectangleLabel.y += 40;

        lblAutor = new JLabel("Autor:");
        panel.add(lblAutor);
        lblAutor.setFont(Constantes.FUENTE_LABEL);
        lblAutor.setBounds(rectangleLabel);
        lblAutor.setForeground(Color.decode("#fcc139"));
        rectangleLabel.y += 40;

        lblAnyo = new JLabel("Año:");
        panel.add(lblAnyo);
        lblAnyo.setFont(Constantes.FUENTE_LABEL);
        lblAnyo.setBounds(rectangleLabel);
        lblAnyo.setForeground(Color.decode("#fcc139"));
        rectangleLabel.y += 40;

        lblFormato = new JLabel("Formato:");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setBounds(rectangleLabel);
        lblFormato.setForeground(Color.decode("#fcc139"));
        rectangleLabel.x += 201;
        rectangleLabel.y -= 40;

        lblCanciones = new JLabel("Canciones:");
        panel.add(lblCanciones);
        lblCanciones.setFont(Constantes.FUENTE_LABEL);
        lblCanciones.setBounds(rectangleLabel);
        lblCanciones.setForeground(Color.decode("#fcc139"));
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

        cbAnyo = new JComboBox<>();
        panel.add(cbAnyo);
        cbAnyo.setEditable(true);
        cbAnyo.setBounds(100, 180, 100, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cbAnyo.addItem(i);

        cbAnyo.setSelectedIndex(cbAnyo.getItemCount() - 1);

        rectangleTextField.width -= 60;
        rectangleTextField.x += 60;
        rectangleTextField.y += 80;

        Rectangle rectangleRadioButton = new Rectangle(100, 250, 150,20);
        bgFormato = new ButtonGroup();
        rbCd = new JRadioButton("CD");
        rbDvd = new JRadioButton("DVD");
        rbBluray = new JRadioButton("BLUE-RAY");
        rbArchivo = new JRadioButton("ARCHIVO");
        bgFormato.add(rbCd);
        bgFormato.add(rbDvd);
        bgFormato.add(rbBluray);
        bgFormato.add(rbArchivo);
        panel.add(rbCd);
        panel.add(rbDvd);
        panel.add(rbBluray);
        panel.add(rbArchivo);
        rbCd.setSelected(true);

        rbCd.setFont(Constantes.FUENTE_LABEL);
        rbCd.setBackground(Color.decode("#1f4489"));
        rbCd.setForeground(Color.WHITE);
        rbDvd.setFont(Constantes.FUENTE_LABEL);
        rbDvd.setBackground(Color.decode("#1f4489"));
        rbDvd.setForeground(Color.WHITE);
        rbBluray.setFont(Constantes.FUENTE_LABEL);
        rbBluray.setBackground(Color.decode("#1f4489"));
        rbBluray.setForeground(Color.WHITE);
        rbArchivo.setFont(Constantes.FUENTE_LABEL);
        rbArchivo.setBackground(Color.decode("#1f4489"));
        rbArchivo.setForeground(Color.WHITE);

        rbCd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rbDvd.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rbBluray.setBounds(rectangleRadioButton);
        rectangleRadioButton.y += 20;
        rbArchivo.setBounds(rectangleRadioButton);

        cbCanciones = new JComboBox<>();
        panel.add(cbCanciones);
        cbCanciones.setEditable(true);
        cbCanciones.setBounds(super.getWidth() - 150, 180, 100, 20);

        taCancionesDisco = new JTextArea();
        panel.add(taCancionesDisco);
        taCancionesDisco.setEditable(false);
        taCancionesDisco.setBounds(super.getWidth() - 250, 220, 100, 120);
    }
}
