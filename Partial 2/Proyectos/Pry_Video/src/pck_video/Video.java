package pck_video;

public final class Video {
    private String titulo;
    private String productor;
    private int anioEstreno;
    private String clasificacion;
    private String genero;

    public Video(String titulo, String productor, int anioEstreno, String clasificacion, String genero) {
        this.titulo = titulo;
        this.productor = productor;
        this.anioEstreno = anioEstreno;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public Video() {
        this(null, null, 0, null, null);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDatos() {
        return "---------VIDEO---------" +
               "\nTitulo: " + getTitulo() +
               "\nProductor: " + getProductor() +
               "\nAño de Estreno: " + getAnioEstreno() +
               "\nClasificacion: " + getClasificacion() +
               "\nGenero: '" + getGenero();
    }
}
