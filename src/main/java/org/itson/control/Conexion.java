/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Victor y Samuel
 */
public class Conexion {
    // ATRIBUTOS
    
    private final String base = "agencia_transito";
    private final String user = "root";
    private final String password = "Retrodashers*10";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    // MÉTODOS
    
    /**
     * Método para establecer una conexión con la base de datos
     * @return Una conexión con la base de datos
     */
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, 
                    this.user, this.password);  
        } catch(SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log
        (Level.SEVERE, null, ex);
        }
      return con;  
    }
}