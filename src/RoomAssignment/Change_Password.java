/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoomAssignment;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author solve
 */
public class Change_Password extends javax.swing.JFrame {

    /**
     * Creates new form Change_Password
     */
    private static int userID;
    private static Dashboard db;
    private static View_Schedule vs;
    Account_Queries userData = new Account_Queries();
    Activity_Log_Queries activityData = new Activity_Log_Queries();
    ResultSet tblData;

    public Change_Password(int userID, Dashboard db) {
        initComponents();
        this.userID = userID;
        this.db = db;
        this.setTitle("RAMS - Change Password");
        this.setAlwaysOnTop(true);
        //Rounded Corners
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }

    public Change_Password(int userID, View_Schedule vs) {
        initComponents();
        this.userID = userID;
        this.vs = vs;
        this.setTitle("RAMS - Change Password");
        this.setAlwaysOnTop(true);
        //Rounded Corners
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCurrentPassword = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pwNewPassword = new javax.swing.JPasswordField();
        pwConfirmPassword = new javax.swing.JPasswordField();
        cbShowPassword = new javax.swing.JCheckBox();
        pwCurrentPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        lblCurrentPassword.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblCurrentPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentPassword.setText("Current Password");

        lblNewPassword.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblNewPassword.setText("New Password");

        lblConfirmPassword.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmPassword.setText("Confirm Password");

        btnChangePassword.setBackground(new java.awt.Color(218, 104, 70));
        btnChangePassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(51, 51, 51));
        btnChangePassword.setText("Change Password");
        btnChangePassword.setBorder(null);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(218, 104, 70));
        btnCancel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(null);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pwNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwNewPasswordActionPerformed(evt);
            }
        });

        cbShowPassword.setForeground(java.awt.Color.white);
        cbShowPassword.setText("Show Password");
        cbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPasswordActionPerformed(evt);
            }
        });

        pwCurrentPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwCurrentPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPassword)
                            .addComponent(lblConfirmPassword)
                            .addComponent(lblCurrentPassword))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbShowPassword)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pwNewPassword)
                            .addComponent(pwConfirmPassword)
                            .addComponent(pwCurrentPassword))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentPassword)
                    .addComponent(pwCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(pwNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword)
                    .addComponent(pwConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(cbShowPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPasswordActionPerformed
        if (cbShowPassword.isSelected()) {
            pwCurrentPassword.setEchoChar((char) 0);
            pwNewPassword.setEchoChar((char) 0);
            pwConfirmPassword.setEchoChar((char) 0);
        } else {
            pwCurrentPassword.setEchoChar('*');
            pwNewPassword.setEchoChar('*');
            pwConfirmPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowPasswordActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (db != null) {
            db.setEnabled(true);
        }
        if (vs != null) {
            vs.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        confirmChangePassword();
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void pwNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwNewPasswordActionPerformed

    private void pwCurrentPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwCurrentPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwCurrentPasswordActionPerformed

    private void confirmChangePassword() {
        try {

            tblData = userData.getUserAccountInformation(userID);
            tblData.next();
            if (!new String(pwCurrentPassword.getPassword()).trim().equals(tblData.getString(3))) {
                new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Old password is incorrect!", NoticeWindow.NORMAL_DELAY, NPosition.BOTTOM_RIGHT);
            } else if (!new String(pwNewPassword.getPassword()).trim().equals(new String(pwConfirmPassword.getPassword()).trim())) {
                new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "New password does not match confirmation password!", NoticeWindow.NORMAL_DELAY, NPosition.BOTTOM_RIGHT);
            } else if (new String(pwCurrentPassword.getPassword()).trim().equals(new String(pwConfirmPassword.getPassword()).trim())) {
                new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "New password must not be the same old password!", NoticeWindow.NORMAL_DELAY, NPosition.BOTTOM_RIGHT);
            } else {
                userData.updateUserAccountPassword(new String(pwConfirmPassword.getPassword()).trim(), userID);
                activityData.insertActivity(tblData.getString(7) + ", " + tblData.getString(6) + " " + tblData.getString(8), "Changed password.", tblData.getInt(1));
                if (db != null) {
                    db.populateDashboardActivityLog();
                }
                new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Password changed!", NoticeWindow.NORMAL_DELAY, NPosition.BOTTOM_RIGHT);
            }

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString(), "SQL Query Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Password(userID, db).setVisible(true);
                new Change_Password(userID, vs).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JCheckBox cbShowPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCurrentPassword;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JPasswordField pwConfirmPassword;
    private javax.swing.JPasswordField pwCurrentPassword;
    private javax.swing.JPasswordField pwNewPassword;
    // End of variables declaration//GEN-END:variables
}
