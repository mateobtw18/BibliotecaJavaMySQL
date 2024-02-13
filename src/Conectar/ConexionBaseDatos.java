package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class ConexionBaseDatos {
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "mateocumbal123M*";//poner contraseña
    String database = "biblioteca";//poner el nombre de su base datos
    String ip = "localhost";
    String puerto = "3306";
    String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + database;
    
    Connection conectar = null;


    public Connection conexion() throws SQLException {
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
//            JOptionPane.showMessageDialog(null, "ConexionBaseDatos realizada correctamente");
        } 
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error 1 en la conexion a la base de datos " + e);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 2 en la conexion a la base de datos " + e);
        }
        return conectar;
    } 
}