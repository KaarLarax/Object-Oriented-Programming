package pck_video;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class TestVideo {
    public static final String MENU = """
            1)     Agregar un elemento
                
            2)     Buscar un elemento
                
            3)     Eliminar un elemento
                
            4)     Salir
            """;

    public static void menu() {

        ArrayList<Video> listaVideos = new ArrayList<>();
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
                    String titleAux = JOptionPane.showInputDialog(null, "Ingrese el titulo");
                    if (listaVideos.stream().filter(video -> video.getTitulo().equals(titleAux)).
                                findFirst().orElse(null) != null) {
                        JOptionPane.showMessageDialog(null, "Titulo encontrado, regresando al menú.");
                        continue;
                    }
                    Video videoAux = new Video();
                    videoAux.setTitulo(titleAux);
                    videoAux.setProductor(JOptionPane.showInputDialog(null, "Ingrese el nombre del productor"));
                    int anioAux = validacionIntJOptionPane();
                    videoAux.setAnioEstreno(anioAux);
                    videoAux.setClasificacion(JOptionPane.showInputDialog(null, "Ingrese la clasificacion."));
                    videoAux.setGenero(JOptionPane.showInputDialog(null, "Ingrese el genero."));
                    listaVideos.add(videoAux);
                    JOptionPane.showMessageDialog(null, "Video Registrado.");
                    break;
                case 2:
                    if (!listaVideos.isEmpty()) {
                        String titleAux1 = JOptionPane.showInputDialog(null, "Ingrese el titulo");
                        Video videoAux1 = listaVideos.stream().filter(video -> video.getTitulo().equals(titleAux1)).findFirst().orElse(null);
                        if (videoAux1 != null) {
                           JOptionPane.showMessageDialog(null,  videoAux1.getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "Video no encontrado, regresando al menú.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vacia.");
                    }
                    break;
                case 3:
                    if (!listaVideos.isEmpty()) {
                        String titleAux1 = JOptionPane.showInputDialog(null, "Ingrese el titulo del video a eliminar");
                        Video videoAux1 = listaVideos.stream().filter(video -> video.getTitulo().
                                        equals(titleAux1)).
                                        findFirst().orElse(null);
                        if (videoAux1 != null) {
                            listaVideos.remove(videoAux1);
                            JOptionPane.showMessageDialog(null, "Video Borrado");
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null, "Titulo no encontrado, regresando al menú.");
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

    private static int validacionIntJOptionPane() {
        int intAux;
        while (true) {
            try {
                intAux = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de estreno de la pelicula"));
                if (intAux < 1888) {
                    throw new EmptyStackException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se adminten entradas numericas.");
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(null, "No se admiten fechas menor al año 1888.");
            }
        }
        return intAux;
    }
}
