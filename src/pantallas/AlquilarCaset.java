/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import settings.Conexion;

/**
 *
 * @author PC-HOGAR
 */
public class AlquilarCaset extends javax.swing.JFrame {

    /**
     * Creates new form AlquilarCaset
     */
    ArrayList array = new ArrayList();
    DefaultListModel modelo = new DefaultListModel();

    public AlquilarCaset() {
        initComponents();
        this.setLocationRelativeTo(null);
        jList_peliculasdisponibles.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_peliculasdisponibles = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_idcliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ALQUILER CASETS");

        jList_peliculasdisponibles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList_peliculasdisponibles);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("BUSCAR CASETS DISPONIBLES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("ALQUILAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("VOLVER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("COLOQUE ID CLIENTE (El que alquila)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(txt_idcliente))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(133, 133, 133))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modelo.clear();

        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {

            //Realizamos la consulta para cuscar las peliculas que tiene alquiladas el socio
            pt = cn.prepareStatement("SELECT * \n"
                    + "FROM peliculas\n"
                    + "INNER JOIN caset ON caset.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE caset.estado = 'Disponible'");

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                this.array.add(rs.getString("titulo"));
            }

            for (int i = 0; i < this.array.size(); i++) {
                this.modelo.addElement(this.array.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (array.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no posee caset");
        }

        //Eliminamos los elementos del arreglo una vez hayamos mostrado todo, esto es para que no moleste cuando volvamos a hacer otra buscqueda
        array.clear();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int idPeli = 0;
        int alquileres = 0;
        String estado = "";
        String nombrePeli = "";
        float precio = 0;
        float gsocio = 0;
        float valorNuevo;

        if (jList_peliculasdisponibles.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar al menos 1 pelicula para devolver");
        } else {
            //Se crea un objeto lista con los nombres de las peliculas a devolver
            Object lista[] = jList_peliculasdisponibles.getSelectedValues();

            //Establecemos coneccion con la base de datos
            Connection cn = null;
            PreparedStatement pt = null;

            try {
                cn = Conexion.getInstance().getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
            for (int i = 0; i < lista.length; i++) {

                try {

                    pt = cn.prepareStatement("SELECT *"
                            + " FROM peliculas"
                            + " INNER JOIN caset ON peliculas.id_peliculas = caset.id_peliculas"
                            + " WHERE peliculas.titulo = '" + lista[i] + "'");

                    ResultSet rs = pt.executeQuery();

                    while (rs.next()) {
                        idPeli = rs.getInt("peliculas.id_peliculas");
                        precio = rs.getFloat("precio");
                    }

                    System.out.println("idpeli = " + idPeli);
                    
                    //Primero actualizamos en peliculas colocando el socio que la tiene 
                    pt = cn.prepareStatement("UPDATE peliculas SET id_socio = ? WHERE peliculas.titulo = ?");

                    pt.setInt(1, Integer.parseInt(txt_idcliente.getText()));
                    pt.setString(2, (String) lista[i]);

                    System.out.println("id socio = " + Integer.parseInt(txt_idcliente.getText()) + "\ntitulo = " + lista[i]);
                    
                    pt.executeUpdate();

                    //Luego actualizamos el estado del caset a Alquilado
                    pt = cn.prepareStatement("UPDATE caset SET estado = 'Alquilada', f_prestamo = ?, f_devolucion = NULL WHERE caset.id_peliculas = " + idPeli);

                    pt.setDate(1, Date.valueOf(LocalDate.now()));

                    System.out.println(Date.valueOf(LocalDate.now()));
                    
                    pt.executeUpdate();

                    //Seleccionamos todo del socios para luego obtener el total de gastos que ha hecho el socio en el videoclub
                    pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + Integer.parseInt(txt_idcliente.getText()));

                    rs = pt.executeQuery();

                    //Obtenermos el gasto total hecho en el videoclub por el socio
                    while (rs.next()) {
                        gsocio = rs.getFloat("g_total");
                    }

                    System.out.println("gasto socio " + gsocio);
                    
                    //Asignamos el gasto al socio
                    valorNuevo = gsocio + precio;
                    
                    System.out.println("valor nuevo " + valorNuevo);

                    pt = cn.prepareStatement("UPDATE socios SET g_total = " + valorNuevo + " WHERE socios.id_socio = " + Integer.parseInt(txt_idcliente.getText()));

                    pt.executeUpdate();
                    
                    
                    //Seleccionamos el numero de alquileres que ha hecho el socio
                    pt = cn.prepareStatement("SELECT n_alquileres FROM socios WHERE id_socio = " + Integer.parseInt(txt_idcliente.getText()));
                    
                    rs = pt.executeQuery();
                    
                    while(rs.next()){
                        alquileres = rs.getInt("n_alquileres");
                    }
                    
                    //Aumentamos en 1 los alquileres por cada nuevo alquiler hecho
                    alquileres++;
                    
                    //Seteamos el nuevo valor dentro de la tabla de socios
                    pt = cn.prepareStatement("UPDATE socios SET n_alquileres = " + alquileres + " WHERE id_socio = " + Integer.parseInt(txt_idcliente.getText()));
                    
                    pt.executeUpdate();
                    
                    //Incertamos el registro de el alquiler en la tabla de alquileres para llevar un historial de alquileres hechos
                    pt = cn.prepareStatement("INSERT INTO alquileres(id_peliculas, id_socio, f_alquiler) VALUES(?,?,?)");
                    
                    pt.setInt(1, idPeli);
                    pt.setInt(2, Integer.parseInt(txt_idcliente.getText()));
                    pt.setDate(3, Date.valueOf(LocalDate.now())); ;
                    
                    pt.executeUpdate();
                            
                    JOptionPane.showMessageDialog(null, "Alquiler realizado con exito");

                } catch (SQLException ex) {
                    Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //Por ultimo devolvemos la conexion al pool
            try {
                Conexion.getInstance().closeConnection(cn);
            } catch (SQLException ex) {
                Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        txt_idcliente.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        Alquiler_Devolucion alqDev = new Alquiler_Devolucion();
        alqDev.setVisible(true);
        this.dispose();

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
            java.util.logging.Logger.getLogger(AlquilarCaset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlquilarCaset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlquilarCaset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlquilarCaset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlquilarCaset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList_peliculasdisponibles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_idcliente;
    // End of variables declaration//GEN-END:variables
}