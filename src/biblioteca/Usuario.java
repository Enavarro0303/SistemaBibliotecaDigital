package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Libro> favoritos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.favoritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void marcarComoFavorito(Libro libro) {
        if (!favoritos.contains(libro)) {
            favoritos.add(libro);
            System.out.println("Libro marcado como favorito: " + libro.getTitulo());
        } else {
            System.out.println("El libro ya está en favoritos.");
        }
    }

    public List<Libro> getFavoritos() {
        return favoritos;
    }

    public List<Libro> buscarPorTitulo(List<Libro> libros, String titulo) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorAutor(List<Libro> libros, String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }
}