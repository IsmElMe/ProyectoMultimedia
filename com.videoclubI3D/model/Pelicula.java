package model;

import java.time.LocalDate;

public class Pelicula extends Multimedia {
	private int duracion;
	private String actorPrincipal;
	private String actrizPrinciapl;

	public Pelicula() {
		super();
		duracion = Constantes.DURACION_INT_DEFAULT;
		actorPrincipal = Constantes.AUTOR_DEFECTO;
		actrizPrinciapl = Constantes.AUTOR_DEFECTO;
	}

	public Pelicula(String titulo, String autor, Formato formato, int anio, int duracion, String actorPrincipal, String actrizPrinciapl) {
		super(titulo, autor, formato, anio);
		setDuracion(duracion);
		setActorPrincipal(actorPrincipal);
		setActrizPrinciapl(actrizPrinciapl);

		if (anio < 2012) {
			setPrecio(Constantes.PRECIO_DEFAULT - 1);
		}

		if (anio == LocalDate.now().getYear()) {
			setPrecio(Constantes.PRECIO_DEFAULT + 1);
		}
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getActorPrincipal() {
		return actorPrincipal;
	}

	public void setActorPrincipal(String actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}

	public String getActrizPrinciapl() {
		return actrizPrinciapl;
	}

	public void setActrizPrinciapl(String actrizPrinciapl) {
		this.actrizPrinciapl = actrizPrinciapl;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\nDuración: " + getDuracion() +
				"\nActor Principal: " + getActorPrincipal() +
				"\nActriz Principal: " + getActrizPrinciapl();
	}
}
