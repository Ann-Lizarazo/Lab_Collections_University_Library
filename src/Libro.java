public class Libro extends Material {
    private String autor;
    private String isbn;

    public Libro(String codigo, String titulo, int anio, String autor, String isbn) {
        super(codigo, titulo, anio);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }
}
