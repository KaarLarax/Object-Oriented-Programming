package pck_empleado;

import javax.swing.*;
import java.util.EmptyStackException;

public class Menu {
    public static void main(String[] args) {
        Empleado a = new Empleado();
        int opc;
        String copyright = """
                Desarrollador: Carlos Alberto Lara Hernandez
                -Licencia Creative Common
                No siempre llovera, pero siempre, mañana sera otro dia.""";
        String menu = """
            ----Menu----
            1) Alta de datos generales
            2) Ingresar una venta
            3) Consultar una venta
            4) Consultar datos y ventas
            5) Salir
            Elija una opcion:""";
        JOptionPane.showMessageDialog(null, copyright, "Copyright", JOptionPane.INFORMATION_MESSAGE);
        do {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas en el menu.", "Error", JOptionPane.WARNING_MESSAGE);
                opc = 0;
                continue;
            }
            switch (opc) {
                case 1:
                    a.setCurp(JOptionPane.showInputDialog(null, "Ingrese la curp"));
                    a.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre"));
                    while (true) {
                        try {
                            a.setNumeroEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de empleado")));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    while (true) {
                        try {
                            int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de venta"));
                            if (anio < 2000 || anio > 2023) {
                                throw new EmptyStackException();
                            }
                            a.setAnio(anio);
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.", "Error", JOptionPane.WARNING_MESSAGE);
                        } catch (EmptyStackException e) {
                            JOptionPane.showMessageDialog(null, "Año fuera de rango.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    a.setDepartamento(JOptionPane.showInputDialog(null, "Ingrese El departamento"));
                    while (true) {
                        try {
                            int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
                            if (edad < 18 || edad > 70) {
                                throw new EmptyStackException();
                            }
                            a.setEdad(edad);
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.", "Error", JOptionPane.WARNING_MESSAGE);
                        } catch (EmptyStackException e) {
                            JOptionPane.showMessageDialog(null, "Edad fuera de rango.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    a.setSexo(JOptionPane.showInputDialog(null, "Ingrese el sexo"));
                    a.setNacionalidad(JOptionPane.showInputDialog(null, "Ingrese la nacionalidad"));
                    break;
                case 2:
                    int mes;
                    while (true) {
                        try {
                            mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la venta"));
                            if (1<= mes && 12 >= mes) {
                                break;
                            }
                            throw new EmptyStackException();
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos, solo se aceptan entradas numericas...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        } catch (EmptyStackException c) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos, mes fuera de rango...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    double valor;
                    while (true) {
                        try {
                            valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la venta"));
                            if (valor >= 0) {
                                break;
                            }
                            throw new EmptyStackException();
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        } catch (EmptyStackException c) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos, las ventas no pueden ser negativas...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    a.setVentas(valor, mes);
                    JOptionPane.showMessageDialog(null, "Datos registrados");
                    break;
                case 3:
                    int mes1;
                    while (true) {
                        try {
                            mes1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la venta"));
                            if (1 <= mes1 && 12 >= mes1) {
                                break;
                            }
                            throw new EmptyStackException();
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        } catch (EmptyStackException e) {
                            JOptionPane.showMessageDialog(null, "Datos invalidos, valor fuera de rango...", "Fallo en entrada", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    double venta1 = a.getVentas(mes1);
                    if (venta1 < 0) {
                        JOptionPane.showMessageDialog(null,"Venta no registrada.");
                        continue;
                    }
                    JOptionPane.showMessageDialog(null,"Su venta del mes " + mes1 + " es de: " + venta1);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, a.getDatos());
                    for (int i = 1; i <= 12; i++) {
                        if (a.getVentas(i) >= 0) {
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