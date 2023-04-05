package model;

import java.time.LocalDate;

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
}
