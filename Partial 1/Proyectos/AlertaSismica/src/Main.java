import xd_pakc.ActividadSismica;


import javax.swing.*;


public class Main {
    public static void main(String[] args) {
       ActividadSismica actopan = new ActividadSismica();
         actopan.setLocalidad(JOptionPane.showInputDialog(null, "Ingrese la localizacion de la actividad sismica"));
         actopan.setMes(JOptionPane.showInputDialog(null, "Ingrese el mes de la actividad sismica"));
        while (true) {
            try {
                actopan.setDay(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de la actividad sismica")));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.","Error de entrada", JOptionPane.WARNING_MESSAGE);
            }
        }
        int hora;
        while (true) {
            try {
                hora = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la hora que desea registrar"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.","Error de entrada", JOptionPane.WARNING_MESSAGE);
            }
        }
        float val;
        while (true) {
            try {
                val = Float.parseFloat(JOptionPane.showInputDialog(null, ("Ingrese el valor de la hora " + hora)));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan entradas numericas.","Error de entrada", JOptionPane.WARNING_MESSAGE);
            }
        }
        actopan.setHoras(hora, val);
        JOptionPane.showMessageDialog(null, actopan.getDatos(), "Datos Completos", JOptionPane.INFORMATION_MESSAGE);
    }
}
