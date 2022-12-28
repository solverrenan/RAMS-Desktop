/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author yhammy21
 */
//Parent class of all query java class subclasses
public class SQLConnection {
    //Variables used in creating an SQL connection to SQL Server and its databases, as well as the objects used for querying data
    protected String connectionURL;
    protected Connection sqlConnection;
    protected Statement sqlStatement; 
    protected String query;
    protected ResultSet rs;
    
    //Initialize connection with SQL Server and connect to database named RoomAssignmentAndManagementDB
    public SQLConnection(){
        try {
            connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=RoomAssignmentAndManagementDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
            sqlConnection = DriverManager.getConnection(connectionURL);            
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null,sqlex.toString(),"SQL Connection Error!",JOptionPane.ERROR_MESSAGE);
        }        
    }
}
