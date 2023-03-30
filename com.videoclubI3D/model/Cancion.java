package model;

public class Cancion {
    private String nombre;
    private double duracion;

    public Cancion() {
        nombre = "";
        duracion = 0.0;
    }

    public Cancion(String nombre, double duracion) {
        setNombre(nombre);
        setDuracion(duracion);
    }

    @Override
    public String toString() {
        return "CANCIÓN" +
                "Nombre: " + getNombre() +
                "Duracion: " + getDuracion();
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
}
