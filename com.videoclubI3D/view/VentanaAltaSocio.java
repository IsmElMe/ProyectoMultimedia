package view;

import model.Constantes;

import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.*;

public class VentanaAltaSocio extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel lblTitulo;
    private JLabel lblNumSocio;
    private JLabel lblNombre;
    private JLabel lblFechaNac;
    private JLabel lblPoblacion;
    private JTextField txtNumSocio, txtNombre, txtFechaNac, txtPoblacion;
    private JButton btnGuardar;

    public VentanaAltaSocio() {
        super("Videoclub I3D - Alta Socio");
        super.setContentPane(this.panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 235, 500, 470);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        lblTitulo = new JLabel("Alta Socio");
        panel.add(this.lblTitulo);
        lblTitulo.setFont(new Font("Titulo", 1, 30));
        lblTitulo.setBounds(super.getWidth() / 2 - 74, 15, 148, 60);

        lblNumSocio = new JLabel("Nº Socio: ");
        panel.add(this.lblNumSocio);
        lblNumSocio.setFont(new Font("Titulo", 0, 15));
        lblNumSocio.setBounds(70, 60, 100, 120);
        txtNumSocio = new JTextField();
        panel.add(this.txtNumSocio);
        txtNumSocio.setBounds(160, 110, 250, 20);

        lblNombre = new JLabel("Nombre: ");
        panel.add(this.lblNombre);
        lblNombre.setFont(new Font("Titulo", 0, 15));
        lblNombre.setBounds(70, 120, 100, 120);
        txtNombre = new JTextField();
        panel.add(this.txtNombre);
        txtNombre.setBounds(160, 170, 250, 20);

        lblFechaNac = new JLabel("Fecha Nacimiento: ");
        panel.add(this.lblFechaNac);
        lblFechaNac.setFont(new Font("Titulo", 0, 15));
        lblFechaNac.setBounds(70, 180, 200, 120);
        txtFechaNac = new JTextField();
        panel.add(this.txtFechaNac);
        txtFechaNac.setBounds(240, 230, 100, 20);

        lblPoblacion = new JLabel("Población: ");
        panel.add(this.lblPoblacion);
        lblPoblacion.setFont(new Font("Titulo", 0, 15));
        lblPoblacion.setBounds(70, 240, 100, 120);
        txtPoblacion = new JTextField();
        panel.add(this.txtPoblacion);
        txtPoblacion.setBounds(160, 290, 250, 20);

        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);
        btnGuardar.setBounds(super.getWidth() - 150, super.getHeight() - 70, 100, 20);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaAltaSocio();
    }
}