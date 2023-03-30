package model;

public class Videojuego extends Multimedia {

    private Plataforma[] plataformas;

    public Videojuego(){
        plataformas = new Plataforma[4];
    }
    public Videojuego(String titulo, String autor, Formato formato, int anio, Plataforma[] plataformas){
        super(titulo, autor, formato, anio);
        setPlataformas(plataformas);
    }

    public Plataforma[] getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Plataforma[] plataformas) {
        this.plataformas = plataformas;
    }
}
