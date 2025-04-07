/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class CConexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BD = "tienda2";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD + "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Connection CN;

    public CConexion() {
        CN = null;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al conectar", 0);
            System.exit(0);
        }
        return CN;
    }
    public void close(){
        try{
            CN.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cerrar la BD", 0);
        }
    }
    public static void main(String [] args){
        CConexion con = new CConexion();
        if(con.getConnection() != null){
            System.out.println("Conexion exitosa");
        }else{
            System.out.println("Conexion erronea");
        }
    }
}
