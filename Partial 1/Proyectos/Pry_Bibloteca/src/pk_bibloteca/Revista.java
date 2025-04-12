package pk_bibloteca;


public class Revista extends Ficha {
    private int anio;
    private int numero;

    public Revista(String referencia, String titulo, int anio, int numero) {
        super(referencia, titulo);
        this.anio = anio;
        this.numero = numero;
    }

    public Revista() {
        this(null, null, 0, 0);
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String getDatos() {
        return super.getDatos() +
                "\nAño: " + getAnio() +
                "\nNumero: " + getNumero();
    }
}
