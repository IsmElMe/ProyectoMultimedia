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
    private JComboBox<Integer> cbAnyo, cbCanciones;
    private ButtonGroup bgFormato;
    private JRadioButton rbCd, rbDvd, rbBluray, rbArchivo;
    private JTextArea taCancionesDisco;
    private JButton btnGuardar, btnAnyadir, btnEliminar;

    public VentanaAltaDisco(){
        super("BLOCKBUSTER - ALTA DISCO");
        panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 235, (Constantes.ALTO_PANTALLA / 2) - 225, 470, 550);

        crearLabel();
        crearInput();

        btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));
        btnGuardar.setBounds(170, 460, 120, 25);

        btnAnyadir = new JButton("AÑADIR");
        panel.add(btnAnyadir);
        btnAnyadir.setForeground(Color.decode("#1f4489"));
        btnAnyadir.setBackground(Color.decode("#fcc139"));
        btnAnyadir.setBounds(40, 322, 100, 25);

        btnEliminar = new JButton("ELIMINAR");
        panel.add(btnEliminar);
        btnEliminar.setForeground(Color.decode("#1f4489"));
        btnEliminar.setBackground(Color.decode("#fcc139"));
        btnEliminar.setBounds(40, 370, 100, 25);

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);
    }

    public void crearLabel(){

        lblTituloVentana = new JLabel("ALTA DISCO");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(145, 0, 300, 100);
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
        lblAnyo.setBounds(240, 145, 200, 40);
        lblAnyo.setForeground(Color.decode("#fcc139"));

        lblFormato = new JLabel("FORMATO");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setBounds(40, 145, 200, 40);
        lblFormato.setForeground(Color.decode("#fcc139"));

        lblCanciones = new JLabel("CANCIONES");
        panel.add(lblCanciones);
        lblCanciones.setFont(Constantes.FUENTE_LABEL);
        lblCanciones.setBounds(40, 270, 200, 40);
        lblCanciones.setForeground(Color.decode("#fcc139"));

    }

    private void crearInput() {

        txtTitulo = new JTextField();
        panel.add(txtTitulo);
        txtTitulo.setBounds(120, 80, 200, 20);

        txtAutor = new JTextField();
        panel.add(txtAutor);
        txtAutor.setBounds(120, 120, 200, 20);

        cbAnyo = new JComboBox<>();
        panel.add(cbAnyo);
        cbAnyo.setEditable(true);
        cbAnyo.setBounds(290, 155, 70, 20);

        for (int i = 1940; i <= LocalDate.now().getYear(); i++)
            cbAnyo.addItem(i);

        cbAnyo.setSelectedIndex(cbAnyo.getItemCount() - 1);

        Rectangle rectangleRadioButton = new Rectangle(110, 180, 140,20);
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
        cbCanciones.setBounds(150, 280, 150, 20);

        taCancionesDisco = new JTextArea();
        panel.add(taCancionesDisco);
        taCancionesDisco.setEditable(false);
        taCancionesDisco.setBounds(170, 320, 250, 100);
        taCancionesDisco.setBorder(BorderFactory.createLineBorder(Color.decode("#fcc139"), 3));
    }

    /*
    public static void main(String[] args) {
        VentanaAltaDisco gui = new VentanaAltaDisco();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     */
}
