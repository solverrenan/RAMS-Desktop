/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomAssignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author yhammy21
 */
public class Room_Validator {

    Room_Queries roomData = new Room_Queries();
    ResultSet tblData;
    Pattern inputPattern;
    SimpleDateFormat sdf12;
    Date newStartTime;
    Date newEndTime;
    Date timeRestrictionStart;
    Date timeRestrictionEnd;
    Date existingStartTime;
    Date existingEndTime;
    Calendar existingStartTimeModified;
    Calendar existingEndTimeModified;
    Calendar newScheduleTimeModified;

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

    protected boolean isStartTimeGreaterThanOrEqualToEndTime(String startTime, String endTime) {
        try {
            sdf12 = new SimpleDateFormat("hh:mm aa");
            newStartTime = sdf12.parse(startTime);
            newEndTime = sdf12.parse(endTime);
            if (newStartTime.before(newEndTime)) {
                return true;
            }
        } catch (ParseException peex) {
            JOptionPane.showMessageDialog(null, peex.toString(), "Date Parse Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isScheduleTimeValid(String startTime, String endTime) {
        try {
            sdf12 = new SimpleDateFormat("hh:mm aa");
            newStartTime = sdf12.parse(startTime);
            newEndTime = sdf12.parse(endTime);
            timeRestrictionStart = sdf12.parse("6:59 AM");
            timeRestrictionEnd = sdf12.parse("7:01 PM");
            if (newStartTime.after(timeRestrictionStart) && newStartTime.before(timeRestrictionEnd) && newEndTime.after(timeRestrictionStart) && newEndTime.before(timeRestrictionEnd)) {
                return true;
            }
        } catch (ParseException peex) {
            JOptionPane.showMessageDialog(null, peex.toString(), "Date Parse Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isScheduleTimeFree(String dayOfTheWeek, String room, String startTime, String endTime) {
        try {
            tblData = roomData.getSpecificRoomScheduleInformation(dayOfTheWeek, room);
            sdf12 = new SimpleDateFormat("hh:mm aa");
            newStartTime = sdf12.parse(startTime);
            newEndTime = sdf12.parse(endTime);
            existingStartTimeModified = Calendar.getInstance();// Modifies start time
            existingEndTimeModified = Calendar.getInstance();// Modifies end time
            newScheduleTimeModified = Calendar.getInstance();
            if (tblData.isBeforeFirst()) {
                while (tblData.next()) {
                    newScheduleTimeModified.setTime(newStartTime);
                    existingStartTime = sdf12.parse(tblData.getString(7));// Get start time from table
                    existingEndTime = sdf12.parse(tblData.getString(8));// Get end time from table
                    existingStartTimeModified.setTime(existingStartTime);// Pass start time to Calendar object
                    existingEndTimeModified.setTime(existingEndTime);// Pass end time to Calendar object          
                    existingStartTimeModified.add(Calendar.MINUTE, 1);// Adds a minute to start time
                    existingEndTimeModified.add(Calendar.MINUTE, -1);// Subtracts a minute to end time
                    existingStartTime = existingStartTimeModified.getTime();// Reassign new value of start time from calendar object
                    existingEndTime = existingEndTimeModified.getTime();// Reassign new value of end time from calendar object 
                    if ((newStartTime.before(existingStartTime) || newStartTime.after(existingEndTime)) && (newEndTime.before(existingStartTime) || newEndTime.after(existingEndTime))) {
                        while (newScheduleTimeModified.getTime().compareTo(newEndTime) != 0) {
                            System.out.println("Logic goes until here!" + " " + sdf12.format(newScheduleTimeModified.getTime()));
                            if (newScheduleTimeModified.getTime().after(existingStartTime) && newScheduleTimeModified.getTime().before(existingEndTime)) {
                                return false;
                            }
                            newScheduleTimeModified.add(Calendar.MINUTE, 1);
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return true;
            }
        } catch (ParseException peex) {
            JOptionPane.showMessageDialog(null, peex.toString(), "Date Parse Error!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    protected boolean isTeacherScheduleTimeFree(String dayOfTheWeek, String teacher, String startTime, String endTime) {
        try {
            tblData = roomData.getSpecificTeacherScheduleInformation(dayOfTheWeek, teacher);
            sdf12 = new SimpleDateFormat("hh:mm aa");
            newStartTime = sdf12.parse(startTime);
            newEndTime = sdf12.parse(endTime);
            existingStartTimeModified = Calendar.getInstance();// Modifies start time
            existingEndTimeModified = Calendar.getInstance();// Modifies end time
            newScheduleTimeModified = Calendar.getInstance();
            if (tblData.isBeforeFirst()) {
                while (tblData.next()) {
                    newScheduleTimeModified.setTime(newStartTime);
                    existingStartTime = sdf12.parse(tblData.getString(7));// Get start time from table
                    existingEndTime = sdf12.parse(tblData.getString(8));// Get end time from table
                    existingStartTimeModified.setTime(existingStartTime);// Pass start time to Calendar object
                    existingEndTimeModified.setTime(existingEndTime);// Pass end time to Calendar object          
                    existingStartTimeModified.add(Calendar.MINUTE, 1);// Adds a minute to start time
                    existingEndTimeModified.add(Calendar.MINUTE, -1);// Subtracts a minute to end time
                    existingStartTime = existingStartTimeModified.getTime();// Reassign new value of start time from calendar object
                    existingEndTime = existingEndTimeModified.getTime();// Reassign new value of end time from calendar object 
                    if ((newStartTime.before(existingStartTime) || newStartTime.after(existingEndTime)) && (newEndTime.before(existingStartTime) || newEndTime.after(existingEndTime))) {
                        while (newScheduleTimeModified.getTime().compareTo(newEndTime) != 0) {
                            System.out.println("Logic goes until here!" + " " + sdf12.format(newScheduleTimeModified.getTime()));
                            if (newScheduleTimeModified.getTime().after(existingStartTime) && newScheduleTimeModified.getTime().before(existingEndTime)) {
                                return false;
                            }
                            newScheduleTimeModified.add(Calendar.MINUTE, 1);
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return true;
            }
        } catch (ParseException peex) {
            JOptionPane.showMessageDialog(null, peex.toString(), "Date Parse Error!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
