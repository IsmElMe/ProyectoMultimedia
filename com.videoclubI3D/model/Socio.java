package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Socio {
    private static int numSocio;
    private final String NIF;
    private String nombre, poblacion;
    private LocalDate fechaNacimiento;

    public Socio(LocalDate fechaNacimiento, String nombre, String poblacion, String NIF) {
        numSocio++;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.NIF = NIF;
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

    @Override
    public String toString() {
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "Socio n#" + numSocio +
                "\n \tNIF: " + NIF +
                "\n \tNombre: " + nombre +
                "\n \tFecha nacimiento: " + fechaNacimiento.format(fechaFormateada) +
                "\n \tPoblación: " + poblacion;
    }

}
