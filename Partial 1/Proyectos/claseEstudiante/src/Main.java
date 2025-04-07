import pk_estudiante.Estudiante;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Prueba de primer constructor ocupando el default
        Estudiante a = new Estudiante();
        JOptionPane.showMessageDialog(null, a.getDatos());
        // Prueba de segundo constructor, usando argumentos
        Estudiante b = new Estudiante(476759, "Carlos Alberto", 3, 1, "LCC",
                                9.3f, "Matutino", "Activo");
        JOptionPane.showMessageDialog(null, b.getDatos());
        // Prueba de dialogos de entrada en clase Estudiante
        Estudiante c = new Estudiante();
        c.setNombre(JOptionPane.showInputDialog(null, "Ingresa el nombre: "));
        c.setNoCuenta(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el No. de Cuenta: ")));
        c.setSemestre(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: ")));
        c.setGrupo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el grupo: ")));
        c.setCarrera(JOptionPane.showInputDialog(null, "Ingresa la carrera: "));
        c.setPromedio(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa el promedio: ")));
        c.setTurno(JOptionPane.showInputDialog(null, "Ingresa el turno: "));
        c.setEstatus(JOptionPane.showInputDialog(null, "Ingresa el estatus: "));
        JOptionPane.showMessageDialog(null, c.getDatos());
    }
}
