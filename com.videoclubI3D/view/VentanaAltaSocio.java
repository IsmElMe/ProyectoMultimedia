package view;

import com.toedter.calendar.JDateChooser;
import controler.Videoclub;
import model.Constantes;
import model.Socio;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.time.*;

public class VentanaAltaSocio extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel lblTitulo;
    private JLabel lblNif;
    private JLabel lblNombre;
    private JLabel lblFechaNac;
    private JLabel lblPoblacion;
    private JTextField txtNif, txtNombre, txtPoblacion;
    private JButton btnGuardar;
    private JDateChooser calendario;

    public VentanaAltaSocio() {
        super("BLOCKBUSTER - ALTA SOCIO");
        super.setContentPane(this.panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 215, (Constantes.ALTO_PANTALLA / 2) - 165, 430, 330);

        lblTitulo = new JLabel("ALTA SOCIO");
        panel.add(this.lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_TITULO);
        lblTitulo.setBounds(125, 0, 300, 100);
        lblTitulo.setForeground(Color.decode("#fcc139"));

        lblNif = new JLabel("NIF");
        panel.add(lblNif);
        lblNif.setFont(Constantes.FUENTE_LABEL);
        lblNif.setBounds(40, 75, 200, 40);
        lblNif.setForeground(Color.decode("#fcc139"));
        txtNif = new JTextField();
        panel.add(txtNif);
        txtNif.setBounds(85, 86, 150, 20);

        lblNombre = new JLabel("NOMBRE");
        panel.add(lblNombre);
        lblNombre.setFont(Constantes.FUENTE_LABEL);
        lblNombre.setBounds(40, 110, 200, 40);
        lblNombre.setForeground(Color.decode("#fcc139"));
        txtNombre = new JTextField();
        panel.add(txtNombre);
        txtNombre.setBounds(130, 121, 150, 20);

        lblFechaNac = new JLabel("FECHA NACIMIENTO");
        panel.add(lblFechaNac);
        lblFechaNac.setFont(Constantes.FUENTE_LABEL);
        lblFechaNac.setBounds(40, 145, 200, 40);
        lblFechaNac.setForeground(Color.decode("#fcc139"));

        calendario = new JDateChooser();
        panel.add(calendario);
        calendario.setBounds(220, 155, 100, 20);
        calendario.setDate(Date.from(Instant.now()));

        lblPoblacion = new JLabel("POBLACIÓN");
        panel.add(lblPoblacion);
        lblPoblacion.setFont(Constantes.FUENTE_LABEL);
        lblPoblacion.setBounds(40, 180, 200, 40);
        lblPoblacion.setForeground(Color.decode("#fcc139"));
        txtPoblacion = new JTextField();
        panel.add(this.txtPoblacion);
        txtPoblacion.setBounds(160, 190, 150, 20);

        btnGuardar = new JButton("GUARDAR");
        panel.add(btnGuardar);
        btnGuardar.setFont(Constantes.FUENTE_BOTON);
        btnGuardar.setForeground(Color.decode("#1f4489"));
        btnGuardar.setBackground(Color.decode("#fcc139"));
        btnGuardar.setBounds(160, 240, 120, 25);

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        crearSocio();
    }

    private void crearSocio() {
        btnGuardar.addActionListener(evento -> {
            String nif = txtNif.getText();
            String nombre = txtNombre.getText();
            String poblacion = txtPoblacion.getText();
            LocalDate fechaNacimiento;
            Period edad;

            // Quita los espacios al principio y al final del texto
            nif = nif.trim().toUpperCase();
            nombre = nombre.trim();
            poblacion = poblacion.trim();

            // Se obtiene la fecha del calendario
            Date fecha = calendario.getDate();
            // Se transforma la fecha en un objeto Instant
            Instant instant = fecha.toInstant();
            // Se obtiene la zona horaria del sistema
            ZoneId zonaHoraria = ZoneId.systemDefault();
            // Del objeto Instant que tiene la fecha llama al método atZone con la zona horaria del sistema y lo transforma a LocalDate
            fechaNacimiento = instant.atZone(zonaHoraria).toLocalDate();

            edad = Period.between(fechaNacimiento, LocalDate.now());

            if (!Socio.comprobarNif(nif))
                JOptionPane.showMessageDialog(null, "EL NIF NO ES VÁLIDO");
            else if (nombre.equals(""))
                JOptionPane.showMessageDialog(null, "EL NOMBRE ESTÁ VACÍO");
            else if (edad.getYears() < 18)
                JOptionPane.showMessageDialog(null, "SOLO PUEDEN DARSE DE ALTA MAYORES DE EDAD");
            else if (poblacion.equals(""))
                JOptionPane.showMessageDialog(null, "lA POBLACIÓN ESTÁ VACÍA");
            else
                Videoclub.guardarSocio(new Socio(fechaNacimiento, nombre, poblacion, nif));
        });
    }
}