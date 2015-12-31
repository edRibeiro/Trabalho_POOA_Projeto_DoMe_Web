/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ederson
 */
public class ConnectionFactory {
     public static Connection getConnection() throws SQLException{
     // String //url = "jdbc:jtds:sqlserver://localhost:1433/vendas;user=root;password=";
         Connection c =null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
         
         return c  = DriverManager.getConnection("jdbc:mysql://localhost:3306/domeweb","root","");
         } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
         }
         
      return null;
    }
}
