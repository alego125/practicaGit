/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

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
import pantallas.AlquilarCaset;

/**
 *
 * @author PC-HOGAR
 */
public class Alquiler {

    private ArrayList array = new ArrayList();
    private DefaultListModel modelo = new DefaultListModel();
    private Object lista[];
    private int cliente;

    public Alquiler() {

    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }        

    public void setLista(Object[] lista) {
        this.lista = lista;
    }   
    
    public DefaultListModel buscarCaset() {

        Connection cn = null;

        modelo.clear();

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

        return modelo;
    }

    public void alquilarCaset() {
        int idPeli = 0;
        int alquileres = 0;
        String estado = "";
        String nombrePeli = "";
        float precio = 0;
        float gsocio = 0;
        float valorNuevo;

        AlquilarCaset aq = new AlquilarCaset();

        //Establecemos coneccion con la base de datos
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AlquilarCaset.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
        System.out.println(lista);
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

                pt.setInt(1, cliente);
                pt.setString(2, (String) lista[i]);

                System.out.println("id socio = " + cliente + "\ntitulo = " + lista[i]);

                pt.executeUpdate();

                //Luego actualizamos el estado del caset a Alquilado
                pt = cn.prepareStatement("UPDATE caset SET estado = 'Alquilada', f_prestamo = ?, f_devolucion = NULL WHERE caset.id_peliculas = " + idPeli);

                pt.setDate(1, Date.valueOf(LocalDate.now()));

                System.out.println(Date.valueOf(LocalDate.now()));

                pt.executeUpdate();

                //Seleccionamos todo del socios para luego obtener el total de gastos que ha hecho el socio en el videoclub
                pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + cliente);

                rs = pt.executeQuery();

                //Obtenermos el gasto total hecho en el videoclub por el socio
                while (rs.next()) {
                    gsocio = rs.getFloat("g_total");
                }

                System.out.println("gasto socio " + gsocio);

                //Asignamos el gasto al socio
                valorNuevo = gsocio + precio;

                System.out.println("valor nuevo " + valorNuevo);

                pt = cn.prepareStatement("UPDATE socios SET g_total = " + valorNuevo + " WHERE socios.id_socio = " + cliente);

                pt.executeUpdate();

                //Seleccionamos el numero de alquileres que ha hecho el socio
                pt = cn.prepareStatement("SELECT n_alquileres FROM socios WHERE id_socio = " + cliente);

                rs = pt.executeQuery();

                while (rs.next()) {
                    alquileres = rs.getInt("n_alquileres");
                }

                //Aumentamos en 1 los alquileres por cada nuevo alquiler hecho
                alquileres++;

                //Seteamos el nuevo valor dentro de la tabla de socios
                pt = cn.prepareStatement("UPDATE socios SET n_alquileres = " + alquileres + " WHERE id_socio = " + cliente);

                pt.executeUpdate();

                //Incertamos el registro de el alquiler en la tabla de alquileres para llevar un historial de alquileres hechos
                pt = cn.prepareStatement("INSERT INTO alquileres(id_peliculas, id_socio, f_alquiler) VALUES(?,?,?)");

                pt.setInt(1, idPeli);
                pt.setInt(2, cliente);
                pt.setDate(3, Date.valueOf(LocalDate.now()));;

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

    
    
    
}
