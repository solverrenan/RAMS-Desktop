/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.util.regex.Pattern;

/**
 *
 * @author yhammy21
 */
public class Account_Validator {
    
    Pattern inputPattern;
    protected boolean isUserIDInputValid(String userID) {
        inputPattern = Pattern.compile("[0-9]+");// Restriction to only allow number input
        return inputPattern.matcher(userID).matches();
    }     
}
