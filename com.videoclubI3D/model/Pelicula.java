package model;

public class Pelicula extends Multimedia {
    private int duracion;
    private String actorPrincipal;
    private String actrizPrinciapl;

    public Pelicula(){
        duracion = 0;
        actorPrincipal = "";
        actrizPrinciapl = "";
    }

    public Pelicula(String titulo, String autor, Formato formato, int anio, int duracion, String actorPrincipal, String actrizPrinciapl) {
        super(titulo, autor, formato, anio);
        setDuracion(duracion);
        setActorPrincipal(actorPrincipal);
        setActrizPrinciapl(actrizPrinciapl);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDuración: " + getDuracion() +
                "\nActor Principal: " + getActorPrincipal() +
                "\nActriz Principal: " + getActrizPrinciapl();
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
}
