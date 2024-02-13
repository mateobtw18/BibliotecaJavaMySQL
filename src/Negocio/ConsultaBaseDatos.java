package Negocio;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author G3
 */
public class ConsultaBaseDatos {     
//    public void registrarEstudiante(Connection cn, String idEstudiante, String nombreEstudiante, String fechaNacimientoEstudiante){
//        try{
//            PreparedStatement ps = cn.prepareStatement("INSERT INTO estudiante VALUES (?,?,?)");
//            ps.setInt(1, Integer.parseInt(idEstudiante));
//            ps.setString(2, nombreEstudiante);
//            ps.setString(3, fechaNacimientoEstudiante);
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.", "Registrar Estudiante", JOptionPane.INFORMATION_MESSAGE);
//        }catch (SQLException ex){
//            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    public boolean registrarEstudiante(Connection cn, String idEstudiante, String nombreEstudiante, String fechaNacimientoEstudiante){
        boolean error = false;
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO estudiante VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idEstudiante));
            ps.setString(2, nombreEstudiante);
            ps.setString(3, fechaNacimientoEstudiante);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.", "Registrar Estudiante", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        return error;
    }
    
    public void actualizarEstudiante(Connection cn, String idEstudiante, String nombreEstudiante, String fechaNacimientoEstudiante){
        try{
            PreparedStatement ps = cn.prepareStatement("UPDATE estudiante SET NombreEstudiante = ?, FechaNacimiento = ? WHERE idEstudiante = " + idEstudiante);
            ps.setString(1, nombreEstudiante);
            ps.setString(2, fechaNacimientoEstudiante);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Actualizar Datos", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarEstudiante(Connection cn, String idEstudiante){
        try{
            PreparedStatement ps = cn.prepareStatement("DELETE FROM estudiante WHERE idEstudiante = " + idEstudiante);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.", "Eliminar Estudiante", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el estudiante.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean registrarAutor(Connection cn, String idAutor, String nombreAutor, String fechaNacimientoAutor){
        boolean error = false;
        try{
            PreparedStatement ps = cn.prepareStatement("INSERT INTO autor VALUES (?,?,?)");
            ps.setInt(1, Integer.parseInt(idAutor));
            ps.setString(2, nombreAutor);
            ps.setString(3, fechaNacimientoAutor);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Autor registrado correctamente.", "Registrar Autor", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        return error;
    }
    
    public void actualizarAutor(Connection cn, String idAutor, String nombreAutor, String fechaNacimientoAutor){
        try{
            PreparedStatement ps = cn.prepareStatement("UPDATE autor SET NombreAutor = ?, FechaNacimiento = ? WHERE idAutor = " + idAutor);
            ps.setString(1, nombreAutor);
            ps.setString(2, fechaNacimientoAutor);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Actualizar Datos", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarAutor(Connection cn, String idAutor){
        try{
            PreparedStatement ps = cn.prepareStatement("DELETE FROM autor WHERE idAutor = " + idAutor);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Autor eliminado correctamente.", "Eliminar autor", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el autor.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
