package biblioteca;

import java.util.ArrayList;
import java.util.List;

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

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Clase anidada estática
    public static class EstadisticaBiblioteca {

        public static double calcularPromedioPalabras(List<Libro> libros) {
            if (libros.isEmpty()) return 0;

            int totalPalabras = 0;
            for (Libro libro : libros) {
                totalPalabras += libro.calcularPalabrasEstimadas();
            }
            return (double) totalPalabras / libros.size();
        }

        public static int contarFavoritos(List<Usuario> usuarios) {
            int total = 0;
            for (Usuario u : usuarios) {
                total += u.getFavoritos().size();
            }
            return total;
        }
    }
}