package Negocio;

import java.sql.*;
import javax.print.attribute.standard.Sides;
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
    
    public boolean registrarLibro(Connection cn, String titulo, String idAutor, String fechaPublicacion, String stock, String nombreAutor, String fechaNacimientoAutor) {
        boolean error = false;
        try {
            PreparedStatement ps1 = cn.prepareStatement("SELECT * FROM autor WHERE idAutor = ? AND NombreAutor = ? AND FechaNacimiento = ?");
            ps1.setInt(1, Integer.parseInt(idAutor));
            ps1.setString(2, nombreAutor);
            ps1.setString(3, fechaNacimientoAutor);
            ResultSet existe = ps1.executeQuery();

            if (!existe.next()) {
                this.registrarAutor(cn, idAutor, nombreAutor, fechaNacimientoAutor);
            }

            // Omitir la columna idLibro en la inserción, ya que es autoincremental
            PreparedStatement ps2 = cn.prepareStatement("INSERT INTO Libro (Titulo, idAutor, FechaPublicacion, Stock) VALUES (?,?,?,?)");
            ps2.setString(1, titulo);
            ps2.setInt(2, Integer.parseInt(idAutor));
            ps2.setString(3, fechaPublicacion);
            ps2.setInt(4, Integer.parseInt(stock));
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
    
    public boolean registrarPrestamo(Connection cn, String idEstudiante, String idLibro, String fechaPrestamo, String fechaRetorno, String idEstudiante, String fechaNacimientoEstudiante, String fechaPublicacionAutor, String Stock) {
        boolean error = false;
        try {
            // Iniciar una transacción
            cn.setAutoCommit(false);

            // Verificar existencia del estudiante
            PreparedStatement ps1 = cn.prepareStatement("SELECT * FROM estudiante WHERE idEstudiante = ? AND NombreEstudiante = ? AND FechaNacimiento = ?");
            ps1.setInt(1, Integer.parseInt(idEstudiante));
            ps1.setString(2, nombreEstudiante);
            ps1.setString(3, fechaNacimientoEstudiante);
            ResultSet existeEstudiante = ps1.executeQuery();

            if (!existeEstudiante.next()) {
                JOptionPane.showMessageDialog(null, "El estudiante no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return true; // Terminar la ejecución si el estudiante no existe
            }

            // Verificar existencia del libro
            PreparedStatement ps2 = cn.prepareStatement("SELECT * FROM libro WHERE Titulo = ? AND FechaPublicacion = ? AND Stock = ?");
            ps2.setString(1, idLibro);
            ps2.setString(2, fechaPublicacionAutor);
            ps2.setInt(3, Integer.parseInt(Stock));
            ResultSet existeLibro = ps2.executeQuery();

            if (!existeLibro.next()) {
                JOptionPane.showMessageDialog(null, "El libro no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return true; // Terminar la ejecución si el libro no existe
            }

            // Registrar préstamo
            PreparedStatement ps3 = cn.prepareStatement("INSERT INTO `Préstamo` (NombreEstudiante, Titulo, FechaPrestamo, FechaRetorno, Cantidad) VALUES (?,?,?,?,?)");
            ps3.setString(1, nombreEstudiante);
            ps3.setString(2, idLibro);
            ps3.setString(3, fechaPrestamo);
            ps3.setString(4, fechaRetorno);
            ps3.executeUpdate();

            // Restar la cantidad prestada del stock del libro
            PreparedStatement ps4 = cn.prepareStatement("UPDATE libro SET Stock = Stock - 1 WHERE Titulo = ?");
            ps4.setString(1, idLibro);
            ps4.executeUpdate();

            // Confirmar la transacción
            cn.commit();

            JOptionPane.showMessageDialog(null, "Préstamo registrado correctamente.", "Registrar Préstamo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar los datos.", "Error", JOptionPane.ERROR_MESSAGE);

            try {
                // En caso de error, hacer rollback
                cn.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }

            error = true;
        } finally {
            try {
                // Restaurar la configuración de auto-commit
                cn.setAutoCommit(true);
            } catch (SQLException autoCommitException) {
                autoCommitException.printStackTrace();
            }
        }
        return error;
    }
    
    public void actualizarPrestamo(Connection cn, String idPrestamo, String titulo, String nombreEstudiante, String fechaPrestamo, String fechaRetorno, String cantidad){
    try {
        // Obtener la cantidad prestada antes de actualizar el préstamo
        PreparedStatement psCantidad = cn.prepareStatement("SELECT Cantidad FROM `Préstamo` WHERE idPrestamo = ?");
        psCantidad.setInt(1, Integer.parseInt(idPrestamo));
        

        PreparedStatement ps3 = cn.prepareStatement("UPDATE `Préstamo` SET NombreEstudiante = ?, Titulo = ?, FechaPrestamo = ?, FechaRetorno = ?, Cantidad = ? WHERE idPrestamo = ?");
        ps3.setString(2, nombreEstudiante);
        ps3.setString(3, titulo);
        ps3.setString(4, fechaPrestamo);
        ps3.setString(5, fechaRetorno);
        ps3.setInt(6, Integer.parseInt(idPrestamo));
        ps3.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Actualizar Datos", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar el stock
        PreparedStatement psStock = cn.prepareStatement("UPDATE `Libro` SET Stock = Stock + 1  WHERE Titulo = ?");
        psStock.setString(1, titulo);
        psStock.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar los datos.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void realizarDevolucion(Connection cn, String idPrestamo, String nuevaFechaRetorno, String nuevaCantidad) {
    try {
        // Obtener la cantidad prestada antes de realizar la devolución
        PreparedStatement psCantidad = cn.prepareStatement("SELECT Cantidad, Titulo FROM `Préstamo` WHERE idPrestamo = ?");
        psCantidad.setInt(1, Integer.parseInt(idPrestamo));
        ResultSet rs = psCantidad.executeQuery();
        String titulo = "";
        if (rs.next()) {
            titulo = rs.getString("Titulo");
        }

        PreparedStatement ps = cn.prepareStatement("UPDATE `Préstamo` SET FechaRetorno = ?, Cantidad = ? WHERE idPrestamo = ?");
        ps.setString(1, nuevaFechaRetorno);
        ps.setInt(2, Integer.parseInt(nuevaCantidad));
        ps.setInt(3, Integer.parseInt(idPrestamo));
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Devolución realizada correctamente.", "Devolución", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar el stock
        PreparedStatement psStock = cn.prepareStatement("UPDATE `Libro` SET Stock = Stock + 1 WHERE Titulo = ?");
        psStock.setString(1, titulo);
        psStock.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la devolución.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void eliminarPrestamo(Connection cn, String idPrestamo){
    try{
        // Obtener la cantidad de libros prestados y el título del libro antes de eliminar el préstamo
        PreparedStatement psCantidad = cn.prepareStatement("SELECT Cantidad, Titulo FROM `Préstamo` WHERE idPrestamo = ?");
        psCantidad.setInt(1, Integer.parseInt(idPrestamo));
        ResultSet rs = psCantidad.executeQuery();
        String titulo = "";
        if (rs.next()) {
            titulo = rs.getString("Titulo");
        }

        PreparedStatement ps = cn.prepareStatement("DELETE FROM préstamo WHERE idPrestamo = ?");
        ps.setInt(1, Integer.parseInt(idPrestamo));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Prestamo eliminado correctamente.", "Eliminar Prestamo", JOptionPane.INFORMATION_MESSAGE);

        // Actualizar el stock
        PreparedStatement psStock = cn.prepareStatement("UPDATE `Libro` SET Stock = Stock + 1 WHERE Titulo = ?");
        psStock.setString(2, titulo);
        psStock.executeUpdate();
    }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el prestamo.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}



    



