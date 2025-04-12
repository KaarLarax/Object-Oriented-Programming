package pck_empleado;

import javax.swing.*;

public class Menu {
    public static String copyright = """
        Desarrolladores: Carlos Alberto Lara Hernandez
        Licencia Creative Commons.
        -No siempre llovera, pero siempre, mañana sera otro dia.""";

    public static void main(String[] args) {
        Empleado a = new Empleado();
        int opc;
        String menu = """
            ----Menu----
            1) Alta de datos generales
            2) Ingresar una venta
            3) Consultar una venta
            4) Consultar datos y ventas
            5) Salir
            Elija una opcion:""";
        JOptionPane.showMessageDialog(null,Menu.copyright, "Copyright", JOptionPane.INFORMATION_MESSAGE);
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            switch (opc) {
                case 1:
                    a.setCurp(JOptionPane.showInputDialog(null, "Ingrese la curp"));
                    a.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre"));
                    a.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad")));
                    a.setSexo(JOptionPane.showInputDialog(null, "Ingrese el sexo"));
                    a.setNacionalidad(JOptionPane.showInputDialog(null, "Ingrese la nacionalidad"));
                    a.setNumeroEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de empleado")));
                    a.setDepartamento(JOptionPane.showInputDialog(null, "Ingrese El departamento"));
                    a.setAnio(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de venta")));
                    break;
                case 2:
                    int mes;
                    while (true) {
                        mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la venta"));
                        if (1<= mes && 12 >= mes) {
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Datos invalidos...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                    }
                    double valor;
                    while (true) {
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la venta"));
                        if (valor >= 0) {
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Datos invalidos...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                    }
                    a.setVentas(valor, mes);
                    JOptionPane.showMessageDialog(null, "Datos registrados");
                    break;
                case 3:
                    int aux2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la venta"));
                    double aux = a.getVentas(aux2);
                    JOptionPane.showMessageDialog(null,"Su venta del mes " + aux2 + " es de: " + aux);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, a.getDatos());
                    for (int i = 1; i <= 12; i++) {
                        if (a.getVentas(i) > 0) {
                            JOptionPane.showMessageDialog(null, "MES: " + i + "\nVenta: " + a.getVentas(i));
                        }

                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Byeeeee.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while(opc != 5);
        JOptionPane.showMessageDialog(null, """
                Gracias por usar el programa
                Creado por Carlos Alberto Lara Hernandez
                ALL WE NEED IS LOVE.""","Despedida", JOptionPane.PLAIN_MESSAGE);
    }
}
