package Negocio;

//import Conectar.ConexionBaseDatos;
import Vista.JFLogin;
import java.sql.SQLException;

/**
 *
 * @author Acer123
 */
public class PrincipalProyecto {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
//        ConexionBaseDatos con = new ConexionBaseDatos();
//        con.getConnection();
        JFLogin jfLogin = new JFLogin();
        jfLogin.setVisible(true);
    } 
}
