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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import org.eclipse.persistence.sessions.server.ConnectionPool;
import settings.Conexion;

/**
 *
 * @author PC-HOGAR
 */
public class CargarPelicula extends javax.swing.JFrame {

    /**
     * Creates new form CargarPelicula
     */
//    private static String url;
//    private static String user;
//    private static String pass;

    public CargarPelicula() {
        initComponents();
//        this.url = "jdbc:mysql://localhost:3306/videoclub";
//        this.user = "root";
//        this.pass = "";
        this.setLocationRelativeTo(null);

        buttonGroup1.add(jRadioButton_caset);
        buttonGroup1.add(jRadioButton_dvd);
        buttonGroup2.add(jRadioButton_doble);
        buttonGroup2.add(jRadioButton_simple);
        buttonGroup3.add(jRadioButton_vhs);
        buttonGroup3.add(jRadioButton_beta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_director = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_genero = new javax.swing.JTextField();
        txt_duracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jRadioButton_dvd = new javax.swing.JRadioButton();
        jRadioButton_caset = new javax.swing.JRadioButton();
        jRadioButton_simple = new javax.swing.JRadioButton();
        jRadioButton_doble = new javax.swing.JRadioButton();
        jRadioButton_vhs = new javax.swing.JRadioButton();
        jRadioButton_beta = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CARGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Titulo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Director");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Genero");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Duracion (colocan en formato HH:MM:SS)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio");

        jRadioButton_dvd.setText("DVD");

        jRadioButton_caset.setText("CASET");

        jRadioButton_simple.setText("SIMPLE");

        jRadioButton_doble.setText("DOBLE");

        jRadioButton_vhs.setText("VHS");

        jRadioButton_beta.setText("BETA");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("PELICULAS");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton_dvd)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton_caset))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton_simple)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton_doble))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton_vhs)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton_beta))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5))))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_director, txt_titulo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_dvd)
                    .addComponent(jRadioButton_caset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_simple)
                    .addComponent(jRadioButton_doble))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton_vhs)
                    .addComponent(jRadioButton_beta))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(3, 3, 3)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton que carga la pelicula a la base de datos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int idPelicula = 0;
        //Conectamos al pool
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cargar caset / simple
        if (jRadioButton_caset.isSelected() == true && jRadioButton_simple.isSelected() == true && jRadioButton_dvd.isSelected() == false && jRadioButton_doble.isSelected() == false) {

            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, txt_titulo.getText().toLowerCase());
                pt.setString(2, txt_duracion.getText().toLowerCase());
                pt.setString(3, txt_director.getText().toLowerCase());
                pt.setString(4, txt_genero.getText().toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + txt_titulo.getText() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (jRadioButton_vhs.isSelected() == true && jRadioButton_beta.isSelected() == false) {
                    pt.setString(1, "VHS");
                } else if (jRadioButton_vhs.isSelected() == false && jRadioButton_beta.isSelected() == true) {
                    pt.setString(1, "Beta");
                }
                pt.setFloat(2, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar caset / doble
        } else if (jRadioButton_caset.isSelected() == true && jRadioButton_simple.isSelected() == false && jRadioButton_dvd.isSelected() == false && jRadioButton_doble.isSelected() == true) {
            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, txt_titulo.getText().toLowerCase());
                pt.setString(2, txt_duracion.getText().toLowerCase());
                pt.setString(3, txt_director.getText().toLowerCase());
                pt.setString(4, txt_genero.getText().toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + txt_titulo.getText() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                //Ejecuto dos veces el codigo para generar dos casets 
                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (jRadioButton_vhs.isSelected() == true && jRadioButton_beta.isSelected() == false) {
                    pt.setString(1, "VHS");
                } else if (jRadioButton_vhs.isSelected() == false && jRadioButton_beta.isSelected() == true) {
                    pt.setString(1, "Beta");
                }
                pt.setFloat(2, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (jRadioButton_vhs.isSelected() == true && jRadioButton_beta.isSelected() == false) {
                    pt.setString(1, "VHS");
                } else if (jRadioButton_vhs.isSelected() == false && jRadioButton_beta.isSelected() == true) {
                    pt.setString(1, "Beta");
                }
                pt.setFloat(2, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar dvd / simple
        } else if (jRadioButton_caset.isSelected() == false && jRadioButton_simple.isSelected() == true && jRadioButton_dvd.isSelected() == true && jRadioButton_doble.isSelected() == false) {
            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, txt_titulo.getText().toLowerCase());
                pt.setString(2, txt_duracion.getText().toLowerCase());
                pt.setString(3, txt_director.getText().toLowerCase());
                pt.setString(4, txt_genero.getText().toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + txt_titulo.getText() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar dvd / doble
        } else if (jRadioButton_caset.isSelected() == false && jRadioButton_simple.isSelected() == false && jRadioButton_dvd.isSelected() == true && jRadioButton_doble.isSelected() == true) {

            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, txt_titulo.getText().toLowerCase());
                pt.setString(2, txt_duracion.getText().toLowerCase());
                pt.setString(3, txt_director.getText().toLowerCase());
                pt.setString(4, txt_genero.getText().toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + txt_titulo.getText() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                //Ejecuto dos veces el codigo para generar dos dvd
                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, Float.parseFloat(txt_precio.getText()));

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ha seleccionado casilleros incorrectos");
        }
        
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Resetamos todos los valores de la pantalla
        txt_director.setText("");
        txt_duracion.setText("");
        txt_genero.setText("");
        txt_precio.setText("");
        txt_titulo.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //Boton para cerrar la ventana actual y volver a la pantalla principal
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
//        //Me oculta el frame
//       this.setVisible(false);
        //Me cierra el frame
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CargarPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarPelicula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarPelicula().setVisible(true);
            }
        });
              
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton_beta;
    private javax.swing.JRadioButton jRadioButton_caset;
    private javax.swing.JRadioButton jRadioButton_doble;
    private javax.swing.JRadioButton jRadioButton_dvd;
    private javax.swing.JRadioButton jRadioButton_simple;
    private javax.swing.JRadioButton jRadioButton_vhs;
    private javax.swing.JTextField txt_director;
    private javax.swing.JTextField txt_duracion;
    private javax.swing.JTextField txt_genero;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
