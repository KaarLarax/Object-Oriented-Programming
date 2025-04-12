package pk_modelo;

import java.sql.PreparedStatement;
import java.sql.Date;
import javax.swing.JOptionPane;
import pk_conexion.C_Conexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Producto_BD {

    private PreparedStatement PS;
    private final C_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;

    public Producto_BD() {
        this.PS = null;
        this.CN = new C_Conexion();
    }

    private DefaultTableModel setTitulos() {
        DTM = new DefaultTableModel();
        DTM.addColumn("Id. producto");
        DTM.addColumn("Descripcion");
        DTM.addColumn("Marca");
        DTM.addColumn("Contenido");
        DTM.addColumn("Precio");
        DTM.addColumn("Categoria");
        DTM.addColumn("Estado");
        DTM.addColumn("F. Elaboracion");
        DTM.addColumn("F. Caducidad");
        return DTM;
    }

    public int insertarDatos(int id, String desc, String marca, float precio, String contenido, String categoria,
            String estado, Date fElab, Date fCad) {
        int res = 0;
        String SQL_INSERT = "INSERT INTO tablaproducto(idArticulo, descripcion, marca,precio,contenido,categoria,estado,fElab,fCad) values (?,?,?,?,?,?,?,?,?)";
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setInt(1, id);
            PS.setString(2, desc);
            PS.setString(3, marca);
            PS.setFloat(4, precio);
            PS.setString(5, contenido);
            PS.setString(6, categoria);
            PS.setString(7, estado);
            PS.setDate(8, fElab);
            PS.setDate(9, fCad);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado", "Alta de un producto", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar registro guardado " + e.getMessage(),
                    "Alta de un producto", 0);
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

    public DefaultTableModel getDatos() {
        String SQL_SELECT = "SELECT * from tablaproducto";
        try {
            this.setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(5);
                fila[4] = RS.getFloat(4);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getDate(8);
                fila[8] = RS.getDate(9);
                DTM.addRow(fila);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de productos " + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DTM;
    }

    public DefaultTableModel buscaProducto(int criterio, String parametro) {
        String SQL_BUSCAR;
        if (criterio == 0) {
            SQL_BUSCAR = "SELECT * FROM tablaproducto WHERE idArticulo=" + parametro;
        } else {
            SQL_BUSCAR = "SELECT * FROM tablaproducto WHERE descripcion like '" + parametro + "%'";
        }
        try {
            this.setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_BUSCAR);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(5);
                fila[4] = RS.getFloat(4);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getDate(8);
                fila[8] = RS.getDate(9);
                DTM.addRow(fila);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de productos " + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DTM;
    }

    public int actualizarRegistro(int id, String descripcion, String marca, float precio, String contenido, String categoria,
            String estado, Date fElab, Date fCad) {
        int res = 0;

        String SQL_UPDATE;
        if (fCad != null) {
            SQL_UPDATE = "UPDATE tablaproducto SET descripcion='" + descripcion + "',marca='"
                    + marca + "',precio='" + precio + "',contenido='" + contenido + "',categoria='" + categoria + "',estado='"
                    + estado + "',fElab='" + fElab + "',fCad='" + fCad
                    + "' WHERE idArticulo=" + id;
        } else {
            SQL_UPDATE = "UPDATE tablaproducto SET descripcion='" + descripcion + "',marca='"
                    + marca + "',precio='" + precio + "',contenido='" + contenido + "',categoria='" + categoria + "',estado='"
                    + estado + "',fElab='" + fElab
                    + "' WHERE idArticulo=" + id;

        }
        try {
            PS = CN.getConnection().prepareStatement(SQL_UPDATE);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado en BD", "Actualizar producto", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la BD", "Actualizar producto", 1);
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

    public int eliminarRegistro(String id) throws SQLException {
        int res = 0;
        String SQL_DELETE = "DELETE from tablaproducto WHERE idArticulo=" + id;
        try {
            PS = CN.getConnection().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente",
                        "Eliminar registro", 2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e.getMessage(),
                    "Eliminar registro", 0);
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

    public ArrayList<Producto> generaLista() {
        ArrayList<Producto> lista = new ArrayList<>();
        String SQL_PRODUCTO = "SELECT * FROM tablaproducto order by idArticulo";
        try {
            PS = CN.getConnection().prepareStatement(SQL_PRODUCTO);
            RS = PS.executeQuery();
            while (RS.next()) {
                lista.add(new Producto(RS.getInt("idArticulo"),
                        RS.getString("descripcion"),
                        RS.getString("marca"),
                        RS.getFloat("Precio"),
                        RS.getString("contenido"),
                        RS.getString("categoria"),
                        RS.getString("estado"),
                        RS.getDate("fElab"),
                        RS.getDate("fCad")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar registros " + e.getMessage(),
                    "Mostrar registros", 0);
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return lista;
    }
}
