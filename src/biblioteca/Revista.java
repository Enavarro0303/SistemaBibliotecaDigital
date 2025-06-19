package biblioteca;

public class Revista extends Publicacion {

    public Revista(String titulo, String autor, int anio, String codigoISBN) {
        super(titulo, autor, anio, codigoISBN);
    }

    @Override
    public String getInfo() {
        return "Revista: " + getTitulo() + " - " + getAutor() + " (" + getAnio() + ")";
    }
}