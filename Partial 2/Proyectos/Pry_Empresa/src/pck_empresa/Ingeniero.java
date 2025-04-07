package pck_empresa;

public class Ingeniero extends Empleado {
    private String especialidad;
    private double comision;
    private static double impuesto = 0.16;

    public Ingeniero(int id, String nombre, int edad, String departamento, double bono) {
        super(id, nombre, edad);
        this.especialidad = departamento;
        this.comision = bono;
    }

    public Ingeniero() {
        this(0, null, 0, "", 0.0);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public static double getImpuesto() {
        return impuesto;
    }

    public static void setImpuesto(double impuesto) {
        Ingeniero.impuesto = impuesto;
    }

    public double getSalario() {
        double SalarioBruto = getSALARIO_BASE() + getComision();
        return SalarioBruto * (1.00 - getImpuesto());
    }

    @Override
    public String getDatos() {
        return """
                ----------INGENIERO----------""" + super.getDatos() +
                "\nEspecialiad: " + getEspecialidad() +
                "\nComision : $" + getComision() +
                "\nSalario Neto: $" + getSalario();

    }
}
