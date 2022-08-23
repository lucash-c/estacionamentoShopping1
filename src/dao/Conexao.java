/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        //localhost:
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhoAcademicoEstacionamentoShopping" , "root", "55247022Lucas");
        
        
        
         //host Somee.
       // Class.forName("net.sourceforge.jtds.jdbc.Driver");       
      // Connection conexao = DriverManager.getConnection(
       // "jdbc:jtds:sqlserver://estacionamento-shopping.mssql.somee.com;"+"databaseName=estacionamento-shopping;user=lucash_c_SQLLogin_1;"+"password=bo9p2abtaf;"
            // );
        
   
        return conexao;
        
        
    }
    
}
