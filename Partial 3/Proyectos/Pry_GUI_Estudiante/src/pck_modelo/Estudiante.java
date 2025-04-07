package pck_modelo;

public class Estudiante {
     private int noCuenta;
    private String nombre;
    private int semestre;
    private int grupo;
    private String carrera;
    private String turno;
    private float promGeneral;
    private String status;

    public Estudiante(int noCuenta, String nombre, int semestre, int grupo,
            String carrera, String turno, float promGeneral, String status) {
        this.noCuenta = noCuenta;
        this.nombre = nombre;
        this.semestre = semestre;
        this.grupo = grupo;
        this.carrera = carrera;
        this.turno = turno;
        this.promGeneral = promGeneral;
        this.status = status;
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

    public void setPromGeneral(float promGeneral) {
        this.promGeneral = promGeneral;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public float getPromGeneral() {
        return promGeneral;
    }

    public String getTurno() {
        return turno;
    }

    public String getStatus() {
        return status;
    }
    
    public String getDatos(){
        return "----------ESTUDIANTE----------\n" +
                "Numero de cuenta: " + getNoCuenta() +
                "\nNombre: " + getNombre() +
                "\nSemestre: " + getSemestre() +
                "\nGrupo: " + getGrupo() +
                "\nCarrera: " + getCarrera() +
                "\nPromedio general: " + getPromGeneral() +
                "\nTurno: " + getTurno() +
                "\nEstatus: " + getStatus();
    }   
}
