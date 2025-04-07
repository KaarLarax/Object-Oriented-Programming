// Lara Hernandez Carlos Alberto
// Sánchez Azpeitia Josue Orlando
// So you think, my heart is made of stone.

import pck_fecha.Fecha;
import pck_perecedero.Perecedero;

import javax.swing.*;

import java.util.EmptyStackException;

public class MenuPerecedero {

    public static void main(String[] args) {
        Perecedero[] listaPerecedero = new Perecedero[10];
        for (int i = 0; i < 10; i++) {
            listaPerecedero[i] = new Perecedero();
        }
        int limitP = 0;
        String menu = """  
                --- MENU ARTICULOS ---

                1) Agregar un artículo

                2) Consultar artículos dados de alta

                3) Consultar detalle de un artículo

                 4) Salir""";
        int opc;
        do {
            while (true) {
                try {
                    opc = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                }
            }
            switch (opc) {
                case 1:
                    if (limitP < 10) {
                        int idaux;
                        while (true) {
                            try {
                                idaux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la ID de su perecedero."));
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
                        if (limitP > 0 && buscquedaId(idaux, listaPerecedero, limitP) != -1) {
                            JOptionPane.showMessageDialog(null, "La ID ya existe, regresando al menu.");
                            continue;
                        }
                        listaPerecedero[limitP].setId(idaux);
                        listaPerecedero[limitP].setDescripcion(JOptionPane.showInputDialog(null, "Ingrese la descripcion del perecedero"));
                        listaPerecedero[limitP].setMarca(JOptionPane.showInputDialog(null, "Ingrese la marca del perecedero"));
                        listaPerecedero[limitP].setContenido(JOptionPane.showInputDialog(null, "Ingrese el contenido del perecedero"));
                        listaPerecedero[limitP].setModelo(JOptionPane.showInputDialog(null, "Ingrese el modelo del perecedero"));
                        listaPerecedero[limitP].setCategoria(JOptionPane.showInputDialog(null, "Ingrese la categoria del perecedero"));
                        float precioAux;
                        while (true) {
                            try {
                                precioAux = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio del perecedero"));
                                if (precioAux < 0.0f) {
                                    throw new EmptyStackException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se admiten entradas numericas");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "Solo se admiten precios positivos.");
                            }
                        }
                        listaPerecedero[limitP].setPrecio(precioAux);
                        listaPerecedero[limitP].setEstado(JOptionPane.showInputDialog(null, "Ingrese el estado del perecedero"));
                        String dateStringE;
                        Fecha fechaElaboracionAux = new Fecha();
                        while (true) {
                            dateStringE = JOptionPane.showInputDialog(null, "Ingrese la fecha de elaboracion en formato abreviado.(dd/mm/aaaa)");
                            if (fechaElaboracionAux.convertirFecha(dateStringE)) {
                                listaPerecedero[limitP].setFechaElaboracion(fechaElaboracionAux);
                                JOptionPane.showMessageDialog(null, "Fecha de elaboracion registrada.");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Fecha invalida.");
                            }
                        }
                        String dateStringC;
                        Fecha fechaCaducidadAux = new Fecha();
                        while (true) {
                            dateStringC = JOptionPane.showInputDialog(null, "Ingrese la fecha de caducidad en formato abreviado.(dd/mm/aaaa)");
                            if (fechaCaducidadAux.convertirFecha(dateStringC)) {
                                if (!fechasValidas(fechaElaboracionAux, fechaCaducidadAux)) {
                                    JOptionPane.showMessageDialog(null, "La fecha de caducidad debe ser despues de la fecha de elaboracion.");
                                    continue;
                                }
                                listaPerecedero[limitP].setFechaCaducidad(fechaCaducidadAux);
                                JOptionPane.showMessageDialog(null, "Fecha de caducidad registrada.");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Fecha invalida.");
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Perecedero Registrado.");
                        limitP++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista llena");
                    }
                    break;
                case 2:
                    if (limitP > 0) {
                        StringBuilder result = new StringBuilder();
                        result.append("""
                                Id Articulo       Descripción               Marca                 Fecha de Caducidad
                                                            
                                    --------------------------------------------------------------------
                                    """);
                        for (int i = 0; i < limitP; i++) {
                            result.append(listaPerecedero[i].getId()).append("      ").
                                    append(listaPerecedero[i].getDescripcion()).append("      ").
                                    append(listaPerecedero[i].getMarca()).append("      ").
                                    append(listaPerecedero[i].getFechaCaducidad()).append('\n');
                        }
                        JOptionPane.showMessageDialog(null, result);
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 3:
                    if (limitP > 0) {
                        int idaux;
                        while (true) {
                            try {
                                idaux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la ID a buscar."));
                                if (idaux < 0) {
                                    throw new EmptyStackException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "La ID debe ser positiva.");
                            }
                        }
                        int indexes = buscquedaId(idaux, listaPerecedero, limitP);
                        if (indexes > -1) {
                            JOptionPane.showMessageDialog(null, listaPerecedero[indexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "ID no econtrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 4:
                    String copyright = """
                            Desarrolladores: Carlos Alberto Lara Hernandez y Josué Orlando Sanchez Azpeitia.
                            -ALL WE NEED IS LOVE.""";
                    JOptionPane.showMessageDialog(null, copyright);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida..\nRegresando al menú.");
            }
        } while (opc != 4);
    }

    public static int buscquedaId(int id, Perecedero[] perecederos, int limit) {
        for (int i = 0; i < limit; i++) {
            if (perecederos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static boolean fechasValidas(Fecha fechaElaboracion, Fecha fechaCaducidad) {
        if (fechaElaboracion.getAnio() < fechaCaducidad.getAnio()) {
            return true;
        }
        if (fechaElaboracion.getAnio() == fechaCaducidad.getAnio() && fechaElaboracion.getMes() < fechaCaducidad.getMes()) {
            return true;
        }
        return fechaElaboracion.getAnio() == fechaCaducidad.getAnio() &&
                fechaElaboracion.getMes() == fechaCaducidad.getMes() &&
                fechaElaboracion.getDia() < fechaCaducidad.getDia();
    }
}
