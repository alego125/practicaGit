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

/**
 *
 * @author PC-HOGAR
 */
public class Alquiler {

    private ArrayList array = new ArrayList();
    private DefaultListModel modelo = new DefaultListModel();
    private Object listaCaset[];
    private Object listaDvd[];
    private Object listaCasetDevuelto[];
    private Object listaDvdDevuelto[];
    private int cliente1;
    private int cliente2;
    private int clienteDevolver1;
    private int clienteDevolver2;

    public Alquiler() {

    }

    public void setCliente1(int cliente) {
        this.cliente1 = cliente;
    }

    public void setListaCaset(Object[] lista) {
        this.listaCaset = lista;
    }

    public void setListaDvd(Object[] listaDvd) {
        this.listaDvd = listaDvd;
    }

    public void setCliente2(int cliente2) {
        this.cliente2 = cliente2;
    }

    public void setClienteDevolver1(int clienteDevolver1) {
        this.clienteDevolver1 = clienteDevolver1;
    }

    public void setListaCasetDevuelto(Object[] listaCasetDevuelto) {
        this.listaCasetDevuelto = listaCasetDevuelto;
    }

    public void setListaDvdDevuelto(Object[] listaDvdDevuelto) {
        this.listaDvdDevuelto = listaDvdDevuelto;
    }

    public void setClienteDevolver2(int clienteDevolver2) {
        this.clienteDevolver2 = clienteDevolver2;
    }

    public DefaultListModel buscarCaset() {

        Connection cn = null;

        modelo.clear();

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (array.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no posee caset");
        }

        //Eliminamos los elementos del arreglo una vez hayamos mostrado todo, esto es para que no moleste cuando volvamos a hacer otra buscqueda
        array.clear();

        return modelo;
    }

    public DefaultListModel buscarDvd() {

        modelo.clear();

        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {

            //Realizamos la consulta para cuscar las peliculas que tiene alquiladas el socio
            pt = cn.prepareStatement("SELECT * \n"
                    + "FROM peliculas\n"
                    + "INNER JOIN dvd ON dvd.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE dvd.estado = 'Disponible'");

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                this.array.add(rs.getString("titulo"));
            }

            for (int i = 0; i < this.array.size(); i++) {
                this.modelo.addElement(this.array.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
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

        //Establecemos coneccion con la base de datos
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
        System.out.println(listaCaset);
        for (int i = 0; i < listaCaset.length; i++) {

            try {

                pt = cn.prepareStatement("SELECT *"
                        + " FROM peliculas"
                        + " INNER JOIN caset ON peliculas.id_peliculas = caset.id_peliculas"
                        + " WHERE peliculas.titulo = '" + listaCaset[i] + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPeli = rs.getInt("peliculas.id_peliculas");
                    precio = rs.getFloat("precio");
                }

                System.out.println("idpeli = " + idPeli);

                //Primero actualizamos en peliculas colocando el socio que la tiene 
                pt = cn.prepareStatement("UPDATE peliculas SET id_socio = ? WHERE peliculas.titulo = ?");

                pt.setInt(1, cliente1);
                pt.setString(2, (String) listaCaset[i]);

                System.out.println("id socio = " + cliente1 + "\ntitulo = " + listaCaset[i]);

                pt.executeUpdate();

                //Luego actualizamos el estado del caset a Alquilado
                pt = cn.prepareStatement("UPDATE caset SET estado = 'Alquilada', f_prestamo = ?, f_devolucion = NULL WHERE caset.id_peliculas = " + idPeli);

                pt.setDate(1, Date.valueOf(LocalDate.now()));

                System.out.println(Date.valueOf(LocalDate.now()));

                pt.executeUpdate();

                //Seleccionamos todo del socios para luego obtener el total de gastos que ha hecho el socio en el videoclub
                pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + cliente1);

                rs = pt.executeQuery();

                //Obtenermos el gasto total hecho en el videoclub por el socio
                while (rs.next()) {
                    gsocio = rs.getFloat("g_total");
                }

                System.out.println("gasto socio " + gsocio);

                //Asignamos el gasto al socio
                valorNuevo = gsocio + precio;

                System.out.println("valor nuevo " + valorNuevo);

                pt = cn.prepareStatement("UPDATE socios SET g_total = " + valorNuevo + " WHERE socios.id_socio = " + cliente1);

                pt.executeUpdate();

                //Seleccionamos el numero de alquileres que ha hecho el socio
                pt = cn.prepareStatement("SELECT n_alquileres FROM socios WHERE id_socio = " + cliente1);

                rs = pt.executeQuery();

                while (rs.next()) {
                    alquileres = rs.getInt("n_alquileres");
                }

                //Aumentamos en 1 los alquileres por cada nuevo alquiler hecho
                alquileres++;

                //Seteamos el nuevo valor dentro de la tabla de socios
                pt = cn.prepareStatement("UPDATE socios SET n_alquileres = " + alquileres + " WHERE id_socio = " + cliente1);

                pt.executeUpdate();

                //Incertamos el registro de el alquiler en la tabla de alquileres para llevar un historial de alquileres hechos
                pt = cn.prepareStatement("INSERT INTO alquileres(id_peliculas, id_socio, f_alquiler) VALUES(?,?,?)");

                pt.setInt(1, idPeli);
                pt.setInt(2, cliente1);
                pt.setDate(3, Date.valueOf(LocalDate.now()));;

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Alquiler realizado con exito");

            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Por ultimo devolvemos la conexion al pool
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alquilarDvd() {

        System.out.println("Cliente fdfasdfasdf " + cliente2);

        int idPeli = 0;
        int alquileres = 0;
        String estado = "";
        String nombrePeli = "";
        float precio = 0;
        float gsocio = 0;
        float valorNuevo;

        //Establecemos coneccion con la base de datos
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
        for (int i = 0; i < listaDvd.length; i++) {

            try {

                pt = cn.prepareStatement("SELECT *"
                        + " FROM peliculas"
                        + " INNER JOIN dvd ON peliculas.id_peliculas = dvd.id_peliculas"
                        + " WHERE peliculas.titulo = '" + listaDvd[i] + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPeli = rs.getInt("peliculas.id_peliculas");
                    precio = rs.getFloat("precio");
                }

                System.out.println("idpeli = " + idPeli);

                //Primero actualizamos en peliculas colocando el socio que la tiene 
                pt = cn.prepareStatement("UPDATE peliculas SET id_socio = ? WHERE peliculas.titulo = ?");

                pt.setInt(1, cliente2);
                pt.setString(2, (String) listaDvd[i]);

                System.out.println("id socio = " + cliente2 + "\ntitulo = " + listaDvd[i]);

                pt.executeUpdate();

                //Luego actualizamos el estado del caset a Alquilado
                pt = cn.prepareStatement("UPDATE dvd SET estado = 'Alquilada', f_prestamo = ?, f_devolucion = NULL WHERE dvd.id_peliculas = " + idPeli);

                pt.setDate(1, Date.valueOf(LocalDate.now()));

                System.out.println(Date.valueOf(LocalDate.now()));

                pt.executeUpdate();

                //Seleccionamos todo del socios para luego obtener el total de gastos que ha hecho el socio en el videoclub
                pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + cliente2);

                rs = pt.executeQuery();

                //Obtenermos el gasto total hecho en el videoclub por el socio
                while (rs.next()) {
                    gsocio = rs.getFloat("g_total");
                }

                System.out.println("gasto socio " + gsocio);

                //Asignamos el gasto al socio
                valorNuevo = gsocio + precio;

                System.out.println("valor nuevo " + valorNuevo);

                pt = cn.prepareStatement("UPDATE socios SET g_total = " + valorNuevo + " WHERE socios.id_socio = " + cliente2);

                pt.executeUpdate();

                //Seleccionamos el numero de alquileres que ha hecho el socio
                pt = cn.prepareStatement("SELECT n_alquileres FROM socios WHERE id_socio = " + cliente2);

                rs = pt.executeQuery();

                while (rs.next()) {
                    alquileres = rs.getInt("n_alquileres");
                }

                //Aumentamos en 1 los alquileres por cada nuevo alquiler hecho
                alquileres++;

                System.out.println("N alquileres " + alquileres);

                //Seteamos el nuevo valor dentro de la tabla de socios
                pt = cn.prepareStatement("UPDATE socios SET n_alquileres = " + alquileres + " WHERE socios.id_socio = " + cliente2);

                System.out.println(pt);

                pt.executeUpdate();

                //Incertamos el registro de el alquiler en la tabla de alquileres para llevar un historial de alquileres hechos
                pt = cn.prepareStatement("INSERT INTO alquileres(id_peliculas, id_socio, f_alquiler) VALUES(?,?,?)");

                pt.setInt(1, idPeli);
                pt.setInt(2, cliente2);
                pt.setDate(3, Date.valueOf(LocalDate.now()));;

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Alquiler realizado con exito");

            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Por ultimo devolvemos la conexion al pool
        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultListModel casetsSocio() {

        modelo.clear();

        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {

            //Realizamos la consulta para cuscar las peliculas que tiene alquiladas el socio
            pt = cn.prepareStatement("SELECT peliculas.titulo\n"
                    + "FROM peliculas\n"
                    + "INNER JOIN caset ON caset.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE peliculas.id_socio = " + clienteDevolver1);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                this.array.add(rs.getString("titulo"));
            }

            for (int i = 0; i < this.array.size(); i++) {
                this.modelo.addElement(this.array.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (array.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no posee caset");
        }

        //Eliminamos los elementos del arreglo una vez hayamos mostrado todo, esto es para que no moleste cuando volvamos a hacer otra buscqueda
        array.clear();

        return modelo;
    }

    public DefaultListModel dvdSocio() {
        //Limpiamos la lista antes de comenzar a mostrar resultados
        modelo.clear();

        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement pt = null;
        try {

            //Realizamos la consulta para cuscar las peliculas que tiene alquiladas el socio
            pt = cn.prepareStatement("SELECT peliculas.titulo\n"
                    + "FROM peliculas\n"
                    + "INNER JOIN dvd ON dvd.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE peliculas.id_socio = " + clienteDevolver2);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                this.array.add(rs.getString("titulo"));
            }

            for (int i = 0; i < this.array.size(); i++) {
                this.modelo.addElement(this.array.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (array.size() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no posee dvd");
        }

        //Eliminamos los elementos del arreglo una vez hayamos mostrado todo, esto es para que no moleste cuando volvamos a hacer otra buscqueda
        array.clear();

        return modelo;
    }

    public void devolverCaset() {
        int idPeli = 0;
        int n_devolucion = 0;
        //Establecemos fechas
        Date fechaPrestamo = null;
        //Fecha actual en formato local
        Date fechaActual = Date.valueOf(LocalDate.now());

        //Mediante un condicional validamos que se haya seleccionado algo de la lista de peliculas a devolver
        //Establecemos coneccion con la base de datos
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
        for (int i = 0; i < listaCasetDevuelto.length; i++) {

            System.out.println(listaCasetDevuelto[i]);

            //Borramos el socio de peliculas
            try {
                pt = cn.prepareStatement("UPDATE peliculas SET id_socio = null WHERE titulo = '" + listaCasetDevuelto[i] + "'");
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Seleccionamos los casets que tengan las peliculas que vamos a devolver
            try {
                pt = cn.prepareStatement("SELECT * \n"
                        + "FROM caset\n"
                        + "INNER JOIN peliculas ON caset.id_peliculas = peliculas.id_peliculas\n"
                        + "WHERE peliculas.titulo = '" + listaCasetDevuelto[i] + "'");
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet rs = null;
            try {
                rs = pt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Obtenemos la fecha que se realizo el prestamo del caset
            try {
                while (rs.next()) {
                    fechaPrestamo = rs.getDate("f_prestamo");
                    idPeli = rs.getInt("caset.id_peliculas");
                }
                System.out.println("fecha prestamo = " + fechaPrestamo);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
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
                        + "\nPerteneciente a la pelicula: " + listaCasetDevuelto[i]);

                try {
                    //Seleccionamos a socios para obtener lo que tiene acumulado de tardanzas
                    pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + clienteDevolver1);
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(pt);

                try {
                    rs = pt.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Obtenemos el acumulado de tardanzas del socio
                try {
                    while (rs.next()) {
                        tardanza = rs.getFloat("g_tardanzas");
                    }

                    System.out.println("tardanzas = " + tardanza);

                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

//                    //Le sumamos al acumulado el total de la multa actual
//                    multa = tardanza + multa;
                System.out.println("multa = " + multa);

                //Cargamos ese total dentro de la tabla al socio
                try {
                    pt = cn.prepareStatement("UPDATE socios SET g_tardanzas = " + (multa + tardanza) + " WHERE id_socio = " + clienteDevolver1);
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(pt);

                try {
                    pt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //Seteamos el estado a disponible del caset al igual que borramos la fecha de prestamo y colocamos la fecha de devolucion
            try {
                pt = cn.prepareStatement("UPDATE caset SET estado = 'Disponible', f_prestamo = NULL, f_devolucion = ? WHERE id_peliculas = " + idPeli);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.setDate(1, fechaActual);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Seleccionamos las devoluciones hechas 
            try {
                pt = cn.prepareStatement("SELECT devoluciones FROM socios WHERE id_socio = " + clienteDevolver1);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                rs = pt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                while (rs.next()) {
                    n_devolucion = rs.getInt("devoluciones");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            n_devolucion = n_devolucion + 1;

            System.out.println("devoluciones " + n_devolucion);

            //Cargamos las nuevas devoluciones mas las que ya habian
            try {
                pt = cn.prepareStatement("UPDATE socios SET devoluciones = " + n_devolucion + " WHERE id_socio = " + clienteDevolver1);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Pelicula devuelta con exito");

            //Cerramos la conexion (devolvemos la conexion al pool)                
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void devolverDvd() {
        
        int n_devolucion = 0;
        int idPeli = 0;
        //Establecemos fechas
        Date fechaPrestamo = null;
        //Fecha actual en formato local
        Date fechaActual = Date.valueOf(LocalDate.now());

        //Establecemos coneccion con la base de datos
        Connection cn = null;
        PreparedStatement pt = null;

        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Recorremos la lista de nombres de peliculas a devolver y hacemos consultas por cada una de ellas
        for (int i = 0; i < listaDvdDevuelto.length; i++) {

            System.out.println(listaDvdDevuelto[i]);

            //Borramos el socio de peliculas
            try {
                pt = cn.prepareStatement("UPDATE peliculas SET id_socio = null WHERE titulo = '" + listaDvdDevuelto[i] + "'");
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Seleccionamos los casets que tengan las peliculas que vamos a devolver
            try {
                pt = cn.prepareStatement("SELECT * \n"
                        + "FROM dvd\n"
                        + "INNER JOIN peliculas ON dvd.id_peliculas = peliculas.id_peliculas\n"
                        + "WHERE peliculas.titulo = '" + listaDvdDevuelto[i] + "'");
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet rs = null;
            try {
                rs = pt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Obtenemos la fecha que se realizo el prestamo del caset
            try {
                while (rs.next()) {
                    fechaPrestamo = rs.getDate("f_prestamo");
                    idPeli = rs.getInt("dvd.id_peliculas");
                }
                System.out.println("fecha prestamo = " + fechaPrestamo);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
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
                JOptionPane.showMessageDialog(null, "Debe pagar una multa de $" + multa + " correspondiente a " + (diasPasados - 3) + " dias de retraso");

                try {
                    //Seleccionamos a socios para obtener lo que tiene acumulado de tardanzas
                    pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + clienteDevolver2);
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    rs = pt.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Obtenemos el acumulado de tardanzas del socio
                try {
                    while (rs.next()) {
                        tardanza = rs.getFloat("g_tardanzas");
                    }

                    System.out.println("tardanzas = " + tardanza);

                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

//                    //Le sumamos al acumulado el total de la multa actual
//                    multa = tardanza + multa;
                System.out.println("multa = " + multa);

                //Cargamos ese total dentro de la tabla al socio
                try {
                    pt = cn.prepareStatement("UPDATE socios SET g_tardanzas = " + (multa + tardanza) + " WHERE id_socio = " + clienteDevolver2);
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    pt.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //Seteamos el estado a disponible del caset al igual que borramos la fecha de prestamo y colocamos la fecha de devolucion
            try {
                pt = cn.prepareStatement("UPDATE dvd SET estado = 'Disponible', f_prestamo = NULL, f_devolucion = ? WHERE id_peliculas = " + idPeli);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.setDate(1, fechaActual);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt = cn.prepareStatement("SELECT * FROM socios WHERE id_socio = " + clienteDevolver2);
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                rs = pt.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                while (rs.next()) {
                    n_devolucion = rs.getInt("devoluciones");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("devoluciones " + n_devolucion);

            try {
                pt = cn.prepareStatement("UPDATE socios SET devoluciones = " + (n_devolucion++));
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Pelicula devuelta con exito");

            //Cerramos la conexion (devolvemos la conexion al pool)                
        }

        try {
            Conexion.getInstance().closeConnection(cn);
        } catch (SQLException ex) {
            Logger.getLogger(Alquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

