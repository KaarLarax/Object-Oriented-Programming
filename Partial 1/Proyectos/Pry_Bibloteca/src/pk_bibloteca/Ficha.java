package pk_bibloteca;


public class Ficha {
    String referencia;
    String titulo;

    public Ficha(String referencia, String titulo) {
        this.referencia = referencia;
        this.titulo = titulo;
    }

    public Ficha() {
        this(null, null);
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDatos() {
        return  "Referencia: " + getReferencia() +
                "\nTitulo: " + getTitulo();
    }
}
