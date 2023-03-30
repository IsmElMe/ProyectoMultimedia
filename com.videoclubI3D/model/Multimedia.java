package model;

public abstract class Multimedia {
    private static int numMultimedias = 0;
    private String titulo;
    private String autor;
    private Formato formato;
    private int anio;

    public Multimedia(){
        titulo = Constantes.TITULO_DEFECTO;
        autor = Constantes.AUTOR_DEFECTO;
        formato = Constantes.FORMATO_DEFECTO;
        anio = Constantes.ANIO_DEFETO;
        numMultimedias++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public static int getNumMultimedias() {
        return numMultimedias;
    }
}
