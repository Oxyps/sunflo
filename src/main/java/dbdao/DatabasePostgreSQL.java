/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author milen
 */
public class DatabasePostgreSQL {     
    public static Connection conectar(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Integrador", "postgres", "3294");
        } catch (SQLException e) {		
            throw new RuntimeException(e);
        }    
    }
}