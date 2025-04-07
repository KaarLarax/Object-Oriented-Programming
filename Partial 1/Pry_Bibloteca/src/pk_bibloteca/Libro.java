package pk_bibloteca;

public class Libro extends Ficha {
    private String autor;
    private String editorial;
    private int noPaginas;

    public Libro(String referencia, String titulo, String autor, String editorial, int noPaginas) {
        super(referencia, titulo);
        this.autor = autor;
        this.editorial = editorial;
        this.noPaginas = noPaginas;
    }

    public Libro() {
        this(null, null, null, null, 0);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }

    @Override
    public String getDatos() {
        return super.getDatos() +
                "\nAutor: " + getAutor() +
                "\nEditorial" + getEditorial() +
                "\nNumero de paginas: " + getNoPaginas();
    }

}
