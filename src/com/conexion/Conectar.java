/*
 * Con esta clase nos conectamos a la base de datos 
 */
package com.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gemma
 */
public class Conectar {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/bd_tapce";

    public Conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Connexion establecida ");
            }
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al coectar " + e);
        }
    }
    
    // Con este metodo nos retorna la conecion 
    public Connection getConnection(){
        return conn;
    }
    
    // con este metodo nos desconectamos de la base de datos 
    public void desconectar (){
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada");    
        }
    }
}
