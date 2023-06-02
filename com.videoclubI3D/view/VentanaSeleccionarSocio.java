package view;

import controler.Videoclub;
import model.*;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionarSocio extends JDialog {
    private static JButton btnAceptar, btnCancelar;
    private static JList<String> listaSocio;
    private static JScrollPane scrollSocio;

    public VentanaSeleccionarSocio() {
        super.setTitle("BLOCKBUSTER - SELECCIONAR SOCIO");
        super.setModal(true);
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode(Constantes.COLOR_AZUL));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 200, (Constantes.ALTO_PANTALLA / 2) - 200, 400, 400);

        JLabel lblTitulo = new JLabel("SELECCIONA UN SOCIO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setForeground(Color.decode(Constantes.COLOR_AMARILLO));
        lblTitulo.setBounds((super.getWidth() / 2) - 100, 20, 200, 30);

        listaSocio = new JList<>();
        scrollSocio = new JScrollPane(listaSocio);
        panel.add(scrollSocio);
        scrollSocio.setBounds(20, 60, 350, 200);

        btnCancelar = new JButton("CANCELAR");
        panel.add(btnCancelar);
        btnCancelar.setFont(Constantes.FUENTE_BOTON);
        btnCancelar.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnCancelar.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnCancelar.setBounds(25, 300, 150, 30);

        btnAceptar = new JButton("ACEPTAR");
        panel.add(btnAceptar);
        btnAceptar.setFont(Constantes.FUENTE_BOTON);
        btnAceptar.setForeground(Color.decode(Constantes.COLOR_AZUL));
        btnAceptar.setBackground(Color.decode(Constantes.COLOR_AMARILLO));
        btnAceptar.setBounds(220, 300, 150, 30);

        btnCancelar.addActionListener(evento -> {
            Videoclub.setSocioSeleccionado(null);
            this.setVisible(false);
        });

        btnAceptar.addActionListener(evento -> {
            Videoclub.setSocioSeleccionado(socioSeleccionado());
            this.setVisible(false);
        });
    }

    public static void actualizarLista() {
        DefaultListModel<String> modelList = new DefaultListModel<>();
        StringBuilder nifYNombre = new StringBuilder();

        for (Socio socio : Videoclub.getSocios()) {
            nifYNombre.append(socio.getNIF()).append(" - ").append(socio.getNombre());
            modelList.addElement(nifYNombre.toString());
            nifYNombre.delete(0, nifYNombre.length());
        }

        listaSocio.setModel(modelList);
    }

    private static Socio socioSeleccionado() {
        String socioSeleccionado = listaSocio.getSelectedValue().split("-")[0].trim();

        for (Socio socio : Videoclub.getSocios())
            if (socio.getNIF().equals(socioSeleccionado))
                return socio;

        return null;
    }
}
