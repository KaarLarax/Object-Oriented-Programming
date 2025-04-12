/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pk_modelo;

/**
 *
 * @author Lenovo
 */
public class Articulo {

    private int idArticulo;
    private String descripcion;
    private String marca;
    private String contenido;
    private String modelo;
    private float precio;
    private String categoria;
    private String estatus;

    public Articulo(int id, String desc, String marca,float precio, String cont, String categoria, String estatus) {
        this.idArticulo = id;
        this.descripcion = desc;
        this.marca = marca;
        this.contenido = cont;
        this.precio = precio;
        this.categoria = categoria;
        this.estatus = estatus;
    }

    public Articulo() {
        this.idArticulo = 0;
        this.descripcion = null;
        this.marca = null;
        this.contenido = null;
        this.modelo = null;
        this.precio = 0.0f;
        this.categoria = null;
        this.estatus = null;
    }

//    public Articulo(int id, String desc, float precio) {
//        this(id, desc, null, null, null, precio, null, null);
//    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
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

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setIdCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdArticulo() {
        return idArticulo;
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

    public float getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDatos() {
        return "----Articulo----\n"
                + "id articulo:" + getIdArticulo()
                + "\n Descripcion: " + getDescripcion()
                + "\n Marca: " + getMarca()
                + "\n Contenido: " + getContenido()
                + "\n Modelo: " + getModelo()
                + "\n Precio: " + getPrecio()
                + "\n Categoria: " + getCategoria()
                + "\n Estatus: " + getEstatus();
    }
}
