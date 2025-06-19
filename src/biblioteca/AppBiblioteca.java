package biblioteca;

import java.util.List;

public class AppBiblioteca {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Biblioteca Profesional ---");

        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear publicaciones
        Libro libro1 = new Libro("Java Básico", "Juan Pérez", 2020, "ISBN001");
        Libro libro2 = new Libro("POO Avanzado", "Ana Torres", 2021, "ISBN002");
        Libro libro3 = new Libro("Estructuras de Datos", "Carlos Ruiz", 2022, "ISBN003");
        Revista revista1 = new Revista("Ciencia Hoy", "Revista Científica", 2023, "R001");

        // Agregar publicaciones a la biblioteca
        biblioteca.agregarPublicacion(libro1);
        biblioteca.agregarPublicacion(libro2);
        biblioteca.agregarPublicacion(libro3);
        biblioteca.agregarPublicacion(revista1);
        System.out.println("\n📚 Publicaciones agregadas al catálogo.");

        // Crear y registrar usuario
        Usuario usuario = new Usuario("Erick");
        biblioteca.registrarUsuario(usuario);
        System.out.println("👤 Usuario '" + usuario.getNombre() + "' registrado.");

        // Marcar favoritos (ahora pueden ser libros o revistas)
        usuario.marcarComoFavorito(libro1);
        usuario.marcarComoFavorito(libro3);
        usuario.marcarComoFavorito(revista1); // Demostración de la nueva flexibilidad
        
        System.out.println("\n--- Demostración de Funcionalidades ---");

        // Llamada a la búsqueda ahora es simple y directa
        System.out.println("\n📘 Búsqueda de libros por título 'Java':");
        List<Libro> librosPorTitulo = usuario.buscarLibroPorTitulo(biblioteca.getPublicaciones(), "Java");
        librosPorTitulo.forEach(l -> System.out.println("-> " + l.getInfo()));

        System.out.println("\n📗 Búsqueda de libros por autor 'Carlos':");
        List<Libro> librosPorAutor = usuario.buscarLibroPorAutor(biblioteca.getPublicaciones(), "Carlos");
        librosPorAutor.forEach(l -> System.out.println("-> " + l.getInfo()));

        // Estadísticas
        System.out.println("\n--- Estadísticas de la Biblioteca ---");
        double promedio = Biblioteca.EstadisticaBiblioteca.calcularPromedioPalabras(biblioteca.getPublicaciones());
        int totalFavoritos = Biblioteca.EstadisticaBiblioteca.contarFavoritos(biblioteca.getUsuarios());

        System.out.printf("📊 Promedio de palabras por libro: %.0f\n", promedio);
        System.out.println("⭐ Total de publicaciones favoritas en el sistema: " + totalFavoritos);
    }
}