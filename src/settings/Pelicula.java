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
import pantallas.CargarPelicula;

/**
 *
 * @author PC-HOGAR
 */
public class Pelicula {
 
    private String director;
    private String duracion;
    private String genero;
    private String titulo;
    private float precio;
    
    private boolean beta;
    private boolean caset;
    private boolean doble;
    private boolean dvd;
    private boolean simple;
    private boolean vhs;

    public Pelicula() {
    }        

    public Pelicula(String director, String duracion, String genero, String titulo, float precio, boolean beta, boolean caset, boolean doble, boolean dvd, boolean simple, boolean vhs) {
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.titulo = titulo;
        this.precio = precio;
        this.beta = beta;
        this.caset = caset;
        this.doble = doble;
        this.dvd = dvd;
        this.simple = simple;
        this.vhs = vhs;
    }
          
    
    public void cargarPelicula(){
        
        int idPelicula = 0;
        //Conectamos al pool
        Connection cn = null;
        try {
            cn = Conexion.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cargar caset / simple
        if (caset == true && simple == true && dvd == false && doble == false) {

            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, titulo.toLowerCase());
                pt.setString(2, duracion.toLowerCase());
                pt.setString(3, director.toLowerCase());
                pt.setString(4, genero.toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + titulo.toLowerCase() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (vhs == true && beta == false) {
                    pt.setString(1, "VHS");
                } else if (vhs == false && beta == true) {
                    pt.setString(1, "Beta");
                }
                pt.setFloat(2, precio);

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar caset / doble
            
        } else if (caset == true && simple == false && dvd == false && doble == true) {
            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, titulo.toLowerCase());
                pt.setString(2, duracion.toLowerCase());
                pt.setString(3, director.toLowerCase());
                pt.setString(4, genero.toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + titulo.toLowerCase() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                //Ejecuto dos veces el codigo para generar dos casets 
                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (vhs == true && beta == false) {
                    pt.setString(1, "VHS");
                } else if (vhs == false && beta == true) {
                    pt.setString(1, "Beta");
                }
                
                pt.setFloat(2, precio);

                pt.executeUpdate();

                pt = cn.prepareStatement("INSERT INTO caset(id_peliculas, tipo, precio, estado) VALUES(" + idPelicula + ",?,?,'Disponible')");

                if (vhs == true && beta == false) {
                    pt.setString(1, "VHS");
                } else if (vhs == false && beta == true) {
                    pt.setString(1, "Beta");
                }
                
                pt.setFloat(2, precio);

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar dvd / simple
            
        } else if (caset == false && simple == true && dvd == true && doble == false) {
            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

               pt.setString(1, titulo.toLowerCase());
                pt.setString(2, duracion.toLowerCase());
                pt.setString(3, director.toLowerCase());
                pt.setString(4, genero.toLowerCase());

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + titulo.toLowerCase() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, precio);

                pt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: " + ex);
            }

            //Cargar dvd / doble
            
        } else if (caset == false && simple == false && dvd == true && doble == true) {

            try {
                PreparedStatement pt = cn.prepareStatement("INSERT INTO peliculas(titulo, duracion, director, categoria) VALUES (?, ?, ?, ?)");

                pt.setString(1, titulo.toLowerCase());
                pt.setString(2, duracion.toLowerCase());
                pt.setString(3, director.toLowerCase());
                pt.setString(4, genero.toLowerCase());
                

                pt.executeUpdate();

                pt = cn.prepareStatement("SELECT id_peliculas FROM peliculas WHERE titulo = '" + titulo.toLowerCase() + "'");

                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    idPelicula = rs.getInt("id_peliculas");
                }

                //Ejecuto dos veces el codigo para generar dos dvd
                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, precio);

                pt.executeUpdate();

                pt = cn.prepareStatement("INSERT INTO dvd(id_peliculas, precio, estado) VALUES(" + idPelicula + ",?,'Disponible')");

                pt.setFloat(1, precio);

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
    }
    
    public void cantidadAlquileresPelicula(){
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
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Traemos la cantidad de veces que la pelicula especificada ha sido alquilada
        try {
            pt = cn.prepareStatement("SELECT COUNT(n_alquiler) AS numeroPeliculas \n"
                    + " FROM alquileres\n"
                    //  + " INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + " WHERE alquileres.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Guardamos el numero de veces que la pelicula fue alquilada en una variable para luego mostrar
        try {
            while (rs.next()) {
                numeroPeliculas = rs.getInt("numeroPeliculas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Traemos los caset que tengan la pelicula alquilada, para eso debemos hacer 2 inner join ya que las tablas caset y alquiler solo se relacionan a travezx de peliculas
        try {
            pt = cn.prepareStatement("SELECT *"
                    + "FROM alquileres\n"
                    + "INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + "INNER JOIN caset ON caset.id_peliculas = peliculas.id_peliculas\n"
                    + "WHERE peliculas.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Si la consulta trae algo entonces el ciclo se ejecuta tantas veces como campos haya traido por lo cula nos cuenta para luego validar que la pelicula esta en caset
        try {
            while (rs.next()) {
                contadorCaset++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Realizamos el mismo procedimeinto con los dvds que en los casets
        try {
            pt = cn.prepareStatement("SELECT *"
                    + " FROM alquileres\n"
                    + " INNER JOIN peliculas ON peliculas.id_peliculas = alquileres.id_peliculas\n"
                    + " INNER JOIN dvd ON dvd.id_peliculas = peliculas.id_peliculas\n"
                    + " WHERE peliculas.id_peliculas = " + pelicula);
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs.next()) {
                contadorDvd++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
