package view;

import controler.Videoclub;
import model.*;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionarDisco extends JDialog {
    private static JButton btnAceptar, btnCancelar;
    private static JList<String> listDisco;
    private static JScrollPane scrollDisco;

    public VentanaSeleccionarDisco() {
        super.setTitle("BLOCKBUSTER - SELECCIONAR DISCO");
        setModal(true);
        JPanel panel = new JPanel();
        super.setContentPane(panel);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setBackground(Color.decode(Constantes.COLOR_AZUL));
        super.setBounds((Constantes.ANCHO_PANTALLA / 2) - 200, (Constantes.ALTO_PANTALLA / 2) - 200, 400, 400);

        JLabel lblTitulo = new JLabel("SELECCIONA UN DISCO");
        panel.add(lblTitulo);
        lblTitulo.setFont(Constantes.FUENTE_LABEL);
        lblTitulo.setForeground(Color.decode(Constantes.COLOR_AMARILLO));
        lblTitulo.setBounds((super.getWidth() / 2) - 100, 20, 200, 30);

        listDisco = new JList<>();
        scrollDisco = new JScrollPane(listDisco);
        panel.add(scrollDisco);
        scrollDisco.setBounds(20, 60, 350, 200);

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

        btnCancelar.addActionListener(evento -> this.setVisible(false));
        btnAceptar.addActionListener(evento -> {
            Videoclub.discoSeleccionado = discoSeleccionado();
            this.setVisible(false);
        });
    }

    public static void actualizarLista() {
        DefaultListModel<String> modelList = new DefaultListModel<>();

        for (Multimedia multimedia : Videoclub.sacarDiscos())
            modelList.addElement(multimedia.getTitulo());

        listDisco.setModel(modelList);
    }

    public static Disco discoSeleccionado() {
        String discoSeleccionado = listDisco.getSelectedValue();

        for (Multimedia disco : Videoclub.sacarDiscos())
            if (disco.getTitulo().equals(discoSeleccionado))
                return (Disco) disco;

        return null;
    }
}
