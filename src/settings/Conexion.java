/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.persistence.sessions.server.ConnectionPool;

/**
 *
 * @author PC-HOGAR
 */
public class Conexion {

//    private static String url = "jdbc:mysql://localhost/videoclub";
//    private static String user = "root";
//    private static String pass = "";
    
    //Conexion a base de datos remota mediante el hostClever Cloud    
    
    private static String url = "jdbc:mysql://uwwo9xkytjosix9w:vtgdSH1ffD1mZoIDz3P6@b8qhvm8wexm0vibwanzg-mysql.services.clever-cloud.com:3306/b8qhvm8wexm0vibwanzg";
    private static String user = "uwwo9xkytjosix9w";
    private static String pass = "vtgdSH1ffD1mZoIDz3P6";

    private static Conexion dataSource;
    private BasicDataSource basicDataSource = null;

    private Conexion() {

        //Se establecen las conexiones basicas a la base de datos a indicando los accesos y el driver para realizarla
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);

        //Opcionalmente podemos agragar las siguinetes lineas de codigo para setear limitaciones en la conexion o dejarlo sin ellas para que el sistema las maneje
        basicDataSource.setMinIdle(5); //Minimo de conexiones inactivas que pueden haber
        basicDataSource.setMaxIdle(20); //Maximo de conexiones inactivas que pueden haber
        basicDataSource.setMaxTotal(50); //Maximo de conexiones en total, activas mas inactivas que pueden haber
        basicDataSource.setMaxWaitMillis(10000); //La espera maxima en milisegundos que realiza un usuario si estan todas las conexiones ocupadas
        //Si colocamos en los parentesis -1 el tiempo es infinito y el usuario queda en espera hasta que se libere una conexion y alli entra                                      
    }

    //Metodo que sirve para crear una instancia de la clase
    public static Conexion getInstance() {
        //Si ya existe el objeto datasource entonces ya hay instancia por lo tanto no entra al if y devuelve el objeto datasourse pues ya teiene la instancia creada
        if (dataSource == null) {
            dataSource = new Conexion();
        }
        return dataSource;
    }

    //Metodo para establecer la conexion 
    public Connection getConnection() throws SQLException {
//        Connection connect = null;
//        try{
//            connect = this.basicDataSource.getConnection();
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//        return connect;
        //O directamente podemos retornar lo sigiente y porner los throw en el metodo
        return this.basicDataSource.getConnection();
    }

    //Por ultimo se hace el metodo para cerrar la conexion y dejarla en espera para el proximo
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
