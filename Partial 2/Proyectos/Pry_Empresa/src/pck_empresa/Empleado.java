package pck_empresa;

public class Empleado {
    protected int id;
    protected String nombre;
    protected final double SALARIO_BASE = 15000.00;
    protected int edad;

    public Empleado(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Empleado() {
        this(0, null, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSALARIO_BASE() {
        return SALARIO_BASE;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDatos() {
        return "\nID: " + getId() +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nSalario base: $" + getSALARIO_BASE();
    }
}
