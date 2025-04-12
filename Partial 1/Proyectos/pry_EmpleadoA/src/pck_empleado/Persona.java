package pck_empleado;

public class Persona {
    private String curp;
    private String nombre;
    private int edad;
    private String sexo;
    private String nacionalidad;

    public Persona(String curp, String nombre, int edad, String sexo, String nacionalidad) {
        this.curp = curp;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }

    public Persona() {
        curp = nombre = sexo = nacionalidad = null;
        edad = 0;
    }

    public void setCurp(String curp) {
        this.curp = curp.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCurp() {
        return curp;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public String getDatos() {
        return "Curp: " + getCurp() +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nSexo: " + getSexo() +
                "\nNacionalidad: " + getNacionalidad();

    }
}
