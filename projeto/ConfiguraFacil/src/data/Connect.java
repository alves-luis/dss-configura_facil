/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diogo
 */
public class Connect {
 
    public Connection Connect(){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:DSS");
            return conn;
        }
        catch (ClassNotFoundException | SQLException e) {}    
        return null;
    }
    public void close(Connection conn){
        try{
            conn.close();
        }
        catch (SQLException e) {}    
    }
}
