import pck_evento.Evento;
import pck_fecha.Fecha;


import javax.swing.*;
import java.util.EmptyStackException;

public class EventoTest {
    public static void main(String[] args) {
        Evento[] eventos = new Evento[10];
        for (int i = 0; i < 10; i++) {
            eventos[i] = new Evento();
        }
        int limitP = 0;
        String menu = """  
                --- MENU EVENTOS ---

                1) Agregar un evento

                2) Consultar eventos dados de alta

                3) Consultar detalle de un evento

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
                        if (limitP > 0 && buscquedaId(idaux, eventos, limitP) != -1) {
                            JOptionPane.showMessageDialog(null, "La ID ya existe, regresando al menu.");
                            continue;
                        }
                        eventos[limitP].setId(idaux);
                        eventos[limitP].setDescripcion(JOptionPane.showInputDialog(null, "Ingrese la descripcion del evento"));
                        eventos[limitP].setUbicacion(JOptionPane.showInputDialog(null, "Ingrese la ubicacion del evento"));
                        eventos[limitP].setAnfitrion(JOptionPane.showInputDialog(null, "Ingrese el anfitrion del evento"));
                        int noInvitadosAux;
                        while (true) {
                            try {
                                noInvitadosAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de invitados del evento."));
                                if (noInvitadosAux < 0) {
                                    throw new EmptyStackException();
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "El numero de invitados debe ser positivo.");
                            }
                        }
                        eventos[limitP].setNoInvitados(noInvitadosAux);
                        Fecha fechaAux = new Fecha();
                        String dateString;
                        while (true) {
                            dateString = JOptionPane.showInputDialog(null, "Ingrese la fecha en formato abreviado.(dd/mm/aaaa)");
                            if (fechaAux.convertirFecha(dateString)) {
                                eventos[limitP].setFecha(fechaAux);
                                JOptionPane.showMessageDialog(null, "Fecha registrada.");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Fecha invalida.");
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Evento Registrado.");
                        limitP++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista llena");
                    }
                    break;
                case 2:
                    if (limitP > 0) {
                        StringBuilder result = new StringBuilder();
                        result.append("""
                                Id Evento       Descripción            Anfitrion          Fecha     No.Invitados
                                                            
                                    -----------------------------------------------------------------------------
                                    """);
                        for (int i = 0; i < limitP; i++) {
                            result.append(eventos[i].getId()).append("      ").
                                    append(eventos[i].getDescripcion()).append("      ").
                                    append(eventos[i].getAnfitrion()).append("      ").
                                    append(eventos[i].getFecha()).append("      ").
                                    append(String.format("%02d\n", eventos[i].getNoInvitados()));
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
                        int indexes = buscquedaId(idaux, eventos, limitP);
                        if (indexes > -1) {
                            JOptionPane.showMessageDialog(null, eventos[indexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "ID no econtrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 4:
                    String copyright = """
                            Desarrollador: Carlos Alberto Lara Hernandez.
                            -ALL WE NEED IS LOVE.""";
                    JOptionPane.showMessageDialog(null, copyright);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida..\nRegresando al menú.");
            }
        } while (opc != 4);
    }

    public static int buscquedaId(int id, Evento[] eventos, int limit) {
        for (int i = 0; i < limit; i++) {
            if (eventos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
