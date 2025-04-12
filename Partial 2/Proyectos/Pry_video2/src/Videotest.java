import javax.swing.*;
import java.util.ArrayList;

public class Videotest {
    public static void main(String[] args) {
        ArrayList<Video> misVideos = new ArrayList<>();
        Video v1 = new Video();
        int id, pos = -1, res;

        v1.setId(123);
        v1.setTitulo(" el jajas");
        v1.setDirector(" el risas");
        v1.setAnioEstreno(2019);
        v1.setClasificacion(" mubi");
        v1.setGenero(" risas");

        misVideos.add(v1);
        misVideos.add(new Video(124, "IA", "juakin", 2020, "no c", "no c je"));
        misVideos.add(new Video(125, "jujue", "no juakin", 2020, "no c", "no c je"));


        for (int i = 0; i < misVideos.size(); i++)
            JOptionPane.showMessageDialog(null, misVideos.get(i).getDatos());

        id = Integer.parseInt(JOptionPane.showInputDialog("Id del video: "));
        for (int i = 0; i < misVideos.size(); i++) {
            if (id == misVideos.get(i).getId()){
                pos = i;
                JOptionPane.showMessageDialog(null, misVideos.get(i).getDatos(), "Video buscado", 1);
                break;
            }
            if (pos == -1)
                JOptionPane.showMessageDialog(null, "No se encontró el video");
        }

        id = Integer.parseInt(JOptionPane.showInputDialog("Id del video a eliminar: "));
        for (int i = 0; i < misVideos.size(); i++) {
            if (id == misVideos.get(i).getId()){
                pos = i;
                JOptionPane.showMessageDialog(null, misVideos.get(i).getDatos(), "Video encontrado", 1);
                res = JOptionPane.showConfirmDialog(null, "Eliminar?");
                if (res == JOptionPane.OK_OPTION) {
                    misVideos.remove(pos);
                    JOptionPane.showMessageDialog(null, "Eliminado");
                    for (Video v: misVideos)
                        JOptionPane.showMessageDialog(null, v.getDatos());
                }
                break;
            }
            if (pos == -1)
                JOptionPane.showMessageDialog(null, "No se encontró el video");
        }
    }
}
