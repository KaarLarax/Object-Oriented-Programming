// Lara Hernandez Carlos Alberto
// Sánchez Azpeitia Josue Orlando
// So you think, my heart is made of stone.
package pck_perecedero;

public class Articulo {
    int id;
    String descripcion;
    String marca;
    String modelo;
    String contenido;
    String categoria;
    float precio;
    String estado;

    public Articulo() {
        id = 0;
        descripcion = null;
        marca = null;
        modelo = null;
        contenido = null;
        categoria = null;
        precio = 0.0f;
        estado = null;
    }

    public Articulo(int id, String descripcion, String marca, String modelo, String contenido, String categoria, float precio, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

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

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getEstado() {
        return estado;
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
                "\nEstado: " + getEstado();
    }


}
