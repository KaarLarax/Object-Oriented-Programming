/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pk_modelo;

import java.util.Date;

public class Producto {
    private int idArticulo;
    private String descripcion;
    private String marca;
    private float precio;
    private String contenido;
    private String categoria;
    private String estado;
    private Date fElab;
    private Date fCad;

    public Producto(int idArticulo, String descripcion, String marca, float precio, String contenido, String categoria, String estado, Date fElab, Date fCad) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.contenido = contenido;
        this.categoria = categoria;
        this.estado = estado;
        this.fElab = fElab;
        this.fCad = fCad;
    }

    public Producto() {
        this(0,null,null,0.0f,null,null,null,null,null);
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setfElab(Date fElab) {
        this.fElab = fElab;
    }

    public void setfCad(Date fCad) {
        this.fCad = fCad;
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

    public float getPrecio() {
        return precio;
    }

    public String getContenido() {
        return contenido;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

    public Date getfElab() {
        return fElab;
    }

    public Date getfCad() {
        return fCad;
    }
    
    
}
