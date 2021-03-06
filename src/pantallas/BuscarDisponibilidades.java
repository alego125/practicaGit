/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import settings.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author PC-HOGAR
 */
public class BuscarDisponibilidades extends javax.swing.JFrame {

    /**
     * Creates new form BuscarDisponibilidades
     */
     private static String url;
    private static String user;
    private static String pass;

    public BuscarDisponibilidades() {
        initComponents();
        this.url = "jdbc:mysql://localhost:3306/videoclub";
        this.user  = "root";
        this.pass  = "";
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_BuscarCasets = new javax.swing.JButton();
        jButton_BuscarDvds = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_BuscarCasets.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_BuscarCasets.setText("TODOS LOS CASETS");
        jButton_BuscarCasets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarCasetsActionPerformed(evt);
            }
        });

        jButton_BuscarDvds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_BuscarDvds.setText("TODOS LOS DVDs");
        jButton_BuscarDvds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarDvdsActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR DISPONIBILIDADES");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("BUSCAR DVDs DISPONIBLES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("BUSCAR CASETS DISPONIBLES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_BuscarDvds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_BuscarCasets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_BuscarDvds)
                    .addComponent(jButton_BuscarCasets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton que hace la conexion a la base de datos para buscar la informacion
    private void jButton_BuscarCasetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarCasetsActionPerformed
        
        String[] registro = new String[5];
        
        String[] columnas = {"ID PELICULA","ID CASET","PELICULA","PRECIO","ESTADO"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);
        PreparedStatement pt = null;
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
             pt = cn.prepareStatement("SELECT peliculas.id_peliculas, id_caset, titulo, precio, estado"
                     + " FROM peliculas"
                     + " INNER JOIN caset ON peliculas.id_peliculas = caset.id_peliculas"
                     + " ORDER BY id_caset");                     
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         ResultSet rs = null;
         try {
             rs = pt.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }                                
        
        try{
            while(rs.next()){
                registro[0] = Integer.toString(rs.getInt(1));
                registro[1] = Integer.toString(rs.getInt(2));
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
            //Ahora le seteamos a la tabla de la pantalla lo que nos trajo el registro
            jTable1.setModel(ModeloTabla);
        }catch(SQLException ex){
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }                       
        
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton_BuscarCasetsActionPerformed

    private void jButton_BuscarDvdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarDvdsActionPerformed

        String[] registro = new String[5];
        
        String[] columnas = {"ID PELICULA","ID DVD","PELICULA","PRECIO","ESTADO"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);
        PreparedStatement pt = null;
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
             pt = cn.prepareStatement("SELECT peliculas.id_peliculas, id_dvd, titulo, precio, estado"
                     + " FROM peliculas"
                     + " INNER JOIN dvd ON peliculas.id_peliculas = dvd.id_peliculas"
                     + " ORDER BY id_dvd");                     
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         ResultSet rs = null;
         try {
             rs = pt.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }                                
        
        try{
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
            //Ahora le seteamos a la tabla de la pantalla lo que nos trajo el registro
            jTable1.setModel(ModeloTabla);
        }catch(SQLException ex){
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_BuscarDvdsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.setVisible(false);
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String[] registro = new String[5];
        
        String[] columnas = {"ID PELICULA","ID DVD","PELICULA","PRECIO","ESTADO"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);
        PreparedStatement pt = null;
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
             pt = cn.prepareStatement("SELECT peliculas.id_peliculas, id_dvd, titulo, precio, estado"
                     + " FROM peliculas"
                     + " INNER JOIN dvd ON peliculas.id_peliculas = dvd.id_peliculas"
                     + " WHERE dvd.estado = 'Disponible'"
                     + " ORDER BY id_dvd");                     
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         ResultSet rs = null;
         try {
             rs = pt.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }                                
        
        try{
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
            //Ahora le seteamos a la tabla de la pantalla lo que nos trajo el registro
            jTable1.setModel(ModeloTabla);
        }catch(SQLException ex){
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String[] registro = new String[5];
        
        String[] columnas = {"ID PELICULA","ID CASET","PELICULA","PRECIO","ESTADO"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);
        PreparedStatement pt = null;
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
             pt = cn.prepareStatement("SELECT peliculas.id_peliculas, id_caset, titulo, precio, estado"
                     + " FROM peliculas"
                     + " INNER JOIN caset ON peliculas.id_peliculas = caset.id_peliculas"
                     + " WHERE caset.estado = 'Disponible'"
                     + " ORDER BY id_caset");                     
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         ResultSet rs = null;
         try {
             rs = pt.executeQuery();
         } catch (SQLException ex) {
             Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
         }                                
        
        try{
            while(rs.next()){
                registro[0] = Integer.toString(rs.getInt(1));
                registro[1] = Integer.toString(rs.getInt(2));
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
            //Ahora le seteamos a la tabla de la pantalla lo que nos trajo el registro
            jTable1.setModel(ModeloTabla);
        }catch(SQLException ex){
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }                       
        
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarDisponibilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarDisponibilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarDisponibilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarDisponibilidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarDisponibilidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_BuscarCasets;
    private javax.swing.JButton jButton_BuscarDvds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
