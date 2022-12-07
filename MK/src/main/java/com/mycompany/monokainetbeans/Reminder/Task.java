/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.monokainetbeans.Reminder;

import javazoom.jl.player.Player;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.*;

import static com.mycompany.monokainetbeans.Application.*;

/**
 * @author Mr Rabbani
 */
public class Task extends javax.swing.JPanel {

    /**
     * Creates new form Task
     */
    private TaskDetails taskDetail;
    private Reminder taskBoard;
    @Getter
    @Setter
    private String taskName;
    @Getter
    @Setter
    private int taskID;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private Time time;
    @Getter
    @Setter
    private int repeat;
    private Connection connection;
    private Player jlPlayer;

    public Task() {
        initComponents();
        repeatLabel.setForeground(Color.white);
        taskNameLabel.setForeground(Color.white);
        taskNameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                taskBoard.getTaskDetails(Task.this);
            }
        });
        ImageIcon repeatIcon = new ImageIcon("C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\repeatIcon.png");
        repeatLabel.setIcon(repeatIcon);
        repeatLabel.setBackground(Color.white);
        taskCheckBox.addActionListener(event -> {
            completeTask();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String file = "C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\notification.mp3";
                        FileInputStream fileInputStream = new FileInputStream(file);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                        jlPlayer = new Player(bufferedInputStream);
                        jlPlayer.play();
                    } catch (Exception e) {
                    }
                }
            });
            thread.start();
        });
    }

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

    public void completeTask() {
        try {
            if (connectDB()) {
                CallableStatement cstmt = connection.prepareCall("{call DELETEREMINDER(?)}");
                cstmt.setInt(1, taskID);
                int r = cstmt.executeUpdate();
                taskBoard.loadTasks();
            }
        } catch (SQLException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        taskCheckBox = new javax.swing.JCheckBox();
        repeatLabel = new javax.swing.JLabel();
        taskNameLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 43, 54));

        taskCheckBox.setText("jCheckBox1");

        repeatLabel.setForeground(new java.awt.Color(255, 255, 255));
        repeatLabel.setText("repeat");

        taskNameLabel.setText("Task Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(taskCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(taskNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                                .addComponent(repeatLabel)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(taskCheckBox)
                                        .addComponent(taskNameLabel)
                                        .addComponent(repeatLabel)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (connectDB()) {
                CallableStatement cstmt = connection.prepareCall("{call DELETEREMINDER(?)}");
                cstmt.setInt(1, taskID);
                int r = cstmt.executeUpdate();
                taskBoard.loadTasks();
            }
        } catch (SQLException ex) {
        }
    }

    public void setTaskComponents(Reminder board, int taskID, String taskName, Time time, Date date, int repeat) {
        taskBoard = board;
        this.taskID = taskID;
        taskCheckBox.setText("");
        taskNameLabel.setText(taskName);
        taskDetail = new TaskDetails();
        this.taskID = taskID;
        this.taskName = taskName;
        this.date = date;
        this.time = time;
        this.repeat = repeat;
        taskDetail.setCompnents(taskName, time, date, repeat);
        String repeatition = "Never";
        if (repeat == 0)
            repeatition = "Never";
        if (repeat == 1)
            repeatition = "Daily";
        if (repeat == 2)
            repeatition = "Weekly";
        if (repeat == 3)
            repeatition = "Monthly";
        if (repeat == 4)
            repeatition = "Yearly";

        repeatLabel.setText(String.valueOf(repeatition));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel repeatLabel;
    private javax.swing.JCheckBox taskCheckBox;
    private javax.swing.JLabel taskNameLabel;
    // End of variables declaration//GEN-END:variables


    public String getTaskName() {
        return taskName;
    }

    public TaskDetails getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(TaskDetails taskDetail) {
        this.taskDetail = taskDetail;
    }

    public Reminder getTaskBoard() {
        return taskBoard;
    }

    public void setTaskBoard(Reminder taskBoard) {
        this.taskBoard = taskBoard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Player getJlPlayer() {
        return jlPlayer;
    }

    public void setJlPlayer(Player jlPlayer) {
        this.jlPlayer = jlPlayer;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getRepeatLabel() {
        return repeatLabel;
    }

    public void setRepeatLabel(JLabel repeatLabel) {
        this.repeatLabel = repeatLabel;
    }

    public JCheckBox getTaskCheckBox() {
        return taskCheckBox;
    }

    public void setTaskCheckBox(JCheckBox taskCheckBox) {
        this.taskCheckBox = taskCheckBox;
    }

    public JLabel getTaskNameLabel() {
        return taskNameLabel;
    }

    public void setTaskNameLabel(JLabel taskNameLabel) {
        this.taskNameLabel = taskNameLabel;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
