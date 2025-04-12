import pck_empleado.Empleado;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Empleado a = new Empleado();
        System.out.println(a.getDatos());
        Empleado b = new Empleado("String curp", "String nombre", 18, "String sexo",
                "String nacionalidad", 476759, "String departamento", 2023);
        for (int i = 0; i < 12; ++i) {
            b.setVentas(10001.23 + i, i);
        }
        JOptionPane.showMessageDialog(null, a.getDatos());


    }
}
