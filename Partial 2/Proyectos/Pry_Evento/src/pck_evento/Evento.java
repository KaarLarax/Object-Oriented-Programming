package pck_evento;

import pck_fecha.Fecha;

public class Evento {
    private int id;
    private String descripcion;
    private String ubicacion;
    private String anfitrion;
    private Fecha fecha;
    private int noInvitados;
    private String[] invitados = new String[20];

    public Evento(int id, String descripcion, String ubicacion, String anfitrion, int noInvitados, Fecha fecha){
        this.id = id;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.anfitrion = anfitrion;
        this.noInvitados = noInvitados;
        this.fecha = fecha;
        for (int i = 0; i < 20; i++) {
            invitados[i] = null;
        }
    }
    public Evento(){
        this.id = 0;
        this.descripcion = null;
        this.ubicacion = null;
        this.anfitrion = null;
        this.fecha = new Fecha();
        this.noInvitados = 0;
        for (int i = 0; i < 20; i++) {
            invitados[i] = null;
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getAnfitrion() {
        return anfitrion;
    }
    public void setAnfitrion(String anfitrion) {
        this.anfitrion = anfitrion;
    }
    public String getFecha() {
        return fecha.getFecha();
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    public int getNoInvitados() {
        return noInvitados;
    }
    public void setNoInvitados(int num) {
        this.noInvitados = num;
    }
    public String getInvitados(int num) {
        return invitados[num - 1];
    }
    public void setInvitados(String invitados, int no) {
        this.invitados[no - 1] = invitados;
    }
    public String getDatos(){
        String lista = """
                No.         invitado
                -----------------------------
                """;
        for (int i = 0; i < getNoInvitados(); i++) {
            lista += String.format("%02d  ", i+1) + invitados[i] + "\n";
        }
        return "\nID: " + getId() +
                "\nDescripcion: " + getDescripcion() +
                "\nUbicacion: " + getUbicacion() +
                "\nAnfitrion: " + getAnfitrion() +
                "\nNo. invitados: " + getNoInvitados() +
                "\nFecha: " + getFecha() + '\n' + lista;
    }
}
