package pck_empresa;

public class Gerente extends Empleado {
    private String departamento;
    private double bono;
    private double prestaciones;

    private static double impuesto = 0.28;

    public Gerente(int id, String nombre, int edad, String departamento, double bono, double prestaciones) {
        super(id, nombre, edad);
        this.departamento = departamento;
        this.bono = bono;
        this.prestaciones = prestaciones;
    }

    public Gerente() {
        this(0, null, 0, "", 0.0, 0.0);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(double prestaciones) {
        this.prestaciones = prestaciones;
    }

    public static double getImpuesto() {
        return impuesto;
    }

    public static void setImpuesto(double impuesto) {
        Gerente.impuesto = impuesto;
    }

    public double getSalario() {
        double SalarioBruto = getSALARIO_BASE() + getPrestaciones() + getBono();
        return SalarioBruto * (1 - getImpuesto());
    }

    @Override
    public String getDatos() {
        return """
                ----------GERENTE----------""" + super.getDatos() +
                "\nDepartamento: " + getDepartamento() +
                "\nBono: $" + getBono() +
                "\nPrestaciones: $" + getPrestaciones() +
                "\nSalario Neto: $" + getSalario();

    }
}
