import java.io.Serializable;

public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String titulo;
    private String director;
    private int anioEstreno;
    private String clasificacion;
    private String genero;

    public Video(int id, String titulo, String director, int anioEstreno, String clasificacion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anioEstreno = anioEstreno;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public Video(){
        this(0, null, null, 0, null, null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public String getDatos(){
        return "Id del video: " + getId() +
               "\nTitulo: " + getTitulo() +
               "\nDirector: " + getDirector() +
               "\nAño de estreno: " + getAnioEstreno() +
               "\nClasificación: " + getClasificacion() +
               "\nGénero: " + getGenero();
    }
}
