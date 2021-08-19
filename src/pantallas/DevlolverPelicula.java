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
public class DevlolverPelicula extends javax.swing.JFrame {

    /**
     * Creates new form DevlolverPelicula
     */
    ArrayList array = new ArrayList();
    DefaultListModel modelo = new DefaultListModel();

    public DevlolverPelicula() {
        initComponents();
        this.setLocationRelativeTo(null);
        jList_peliculas.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_socio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_peliculas = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("BUSCAR PELICULAS A DEVOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DEVOLVER CASET");

        jList_peliculas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList_peliculas);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("DEVOLVER");
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID SOCIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(txt_socio, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_socio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton que busca peliculas del socio 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Limpiamos la lista antes de comenzar a mostrar resultados
        modelo.clear();

        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {

            //Realizamos la consulta para cuscar las peliculas que tiene alquiladas el socio
            pt = cn.prepareStatement("SELECT peliculas.titulo\n"
                    + "FROM peliculas\n"
                    + "INNER JOIN caset ON caset.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE peliculas.id_socio = " + Integer.parseInt(txt_socio.getText()));

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                this.array.add(rs.getString("titulo"));
            }

            for (int i = 0; i < this.array.size(); i++) {
                this.modelo.addElement(this.array.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
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
        int n_devolucion = 0;
        //Establecemos fechas
        Date fechaPrestamo = null;
        //Fecha actual en formato local
        Date fechaActual = Date.valueOf(LocalDate.now());

        //Mediante un condicional validamos que se haya seleccionado algo de la lista de peliculas a devolver
        if (jList_peliculas.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar al menos 1 pelicula para devolver");
        } else {
            //Se crea un objeto lista con los nombres de las peliculas a devolver
            Object lista[] = jList_peliculas.getSelectedValues();

            //Establecemos coneccion con la base de datos
            Connection cn = null;
            PreparedStatement pt = null;

            try {
                cn = Conexion.getInstance().getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
            for (int i = 0; i < lista.length; i++) {

                System.out.println(lista[i]);

                //Borramos el socio de peliculas
                try {
                    pt = cn.prepareStatement("UPDATE peliculas SET id_socio = null WHERE titulo = '" + lista[i] + "'");
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    pt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Seleccionamos los casets que tengan las peliculas que vamos a devolver
                try {
                    pt = cn.prepareStatement("SELECT * \n"
                            + "FROM caset\n"
                            + "INNER JOIN peliculas ON caset.id_peliculas = peliculas.id_peliculas\n"
                            + "WHERE peliculas.titulo = '" + lista[i] + "'");
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                ResultSet rs = null;
                try {
                    rs = pt.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Obtenemos la fecha que se realizo el prestamo del caset
                try {
                    while (rs.next()) {
                        fechaPrestamo = rs.getDate("f_prestamo");
                        idPeli = rs.getInt("caset.id_peliculas");
                    }
                    System.out.println("fecha prestamo = " + fechaPrestamo);
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Hacemos calculo de diferencia de fechas en milisegundos
                int miliSegPasados = (int) (fechaActual.getTime() - ((int) fechaPrestamo.getTime()));

                int diasPasados = ((((miliSegPasados / 1000) / 60) / 60) / 24);

                System.out.println("dias pasados = " + diasPasados);

                //Si la diferencia de fechas es mayor a 3 dias entonces se coloca una multa
                if (diasPasados > 3) {

                    int dias = diasPasados;
                    float multa = 0;
                    float tardanza = 0;

                    //Calculamos la multa sumando 100 pesos por dia de retraso
                    while (dias > 3) {
                        multa = multa + 100;
                        dias--;
                    }

                    //Mostramos mensaje con el monto de la multa a pagar
                    JOptionPane.showMessageDialog(null, "Debe pagar una multa de $" + multa + " correspondiente a " + (diasPasados - 3) + " dias de retraso"
                            + "\nPerteneciente a la pelicula: " + lista[i]);

                    try {
                        //Seleccionamos a socios para obtener lo que tiene acumulado de tardanzas
                        pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + Integer.parseInt(txt_socio.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println(pt);

                    try {
                        rs = pt.executeQuery();
                    } catch (SQLException ex) {
                        Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Obtenemos el acumulado de tardanzas del socio
                    try {
                        while (rs.next()) {
                            tardanza = rs.getFloat("g_tardanzas");
                        }

                        System.out.println("tardanzas = " + tardanza);

                    } catch (SQLException ex) {
                        Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                    }

//                    //Le sumamos al acumulado el total de la multa actual
//                    multa = tardanza + multa;
                    System.out.println("multa = " + multa);

                    //Cargamos ese total dentro de la tabla al socio
                    try {
                        pt = cn.prepareStatement("UPDATE socios SET g_tardanzas = " + (multa + tardanza) + " WHERE id_socio = " + Integer.parseInt(txt_socio.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println(pt);

                    try {
                        pt.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                //Seteamos el estado a disponible del caset al igual que borramos la fecha de prestamo y colocamos la fecha de devolucion
                try {
                    pt = cn.prepareStatement("UPDATE caset SET estado = 'Disponible', f_prestamo = NULL, f_devolucion = ? WHERE id_peliculas = " + idPeli);
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    pt.setDate(1, fechaActual);
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    pt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Seleccionamos las devoluciones hechas 
                try {
                    pt = cn.prepareStatement("SELECT devoluciones FROM socios WHERE id_socio = " + Integer.parseInt(txt_socio.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    rs = pt.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    while(rs.next()){
                        n_devolucion = rs.getInt("devoluciones");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                n_devolucion = n_devolucion + 1;
                
                System.out.println("devoluciones " + n_devolucion);
                
                //Cargamos las nuevas devoluciones mas las que ya habian
                try {
                    pt = cn.prepareStatement("UPDATE socios SET devoluciones = " + n_devolucion + " WHERE id_socio = " + Integer.parseInt(txt_socio.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    pt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                

                JOptionPane.showMessageDialog(null, "Pelicula devuelta con exito");

                //Cerramos la conexion (devolvemos la conexion al pool)                
            }

            try {
                Conexion.getInstance().closeConnection(cn);
            } catch (SQLException ex) {
                Logger.getLogger(DevlolverPelicula.class.getName()).log(Level.SEVERE, null, ex);
            }

            //limpiamos el txt_fiel
            txt_socio.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Volvemos a la pantalla principal y cerramos terminando el proceso de la pantalla actual
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        Alquiler_Devolucion principal = new Alquiler_Devolucion();
        principal.setVisible(true);
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
            java.util.logging.Logger.getLogger(DevlolverPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevlolverPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevlolverPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevlolverPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevlolverPelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList_peliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_socio;
    // End of variables declaration//GEN-END:variables
}