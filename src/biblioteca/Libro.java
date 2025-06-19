package biblioteca;

import java.util.Random;

public class Libro extends Publicacion {

    public Libro(String titulo, String autor, int anio, String codigoISBN) {
        super(titulo, autor, anio, codigoISBN);
    }

    public int calcularPalabrasEstimadas() {
        Random rand = new Random();
        int palabrasPorPagina = 100 + rand.nextInt(201); // 100 a 300
        int totalPaginas = 100 + rand.nextInt(401); // 100 a 500
        return palabrasPorPagina * totalPaginas;
    }

    @Override
    public String getInfo() {
        return "Libro: " + getTitulo() + " - " + getAutor() + " (" + getAnio() + ")";
    }
}