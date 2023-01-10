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
    String updatedName;

    public Account_Validator() {
    }

    protected boolean isUserIDInputValid(String userID) {
        inputPattern = Pattern.compile("[0-9]+");// Restriction to only allow number input
        return inputPattern.matcher(userID).matches();
    }

    protected boolean isUsernameExisting(String username) {
        tblData = userData.getAllUserAccountsInformation();
        try {
            while (tblData.next()) {
                if (username.equals(tblData.getString(2))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isNewUsernameSameAsOldUsername(String username, int userID) {
        tblData = userData.getUserAccountInformation(userID);
        try {
            while (tblData.next()) {
                if (username.equals(tblData.getString(2))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isNewPasswordSameAsOldPassword(String password, int userID) {
        tblData = userData.getUserAccountInformation(userID);
        try {
            while (tblData.next()) {
                if (password.equals(tblData.getString(3))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isNewRoleSameAsOldRole(String role, int userID) {
        tblData = userData.getUserAccountInformation(userID);
        try {
            while (tblData.next()) {
                if (role.equalsIgnoreCase(tblData.getString(5))) {
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
        inputPattern = Pattern.compile("^[a-zA-Z_]+( [a-zA-Z_]+)*$");// Restriction to only allow alphabet input
        return inputPattern.matcher(firstName).matches() && inputPattern.matcher(lastName).matches() && inputPattern.matcher(middleName).matches();
    }

    protected boolean isFirstNameInputValid(String firstName) {
        inputPattern = Pattern.compile("^[a-zA-Z_]+( [a-zA-Z_]+)*$");// Restriction to only allow alphabet input
        return inputPattern.matcher(firstName).matches();
    }

    protected boolean isLastNameInputValid(String lastName) {
        inputPattern = Pattern.compile("^[a-zA-Z_]+( [a-zA-Z_]+)*$");// Restriction to only allow alphabet input
        return inputPattern.matcher(lastName).matches();
    }

    protected boolean isMiddleNameInputValid(String middleName) {
        inputPattern = Pattern.compile("^[a-zA-Z_]+( [a-zA-Z_]+)*$");// Restriction to only allow alphabet input
        return inputPattern.matcher(middleName).matches();
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

    protected boolean isEmailInputValid(String email) {
        inputPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");// Restriction for valid email format input
        return inputPattern.matcher(email).matches();
    }

    protected boolean isEmailExisting(String email) {
        tblData = userData.getAllUserAccountsInformation();
        try {
            while (tblData.next()) {
                if (email.equalsIgnoreCase(tblData.getString(9))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isNewEmailSameAsOldEmail(String email, int userID) {
        tblData = userData.getUserAccountInformation(userID);
        try {
            while (tblData.next()) {
                if (email.equalsIgnoreCase(tblData.getString(9))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isContactNoInputValid(String contactNo) {
        inputPattern = Pattern.compile("^\\d{11}$");// Restriction for valid contact no. format input
        return inputPattern.matcher(contactNo).matches();
    }

    protected boolean isContactNoExisting(String contactNo) {
        tblData = userData.getAllUserAccountsInformation();
        try {
            while (tblData.next()) {
                if (contactNo.equals(tblData.getString(10))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    protected boolean isNewContactNoSameAsOldContactNo(String contactNo, int userID) {
        tblData = userData.getUserAccountInformation(userID);
        try {
            while (tblData.next()) {
                if (contactNo.equalsIgnoreCase(tblData.getString(10))) {
                    return true;
                }
            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    protected boolean isAddressInputValid(String address) {
        inputPattern = Pattern.compile("^[a-zA-Z0-9.,_]+( [a-zA-Z0-9.,])*$");// Restriction to only allow one white space between characters
        return inputPattern.matcher(address).matches();
    }

}
