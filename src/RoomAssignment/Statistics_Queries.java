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
public class Statistics_Queries extends SQLConnection {

    public ResultSet getAllStatisticsInformation() {

        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT * FROM [Statistics]";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertStatisticsInformation() {
        try {
            query = "DECLARE @UserAccountCreatedCount AS INT =  (SELECT IDENT_CURRENT('UserAccounts'))\n"
                    + "DECLARE @TeacherScheduleCreatedCount AS INT =  (SELECT IDENT_CURRENT('TeacherSchedules'))\n"
                    + "DECLARE @StatisticsRows AS INT = (SELECT COUNT(StatID) FROM [Statistics])\n"
                    + "DECLARE @UserAccountRows AS INT = (SELECT COUNT(UserID) FROM UserAccounts)\n"
                    + "DECLARE @TeacherScheduleRows AS INT = (SELECT COUNT(ScheduleID) FROM TeacherSchedules)\n"
                    + "IF (@StatisticsRows < 1 AND @UserAccountRows > 0 AND @TeacherScheduleRows > 0)\n"
                    + "  INSERT INTO [Statistics] (LastUpdated, CurrentFaculties, TotalCreatedAccounts, TotalCreatedSchedules) VALUES (GETDATE(), (SELECT COUNT(UserID) FROM UserAccounts), @UserAccountCreatedCount, @TeacherScheduleCreatedCount)\n"
                    + "ELSE IF (@StatisticsRows < 1 AND @UserAccountRows < 1 AND @TeacherScheduleRows < 1)\n"
                    + "  INSERT INTO [Statistics] (LastUpdated, CurrentFaculties, TotalCreatedAccounts, TotalCreatedSchedules) VALUES (GETDATE(), (SELECT COUNT(UserID) FROM UserAccounts), 0 , 0)\n"
                    + "ELSE IF (@StatisticsRows < 1 AND @UserAccountRows < 1 AND @TeacherScheduleRows > 0)\n"
                    + "  INSERT INTO [Statistics] (LastUpdated, CurrentFaculties, TotalCreatedAccounts, TotalCreatedSchedules) VALUES (GETDATE(), (SELECT COUNT(UserID) FROM UserAccounts), 0 , @TeacherScheduleCreatedCount)\n"
                    + "ELSE IF (@StatisticsRows < 1 AND @UserAccountRows > 0 AND @TeacherScheduleRows < 1)\n"
                    + "  INSERT INTO [Statistics] (LastUpdated, CurrentFaculties, TotalCreatedAccounts, TotalCreatedSchedules) VALUES (GETDATE(), (SELECT COUNT(UserID) FROM UserAccounts), @UserAccountCreatedCount , 0)\n"
                    + "";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void incrementCurrentFacultiesCount() {
        try {
            query = "UPDATE [Statistics] SET LastUpdated = GETDATE(), CurrentFaculties += 1;";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void decrementCurrentFacultiesCount() {
        try {
            query = "UPDATE [Statistics] SET LastUpdated = GETDATE(), CurrentFaculties -= 1;";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateTotalCreatedAccountsCount() {
        try {
            query = "UPDATE [Statistics] SET LastUpdated = GETDATE(), TotalCreatedAccounts += 1;";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateTotalCreatedSchedulesCount() {
        try {
            query = "UPDATE [Statistics] SET LastUpdated = GETDATE(), TotalCreatedSchedules += 1;";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
