/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import settings.Conexion;

/**
 *
 * @author PC-HOGAR
 */
public class InfoExtra extends javax.swing.JFrame {

    /**
     * Creates new form InfoExtra
     */
    public InfoExtra() {
        initComponents();
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("ALQUILERES CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GASTOS Y RETRASOS CLIENTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANTIDAD ALQUILERES PELICULA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("VOLVER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jLabel1.setText("TABLA PARA MOSTRAR LOS ALQUILES DE LOS CLIENTES");

        jButton5.setText("MOSTRAR INFORMACION CLIENTE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(97, 97, 97))
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //Creamos las variables para la tabla que mostrara los resultados
        String[] registro = new String[5];

        String[] columnas = {"ID PELICULA", "PELICULA", "DURACION", "CATEGORIA"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);

        //Creamos las variables que vamos a usar
        int numeroAlquileres = 0;
        //Ingresamos el numero de id del socio que vamos a buscar
        int cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del socio"));

        //Realizamos la conexion
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Contamos el numero de veces que se encuentra dedntro de la tabla alquileres el id del socio, con lo cual sabremos el numero de alquileres que ha hecho
        try {
            pt = cn.prepareStatement("SELECT COUNT(n_alquiler) AS alquiler FROM alquileres WHERE id_socio = " + cliente);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Juardamos el valor total de veces en una variable para luego mostrar
        try {
            while (rs.next()) {
                numeroAlquileres = rs.getInt("alquiler");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Validamos que el cliente exista y mostramos el resultado
        if (numeroAlquileres == 0) {
            JOptionPane.showMessageDialog(null, "El cliente ingresado no existes");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ha realizado " + numeroAlquileres);
        }

        //Traemos las peliculas que alquilo el cliente, y luego las seteamos dentro de una tabla para mostrarlas
        try {
            pt = cn.prepareStatement("SELECT peliculas.id_peliculas, titulo, duracion, categoria, alquileres.id_socio"
                    + " \nFROM peliculas"
                    + " \nINNER JOIN alquileres ON alquileres.id_peliculas = peliculas.id_peliculas"
                    + " \nWHERE alquileres.id_socio = " + cliente
                    + " \nORDER BY id_peliculas");
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                try {
                    registro[0] = rs.getString(1);
                    registro[1] = rs.getString(2);
                    registro[2] = rs.getString(3);
                    registro[3] = rs.getString(4);
                    ModeloTabla.addRow(registro);
                } catch (SQLException ex) {
                    Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTable1.setModel(ModeloTabla);

        //Devolvemos la conexion al pool de conexiones
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        //Creamos las variables que vamos a usar
        int numeroPeliculas = 0;
        int idDvd = 0;
        int idCaset = 0;
        int contadorCaset = 0;
        int contadorDvd = 0;

        //Ingresamos el id de la pelicula a buscar
        int pelicula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la pelicula"));

        //Conectamos al pool de conexiones
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Traemos la cantidad de veces que la pelicula especificada ha sido alquilada
        try {
            pt = cn.prepareStatement("SELECT COUNT(n_alquiler) AS numeroPeliculas \n"
                    + " FROM alquileres\n"
                    //  + " INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + " WHERE alquileres.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Guardamos el numero de veces que la pelicula fue alquilada en una variable para luego mostrar
        try {
            while (rs.next()) {
                numeroPeliculas = rs.getInt("numeroPeliculas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Traemos los caset que tengan la pelicula alquilada, para eso debemos hacer 2 inner join ya que las tablas caset y alquiler solo se relacionan a travezx de peliculas
        try {
            pt = cn.prepareStatement("SELECT *"
                    + "FROM alquileres\n"
                    + "INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + "INNER JOIN caset ON caset.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE peliculas.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Si la consulta trae algo entonces el ciclo se ejecuta tantas veces como campos haya traido por lo cula nos cuenta para luego validar que la pelicula esta en caset
        try {
            while (rs.next()) {
                contadorCaset++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Realizamos el mismo procedimeinto con los dvds que en los casets
        try {
            pt = cn.prepareStatement("SELECT *"
                    + " FROM alquileres\n"
                    + " INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + " INNER JOIN dvd ON dvd.id_peliculas = peliculas.id_peliculas\n"
                    + " WHERE peliculas.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                contadorDvd++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Validamos primero que la pelicula haya sido usada, y luego validamos si es un caset o dvd y mostramos el resultado
        if (numeroPeliculas == 0) {
            JOptionPane.showMessageDialog(null, "La pelicula que ingreso no presenta uso");
        } else {
            if (contadorCaset != 0 && contadorDvd == 0) {
                JOptionPane.showMessageDialog(null, "Caset alquilado " + numeroPeliculas + " veces");
            } else {
                JOptionPane.showMessageDialog(null, "DVD alquilado " + numeroPeliculas + " veces");
            }
        }

        //Por ultimo devolvemos la conexion al pool
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int alquileres = 0;
        int tardanzas = 0;
        float gtotal = 0;
        float gtaldanza = 0;

        int cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del socio"));
                
        Connection cn = null;
        PreparedStatement pt = null;
        
        try {
            cn = Conexion.getInstance().getConnection();
            pt = cn.prepareStatement("SELECT n_alquileres, n_tardanzas, g_total, g_tardanzas"
                    + " \nFROM socios"
                    + " \nWHERE id_socio = " + cliente);

        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                alquileres = rs.getInt(1);
                tardanzas = rs.getInt(2);
                gtotal = rs.getFloat(3);
                gtaldanza = rs.getFloat(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "El cliente ingresado tiene: \n" +
                alquileres + " Alquileres\n" +
                tardanzas + " Tardanzas\n" + 
                "$" + gtotal + " En gastos totales\n" +
                "$" + gtaldanza + " En gastos por tardanzas");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        Principal princip = new Principal();
        princip.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        //Creamos las variables para la tabla que mostrara los resultados
        String[] registro = new String[5];

        String[] columnas = {"ID SOCIO", "NOMBRE", "TELEFONO", "DIRECCION","N?? ALQUILERES"};
        //El metodo Default table model nos permite definir una cantidad de columnas fijas
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas);
        
        //Incertamos el cleinte que queremos msotrar los datos
        int cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del socio"));
        
        Connection cn = null;
        PreparedStatement pt = null;
        
        //Seleccionamos los datos a mostrar del cliente
        try {
            cn = Conexion.getInstance().getConnection();
            pt = cn.prepareStatement("SELECT id_socio, CONCAT(nombre,' ' ,apellido), telefono, direccion, n_alquileres"
                    + " \nFROM socios"
                    + " \nWHERE id_socio = " + cliente);

        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Capturamos dentro del arreglo cada una de las columnas que trajimos de cleinte apra luego con addRow introducirlo dentro del modelo de la tabla
        try {
            while (rs.next()) {
                registro[0] = Integer.toString(rs.getInt(1));
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = Integer.toString(rs.getInt(5));
                ModeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoExtra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Metemos dentro de la tabla el modelo armado 
        jTable1.setModel(ModeloTabla);
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoExtra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoExtra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
