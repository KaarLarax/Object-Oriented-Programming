package pk_bibloteca;

import javax.swing.*;
import java.util.EmptyStackException;

public class MenuBibloteca {

    public static int arrFind(String referencia, Libro[] arr, int limit) {
        int index = -1;
        for (int i = 0; i < limit; i++) {
            if (referencia.equals(arr[i].referencia)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int arrFind(String referencia, Revista[] arr, int limit) {
        for (int i = 0; i < limit; i++) {
            if (referencia.equals(arr[i].referencia)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Libro[] biblotecaLibros1 = new Libro[10];
        Revista[] biblotecaRevistas1 = new Revista[10];
        int librosIngresados = 0, revistasIngresadas = 0;
        String menu = """
                           --- BIBLIOTECA ---
                                
                1)     Agregar un libro
                                
                2)     Agregar una revista
                                
                3)     Listar libros
                                
                4)     Listar revistas
                                
                5)     Ver detalle de un libro
                                
                6)     Ver detalle de una revista
                                
                7)     Salir""";
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
                    if (librosIngresados < 10) {
                        String auxReferencia = JOptionPane.showInputDialog(null, "Ingrese la referencia del libro");
                        if (librosIngresados > 0 && arrFind(auxReferencia, biblotecaLibros1, librosIngresados) >= 0) {
                            JOptionPane.showMessageDialog(null, "Referencia ya existente, regresando al menú.");
                            continue;
                        }
                        Libro auxL = new Libro();
                        auxL.setReferencia(auxReferencia);
                        auxL.setTitulo(JOptionPane.showInputDialog(null, "Ingrese el titulo del libro"));
                        auxL.setAutor(JOptionPane.showInputDialog(null, "Ingrese el nombre del autor"));
                        auxL.setEditorial(JOptionPane.showInputDialog(null, "Ingrese la editorial"));
                        int pag;
                        while (true) {
                            try {
                                pag = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de paginas"));
                                if (pag < 0) {
                                    throw new EmptyStackException(); // Exception utilizada para forzar la entrada a un catch
                                }
                                auxL.setNoPaginas(pag);
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "Valor negativo, dato invalido.");
                            }
                        }
                        biblotecaLibros1[librosIngresados] = auxL;
                        librosIngresados++;
                        JOptionPane.showMessageDialog(null, "Registro exitoso..");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bibloteca llena.");
                    }
                    break;
                case 2:
                    if (revistasIngresadas < 10) {
                        String auxReferencia = JOptionPane.showInputDialog(null, "Ingrese la referencia de la revista");
                        if (revistasIngresadas > 0 && arrFind(auxReferencia, biblotecaRevistas1, revistasIngresadas + 1) >= 0) {
                            JOptionPane.showMessageDialog(null, "Referencia ya existente, regresando al menú.");
                            continue;
                        }
                        Revista auxR = new Revista();
                        auxR.setReferencia(auxReferencia);
                        auxR.setTitulo(JOptionPane.showInputDialog(null, "Ingrese el titulo de la revista"));
                        int anio;
                        while (true) {
                            try {
                                anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de la revista"));
                                auxR.setAnio(anio);
                                if (anio < 1900 || anio > 2060) {
                                    throw new EmptyStackException(); // Excepcion utilizada para forzar la entrada a un catch
                                }
                                 break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "Años invalidos, el rango es de 1900 a 2060");
                            }
                        }
                        int numero;
                        while (true) {
                            try {
                                numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de la revista"));
                                auxR.setNumero(numero);
                                if (numero < 1) {
                                    throw new EmptyStackException(); // Excepcion utilizada para forzar la entrada a un catch
                                }
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.");
                            } catch (EmptyStackException e) {
                                JOptionPane.showMessageDialog(null, "Numero invalido, valor invalido.");
                            }
                        }
                        biblotecaRevistas1[revistasIngresadas] = auxR;
                        revistasIngresadas++;
                        JOptionPane.showMessageDialog(null, "Registro exitoso..");
                    } else {
                        JOptionPane.showMessageDialog(null, "Bibloteca llena");
                    }
                    break;
                case 3:
                    if (librosIngresados > 0) {
                        StringBuilder tempLibro = new StringBuilder();
                        for (int i = 0; i < librosIngresados; i++) {
                            Libro libros = biblotecaLibros1[i];
                            tempLibro.append("""
                                    ---------------
                                    Libro #""").append(i + 1).append('\n').append(libros.getDatos());
                        }
                        JOptionPane.showMessageDialog(null, tempLibro.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "La bibloteca de libros está vacia.");
                    }
                break;
                case 4:
                    if (revistasIngresadas > 0) {
                        StringBuilder tempRevista = new StringBuilder();
                        for (int i = 0; i < revistasIngresadas; i++) {
                            Revista revista = biblotecaRevistas1[i];
                            tempRevista.append("""
                                    ---------------
                                    Revista #""").append(i + 1).append('\n').append(revista.getDatos());
                        }
                        JOptionPane.showMessageDialog(null, tempRevista.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "La bibloteca de revistas está vacia.");
                    }
                break;
                case 5:
                    if (librosIngresados > 0) {
                        String targetReference = JOptionPane.showInputDialog(null, "Ingrese la referencia del libro a buscar");
                        int targetIndexes = arrFind(targetReference, biblotecaLibros1, librosIngresados);
                        if (targetIndexes >= 0) {
                            JOptionPane.showMessageDialog(null, "Referencia encontrada.\n" + biblotecaLibros1[targetIndexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "Referencia no encontrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La bibloteca de libros está vacia.");
                    }
                break;
                case 6:
                    if (revistasIngresadas > 0) {
                        String targetReference = JOptionPane.showInputDialog(null, "Ingrese la referencia de la revista a buscar");
                        int targetIndexes = arrFind(targetReference, biblotecaRevistas1, revistasIngresadas);
                        if (targetIndexes >= 0) {
                            JOptionPane.showMessageDialog(null, "Referencia encontrada.\n" + biblotecaRevistas1[targetIndexes].getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "Referencia no encontrada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La bibloteca de revistas está vacia.");
                    }
                break;
                case 7:
                    String copyright = """
                            Desarrollador: Carlos Alberto Lara Hernandez.
                            -ALL WE NEED IS LOVE.""";
                    JOptionPane.showMessageDialog(null, copyright);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida..\nRegresando al menú.");
            }
        } while (opc != 7);
    }
}
