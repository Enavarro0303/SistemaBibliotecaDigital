package biblioteca;

import java.util.Random;

public class Libro extends Publicacion {

    public Libro(String titulo, String autor, int anio, String codigoISBN) {
        super(titulo, autor, anio, codigoISBN);
    }

    /**
     * Calcula un número de palabras estimado para el libro.
     * @return un número entero de palabras.
     */
    public int calcularPalabrasEstimadas() {
        Random rand = new Random();
        int palabrasPorPagina = 250 + rand.nextInt(101); // 250 a 350
        int totalPaginas = 100 + rand.nextInt(401); // 100 a 500
        return palabrasPorPagina * totalPaginas;
    }

    @Override
    public String getInfo() {
        return "Libro: " + getTitulo() + " - " + getAutor() + " (" + getAnio() + ")";
    }
}