package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Publicacion> publicaciones;
    private List<Usuario> usuarios;

    public Biblioteca() {
        publicaciones = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion pub) {
        publicaciones.add(pub);
    }

    public void registrarUsuario(Usuario user) {
        usuarios.add(user);
    }

    // MEJORA: Devuelve lista no modificable para proteger los datos (encapsulamiento)
    public List<Publicacion> getPublicaciones() {
        return Collections.unmodifiableList(publicaciones);
    }

    // MEJORA: Devuelve lista no modificable
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    // Clase anidada estática para estadísticas
    public static class EstadisticaBiblioteca {

        // MEJORA: Lógica modernizada con Streams
        public static double calcularPromedioPalabras(List<Publicacion> catalogo) {
            List<Libro> libros = catalogo.stream()
                                        .filter(p -> p instanceof Libro)
                                        .map(p -> (Libro) p)
                                        .collect(Collectors.toList());

            if (libros.isEmpty()) return 0;

            return libros.stream()
                         .mapToInt(Libro::calcularPalabrasEstimadas)
                         .average()
                         .orElse(0.0);
        }

        // MEJORA: Lógica modernizada con Streams
        public static int contarFavoritos(List<Usuario> usuarios) {
            return usuarios.stream()
                           .mapToInt(u -> u.getFavoritos().size())
                           .sum();
        }
    }
}