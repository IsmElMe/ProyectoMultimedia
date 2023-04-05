package model;

import java.time.LocalDate;
import java.util.Comparator;

public class Videojuego extends Multimedia {

	private Plataforma[] plataformas;

	public Videojuego() {
		plataformas = new Plataforma[Constantes.MAX_PLATAFORMAS];
	}

	public Videojuego(String titulo, String autor, Formato formato, int anio, Plataforma[] plataformas) {
		super(titulo, autor, formato, anio);
		setPlataformas(plataformas);

		if (anio < 2010) {
			setPrecio(Constantes.PRECIO_DEFAULT - 1);
		}

		if (anio == LocalDate.now().getYear()) {
			setPrecio(Constantes.PRECIO_DEFAULT + 1);
		}
	}

	public Plataforma[] getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Plataforma[] plataformas) {
		this.plataformas = plataformas;
	}

	public static class ComparatorFecha implements Comparator<Multimedia> {
		@Override
		public int compare(Multimedia o1, Multimedia o2) {
			return o2.getAnio() - o1.getAnio();
		}
	}
}
