//NO SIRVE POR AHORA

package Negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer123
 */


public class ConsultaMySQL {
    private Connection connection;

    public ConsultaMySQL(Connection connection) {
        this.connection = connection;
    }

    // Método para actualizar la tabla de estudiantes
//    public void actualizarTabla(DefaultTableModel tabla, String nombreTabla) {
//        String consulta = "SELECT * FROM " + nombreTabla;
//        try {
//            PreparedStatement ps = connection.prepareStatement(consulta);
//            ResultSet rs = ps.executeQuery();
//
//            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
//
//            while(rs.next()) {
//                Object[] estudiante = new Object[3];
//                estudiante[0] = rs.getInt("idEstudiante");
//                estudiante[1] = rs.getString("Nombre");
//                estudiante[2] = rs.getString("FechaNacimiento");
//
//                tabla.addRow(estudiante);
//            }
//
//            // Cerrar recursos
//            ps.close();
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
//        }
//    }
    

    
    public void insertarEstudiante(int idEstudiante, String nombreEstudiante, String fechaNacimientoEstudiante) {
        try {
            if(nombreEstudiante.equals("") || fechaNacimientoEstudiante.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos");
            } else {
                String consulta = "INSERT INTO estudiante(idEstudiante, Nombre, FechaNacimiento) VALUES (?, ?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(consulta)) {
                    ps.setInt(1, idEstudiante);
                    ps.setString(2, nombreEstudiante);
                    ps.setString(3, fechaNacimientoEstudiante);
                    ps.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Los datos han sido agregados");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }

    // Método para verificar si ya existe un registro con el mismo ID en la tabla especificada
    public boolean existeRegistro(String nombreTabla, String columnaID, int id) throws SQLException {
        boolean existe = false;
        String consulta = "SELECT COUNT(*) AS count FROM " + nombreTabla + " WHERE " + columnaID + " = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    existe = (count > 0); // Si count es mayor que cero, significa que ya existe un registro con ese ID
                }
            }
        }
        return existe;
    }
}

