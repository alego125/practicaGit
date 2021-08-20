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
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pantallas.CargarActores;

/**
 *
 * @author PC-HOGAR
 */
public class Actores {

    //Creamos un arraylist donde almacenamos todos los elementos de la base de datos que iran en nuesto jlist
    private ArrayList array = new ArrayList();
    DefaultListModel modelo = new DefaultListModel();

    private Object listaPeliculas[];
    private String nombre;
    private String estadoCivil;
    private int edad;

    public Actores() {

    }

    public void setListaPeliculas(Object[] listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public DefaultListModel mostrarPeliculas() {
        //Creamos la Conexion para traer todas las peliculas
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {
            pt = cn.prepareStatement("SELECT * FROM peliculas");
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos trodas las peliculas de la base de datos 
        ResultSet rs = null;
        try {
            rs = pt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Guardamos cada una de las peliculas traidas dentro de el arraylist
        try {
            while (rs.next()) {
                //Introducimos cada uno de los titulos dentro del arraylist
                this.array.add(rs.getString("titulo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Agregamos cada eleemnto del array dentro del modelo que sera usado para crear la lista, para esto necesitamos recorrer con un for el array
        for (int i = 0; i < this.array.size(); i++) {
            this.modelo.addElement(this.array.get(i));
        }

        //Cerramos conexion
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;
    }

    public void cargarActor() {

        int idActor = 0;
        int id = 0;

        Connection cn = null;
        PreparedStatement pt = null;
        try {
            //Abro la conexion
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Cargo los datos del actor
            pt = cn.prepareStatement("INSERT INTO actores(nombre, est_civiL, edad) VALUES(?, ?, ?)");

            pt.setString(1, nombre.toLowerCase());
            pt.setString(2, estadoCivil.toLowerCase());
            pt.setInt(3, edad);

            System.out.println(pt);
            pt.executeUpdate();

            //Obtengo el id del actor cargado
            pt = cn.prepareStatement("SELECT id_actores FROM actores WHERE nombre = '" + nombre.toLowerCase() + "'");

            System.out.println(pt);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                idActor = rs.getInt("id_actores");
            }

            System.out.println(idActor);

            //Recorro las peliculas que seleccione de la lista
            for (int i = 0; i < listaPeliculas.length; i++) {

                System.out.println(listaPeliculas[i]);

                //Selecciono cada id de cada pelicula seleccionada
                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + listaPeliculas[i] + "'");

                System.out.println(pt);

                rs = pt.executeQuery();

                while (rs.next()) {
                    id = rs.getInt("id_peliculas");
                }

                System.out.println(id);

                //Cargo el id del actor el cual sera el mismo con cada id de cada pelicula dentro de la lista
                pt = cn.prepareStatement("INSERT INTO actores_peliculas(id_peliculas, id_actores) VALUES(" + id + ", " + idActor + ")");

                System.out.println(pt);

                pt.executeUpdate();

            }

            JOptionPane.showMessageDialog(null, "Carga realizada con exito");
            //Cerramos la conexion
//                Conexion.getInstance().closeConnection(cn);

        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }
//Cerramos conexion
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CargarActores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
