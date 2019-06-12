/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Firas
 */
public class DBConnector {
    public static Connection conn = null;
    
    public static Connection getConnector() throws ClassNotFoundException{
        
        try{
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_webservice", "root", ""); 
             System.out.println(" connected to database! ");
        }
        catch(Exception e){
            System.err.println("Error while connecting to database! ");
        }
        return conn;
    }
    
    public void close() throws SQLException{
        conn.close();
    }
}
