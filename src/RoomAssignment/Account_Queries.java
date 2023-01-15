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
    
       public ResultSet getAllTeacherAccountsInformation(){
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts WHERE Role = 'Teacher' ORDER BY LastName ASC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null,sqlex.toString(),"SQL Query Error!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
     public ResultSet getUserAccountInformation(int UserID){
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts WHERE UserID ="+UserID+"";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null,sqlex.toString(),"SQL Query Error!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
     
    public void insertUserAccountInformation(String username, String password, String department, String role, String firstName, String lastName, String middleName, String email, String contactNo, String address){
        try {
            query = "INSERT INTO UserAccounts (Username,Password,Department,[Role],FirstName,LastName,MiddleName,Email,ContactNo,Address) " +
                    "VALUES ('"+username+"','"+password+"','"+department+"','"+role+"','"+firstName+"','"+lastName+"','"+middleName+"','"+email+"','"+contactNo+"','"+address+"')";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);      
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null,sqlex.toString(),"SQL Query Error!",JOptionPane.ERROR_MESSAGE);
        }
    }
}
