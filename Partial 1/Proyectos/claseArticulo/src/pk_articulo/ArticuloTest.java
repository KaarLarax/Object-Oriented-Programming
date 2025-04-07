package pk_articulo;

import javax.swing.*;

public class ArticuloTest {
    public static void main(String[] args) {
        Articulo art1 = new Articulo();
        art1.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la id")));
        art1.setDescripcion(JOptionPane.showInputDialog(null, "Ingrese la descripcion"));
        art1.setMarca(JOptionPane.showInputDialog(null, "Ingrese la marca"));
        art1.setModelo(JOptionPane.showInputDialog(null, "Ingrese el modelo"));
        art1.setContenido(JOptionPane.showInputDialog(null, "Ingrese el contenido"));
        art1.setCategoria(JOptionPane.showInputDialog(null, "Ingrese la categoria"));
        art1.setPrecio(Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio")));
        art1.setEstatus(JOptionPane.showInputDialog(null, "Ingrese el estatus"));
        JOptionPane.showMessageDialog(null, art1.getDatos());
    }
}
