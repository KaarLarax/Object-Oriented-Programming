package pk_articulo;

public class Articulo {
    private int id;
    private String descripcion;
    private String marca;
    private String contenido;
    private String modelo;
    private String categoria;
    private float precio;
    private String estatus;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getContenido() {
        return contenido;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDatos() {
            return "\tArticulo" +
                "\nID Articulo: " + getId() +
                "\nDescripcion: " + getDescripcion() +
                "\nMarca: " + getMarca() +
                "\nContenido: " + getContenido() +
                "\nModelo: " + getModelo() +
                "\nCategoria: " + getCategoria() +
                "\nPrecio: " + getPrecio() +
                "\nEstatus: " + getEstatus();
    }


}
