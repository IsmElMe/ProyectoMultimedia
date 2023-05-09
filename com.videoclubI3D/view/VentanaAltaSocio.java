package view;

import com.toedter.calendar.JDateChooser;
import controler.Videoclub;
import model.Constantes;
import model.Socio;

import java.awt.Font;
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
    private JTextField txtNif, txtNombre, txtFechaNac, txtPoblacion;
    private JButton btnGuardar;
    private JDateChooser calendario;

    public VentanaAltaSocio() {
        super("Blockbuster - Alta Socio");
        super.setContentPane(this.panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 250, (Constantes.ALTO_PANTALLA / 2) - 235, 500, 470);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        lblTitulo = new JLabel("Alta Socio");
        panel.add(this.lblTitulo);
        lblTitulo.setFont(new Font("Titulo", 1, 30));
        lblTitulo.setBounds(super.getWidth() / 2 - 74, 15, 148, 60);

        lblNif = new JLabel("NIF: ");
        panel.add(this.lblNif);
        lblNif.setFont(new Font("Titulo", 0, 15));
        lblNif.setBounds(70, 60, 100, 120);
        txtNif = new JTextField();
        panel.add(this.txtNif);
        txtNif.setBounds(160, 110, 250, 20);

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

        calendario = new JDateChooser();
        panel.add(calendario);
        calendario.setBounds(240, 230, 100, 20);

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

        crearSocio();
    }

    private void crearSocio() {
        btnGuardar.addActionListener(evento -> {
            String nif = txtNif.getText();
            String nombre = txtNombre.getText();
            String poblacion = txtPoblacion.getText();
            LocalDate fechaNacimiento = null;
            Period edad = Period.between(LocalDate.now(), LocalDate.now());

            // Quita los espacios al principio y al final del texto
            nif = nif.trim().toUpperCase();
            nombre = nombre.trim();
            poblacion = poblacion.trim();

            try {
                // Se obtiene la fecha del calendario
                Date fecha = calendario.getDate();
                // Se transforma la fecha en un objeto Instant
                Instant instant = fecha.toInstant();
                // Se obtiene la fecha horaria del sistema
                ZoneId zonaHoraria = ZoneId.systemDefault();
                // Del objeto Instant que tiene la fecha llama al método atZone con la zona horaria del sistema y lo transforma a LocalDate
                fechaNacimiento = instant.atZone(zonaHoraria).toLocalDate();

                edad = Period.between(fechaNacimiento, LocalDate.now());
            } catch (NullPointerException error) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento está vacía");
            }

            if (!Socio.comprobarNif(nif))
                JOptionPane.showMessageDialog(null, "El NIF no es válido");
            else if (nombre.equals(""))
                JOptionPane.showMessageDialog(null, "El nombre está vacío");
            else if (edad.getYears() < 18)
                JOptionPane.showMessageDialog(null, "Solo pueden darse de alta mayores de edad");
            else if (poblacion.equals(""))
                JOptionPane.showMessageDialog(null, "La población está vacía");
            else
                Videoclub.guardarSocio(new Socio(fechaNacimiento, nombre, poblacion, nif));
        });
    }
}