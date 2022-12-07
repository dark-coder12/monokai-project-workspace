package com.mycompany.monokainetbeans.Reminder;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.mycompany.monokainetbeans.Application.*;
public class Remind extends javax.swing.JFrame {

    private Task task;
    private Reminder taskBoard;
    private Connection connection;
    private Thread thread;
    private Player jlPlayer;
    public Remind() {

        initComponents();
        ImageIcon bellIcon = new ImageIcon("C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\reminder.png");
        reminderIcon.setIcon(bellIcon);
        reminderIcon.setForeground(Color.white);

        ImageIcon completeIcon = new ImageIcon("C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\check.png");
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                giveAlert();
            }
        });

        setTitle("Reminder");
        setVisible(true);
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        taskNameLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        completeButton = new javax.swing.JButton();
        reminderIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 43, 54));

        taskNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        taskNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        taskNameLabel.setText("This is your task");

        cancelButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        completeButton.setBackground(new java.awt.Color(0, 0, 0));
        completeButton.setForeground(new java.awt.Color(255, 255, 255));
        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(cancelButton)
                                                .addGap(89, 89, 89)
                                                .addComponent(completeButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(177, 177, 177)
                                                .addComponent(reminderIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(taskNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(reminderIcon)
                                .addGap(65, 65, 65)
                                .addComponent(taskNameLabel)
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(completeButton))
                                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean connectDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if (connection == null) {
                System.out.println("Connection with database not established");
                return false;
            } else return true;
        } catch (SQLException exception) {
        }
        return false;
    }

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        try {
            if (connectDB()) {
                CallableStatement cstmt = connection.prepareCall("{call DELETEREMINDER(?)}");
                cstmt.setInt(1, task.getTaskID());
                int r = cstmt.executeUpdate();
                taskBoard.loadTasks();
                setVisible(false);
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_completeButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        jlPlayer.close();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Remind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Remind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Remind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Remind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remind().setVisible(true);
            }
        });
    }

    public void setComponents(Task task, Reminder taskBoard) {
        this.task = task;
        this.taskBoard = taskBoard;
        taskNameLabel.setText(task.getTaskName());
    }

    public void giveAlert() {
        try {
            String file = "C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\reminder_sound.mp3";
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);
            jlPlayer.play();
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton completeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel reminderIcon;
    private javax.swing.JLabel taskNameLabel;
    // End of variables declaration//GEN-END:variables
}
