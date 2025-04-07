package pk_modelo;

public class Productos {
    public static void main(String[] args){
        pk_conexion.C_Conexion cn = new pk_conexion.C_Conexion();
        if(cn.getConnection() != null){
            System.out.println("Conexion correcta");
        }else{
            System.out.println("Conexion erronea");
        }
    }
    
}
