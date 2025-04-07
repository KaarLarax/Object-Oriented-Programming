// Lara Hernandez Carlos Alberto
// Sánchez Azpeitia Josue Orlando
// So you think, my heart is made of stone.
package pck_perecedero;

import pck_fecha.Fecha;

public class Perecedero extends Articulo {
    private Fecha fechaElaboracion;
    private Fecha fechaCaducidad;

    public Perecedero(int id, String descripcion, String marca, String modelo, String contenido, String categoria,
                      float precio, String estado, Fecha fechaElaboracion, Fecha fechaCaducidad) {
        super(id, descripcion, marca, modelo, contenido, categoria, precio, estado);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Perecedero() {
        super();
        this.fechaElaboracion = new Fecha();
        this.fechaCaducidad  = new Fecha();
    }

    public String getFechaElaboracion() {
        return fechaElaboracion.getFecha();
    }

    public void setFechaElaboracion(Fecha fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad.getFecha();
    }

    public void setFechaCaducidad(Fecha fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }



    @Override
    public String getDatos() {
        return super.getDatos() +
                "\nFecha de Elaboracion: " + getFechaElaboracion() +
                "\nFecha de Caducidad: " + getFechaCaducidad();
    }
}
