public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // Datos: 3 libros y 3 revistas
        biblioteca.registrarMaterial(new Libro("BK-2024-001", "El Principito", 1943,
                "Antoine de Saint-Exupéry", "978-0-000-00001-1"));
        biblioteca.registrarMaterial(new Libro("BK-2024-002", "Los viajes de Gulliver", 1726,
                "Jonathan Swift", "978-0-000-00002-2"));
        biblioteca.registrarMaterial(new Libro("BK-2024-003", "Ciberseguridad para todos", 2021,
                "Camilo Restrepo", "978-0-000-00003-3"));

        biblioteca.registrarMaterial(new Revista("RV-2024-001", "Ciencia y Tecnología Hoy", 2024,
                45, "Innovación"));
        biblioteca.registrarMaterial(new Revista("RV-2024-002", "Seguridad Digital Colombia", 2023,
                12, "Ciberseguridad"));
        biblioteca.registrarMaterial(new Revista("RV-2024-003", "Viajes y Cultura", 2022,
                30, "Turismo"));

        // PRUEBA 1: HashMap
        System.out.println("===== PRUEBA 1: CATÁLOGO (HashMap) =====");
        Material encontrado = biblioteca.buscarMaterial("BK-2024-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }
        Material inexistente = biblioteca.buscarMaterial("BK-9999-000");
        if (inexistente == null) {
            System.out.println("BK-9999-000: material no encontrado");
        }

        // PRUEBA 2: ArrayList
        System.out.println("\n===== PRUEBA 2: LISTA DE ESPERA (ArrayList) =====");
        biblioteca.buscarMaterial("BK-2024-001").setDisponible(false);
        biblioteca.buscarMaterial("BK-2024-001").mostrarInfo();

        biblioteca.agregarEspera("BK-2024-001", "María Rodríguez");
        biblioteca.agregarEspera("BK-2024-001", "Juan Pérez");
        biblioteca.agregarEspera("BK-2024-001", "Carlos Gómez");

        System.out.println("Siguiente en la fila: " + biblioteca.siguienteEnEspera("BK-2024-001"));
        System.out.println("Siguiente en la fila: " + biblioteca.siguienteEnEspera("BK-2024-001"));

        // PRUEBA 3: HashSet
        System.out.println("\n PRUEBA 3: MEMBRESÍAS (HashSet)");
        System.out.println("Juan Pérez registrado: " + biblioteca.registrarMiembro("Juan Pérez"));
        System.out.println("María Rodríguez registrada: " + biblioteca.registrarMiembro("María Rodríguez"));
        System.out.println("Luisa Martínez registrada: " + biblioteca.registrarMiembro("Luisa Martínez"));
        System.out.println("Juan Pérez registrado de nuevo: " + biblioteca.registrarMiembro("Juan Pérez"));
        System.out.println("¿Juan Pérez tiene membresía? " + biblioteca.tieneMembresia("Juan Pérez"));
        System.out.println("¿Andrés Ramírez tiene membresía? " + biblioteca.tieneMembresia("Andrés Ramírez"));

        // PRUEBA 4: Polimorfismo 
        System.out.println("\n PRUEBA 4: POLIMORFISMO ");
        biblioteca.mostrarCatalogo();
    }
}
