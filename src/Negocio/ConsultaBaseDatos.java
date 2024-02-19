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
//            PreparedStatement ps2 = cn.prepareStatement("INSERT INTO estudiante VALUES (?,?,?)");
//            ps2.setInt(1, Integer.parseInt(idEstudiante));
//            ps2.setString(2, nombreEstudiante);
//            ps2.setString(3, fechaNacimientoEstudiante);
//            ps2.executeUpdate();
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
    
//    public boolean registrarLibro(Connection cn, String idLibro, String titulo, String idAutor, String fechaPublicacion, String stock, String nombreAutor, String fechaNacimientoAutor) {
//        boolean error = false;
//        try {
//            PreparedStatement ps1 = cn.prepareStatement("SELECT * FROM autor WHERE idAutor = ?");
//            PreparedStatement ps2 = cn.prepareStatement("INSERT INTO Libro VALUES (?,?,?,?,?)");
//            ps1.setInt(1, Integer.parseInt(idAutor));
//            ResultSet existe = ps1.executeQuery();
//            
//            if(!existe.next()){
//                this.registrarAutor(cn, idAutor, nombreAutor, fechaNacimientoAutor);
//                ps2.setInt(1, Integer.parseInt(idLibro));
//                ps2.setString(2, titulo);
//                ps2.setInt(3, Integer.parseInt(idAutor));
//                ps2.setString(4, fechaPublicacion);
//                ps2.setInt(5, Integer.parseInt(stock));
//                ps2.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Autor y Libro registrados correctamente.", "Registrar libro y Crear Autor", JOptionPane.INFORMATION_MESSAGE);
//            }
//            else{
//                ps2.setInt(1, Integer.parseInt(idLibro));
//                ps2.setString(2, titulo);
//                ps2.setInt(3, Integer.parseInt(idAutor));
//                ps2.setString(4, fechaPublicacion);
//                ps2.setInt(5, Integer.parseInt(stock));
//                ps2.executeUpdate();        
//                JOptionPane.showMessageDialog(null, "Libro registrado correctamente.", "Registrar libro", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
//            error = true;
//        }
//        return error;
//    }
    
    public boolean registrarLibro(Connection cn, String idLibro, String titulo, String idAutor, String fechaPublicacion, String stock, String nombreAutor, String fechaNacimientoAutor) {
        boolean error = false;
        try {
            PreparedStatement ps1 = cn.prepareStatement("SELECT * FROM autor WHERE idAutor = ? AND NombreAutor = ? AND FechaNacimiento = ?");
            ps1.setInt(1, Integer.parseInt(idAutor));
            ps1.setString(2, nombreAutor);
            ps1.setString(3, fechaNacimientoAutor);
            ResultSet existe = ps1.executeQuery();
            
            if(!existe.next()){
                this.registrarAutor(cn, idAutor, nombreAutor, fechaNacimientoAutor);
//                    JOptionPane.showMessageDialog(null, "El idAutor ya existe.", "Error", JOptionPane.ERROR_MESSAGE);                  
            }
                PreparedStatement ps2 = cn.prepareStatement("INSERT INTO Libro VALUES (?,?,?,?,?)");
                ps2.setInt(1, Integer.parseInt(idLibro));
                ps2.setString(2, titulo);
                ps2.setInt(3, Integer.parseInt(idAutor));
                ps2.setString(4, fechaPublicacion);
                ps2.setInt(5, Integer.parseInt(stock));
                ps2.executeUpdate();        
                JOptionPane.showMessageDialog(null, "Libro registrado correctamente.", "Registrar libro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        return error;
    }

    public void actualizarLibro(Connection cn, String idLibro, String titulo, String fechaPublicacion, String stock){
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE libro SET Titulo = ?, FechaPublicacion = ?, Stock = ? WHERE idlibro = ?");
            ps.setString(1, titulo);
            ps.setString(2, fechaPublicacion);
            ps.setInt(3, Integer.parseInt(stock));
            ps.setString(4, idLibro);  // Asegúrate de establecer el valor del parámetro idlibro
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Actualizar Datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarLibro(Connection cn, String idLibro){
        try{
            PreparedStatement ps = cn.prepareStatement("DELETE FROM libro WHERE idLibro = ?");
            ps.setInt(1, Integer.parseInt(idLibro));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.", "Eliminar libro", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el libro.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
