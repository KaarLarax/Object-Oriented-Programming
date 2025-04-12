package pck_empleado;


public class Empleado extends Persona{
    private int numeroEmpleado;
    private String departamento;
    private int anio;
    private double[] ventas = new double[12];

    public Empleado(String curp, String nombre, int edad, String sexo, String nacionalidad,
                    int numeroEmpleado, String departamento, int anio) {
        super(curp, nombre, edad, sexo, nacionalidad);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.anio = anio;
        for (int i = 0; i < 12; ++i) ventas[i] = -1.0;
    }

    public Empleado() {
        super();
        anio = numeroEmpleado = 0;
        departamento = null;
        for (int i = 0; i < 12; ++i) ventas[i] = -1.0;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setVentas(double venta, int mes) {
        this.ventas[mes - 1] = venta;
    }
    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getAnio() {
        return anio;
    }

    public double getVentas(int mes) {
        return ventas[mes - 1];
    }

    @Override
    public String getDatos() {
        String tabla = "";
        for (int i = 1; i <= 12; i++) {
            tabla += "\nMes " + i + ": " + getVentas(i);
        }
        return "\nNumero de cuenta: " + getNumeroEmpleado() +
                "\nDepartamento: " + getDepartamento() +
                "\nAño de venta: " + getAnio() + '\n' +
                super.getDatos() +
                "Ventas\n________________________" +
                tabla;
    }
}