package model;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Constantes {
	public static final int ANIO_DEFETO = 1980;
	public static final int MAX_PLATAFORMAS = 4;
	public static final int PRECIO_DEFAULT = 4;
	public static final int DURACION_INT_DEFAULT = 0;
	public static final int MAX_DIAS_ALQUILER = 3;
	public static final int ANCHO_PANTALLA = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int ALTO_PANTALLA = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final double DURACION_DOUBLE_DEFAULT = 0.0;
	public static final String TITULO_DEFECTO = "";
	public static final String AUTOR_DEFECTO = "";
	public static final String COLOR_AZUL = "#1F4489";
	public static final String COLOR_AMARILLO = "#FCC139";
	public static final Formato FORMATO_DEFECTO = Formato.DVD;

	private static final Font blockletter = loadFont("fonts/blockletter.ttf", 40);

	public static final Font FUENTE_TITULO = blockletter;
	public static final Font FUENTE_BOTON = new Font("Boton", Font.BOLD, 15);
	public static final Font FUENTE_LABEL = new Font("Label", Font.BOLD, 16);

	private static Font loadFont(String path, float size) {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			font = font.deriveFont(size);
			return font;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
}




