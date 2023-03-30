package model;

public class Videojuego extends Multimedia {
    private Plataforma[] plataformas;

    public Videojuego(String titulo, String autor, String formato, String anio, Plataforma[] plataformas) {
        super(titulo, autor, formato, anio);
        setPlataformas(plataformas);
    }

    @Override
        public String toString(){
            return super.toString() +
                    "\nPlataformas: " + getPlataformas();
        }
    public Plataforma[] getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Plataforma[] plataformas) {
        this.plataformas = plataformas;
    }
}
