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
//Queries for schedules
public class Room_Queries extends SQLConnection {

    public Room_Queries() {
        super();
    }

    public ResultSet getAllRoomSchedulesInformation() {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules ORDER BY CASE WHEN DayOfTheWeek = 'Monday' THEN 1 WHEN DayOfTheWeek = 'Tuesday' THEN 2 WHEN DayOfTheWeek = 'Wednesday' THEN 3 WHEN DayOfTheWeek = 'Thursday' THEN 4 WHEN DayOfTheWeek = 'Friday' THEN 5 WHEN DayOfTheWeek = 'Saturday' THEN 6 END, FORMAT(CAST(StartTime AS datetime),'HH:MM'), Room ASC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getRoomScheduleInformation(int ScheduleID) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE ScheduleID = " + ScheduleID + "";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getSearchedRoomScheduleInformation(String searchQuery) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE CAST(ScheduleID AS VARCHAR) = '" + searchQuery + "' AND CAST(ScheduleID AS VARCHAR) LIKE '" + searchQuery + "%' OR Room  LIKE '" + searchQuery + "%' OR Subject LIKE '" + searchQuery + "%' OR Section LIKE '" + searchQuery + "%' OR Teacher LIKE '" + searchQuery + "%' OR DayOfTheWeek LIKE '" + searchQuery + "%' OR FORMAT(CAST(StartTime AS datetime),'hh:mm tt') LIKE'%" + searchQuery + "%' OR FORMAT(CAST(EndTime AS datetime),'hh:mm tt')LIKE '%" + searchQuery + "%' ORDER BY CASE WHEN DayOfTheWeek = 'Monday' THEN 1 WHEN DayOfTheWeek = 'Tuesday' THEN 2 WHEN DayOfTheWeek = 'Wednesday' THEN 3 WHEN DayOfTheWeek = 'Thursday' THEN 4 WHEN DayOfTheWeek = 'Friday' THEN 5 WHEN DayOfTheWeek = 'Saturday' THEN 6 END, FORMAT(CAST(StartTime AS datetime),'HH:MM'), Room ASC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getSpecificRoomScheduleInformation(String dayOfTheWeek, String room) {
        try {
            sqlStatement = sqlConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE DayOfTheWeek ='" + dayOfTheWeek + "' AND Room = '" + room + "'";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getSpecificTeacherScheduleInformation(String dayOfTheWeek, String teacher) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE DayOfTheWeek ='" + dayOfTheWeek + "' AND Teacher = '" + teacher + "'";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getSpecificSectionScheduleInformation(String dayOfTheWeek, String section) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE DayOfTheWeek ='" + dayOfTheWeek + "' AND [Section] = '" + section + "'";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet getTeacherScheduleInformationThisDay(String teacher) {
        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT ScheduleID,Room,Subject,[Section],Teacher,DayOfTheWeek,FORMAT(CAST(StartTime AS datetime),'hh:mm tt')'StartTime',FORMAT(CAST(EndTime AS datetime),'hh:mm tt') 'EndTime' FROM TeacherSchedules WHERE DayOfTheWeek = DATENAME(WEEKDAY,GETDATE()) AND Teacher = "
                    + "'" + teacher + "' ORDER BY FORMAT(CAST(StartTime AS datetime),'HH:MM') ASC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertRoomScheduleInformation(String room, String subject, String section, String teacher, String dayOfTheWeek, String startTime, String endTime) {
        try {
            query = "INSERT INTO TeacherSchedules (Room,Subject,[Section],Teacher,DayOfTheWeek,StartTime,EndTime) "
                    + "VALUES ('" + room + "','" + subject + "','" + section + "','" + teacher + "','" + dayOfTheWeek + "','" + startTime + "','" + endTime + "')";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRoomScheduleSubject(String subject, int scheduleID) {
        try {
            query = "UPDATE TeacherSchedules SET Subject = '" + subject + "' WHERE ScheduleID = " + scheduleID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRoomScheduleTimeInformation(String room, String section, String teacher, String dayOfTheWeek, String startTime, String endTime, int scheduleID) {
        try {
            query = "UPDATE TeacherSchedules SET Room = '" + room + "', [Section] = '" + section + "', Teacher = '" + teacher + "', DayOfTheWeek = '" + dayOfTheWeek + "', StartTime = '" + startTime + "', EndTime = '" + endTime + "' WHERE ScheduleID = " + scheduleID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRoomScheduleInformation(int scheduleID) {
        try {
            query = "DELETE FROM TeacherSchedules WHERE ScheduleID = " + scheduleID + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
