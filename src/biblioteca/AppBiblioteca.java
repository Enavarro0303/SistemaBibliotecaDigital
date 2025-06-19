package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AppBiblioteca {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear libros
        Libro libro1 = new Libro("Java Básico", "Juan Pérez", 2020, "ISBN001");
        Libro libro2 = new Libro("POO Avanzado", "Ana Torres", 2021, "ISBN002");
        Libro libro3 = new Libro("Estructuras de Datos", "Carlos Ruiz", 2022, "ISBN003");

        // Crear revistas
        Revista revista1 = new Revista("Ciencia Hoy", "Revista Científica", 2023, "R001");

        // Agregar publicaciones a la biblioteca
        biblioteca.agregarPublicacion(libro1);
        biblioteca.agregarPublicacion(libro2);
        biblioteca.agregarPublicacion(libro3);
        biblioteca.agregarPublicacion(revista1);

        // Crear usuario
        Usuario usuario = new Usuario("Erick");
        biblioteca.registrarUsuario(usuario);

        // Marcar favoritos
        usuario.marcarComoFavorito(libro1);
        usuario.marcarComoFavorito(libro3);

        // Buscar libros en publicaciones
        List<Libro> libros = new ArrayList<>();
        for (Publicacion pub : biblioteca.getPublicaciones()) {
            if (pub instanceof Libro) {
                libros.add((Libro) pub);
            }
        }

        // Buscar por título
        System.out.println("\n📘 Libros que contienen 'Java':");
        for (Libro l : usuario.buscarPorTitulo(libros, "Java")) {
            System.out.println(l.getInfo());
        }

        // Buscar por autor
        System.out.println("\n📗 Libros que contienen 'Carlos':");
        for (Libro l : usuario.buscarPorAutor(libros, "Carlos")) {
            System.out.println(l.getInfo());
        }

        // Estadísticas
        double promedio = Biblioteca.EstadisticaBiblioteca.calcularPromedioPalabras(libros);
        int totalFavoritos = Biblioteca.EstadisticaBiblioteca.contarFavoritos(biblioteca.getUsuarios());

        System.out.println("\n📊 Promedio de palabras por libro: " + promedio);
        System.out.println("⭐ Total de libros favoritos: " + totalFavoritos);
    }
}