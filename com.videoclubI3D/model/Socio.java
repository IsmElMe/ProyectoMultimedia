package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Socio {
	private static int numSocio;
	private final String NIF;
	private String nombre, poblacion;
	private LocalDate fechaNacimiento;
	private ArrayList<Multimedia> multimediasAlquiladas;

	public Socio(LocalDate fechaNacimiento, String nombre, String poblacion, String NIF) {
		numSocio++;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.NIF = NIF;
		multimediasAlquiladas = new ArrayList<>();
	}

	public static int getNumSocio() {
		return numSocio;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getNIF() {
		return NIF;
	}

	public ArrayList<Multimedia> getMultimediasAlquiladas() {
		return multimediasAlquiladas;
	}

	public void setMultimediasAlquiladas(ArrayList<Multimedia> multimediasAlquiladas) {
		this.multimediasAlquiladas = multimediasAlquiladas;
	}

	public void alquilarMultimedia(Multimedia multimedia) {
		multimediasAlquiladas.add(multimedia);
	}

	public static boolean comprobarNif(String nif) {
		int dniNum;
		String letra;

		if (!(nif.length() == 9))
			return false;

		try {
			dniNum = Integer.parseInt(nif.substring(0, 8)) % 23;
			letra = "TRWAGMYFPDXBNJZSQVHLCKE";
		} catch (NumberFormatException error) {
			return false;
		}

		return nif.equals(nif.substring(0, 8) + letra.charAt(dniNum));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Socio)
			return NIF.equals(((Socio) obj).NIF);

		return false;
	}

	@Override
	public String toString() {
		return "Socio n#" + numSocio +
				"\n \tNIF: " + NIF +
				"\n \tNombre: " + nombre +
				"\n \tFecha nacimiento: " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
				"\n \tPoblación: " + poblacion + "\n";
	}
}