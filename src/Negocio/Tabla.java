package Negocio;

import java.sql.*;
import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REAL
 */
public class Tabla {
//    private DefaultTableModel tabla;

//    public Tabla(DefaultTableModel tabla) {
//        this.tabla = tabla;
//    }
    
    
    public void actualizarTablaEstudiante(Connection cn, DefaultTableModel tabla) {
        String consulta = "SELECT * FROM estudiante";
        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] estudiante = new Object[3];
                estudiante[0] = rs.getInt("idEstudiante");
                estudiante[1] = rs.getString("NombreEstudiante");
                estudiante[2] = rs.getString("FechaNacimiento");

                tabla.addRow(estudiante);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
    
        public void consultarEstudiante(Connection cn, String atributoABuscar, String texto, DefaultTableModel tabla){
        String consultaSQL = "SELECT * FROM estudiante WHERE " + atributoABuscar + " LIKE ?";
        try {
            PreparedStatement ps = cn.prepareStatement(consultaSQL);
        // Configurar el parámetro para evitar inyección SQL y manejar las comillas
            ps.setString(1, texto + "%");
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] estudiante = new Object[3];
                estudiante[0] = rs.getInt("idEstudiante");
                estudiante[1] = rs.getString("NombreEstudiante");
                estudiante[2] = rs.getString("FechaNacimiento");

                tabla.addRow(estudiante);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
        
    public void actualizarTablaAutor(Connection cn, DefaultTableModel tabla) {
        String consulta = "SELECT * FROM autor";
        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] autor = new Object[3];
                autor[0] = rs.getInt("idAutor");
                autor[1] = rs.getString("NombreAutor");
                autor[2] = rs.getString("FechaNacimiento");

                tabla.addRow(autor);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
        
        public void consultarAutor(Connection cn, String atributoABuscar, String texto, DefaultTableModel tabla){
        String consultaSQL = "SELECT * FROM autor WHERE " + atributoABuscar + " LIKE ?";
        try {
            PreparedStatement ps = cn.prepareStatement(consultaSQL);
        // Configurar el parámetro para evitar inyección SQL y manejar las comillas
            ps.setString(1, texto + "%");
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] autor = new Object[3];
                autor[0] = rs.getInt("idAutor");
                autor[1] = rs.getString("NombreAutor");
                autor[2] = rs.getString("FechaNacimiento");

                tabla.addRow(autor);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
        
    public void actualizarTablaLibro(Connection cn, DefaultTableModel tabla) {
        String consulta = "SELECT * FROM libro";
        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while (rs.next()) {
                Object[] libro = new Object[5];
                libro[0] = rs.getInt("idLibro");
                libro[1] = rs.getString("Titulo");
                libro[2] = rs.getInt("idAutor");
                libro[3] = rs.getString("FechaPublicacion");
                libro[4] = rs.getInt("Stock");

                tabla.addRow(libro);
            }

            // Notificar a la tabla que se han realizado cambios en el modelo
//            tabla.fireTableDataChanged();

            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }

    public void consultarLibro(Connection cn, String atributoABuscar, String texto, DefaultTableModel tabla){
        String consultaSQL = "SELECT * FROM libro WHERE " + atributoABuscar + " LIKE ?";
        try {
            PreparedStatement ps = cn.prepareStatement(consultaSQL);
        // Configurar el parámetro para evitar inyección SQL y manejar las comillas
            ps.setString(1, texto + "%");
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] libro = new Object[5];
                libro[0] = rs.getInt("idLibro");
                libro[1] = rs.getString("Titulo");
                libro[2] = rs.getInt("idAutor");               
                libro[3] = rs.getString("FechaPublicacion");
                libro[4] = rs.getInt("Stock");
                

                tabla.addRow(libro);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
    
    public void actualizarTablaPrestamo(Connection cn, DefaultTableModel tabla) {
        String consulta = "SELECT * FROM préstamo";
        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while (rs.next()) {
                Object[] prestamo = new Object[6];
                prestamo[0] = rs.getInt("idPrestamo");
                prestamo[1] = rs.getString("NombreEstudiante");
                prestamo[2] = rs.getString("Titulo");
                prestamo[3] = rs.getString("FechaPrestamo");
                prestamo[4] = rs.getString("FechaRetorno");

                tabla.addRow(prestamo);
            }

            // Notificar a la tabla que se han realizado cambios en el modelo
//            tabla.fireTableDataChanged();

            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
    
    public void consultarPrestamo(Connection cn, String atributoABuscar, String texto, DefaultTableModel tabla){
        String consultaSQL = "SELECT * FROM préstamo WHERE " + atributoABuscar + " LIKE ?";
        try {
            PreparedStatement ps = cn.prepareStatement(consultaSQL);
        // Configurar el parámetro para evitar inyección SQL y manejar las comillas
            ps.setString(1, texto + "%");
            ResultSet rs = ps.executeQuery();

            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] prestamo = new Object[6];
                prestamo[0] = rs.getInt("idPrestamo");
                prestamo[1] = rs.getString("NombreEstudiante");
                prestamo[2] = rs.getString("Titulo");
                prestamo[3] = rs.getString("FechaPrestamo");
                prestamo[4] = rs.getString("FechaRetorno");
                prestamo[5] = rs.getInt("Cantidad");
                tabla.addRow(prestamo);
            }
            // Cerrar recursos
            ps.close();
            rs.close();
        } 
        catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
    }
}
