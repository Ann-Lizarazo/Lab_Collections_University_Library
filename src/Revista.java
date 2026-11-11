public class Revista extends Material {
    private int edicion;
    private String tematica;

    public Revista(String codigo, String titulo, int anio, int edicion, String tematica) {
        super(codigo, titulo, anio);
        this.edicion = edicion;
        this.tematica = tematica;
    }

    public int getEdicion() {
        return edicion;
    }

    public String getTematica() {
        return tematica;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}
