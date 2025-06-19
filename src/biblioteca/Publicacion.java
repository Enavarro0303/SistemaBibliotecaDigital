package biblioteca;

public abstract class Publicacion {
    protected String titulo;
    protected String autor;
    protected int anio;
    protected String codigoISBN;

    public Publicacion(String titulo, String autor, int anio, String codigoISBN) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.codigoISBN = codigoISBN;
    }

    // Getters estándar
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    /**
     * Define un contrato para que todas las subclases deban implementar
     * una forma de mostrar su información.
     */
    public abstract String getInfo();
}