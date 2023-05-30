package view;

import controler.Videoclub;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaAlquilarMultimedia extends JFrame {
    private JTextField txtNif;
    private JRadioButton rdbPelicula, rdbVideojuego, rdbDisco;
    private JComboBox<String> cmbMultimedia;
    private JButton btnAlquilar;

    public VentanaAlquilarMultimedia() {
        super("BLOCKBUSTER - ALQUILAR MULTIMEDIA");
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode("#1f4489"));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 215, (Constantes.ALTO_PANTALLA / 2) - 200, 430, 400);

        crearLabel(panel);
        crearRadioButton(panel);

        btnAlquilar = new JButton("ALQUILAR");
        panel.add(btnAlquilar);
        btnAlquilar.setFont(Constantes.FUENTE_BOTON);
        btnAlquilar.setForeground(Color.decode("#1f4489"));
        btnAlquilar.setBackground(Color.decode("#fcc139"));
        btnAlquilar.setBounds(160, 300, 120, 25);

        JButton btnAtras = new JButton("\uD83E\uDC80");
        panel.add(btnAtras);
        btnAtras.setFont(Constantes.FUENTE_BOTON);
        btnAtras.setBounds(10, 10, 65, 30);
        btnAtras.setFocusPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setForeground(Color.decode("#fcc139"));
        btnAtras.setFont(Constantes.FUENTE_BOTON_ATRAS);

        txtNif = new JTextField();
        panel.add(txtNif);
        txtNif.setBounds(80, 86, 150, 20);

        cmbMultimedia = new JComboBox<>();
        panel.add(cmbMultimedia);
        cmbMultimedia.setBounds(120, 250, 200, 20);

        alquilarMultimedia();
    }

    private void crearLabel(JPanel panel) {
        JLabel lblTituloVentana = new JLabel("ALQUILAR MULTIMEDIA");
        panel.add(lblTituloVentana);
        lblTituloVentana.setFont(Constantes.FUENTE_TITULO);
        lblTituloVentana.setBounds(60, 0, 350, 100);
        lblTituloVentana.setForeground(Color.decode("#fcc139"));

        JLabel lblNif = new JLabel("NIF");
        panel.add(lblNif);
        lblNif.setFont(Constantes.FUENTE_LABEL);
        lblNif.setBounds(40, 75, 200, 40);
        lblNif.setForeground(Color.decode("#fcc139"));

        JLabel lblTipoMultimedia = new JLabel("TIPO DE MULTIMEDIA");
        panel.add(lblTipoMultimedia);
        lblTipoMultimedia.setFont(Constantes.FUENTE_LABEL);
        lblTipoMultimedia.setBounds(40, 120, 200, 40);
        lblTipoMultimedia.setForeground(Color.decode("#fcc139"));

        JLabel lblTitulo = new JLabel("TÍTULO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setBounds(40, 240, 100, 40);
        lblTitulo.setForeground(Color.decode("#fcc139"));
    }

    private void crearRadioButton(JPanel panel) {
        Rectangle rectangle = new Rectangle(150, 160, 150, 20);

        ButtonGroup buttonGroup = new ButtonGroup();
        rdbPelicula = new JRadioButton("PELÍCULA");
        rdbPelicula.setFont(Constantes.FUENTE_LABEL);
        rdbPelicula.setBackground(Color.decode("#1f4489"));
        rdbPelicula.setForeground(Color.WHITE);
        rdbPelicula.setBounds(rectangle);
        rectangle.y += 25;

        rdbVideojuego = new JRadioButton("VIDEOJUEGO");
        rdbVideojuego.setFont(Constantes.FUENTE_LABEL);
        rdbVideojuego.setBackground(Color.decode("#1f4489"));
        rdbVideojuego.setForeground(Color.WHITE);
        rdbVideojuego.setBounds(rectangle);
        rectangle.y += 25;

        rdbDisco = new JRadioButton("DISCO");
        rdbDisco.setFont(Constantes.FUENTE_LABEL);
        rdbDisco.setBackground(Color.decode("#1f4489"));
        rdbDisco.setForeground(Color.WHITE);
        rdbDisco.setBounds(rectangle);

        buttonGroup.add(rdbPelicula);
        buttonGroup.add(rdbVideojuego);
        buttonGroup.add(rdbDisco);
        panel.add(rdbPelicula);
        panel.add(rdbVideojuego);
        panel.add(rdbDisco);
    }

    private void alquilarMultimedia() {
        btnAlquilar.addActionListener(evento -> {
            ArrayList<Multimedia> multimedias = Videoclub.getMultimedias();
            ArrayList<Socio> socios = Videoclub.getSocios();
            Multimedia multimediaSeleccionada = null;
            String nifSocio = txtNif.getText().toUpperCase();
            nifSocio = nifSocio.trim();
            boolean socioEncontrado = false;

            for (Multimedia multimedia : multimedias)
                if (multimedia.getTitulo().equals(cmbMultimedia.getSelectedItem()))
                    multimediaSeleccionada = multimedia;

            if (multimediaSeleccionada != null) {
                for (Socio socio : socios)
                    if (socio.getNIF().equals(nifSocio)) {
                        socio.alquilarMultimedia(multimediaSeleccionada);
                        JOptionPane.showMessageDialog(null, "Se ha alquilado correctamente el multimedia al socio " + nifSocio);
                        socioEncontrado = true;
                    }

                if (!socioEncontrado)
                    JOptionPane.showMessageDialog(null, "El socio no existe");
            } else
                JOptionPane.showMessageDialog(null, "Selecciona un multimedia para alquilar");
        });

        rdbPelicula.addActionListener(evento -> {
            ArrayList<Multimedia> multimedias = Videoclub.sacarPeliculas();
            cmbMultimedia.removeAllItems();

            for (Multimedia multimedia : multimedias)
                cmbMultimedia.addItem(multimedia.getTitulo());
        });

        rdbVideojuego.addActionListener(evento -> {
            ArrayList<Multimedia> multimedias = Videoclub.sacarVideojuegos();
            cmbMultimedia.removeAllItems();

            for (Multimedia multimedia : multimedias)
                cmbMultimedia.addItem(multimedia.getTitulo());
        });

        rdbDisco.addActionListener(evento -> {
            ArrayList<Multimedia> multimedias = Videoclub.sacarDiscos();
            cmbMultimedia.removeAllItems();

            for (Multimedia multimedia : multimedias)
                cmbMultimedia.addItem(multimedia.getTitulo());
        });
    }
}
