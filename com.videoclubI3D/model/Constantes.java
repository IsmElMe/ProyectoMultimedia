package model;

import java.awt.Font;
import java.awt.Toolkit;

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
	public static final Formato FORMATO_DEFECTO = Formato.DVD;
	public static final Font FUENTE_TITULO = new Font("Titulo", Font.BOLD, 30);
	public static final Font FUENTE_BOTON = new Font("Boton", Font.PLAIN, 20);
	public static final Font FUENTE_LABEL = new Font("Label", Font.PLAIN, 16);
}
