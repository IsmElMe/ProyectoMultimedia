package model;

public class Cancion {
	private String nombre;
	private double duracion;

	public Cancion() {
		nombre = Constantes.TITULO_DEFECTO;
		duracion = Constantes.DURACION_DOUBLE_DEFAULT;
	}

	public Cancion(String nombre, double duracion) {
		setNombre(nombre);
		setDuracion(duracion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "CANCIÓN" +
				"Nombre: " + getNombre() +
				"Duracion: " + getDuracion();
	}
}