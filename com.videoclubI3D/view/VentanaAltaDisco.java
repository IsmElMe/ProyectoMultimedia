package view;

import model.Constantes;

import javax.swing.*;
import java.awt.*;

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
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 235, 500, 470);

        crearLabel();
    }

    public void crearLabel(){
        Rectangle rectangleLabel = new Rectangle(50, 100, 150, 20);

        lblTituloVentana = new JLabel("Alta disco");
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

        lblFormato = new JLabel("Formato:");
        panel.add(lblFormato);
        lblFormato.setFont(Constantes.FUENTE_LABEL);
        lblFormato.setBounds(rectangleLabel);

        lblCanciones = new JLabel("Canciones:");
        panel.add(lblCanciones);
        lblCanciones.setFont(Constantes.FUENTE_LABEL);

    }
}
