package model;

public abstract class Multimedia {
    private static int numMultimedias = 0;
    private String titulo;
    private String autor;
    private Formato formato;
    private int anio;

    private int precio;

    public Multimedia(){
        titulo = Constantes.TITULO_DEFECTO;
        autor = Constantes.AUTOR_DEFECTO;
        formato = Constantes.FORMATO_DEFECTO;
        anio = Constantes.ANIO_DEFETO;
        numMultimedias++;
    }

    public Multimedia(String titulo, String autor, Formato formato, int anio){
        this();
        setTitulo(titulo);
        setAutor(autor);
        setFormato(formato);
        setAnio(anio);
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
        if (anio > 1940) {
            this.anio = anio;
        }else throw new RuntimeException("No se pueden introducir multimedias antriores a 1940");
    }

    public static int getNumMultimedias() {
        return numMultimedias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nFormato: " + getFormato() +
                "\nAnio: " + getAnio();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Multimedia) {
            return titulo.equals(((Multimedia)obj).titulo) && autor.equals(((Multimedia)obj).autor);
        }else return false;
    }
}
