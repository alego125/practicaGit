/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pantallas.BuscarDisponibilidades;
import pantallas.CargarPelicula;

/**
 *
 * @author PC-HOGAR
 */
public class Disponibilidades {

    public Disponibilidades() {

    }

    public DefaultTableModel totalDvds() {
        String[] registro = new String[5];

        String[] columnas = {"ID PELICULA", "ID CASET", "PELICULA", "PRECIO", "ESTADO"};
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

        try {
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModeloTabla;
    }
    
    public DefaultTableModel totalCasets(){
        String[] registro = new String[5];

        String[] columnas = {"ID PELICULA", "ID CASET", "PELICULA", "PRECIO", "ESTADO"};
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

        try {
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModeloTabla;
    }
    
    public DefaultTableModel dvdsDisponibles(){
        // TODO add your handling code here:
        String[] registro = new String[5];

        String[] columnas = {"ID PELICULA", "ID DVD", "PELICULA", "PRECIO", "ESTADO"};
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

        try {
            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModeloTabla;
    }
    
    public DefaultTableModel casetsDisponibles(){
        
        String[] registro = new String[5];

        String[] columnas = {"ID PELICULA", "ID CASET", "PELICULA", "PRECIO", "ESTADO"};
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

        try {
            while (rs.next()) {
                registro[0] = Integer.toString(rs.getInt(1));
                registro[1] = Integer.toString(rs.getInt(2));
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                ModeloTabla.addRow(registro);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BuscarDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModeloTabla;
    }

}
