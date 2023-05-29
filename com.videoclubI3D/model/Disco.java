package model;

import java.util.ArrayList;

public class Disco extends Multimedia {
    private double duracion;
    private ArrayList<Cancion> canciones;

    public Disco(){
        duracion = Constantes.DURACION_INT_DEFAULT;
        canciones = new ArrayList<>();
    }

    public Disco(String titulo, String autor, Formato formato, int anio, ArrayList<Cancion> canciones){
        super(titulo, autor, formato, anio);
        setCanciones(canciones);
        totalDuracion(canciones);

        if (duracion < 30){
            setPrecio(Constantes.PRECIO_DEFAULT - 1);
        }
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }else
            throw new RuntimeException("La duración del disco no puede ser inferior a un minuto");
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void totalDuracion(ArrayList<Cancion> canciones){
        for(Cancion cancion: canciones){
            if (cancion != null){
                this.duracion += cancion.getDuracion();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder cancionesStr = new StringBuilder("\nCanciones: ");

        for (Cancion cancion: canciones){
            if(cancion != null){
                cancionesStr.append(cancion).append(", ");
            }
        }
        return super.toString() +
                "\nDuración: " + getDuracion()
                ;
    }
}
