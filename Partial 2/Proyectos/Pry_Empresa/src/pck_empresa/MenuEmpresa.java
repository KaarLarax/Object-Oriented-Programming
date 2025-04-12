package pck_empresa;

import javax.swing.*;
import java.util.EmptyStackException;

public class MenuEmpresa {
    final static String MENU = """  
                --- MENU EMPLEADOS ---

                1) Agregar un empleado

                2) Consultar empleados dados de alta

                3) Consultar datos de un empleado
                                     
                4) Consultar datos de tipo de empleado
                   Especifico
                       
                5) Consultar Salarios
                              
                6) Salir""";
    public static void menu() {
        final int NO_EMPLEADOS = 11;
        Empleado[] empleados = new Empleado[NO_EMPLEADOS];
        int limitE = 0;
        boolean existeGerente = false, existeIngeniero = false;

        int opc;

        do {
            while (true) {
                try {
                    opc = Integer.parseInt(JOptionPane.showInputDialog(null, MENU));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                }
            }
            switch (opc) {
                case 1:
                    if (limitE < 10) {
                        int tipoEmpleado = ValidacionMenuTipoEmpleado();
                        empleados[limitE] = tipoEmpleado == 1 ? new Ingeniero() : new Gerente();
                        int idaux;
                        while (true) {
                            try {
                                idaux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la ID de su empleado."));
                                if (idaux < 0) {
                                    throw new EmptyStackException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "La id debe ser positiva.");
                            }
                        }
                        if (limitE > 0 && busquedaId(idaux, empleados, limitE) != -1) {
                            JOptionPane.showMessageDialog(null, "La ID ya existe, regresando al MENU.");
                            continue;
                        }
                        empleados[limitE].setId(idaux);
                        empleados[limitE].setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado"));
                        int edadAux;
                        while (true) {
                            try {
                                edadAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del empleado."));
                                if (edadAux < 0) {
                                    throw new EmptyStackException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "La edad debe ser positiva.");
                            }
                        }
                        empleados[limitE].setEdad(edadAux);
                        if (empleados[limitE] instanceof Ingeniero) { // si es ingeniero
                            existeIngeniero = true;
                            ((Ingeniero) empleados[limitE]).setEspecialidad(JOptionPane.showInputDialog(null, "Ingrese la especialidad"));
                            double comisionAux;
                            while (true) {
                                try {
                                    comisionAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la comision."));
                                    if (comisionAux < 0.00) {
                                        throw new EmptyStackException();
                                    }
                                    break;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                                } catch (EmptyStackException e) {
                                    JOptionPane.showMessageDialog(null, "La comision debe ser positiva.");
                                }
                            }
                            ((Ingeniero) empleados[limitE]).setComision(comisionAux);
                        } else { // Si es gerente
                            existeGerente = true;
                            ((Gerente) empleados[limitE]).setDepartamento(JOptionPane.showInputDialog(null, "Ingrese el departamento"));
                            double bonoAux;
                            while (true) {
                                try {
                                    bonoAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el bono."));
                                    if (bonoAux < 0.00) {
                                        throw new EmptyStackException();
                                    }
                                    break;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                                } catch (EmptyStackException e) {
                                    JOptionPane.showMessageDialog(null, "El bono debe ser positiva.");
                                }
                            }
                            ((Gerente) empleados[limitE]).setBono(bonoAux);
                            double prestacionesAux;
                            while (true) {
                                try {
                                    prestacionesAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese las prestaciones."));
                                    if (prestacionesAux < 0.00) {
                                        throw new EmptyStackException();
                                    }
                                    break;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                                } catch (EmptyStackException e) {
                                    JOptionPane.showMessageDialog(null, "Las prestaciones deben ser positiva.");
                                }
                            }
                            ((Gerente) empleados[limitE]).setPrestaciones(prestacionesAux);
                        }
                        JOptionPane.showMessageDialog(null, "Empleado Registrado.");
                        limitE++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista llena");
                    }
                    break;
                case 2:
                    if (limitE > 0) {
                        int tipoEmpleado = ValidacionMenuTipoEmpleado();
                        StringBuilder result;
                        if (tipoEmpleado == 2 && existeGerente) {
                            result = new StringBuilder("""
                                    Id Empleado     Nombre         Departamento
                                    -------------------------------------------
                                                                        
                                    """);
                            for (int i = 0; i < limitE; i++) {
                                Empleado aux = empleados[i];
                                if (aux instanceof Gerente) {
                                    result.append(aux.getId()).append("    ").append(aux.getNombre()).append("    ").
                                                                append(((Gerente) aux).getDepartamento()).append('\n');
                                }
                            }
                            JOptionPane.showMessageDialog(null, result.toString());
                        } else if (tipoEmpleado == 1 && existeIngeniero) {
                            result = new StringBuilder("""
                                    Id Empleado     Nombre         Especialidad
                                    -------------------------------------------
                                                                        
                                    """);
                            for (int i = 0; i < limitE; i++) {


                                Empleado aux = empleados[i];
                                if (aux instanceof Ingeniero) {
                                    result.append(aux.getId()).append("    ").append(aux.getNombre()).append("    ").append(((Ingeniero) aux).getEspecialidad()).append('\n');
                                }
                            }
                            JOptionPane.showMessageDialog(null, result.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No existen Empleados del tipo seleccionado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 3:
                    if (limitE > 0) {
                        int idAux = validacionIDJOptionPane();
                        int indexes = busquedaId(idAux, empleados, limitE);
                        if (indexes > -1) {
                            JOptionPane.showMessageDialog(null, empleados[indexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "ID no econtrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 4:
                    if (limitE > 0) {
                        int tipoEmpleado = ValidacionMenuTipoEmpleado();
                        int idAux = validacionIDJOptionPane();
                        int indexes = busquedaId(idAux, empleados, limitE, tipoEmpleado);
                        if (indexes > -1) {
                            JOptionPane.showMessageDialog(null, empleados[indexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "ID no econtrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 5:
                    if (limitE > 0) {
                        String salarios = getSalariosEmpleados(limitE, empleados);
                        JOptionPane.showMessageDialog(null, salarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 6:
                    String copyright = """
                            Desarrollador: Carlos Alberto Lara Hernandez.
                            -ALL WE NEED IS LOVE.""";
                    JOptionPane.showMessageDialog(null, copyright);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida..\nRegresando al menú.");
            }
        } while (opc != 6);
    }

    private static int ValidacionMenuTipoEmpleado() {
        final String MENU_TIPO_EMPLEADO = """
                1) Ingeniero
                2) Gerente""";

        int tipoEmpleado;

        while (true) {
            try {
                tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(null, MENU_TIPO_EMPLEADO));
                if (tipoEmpleado != 2 && tipoEmpleado != 1) {
                    throw new EmptyStackException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(null, "Opcion inexistente.");
            }
        }
        return tipoEmpleado;
    }

    private static String getSalariosEmpleados(int limitE, Empleado[] empleados) {
        StringBuilder salarios = new StringBuilder("""
                -----------------SALARIOS-----------------
                NOMBRE                        SALARIO NETO
                """);
        for (int i = 0; i < limitE; i++) {
            salarios.append(empleados[i].getNombre()).append("    $");
            if (empleados[i] instanceof Ingeniero) {
                salarios.append(((Ingeniero) empleados[i]).getSalario());
            } else {
                salarios.append(((Gerente) empleados[i]).getSalario());
            }
        }
        return salarios.toString();
    }

    private static int validacionIDJOptionPane() {
        int idAux;
        while (true) {
            try {
                idAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la ID a buscar."));
                if (idAux < 0) {
                    throw new EmptyStackException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(null, "La ID debe ser positiva.");
            }
        }
        return idAux;
    }

    public static int busquedaId(int id, Empleado[] empleados, int limit) {
        for (int i = 0; i < limit; i++) {
            if (empleados[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaId(int id, Empleado[] empleados, int limit, int tipoEmpleado) {
        if (tipoEmpleado == 1) {
            for (int i = 0; i < limit; i++) {
                if (empleados[i] instanceof Ingeniero && empleados[i].getId() == id) {
                    return i;
                }
            }
        } else if (tipoEmpleado == 2) {
            for (int i = 0; i < limit; i++) {
                if (empleados[i] instanceof Gerente && empleados[i].getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }
}
