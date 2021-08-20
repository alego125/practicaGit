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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC-HOGAR
 */
public class Socio {

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Socio() {
    }   
    
    public Socio(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void cargarSocio() throws SQLException {

        //Conectamos al pool
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        //Cargamos socio a la tabla
        pt = cn.prepareStatement("INSERT INTO socios(nombre, apellido, telefono, direccion) VALUES(?,?,?,?)");

        pt.setString(1, nombre.toLowerCase());
        pt.setString(2, apellido.toLowerCase());
        pt.setString(3, telefono.toLowerCase());
        pt.setString(4, direccion.toLowerCase());

        pt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Registro realizado exitosamente");

    }
    
    public DefaultTableModel mostrarInfoCliente(){
        //Creamos las variables para la tabla que mostrara los resultados
        String[] registro = new String[5];

        String[] columnas = {"ID SOCIO", "NOMBRE", "TELEFONO", "DIRECCION","N° ALQUILERES"};
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
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModeloTabla;        
    }

    public DefaultTableModel AlquileresCliente(){
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
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Contamos el numero de veces que se encuentra dedntro de la tabla alquileres el id del socio, con lo cual sabremos el numero de alquileres que ha hecho
        try {
            pt = cn.prepareStatement("SELECT COUNT(n_alquiler) AS alquiler FROM alquileres WHERE id_socio = " + cliente);
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Juardamos el valor total de veces en una variable para luego mostrar
        try {
            while (rs.next()) {
                numeroAlquileres = rs.getInt("alquiler");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Validamos que el cliente exista y mostramos el resultado
        if (numeroAlquileres == 0) {
            JOptionPane.showMessageDialog(null, "El cliente ingresado no existes");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ha realizado " + numeroAlquileres + " alquileres");
        }

        //Traemos las peliculas que alquilo el cliente, y luego las seteamos dentro de una tabla para mostrarlas
        try {
            pt = cn.prepareStatement("SELECT peliculas.id_peliculas, titulo, duracion, categoria, alquileres.id_socio"
                    + " \nFROM peliculas"
                    + " \nINNER JOIN alquileres ON alquileres.id_peliculas = peliculas.id_peliculas"
                    + " \nWHERE alquileres.id_socio = " + cliente
                    + " \nORDER BY id_peliculas");
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }       

        //Devolvemos la conexion al pool de conexiones
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ModeloTabla;
    }
    
    //Metodo para calcular cuandto en alquileres y cuento en retrasos ha gastado el cleinte
    public void gastosYRetrasos(){
        
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
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                alquileres = rs.getInt(1);
                tardanzas = rs.getInt(2);
                gtotal = rs.getFloat(3);
                gtaldanza = rs.getFloat(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "El cliente ingresado tiene: \n" +
                alquileres + " Alquileres\n" +
                tardanzas + " Tardanzas\n" + 
                "$" + gtotal + " En gastos totales\n" +
                "$" + gtaldanza + " En gastos por tardanzas");
        
    }
    
}
