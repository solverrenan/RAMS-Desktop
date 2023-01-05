/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.sql.ResultSet;
import java.util.regex.Pattern;

/**
 *
 * @author yhammy21
 */
public class Room_Validator {
    
    Room_Queries roomData = new Room_Queries();
    ResultSet tblData;
    Pattern inputPattern;
    
    protected boolean isScheduleIDInputValid(String scheduleID) {
        inputPattern = Pattern.compile("[0-9]+");// Restriction to only allow number input
        return inputPattern.matcher(scheduleID).matches();
    } 
    protected boolean isRoomInputValid(String room) {
        inputPattern = Pattern.compile("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$");// Restriction for letters and numbers only with one white space in between
        return inputPattern.matcher(room).matches();
    }
    protected boolean isSubjectInputValid(String subject) {
        inputPattern = Pattern.compile("^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$"); // Restriction for letters and numbers only with one white space in between
        return inputPattern.matcher(subject).matches();
    }  
    protected boolean isSectionInputValid(String section) {
        inputPattern = Pattern.compile("[A-Z0-9]+"); // Restriction for letters and numbers only with one white space in between
        return inputPattern.matcher(section).matches();
    }  
}
