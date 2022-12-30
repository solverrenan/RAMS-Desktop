/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yhammy21
 */
// Queries for user accounts
public class Account_Queries extends SQLConnection {
    
    public Account_Queries(){
        super();
    }
    
    public ResultSet getAllUserAccountsInformation(){
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null,sqlex.toString(),"SQL Query Error!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
