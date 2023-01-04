/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author yhammy21
 */
public class Account_Validator {

    Account_Queries userData = new Account_Queries();
    ResultSet tblData;
    Pattern inputPattern;

    protected boolean isUserIDInputValid(String userID) {
        inputPattern = Pattern.compile("[0-9]+");// Restriction to only allow number input
        return inputPattern.matcher(userID).matches();
    }

    protected boolean isUsernameExisting(String username) {
        tblData = userData.getAllUserAccountsInformation();
        try {
            while (tblData.next()) {
                if(username.equals(tblData.getString(2))) {
                    return true;
                }                  
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    protected boolean isDepartmentInputValid(String department) {
        inputPattern = Pattern.compile("[a-zA-Z]+");// Restriction to only allow alphabet input
        return inputPattern.matcher(department).matches();
    }
    
    protected boolean isNameInputValid(String firstName, String lastName, String middleName) {
        inputPattern = Pattern.compile("[a-zA-Z]+");// Restriction to only allow alphabet input
        return inputPattern.matcher(firstName).matches() && inputPattern.matcher(lastName).matches() && inputPattern.matcher(middleName).matches();
    }
    
    protected boolean isNameExisting(String firstName, String lastName, String middleName) {
            tblData = userData.getAllUserAccountsInformation();
        try {
            while (tblData.next()) {
                if (firstName.equalsIgnoreCase(tblData.getString(6)) == true && lastName.equalsIgnoreCase(tblData.getString(7)) == true && middleName.equalsIgnoreCase(tblData.getString(8)) == true) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
