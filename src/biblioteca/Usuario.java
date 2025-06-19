package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
    private String nombre;
    private List<Publicacion> favoritos; // MEJORA: Ahora es de tipo Publicacion

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.favoritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    // MEJORA: Acepta cualquier Publicacion
    public void marcarComoFavorito(Publicacion publicacion) {
        if (!favoritos.contains(publicacion)) {
            favoritos.add(publicacion);
            System.out.println("⭐ Publicación '" + publicacion.getTitulo() + "' marcada como favorita.");
        } else {
            System.out.println("La publicación '" + publicacion.getTitulo() + "' ya está en favoritos.");
        }
    }

    public List<Publicacion> getFavoritos() {
        // Devuelve una copia para proteger la lista original
        return new ArrayList<>(favoritos);
    }

    // MEJORA: Búsqueda inteligente con Streams que recibe el catálogo completo
    public List<Libro> buscarLibroPorTitulo(List<Publicacion> catalogo, String titulo) {
        return catalogo.stream()
                .filter(pub -> pub instanceof Libro)
                .map(pub -> (Libro) pub)
                .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    // MEJORA: Búsqueda inteligente con Streams que recibe el catálogo completo
    public List<Libro> buscarLibroPorAutor(List<Publicacion> catalogo, String autor) {
        return catalogo.stream()
                .filter(pub -> pub instanceof Libro)
                .map(pub -> (Libro) pub)
                .filter(libro -> libro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                .collect(Collectors.toList());
    }
}