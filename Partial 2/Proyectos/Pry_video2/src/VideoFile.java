import javax.swing.*;
import java.io.*;

public class VideoFile {
    public static void main(String[] args) {
        FileInputStream fiin = null;
        FileOutputStream fiout = null;

        Video[] v = new Video[3];
        v[0] = new Video(1424, "Halloween", "Nolan", 2020, "+18", "Terror");
        v[1] = new Video(1997, "Interstellar", "Nolan", 2014, "+18", "Sci-Fi");
        v[2] = new Video(2004, "Pinocho", "Del Toro", 2022, "+18", "Intriga");

        Video[] v1 = new Video[3];
        for (int i = 0; i < 3; i++)
            v1[i] = new Video();

        try{
            fiout = new FileOutputStream("Pelicula.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fiout);
            for (int i = 0; i < 3; i++)
                salida.writeObject(v[i]);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo para escritura");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error E/S" + e.getMessage());
        } finally {
            try {
                if (fiout != null)
                    fiout.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo" + e.getMessage());
            }
        }

        try {
            fiin = new FileInputStream("Pelicula.txt");
            ObjectInputStream entrada = new ObjectInputStream(fiin);
            int j = 0;
            while (true){
                v1[j] = (Video)entrada.readObject();
                j++;
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El objeto no se pudo convertir");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo para lectura");
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null, "Se terminó de leer el archivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error E/S" + e.getMessage());
        } finally {
            try {
                if (fiin != null)
                    fiin.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo" + e.getMessage(),
                        "Lectura de archivo", JOptionPane.WARNING_MESSAGE);
            }
        }

        for (Video vid : v1)
            JOptionPane.showMessageDialog(null, vid.getDatos());
    }
}
