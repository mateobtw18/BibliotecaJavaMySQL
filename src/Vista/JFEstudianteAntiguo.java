package Vista;

import Conectar.ConexionBaseDatos;
//import Negocio.ConsultaMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JFEstudianteAntiguo extends javax.swing.JFrame {

    ConexionBaseDatos con1 = new ConexionBaseDatos();
//    ConsultaMySQL consulta;
    Connection conet;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    DefaultTableModel tabla;
    JFMenu jfMenu;
    
    public JFEstudianteAntiguo() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            conet = con1.conexion();
        } catch (SQLException ex) {
            Logger.getLogger(JFEstudianteAntiguo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        consulta = new ConsultaMySQL(conet);
        tabla = (DefaultTableModel) this.jTlistaEstudiantes.getModel();
        this.actualizarTabla();
    }

//    private void actualizarTabla(){
//        String consulta = "select * from estudiante";
//        try {
//            conet = con1.conexion();
//            st = conet.createStatement();
//            rs = st.executeQuery(consulta);
//            
//            Object [] estudiante = new Object[3];
//            tabla = (DefaultTableModel) this.jTlistaEstudiantes.getModel();
//            while(rs.next()){
//                estudiante [0] = rs.getInt("idEstudiante");
//                estudiante [1] = rs.getString("Nombre");
//                estudiante [2] = rs.getString("FechaNacimiento");
//                
//                tabla.addRow(estudiante);
//            }
//            this.jTlistaEstudiantes.setModel(tabla);
//        } 
//        catch (Exception e) {
//            
//        }
//    }
    
    private void actualizarTabla() {
        String consulta = "SELECT * FROM estudiante";
        try {
            conet = con1.conexion();
            ps = conet.prepareStatement(consulta);
            rs = ps.executeQuery();

            DefaultTableModel tabla = (DefaultTableModel) this.jTlistaEstudiantes.getModel();
            tabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            while(rs.next()) {
                Object[] estudiante = new Object[3];
                estudiante[0] = rs.getInt("idEstudiante");
                estudiante[1] = rs.getString("Nombre");
                estudiante[2] = rs.getString("FechaNacimiento");

                tabla.addRow(estudiante);
            }
            this.jTlistaEstudiantes.setModel(tabla);

            // Cerrar recursos
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones, adaptar según sea necesario
        }
//        this.consulta.actualizarTabla(tabla, "estudiante");
    }
    
    private void limpiarTabla(){
        for(int i = 0; i <= this.jTlistaEstudiantes.getRowCount(); i++){
            tabla.removeRow(i);
            i--;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFidEstudiante = new javax.swing.JTextField();
        jTFnombreEstudiante = new javax.swing.JTextField();
        jTFfechaNacimientoEstudiante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBinsert = new javax.swing.JButton();
        jBupdate = new javax.swing.JButton();
        jBdelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTlistaEstudiantes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnuvolverAlMenu = new javax.swing.JMenuItem();
        jMnusalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estudiantes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre y Apellido:");

        jLabel3.setText("Fecha de Nacimiento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFidEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jTFfechaNacimientoEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jTFnombreEstudiante))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFidEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFnombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFfechaNacimientoEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jBinsert.setText("Agregar");
        jBinsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBinsertActionPerformed(evt);
            }
        });

        jBupdate.setText("Actualizar");

        jBdelete.setText("Borrar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jBinsert)
                .addGap(94, 94, 94)
                .addComponent(jBupdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBdelete)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBinsert)
                    .addComponent(jBupdate)
                    .addComponent(jBdelete))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Estudiantes"));

        jTlistaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEstudiante", "Nombre", "FechaNacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTlistaEstudiantes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        jMenu1.setText("File");

        jMnuvolverAlMenu.setText("Volver al Menú");
        jMnuvolverAlMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuvolverAlMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuvolverAlMenu);

        jMnusalir.setText("Salir");
        jMnusalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnusalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMnusalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBinsertActionPerformed
        int idEstudiante = Integer.parseInt(this.jTFidEstudiante.getText());
        String nombreEstudiante = this.jTFnombreEstudiante.getText();
        String fechaNacimientoEstudiante = this.jTFfechaNacimientoEstudiante.getText();
        
        try {
            if(nombreEstudiante.equals("") || fechaNacimientoEstudiante.equals("")){
                JOptionPane.showMessageDialog(null, "Faltan datos");
            }
            else{
                String consulta = "insert into estudiante(idEstudiante, Nombre, FechaNacimiento) values (" + idEstudiante + ",'" + nombreEstudiante + "','" + fechaNacimientoEstudiante + "')";
                conet = con1.conexion();
                st = conet.createStatement();
                st.executeUpdate(consulta);
                this.jTFidEstudiante.setEditable(false);
                JOptionPane.showMessageDialog(null, "Los datos han sido agregados");
                limpiarTabla();
            }  
        } 
        catch (Exception e) {
            
        }
        actualizarTabla();
    }//GEN-LAST:event_jBinsertActionPerformed

    private void jMnuvolverAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuvolverAlMenuActionPerformed
        jfMenu = new JFMenu();
        jfMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMnuvolverAlMenuActionPerformed

    private void jMnusalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnusalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMnusalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFEstudianteAntiguo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEstudianteAntiguo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEstudianteAntiguo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEstudianteAntiguo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEstudianteAntiguo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBdelete;
    private javax.swing.JButton jBinsert;
    private javax.swing.JButton jBupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnusalir;
    private javax.swing.JMenuItem jMnuvolverAlMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFfechaNacimientoEstudiante;
    private javax.swing.JTextField jTFidEstudiante;
    private javax.swing.JTextField jTFnombreEstudiante;
    private javax.swing.JTable jTlistaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
