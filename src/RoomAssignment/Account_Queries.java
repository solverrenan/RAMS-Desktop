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

    public Account_Queries() {
        super();
    }

    public ResultSet getAllUserAccountsInformation() {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getAllTeacherAccountsInformation() {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts WHERE Role = 'Teacher' ORDER BY LastName ASC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getUserAccountInformation(int UserID) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM UserAccounts WHERE UserID =" + UserID + "";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertUserAccountInformation(String username, String password, String department, String role, String firstName, String lastName, String middleName, String email, String contactNo, String address) {
        try {
            query = "INSERT INTO UserAccounts (Username,Password,Department,[Role],FirstName,LastName,MiddleName,Email,ContactNo,Address) "
                    + "VALUES ('" + username + "','" + password + "','" + department + "','" + role + "','" + firstName + "','" + lastName + "','" + middleName + "','" + email + "','" + contactNo + "','" + address + "')";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserAccountUsername(String username, int userID) {
        try {
            query = "UPDATE UserAccounts SET Username = '" + username + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserAccountPassword(String password, int userID) {
        try {
            query = "UPDATE UserAccounts SET Password = '" + password + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserAccountDepartment(String department, int userID) {
        try {
            query = "UPDATE UserAccounts SET Department = '" + department + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUserAccountRole(String role, int userID) {
        try {
            query = "UPDATE UserAccounts SET Role = '" + role + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountFirstName(String firstName, int userID) {
        try {
            query = "UPDATE UserAccounts SET FirstName = '" + firstName + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountLastName(String lastName, int userID) {
        try {
            query = "UPDATE UserAccounts SET LastName = '" + lastName + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountMiddleName(String middleName, int userID) {
        try {
            query = "UPDATE UserAccounts SET MiddleName = '" + middleName + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountEmail(String email, int userID) {
        try {
            query = "UPDATE UserAccounts SET Email = '" + email + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountContactNo(String contactNo, int userID) {
        try {
            query = "UPDATE UserAccounts SET ContactNo = '" + contactNo + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateUserAccountAddress(String address, int userID) {
        try {
            query = "UPDATE UserAccounts SET Address = '" + address + "' WHERE UserID = " + userID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
