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
public class Activity_Log_Queries extends SQLConnection {

    public Activity_Log_Queries() {
        super();
    }

    public ResultSet getAllActivityLogInformation() {

        try {
            sqlStatement = sqlConnection.createStatement();
            query = "SELECT TOP 100 ActivityID, FullName, Activity, FORMAT([Date],'MM-dd-yyyy') as [Date], FORMAT(CAST([Time] as Time), 'hh\\:mm\\:ss') as [Time], UserID FROM ActivityLog ORDER BY ActivityID DESC";
            rs = sqlStatement.executeQuery(query);
            return rs;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
   public void insertActivity(String name, String activity, int userID) {
        try {
            query = "INSERT INTO ActivityLog (FullName, Activity, [Date], [Time], UserID) VALUES ('"+name+"', '"+activity+"', GETDATE(), GETDATE(), '"+userID+"')";
            sqlPreparedStatement = sqlConnection.prepareStatement(query);
            sqlPreparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
   }
}
