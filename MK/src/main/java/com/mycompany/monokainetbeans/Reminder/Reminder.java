package com.mycompany.monokainetbeans.Reminder;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import static com.mycompany.monokainetbeans.Application.*;
import static java.util.Calendar.PM;

public class Reminder extends javax.swing.JFrame {
    private boolean loading;
    private Connection connection;
    private ImageIcon editIcon;
    private Task openedTask;
    private boolean editMode;
    private ArrayList<Task> tasks;
    private ArrayList<Task> todayTasks;

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ImageIcon getEditIcon() {
        return editIcon;
    }

    public void setEditIcon(ImageIcon editIcon) {
        this.editIcon = editIcon;
    }

    public Task getOpenedTask() {
        return openedTask;
    }

    public void setOpenedTask(Task openedTask) {
        this.openedTask = openedTask;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTodayTasks() {
        return todayTasks;
    }

    public void setTodayTasks(ArrayList<Task> todayTasks) {
        this.todayTasks = todayTasks;
    }

    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    public void setAddTaskButton(JButton addTaskButton) {
        this.addTaskButton = addTaskButton;
    }

    public JTextField getAddTaskField() {
        return addTaskField;
    }

    public void setAddTaskField(JTextField addTaskField) {
        this.addTaskField = addTaskField;
    }

    public JPanel getAddTaskPanel() {
        return addTaskPanel;
    }

    public void setAddTaskPanel(JPanel addTaskPanel) {
        this.addTaskPanel = addTaskPanel;
    }

    public JPanel getAllTasks() {
        return allTasks;
    }

    public void setAllTasks(JPanel allTasks) {
        this.allTasks = allTasks;
    }


    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JButton getCompleteButton() {
        return completeButton;
    }

    public void setCompleteButton(JButton completeButton) {
        this.completeButton = completeButton;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public void setDateField(JTextField dateField) {
        this.dateField = dateField;
    }

    public JDateChooser getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(JDateChooser datePicker) {
        this.datePicker = datePicker;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JLabel getEditDateLabel() {
        return editDateLabel;
    }

    public void setEditDateLabel(JLabel editDateLabel) {
        this.editDateLabel = editDateLabel;
    }

    public JPanel getEditDatePanel() {
        return editDatePanel;
    }

    public void setEditDatePanel(JPanel editDatePanel) {
        this.editDatePanel = editDatePanel;
    }


    public JSpinner getHourSelector() {
        return hourSelector;
    }

    public void setHourSelector(JSpinner hourSelector) {
        this.hourSelector = hourSelector;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JScrollBar getjScrollBar1() {
        return jScrollBar1;
    }

    public void setjScrollBar1(JScrollBar jScrollBar1) {
        this.jScrollBar1 = jScrollBar1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JButton getKanbanBtn1() {
        return kanbanBtn1;
    }

    public void setKanbanBtn1(JButton kanbanBtn1) {
        this.kanbanBtn1 = kanbanBtn1;
    }

    public JPanel getKanbanPanel() {
        return kanbanPanel;
    }

    public void setKanbanPanel(JPanel kanbanPanel) {
        this.kanbanPanel = kanbanPanel;
    }

    public JPanel getListPanel() {
        return listPanel;
    }

    public void setListPanel(JPanel listPanel) {
        this.listPanel = listPanel;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public void setLogoutBtn(JButton logoutBtn) {
        this.logoutBtn = logoutBtn;
    }

    public JSpinner getMinutesSelector() {
        return minutesSelector;
    }

    public void setMinutesSelector(JSpinner minutesSelector) {
        this.minutesSelector = minutesSelector;
    }

    public JComboBox<String> getRepeatAfter() {
        return repeatAfter;
    }

    public void setRepeatAfter(JComboBox<String> repeatAfter) {
        this.repeatAfter = repeatAfter;
    }

    public JTextField getRepeatField() {
        return repeatField;
    }

    public void setRepeatField(JTextField repeatField) {
        this.repeatField = repeatField;
    }

    public JComboBox<String> getSelectorAmPm() {
        return selectorAmPm;
    }

    public void setSelectorAmPm(JComboBox<String> selectorAmPm) {
        this.selectorAmPm = selectorAmPm;
    }

    public JLabel getSiteNameLbl() {
        return siteNameLbl;
    }

    public void setSiteNameLbl(JLabel siteNameLbl) {
        this.siteNameLbl = siteNameLbl;
    }

    public JLabel getTaskAlert() {
        return taskAlert;
    }

    public void setTaskAlert(JLabel taskAlert) {
        this.taskAlert = taskAlert;
    }

    public JPanel getTaskDetailsPanel() {
        return taskDetailsPanel;
    }

    public void setTaskDetailsPanel(JPanel taskDetailsPanel) {
        this.taskDetailsPanel = taskDetailsPanel;
    }

    public JLabel getTaskNameLabel() {
        return taskNameLabel;
    }

    public void setTaskNameLabel(JLabel taskNameLabel) {
        this.taskNameLabel = taskNameLabel;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public void setTimeField(JTextField timeField) {
        this.timeField = timeField;
    }

    private void setForReminder() {
        if (tasks == null)
            return;
        todayTasks = new ArrayList<Task>();
        Date todayDate = Date.valueOf(LocalDate.now());
        for (Task task : tasks) {
            Date taskDate = task.getDate();
            if (taskDate.equals(todayDate)) {
                todayTasks.add(task);
            }
        }
        if (todayTasks.size() > 0) {
            for (int i = 0; i < todayTasks.size(); i++) {
                for (int j = 0; j < todayTasks.size(); j++) {
                    int res = todayTasks.get(j).getTime().compareTo(todayTasks.get(i).getTime());
                    if (res > 0) {
                        Collections.swap(todayTasks, i, j);
                    }

                }
            }

            for (Task t : todayTasks) {
                remindTask(t);
            }

        }
    }

    public Reminder() {

        setTitle("Reminders");
        editMode = false;
        editIcon = new ImageIcon("C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\Reminder\\edit__pencil.jpg");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if (connection == null) {
                System.out.println("Connection with database not established");
            }
        } catch (SQLException exception) {
        }

        initComponents();
        clearAddTaskPanel();
        taskAlert.setVisible(false);
        Date currentDate = Date.valueOf(LocalDate.now());
        datePicker.setDate(currentDate);

        taskDetailsPanel.setVisible(false);

        selectorAmPm.removeAllItems();
        selectorAmPm.addItem("AM");
        selectorAmPm.addItem("PM");


        repeatAfter.removeAllItems();
        repeatAfter.addItem("Daily");
        repeatAfter.addItem("Weekly");
        repeatAfter.addItem("Monthly");
        repeatAfter.addItem("Yearly");
        repeatAfter.addItem("Never");
        repeatAfter.setSelectedItem("Never");

        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setFocusable(false);

        kanbanBtn1.setBorderPainted(false);
        kanbanBtn1.setContentAreaFilled(false);
        kanbanBtn1.setFocusable(false);

        logoutBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                logoutBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutBtn.setContentAreaFilled(false);
            }
        });

        addTaskButton.setContentAreaFilled(false);
        addTaskButton.setFocusable(false);
        addTaskButton.setBorderPainted(false);

        loadTasks();

        addTaskPanel.setVisible(true);

        //setVisible(true);
        // remindTask();
        // setForReminder();
    }

    public JPanel returnReminders() {
        return jPanel2;
    }

    public static void main(String args[]) {

        Reminder rem = new Reminder();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        kanbanPanel = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        siteNameLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();
        addTaskPanel = new javax.swing.JPanel();
        addTaskField = new javax.swing.JTextField();
        addTaskButton = new javax.swing.JButton();
        datePicker = new com.toedter.calendar.JDateChooser();
        repeatAfter = new javax.swing.JComboBox<>();
        hourSelector = new javax.swing.JSpinner();
        minutesSelector = new javax.swing.JSpinner();
        selectorAmPm = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allTasks = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        taskDetailsPanel = new javax.swing.JPanel();
        taskNameLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        completeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        timeField = new javax.swing.JTextField();
        repeatField = new javax.swing.JTextField();
        editDateLabel = new javax.swing.JLabel();
        editDatePanel = new javax.swing.JPanel();
        dateField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        taskAlert = new javax.swing.JLabel();
        kanbanBtn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jLabel14.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        kanbanPanel.setBackground(new java.awt.Color(0, 43, 54));

        logoutBtn.setBackground(new java.awt.Color(0, 0, 0));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        siteNameLbl.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        siteNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setText("Monokai");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        listPanel.setLayout(new java.awt.GridLayout(1, 0));

        addTaskPanel.setBackground(new java.awt.Color(0, 43, 54));
        addTaskPanel.setForeground(new java.awt.Color(255, 255, 255));

        addTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        addTaskButton.setText("Add");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        repeatAfter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        hourSelector.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        minutesSelector.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        selectorAmPm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectorAmPm.setSelectedItem(PM);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add Task");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hour");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Minute");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("AM / PM");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Repeat");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date");

        javax.swing.GroupLayout addTaskPanelLayout = new javax.swing.GroupLayout(addTaskPanel);
        addTaskPanel.setLayout(addTaskPanelLayout);
        addTaskPanelLayout.setHorizontalGroup(
            addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTaskPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTaskPanelLayout.createSequentialGroup()
                        .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hourSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minutesSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addComponent(selectorAmPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addTaskButton))
                        .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(repeatAfter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(180, 180, 180))
                    .addGroup(addTaskPanelLayout.createSequentialGroup()
                        .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addTaskPanelLayout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        addTaskPanelLayout.setVerticalGroup(
            addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTaskPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(addTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(repeatAfter)
                    .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectorAmPm)
                    .addComponent(minutesSelector)
                    .addComponent(hourSelector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addComponent(addTaskButton)
                .addContainerGap())
        );

        allTasks.setBackground(new java.awt.Color(0, 43, 54));
        allTasks.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout allTasksLayout = new javax.swing.GroupLayout(allTasks);
        allTasks.setLayout(allTasksLayout);
        allTasksLayout.setHorizontalGroup(
            allTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allTasksLayout.createSequentialGroup()
                .addContainerGap(602, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        allTasksLayout.setVerticalGroup(
            allTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(allTasks);

        taskDetailsPanel.setBackground(new java.awt.Color(0, 43, 54));

        taskNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        taskNameLabel.setText("jLabel14");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Time");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Repeat");

        completeButton.setBackground(new java.awt.Color(0, 43, 54));
        completeButton.setForeground(new java.awt.Color(255, 255, 255));
        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(0, 43, 54));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editDatePanelLayout = new javax.swing.GroupLayout(editDatePanel);
        editDatePanel.setLayout(editDatePanelLayout);
        editDatePanelLayout.setHorizontalGroup(
            editDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        editDatePanelLayout.setVerticalGroup(
            editDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(0, 43, 54));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskDetailsPanelLayout = new javax.swing.GroupLayout(taskDetailsPanel);
        taskDetailsPanel.setLayout(taskDetailsPanelLayout);
        taskDetailsPanelLayout.setHorizontalGroup(
            taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                        .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(timeField)
                            .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(repeatField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editDatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(105, 105, 105)
                        .addComponent(editDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                        .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(completeButton))
                            .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(taskNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        taskDetailsPanelLayout.setVerticalGroup(
            taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(taskNameLabel)
                        .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(taskDetailsPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(editDateLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taskDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repeatField))
                .addGap(18, 18, 18)
                .addGroup(taskDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(completeButton)
                    .addComponent(editButton))
                .addGap(15, 15, 15))
        );

        taskAlert.setForeground(Color.DARK_GRAY);
        taskAlert.setText("Add Task Name!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(taskDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taskAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(taskDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(addTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskAlert)
                .addGap(35, 35, 35))
        );

        kanbanBtn1.setBackground(new java.awt.Color(0, 0, 0));
        kanbanBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kanbanBtn1.setForeground(new java.awt.Color(255, 255, 255));
        kanbanBtn1.setText("Projects");
        kanbanBtn1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kanbanBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanbanBtn1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > Reminders");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kanbanPanelLayout = new javax.swing.GroupLayout(kanbanPanel);
        kanbanPanel.setLayout(kanbanPanelLayout);
        kanbanPanelLayout.setHorizontalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(kanbanBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addComponent(siteNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        kanbanPanelLayout.setVerticalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kanbanPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addComponent(siteNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(kanbanBtn1)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remindTask(Task task) {
        Time time = task.getTime();
        int m = time.getMinutes();
        time.setHours(time.getHours() + 12);
        Time currentTime = Time.valueOf(LocalTime.now());
        if (time.getHours() == currentTime.getHours()) {
            if (time.getMinutes() < currentTime.getMinutes())
                return;
            while (time.getMinutes() != currentTime.getMinutes()) {
                currentTime = Time.valueOf(LocalTime.now());
            }
            Remind r = new Remind();
            r.setComponents(task, this);
        }
    }

    private void toDoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_toDoBtn1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_toDoBtn1ActionPerformed

    private void kanbanBtn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_kanbanBtn1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_kanbanBtn1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
        taskDetailsPanel.setVisible(false);
        allTasks.setVisible(true);
        addTaskPanel.setVisible(true);
        jScrollPane2.setVisible(true);
        clearAddTaskPanel();
    }// GEN-LAST:event_cancelButtonActionPerformed

    private void addNewTask(String taskName, Date date, int hour, int minute, String repeat) {
        // 0: never 1: Daily 2: Weekly 3: Monthtly 4: Yearly
        int repeatation = 0;
        if (repeat.equals("Never")) {
            repeatation = 0;
            Time time = new Time(hour, minute, 0);
            setReminder(taskName, time, date, repeatation);
        }

        if (repeat.equals("Daily")) {
            repeatation = 1;
            Time time = new Time(hour, minute, 0);
            setReminder(taskName, time, date, repeatation);
        }
        if (repeat.equals("Weekly")) {
            repeatation = 2;
            Time time = new Time(hour, minute, 0);
            setReminder(taskName, time, date, repeatation);
        }
        if (repeat.equals("Monthly")) {
            repeatation = 3;
            Time time = new Time(hour, minute, 0);
            setReminder(taskName, time, date, repeatation);
        }
        if (repeat.equals("Yearly")) {
            repeatation = 4;
            Time time = new Time(hour, minute, 0);
            setReminder(taskName, time, date, repeatation);
        }
    }

    private int updateTask(int taskID, String taskName, Time time, Date date, int repeat) {
        try {
            CallableStatement cStmt = connection.prepareCall("{call UPDATEREMINDER(?,?,?,?,?)}");
            cStmt.setInt(1, taskID);
            cStmt.setString(2, taskName);
            cStmt.setTime(3, time);
            cStmt.setDate(4, date);
            cStmt.setInt(5, repeat);
            int c = cStmt.executeUpdate();
            loadTasks();
            return c;
        } catch (SQLException ex) {
        }
        return 0;
    }

    private void clearAddTaskPanel() {
        addTaskField.setText("");
        hourSelector.setValue(LocalTime.now().getHour() - 12);
        minutesSelector.setValue(LocalTime.now().getMinute());
        Date currentDate = Date.valueOf(LocalDate.now());
        datePicker.setDate(currentDate);
        repeatAfter.setSelectedItem("Never");
        if (LocalTime.now().getHour() > 12) {
            selectorAmPm.setSelectedItem("PM");
        }
    }

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addTaskButtonActionPerformed
        String taskName = addTaskField.getText();
        if (taskName.length() <= 0) {
            taskAlert.setVisible(true);
            return;
        } else
            taskAlert.setVisible(false);

        int hour = (int) hourSelector.getValue();
        int minute = (int) minutesSelector.getValue();
        String amPm = (String) selectorAmPm.getSelectedItem();
        java.util.Date d = datePicker.getDate();
        java.sql.Date date = new java.sql.Date(d.getTime());
        String repeat = (String) repeatAfter.getSelectedItem();
        if (!editMode) {
            assert repeat != null;
            addNewTask(taskName, date, hour, minute, repeat);
        }

        if (editMode) {
            int repeatition = 0;
            assert repeat != null;
            if (repeat.equals("Never")) {
                repeatition = 0;
            }

            if (repeat.equals("Daily")) {
                repeatition = 1; // for daily repeatition we will repeat it for 7 days
            }
            if (repeat.equals("Weekly")) {
                repeatition = 2;

            }
            if (repeat.equals("Monthly")) {
                repeatition = 3;
            }
            if (repeat.equals("Yearly")) {
                repeatition = 4;
            }
            Time time = new Time(hour, minute, 0);
            if (updateTask(openedTask.getTaskID(), taskName, time, date, repeatition) > 0) {
                dateField.setText(String.valueOf(date));
                timeField.setText(String.valueOf(time));
                repeatField.setText(String.valueOf(repeat));
            }
            editMode = false;
            addTaskPanel.setVisible(false);
        }
        loading = false;
        clearAddTaskPanel();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                setForReminder();
            }
        });

        thread.start();
    }// GEN-LAST:event_addTaskButtonActionPerformed

    private void reminderBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_reminderBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_reminderBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_logoutBtnActionPerformed

    private void analyticsBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_analyticsBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_analyticsBtnActionPerformed

    private void toDoBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_toDoBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_toDoBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_homeBtnActionPerformed

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_completeButtonActionPerformed
        taskDetailsPanel.setVisible(false);
        addTaskPanel.setVisible(true);
        allTasks.setVisible(true);
        jScrollPane2.setVisible(true);
        openedTask.completeTask();
        clearAddTaskPanel();
    }// GEN-LAST:event_completeButtonActionPerformed

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_dateFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editButtonActionPerformed
        editMode = true;
        addTaskPanel.setVisible(true);
    }// GEN-LAST:event_editButtonActionPerformed

    public void getTaskDetails(Task task) {
        openedTask = task;
        allTasks.setVisible(false);
        addTaskPanel.setVisible(false);
        jScrollPane2.setVisible(false);
        taskNameLabel.setText(openedTask.getTaskName());
        dateField.setText(String.valueOf(openedTask.getDate()));
        timeField.setText(String.valueOf(openedTask.getTime()));
        String repetition = "";
        int repeat = openedTask.getRepeat();
        if (repeat == 0)
            repetition = "Never";
        if (repeat == 1)
            repetition = "Daily";
        if (repeat == 2)
            repetition = "Weekly";
        if (repeat == 3)
            repetition = "Monthly";
        if (repeat == 4)
            repetition = "Yearly";

        repeatField.setText(repetition);

        dateField.setEditable(false);
        timeField.setEditable(false);
        repeatField.setEditable(false);

        addTaskField.setText(openedTask.getTaskName());
        hourSelector.setValue(openedTask.getTime().getHours());
        minutesSelector.setValue(openedTask.getTime().getMinutes());
        datePicker.setDate(openedTask.getDate());

        taskDetailsPanel.setVisible(true);
    }

    public void loadTasks() {
        allTasks.setVisible(false);
        allTasks.removeAll();
        int count = 0;
        try {
            CallableStatement statement = connection.prepareCall("{call getReminderCount()}");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("remCount");
            }
        } catch (SQLException exception) {
        }
        if (count <= 0) {
            JLabel notTask = new JLabel("\t\t\tNo Tasks Yet!");
            notTask.setForeground(Color.WHITE);
            notTask.setVisible(true);
            allTasks.add(notTask);
            allTasks.setVisible(true);
            return;
        }
        allTasks.setLayout(new GridLayout(count, 1));
        tasks = new ArrayList<Task>();
        try {
            CallableStatement cStmt = connection.prepareCall("{call getReminders()}");
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setTaskComponents(this, rs.getInt("taskID"), rs.getString("taskName"), rs.getTime("time"), rs.getDate("date"), rs.getInt("repeat"));
                tasks.add(task);
            }
            cStmt.close();
        } catch (SQLException ex) {
        }

        for (int index = count - 1; index >= 0; index--) {
            allTasks.add(tasks.get(index));
        }
        allTasks.setVisible(true);
        if (!loading) {
            allTasks.setVisible(true);
            loading = true;
        }
        allTasks.repaint();
        allTasks.revalidate();
        allTasks.setVisible(true);
    }

    private void setReminder(String taskName, Time time, Date date, int repeatation) {
        try {
            // CallableStatement statement = connection.prepareCall("{call
            // getReminderCount()}");
            CallableStatement stmt = connection.prepareCall("{call setReminder(?,?,?,?)}");
            stmt.setString(1, taskName);
            stmt.setTime(2, time);
            stmt.setDate(3, date);
            stmt.setInt(4, repeatation);
            int rs = stmt.executeUpdate();
            loadTasks();
        } catch (SQLException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JTextField addTaskField;
    private javax.swing.JPanel addTaskPanel;
    private javax.swing.JPanel allTasks;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton completeButton;
    private javax.swing.JTextField dateField;
    private com.toedter.calendar.JDateChooser datePicker;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editDateLabel;
    private javax.swing.JPanel editDatePanel;
    private javax.swing.JSpinner hourSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton kanbanBtn1;
    private javax.swing.JPanel kanbanPanel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JSpinner minutesSelector;
    private javax.swing.JComboBox<String> repeatAfter;
    private javax.swing.JTextField repeatField;
    private javax.swing.JComboBox<String> selectorAmPm;
    private javax.swing.JLabel siteNameLbl;
    private javax.swing.JLabel taskAlert;
    private javax.swing.JPanel taskDetailsPanel;
    private javax.swing.JLabel taskNameLabel;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables

}
