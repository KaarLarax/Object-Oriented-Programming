package pk_estudiante;

public class Estudiante {
    private int noCuenta;
    private String nombre;
    private int semestre;
    private int grupo;
    private String carrera;
    private float promedio;
    private String turno;
    private String estatus;

    public Estudiante() {
        promedio = semestre = grupo = 0;
        carrera = turno = estatus = null;

    }

    public Estudiante(int noCuenta, String nombre, int semestre, int grupo, String carrera,
                      float promedio, String turno, String estatus) {
        this.noCuenta = noCuenta;
        this.nombre = nombre;
        this.semestre = semestre;
        this.grupo = grupo;
        this.carrera = carrera;
        this.promedio = promedio;
        this.turno = turno;
        this.estatus = estatus;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getGrupo() {
        return grupo;
    }

    public String getCarrera() {
        return carrera;
    }

    public float getPromedio() {
        return promedio;
    }

    public String getTurno() {
        return turno;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDatos() {
        return "\tEstudiante" +
                "\n No.Cuenta: " + getNoCuenta() +
                "\n Nombre: " + getNombre() +
                "\n Semestre: " + getSemestre() +
                "\n Grupo: " + getGrupo() +
                "\n Carrera: " + getCarrera() +
                "\n Promedio: " + getPromedio() +
                "\n Turno: " + getTurno() +
                "\n Estatus: " + getEstatus();
    }
}
