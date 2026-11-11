import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {

    // HashMap: búsqueda directa por código
    private Map<String, Material> catalogo = new HashMap<>();

    // HashMap + ArrayList: una fila de espera ordenada por cada material
    private Map<String, List<String>> listaEspera = new HashMap<>();

    // HashSet: membresías únicas, consulta con contains()
    private Set<String> miembros = new HashSet<>();

    // Catálogo (HashMap)
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo); // retorna null si no existe
    }

    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            System.out.print(entrada.getKey() + " -> ");
            entrada.getValue().mostrarInfo();
        }
    }

    // Lista de espera (ArrayList) 
    public void agregarEspera(String codigoMaterial, String usuario) {
        if (!listaEspera.containsKey(codigoMaterial)) {
            listaEspera.put(codigoMaterial, new ArrayList<>());
        }
        listaEspera.get(codigoMaterial).add(usuario); // se agrega al final
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> fila = listaEspera.get(codigoMaterial);
        if (fila == null || fila.isEmpty()) {
            return null; // nadie esperando
        }
        return fila.remove(0); // elimina por índice: el más antiguo
    }

    // Membresías (HashSet) 
    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario); // false si ya existía
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}
