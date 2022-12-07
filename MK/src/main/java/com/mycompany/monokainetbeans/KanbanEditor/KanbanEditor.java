package com.mycompany.monokainetbeans.KanbanEditor;

import com.mycompany.monokainetbeans.Project.AddProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

import static com.mycompany.monokainetbeans.Application.*;
import static java.lang.Thread.sleep;

public class KanbanEditor extends javax.swing.JPanel {
    int panelChoice;
    public String currProject  = "";

    public JPanel kanbanTiles[];
    AddTask myTask;

    public KanbanEditor() {

        initComponents();

        addTaskButton.setBorderPainted(false);
        addTaskButton.setContentAreaFilled(false);
        addTaskButton.setFocusable(false);

        projectBtn.setBorderPainted(false);
        projectBtn.setContentAreaFilled(false);
        projectBtn.setFocusable(false);


        addTaskButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addTaskButton.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addTaskButton.setContentAreaFilled(false);
            }
        });

        projectBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                projectBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                projectBtn.setContentAreaFilled(false);
            }
        });

        addTaskButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                myTask = new AddTask();
                myTask.getPriority().setSelectedIndex(0);
                myTask.getColumn().setSelectedIndex(0);

                myTask.getApplyButton().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        myTask.name = myTask.getField().getText();
                        myTask.priority = myTask.getPriority().getSelectedItem().toString();
                        myTask.columnVal = myTask.getColumn().getSelectedItem().toString();

                        int col = 0;

                        if (myTask.columnVal.equals("To Do")) {

                           col = 2;


                        } else if (myTask.columnVal.equals("In Progress")) {

                            col = 1;

                        } else if (myTask.columnVal.equals("Completed")) {

                            col = 3;
                        }

                        if(addKanbanTask(col, myTask.name , myTask.getPriority().getSelectedIndex(), currProject)){

                            initializeBoard();
                            myTask.dispose();
                        }else
                            myTask.dispose();
                    }
                });
            }
        });

        initializeBoard();
        setVisible(true);
    }

    public boolean addKanbanTask(int col, String name, int prior, String projName){

        try {
            if(name.length() == 0)
                return false;

            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String checkProject = "select count(*) from project where name = ?";
            PreparedStatement cP = con.prepareStatement(checkProject);
            cP.setString(1, projName);

            ResultSet rsCP = cP.executeQuery();
            rsCP.next();

            if(rsCP.getInt(1) == 0){
                return false;
            }

            String sql = "insert into kanbaneditor (columnID, name, priority, projectName) values (? , ? , ?, ?)";

            PreparedStatement ptst = con.prepareStatement(sql);

            ptst.setInt(1, col);
            ptst.setString(2, name);
            ptst.setInt(3, prior);
            ptst.setString(4, projName);

            ptst.execute();
            ptst.close();
            con.close();
            return  true;

        }catch(Exception ec){
            System.out.println("Connection invalid.");
            return false;
        }
    }
     public void initializeBoard() {

         inProgPanel.removeAll();

         GridBagLayout g1 = new GridBagLayout();
         inProgPanel.setLayout(g1);

         GridBagConstraints constraints1 = new GridBagConstraints();

         constraints1.gridx = 0;
         constraints1.gridy = 0;
         constraints1.anchor = GridBagConstraints.CENTER;
         constraints1.insets = new Insets(10, 5, 10, 4);

         toDoPanel.removeAll();

         GridBagLayout g2 = new GridBagLayout();
         toDoPanel.setLayout(g2);

         GridBagConstraints constraints2 = new GridBagConstraints();

         constraints2.gridx = 0;
         constraints2.gridy = 0;
         constraints2.anchor = GridBagConstraints.CENTER;
         constraints2.insets = new Insets(10, 5, 10, 4);

         donePanel.removeAll();

         GridBagLayout g3 = new GridBagLayout();
         donePanel.setLayout(g3);

         GridBagConstraints constraints3 = new GridBagConstraints();

         constraints3.gridx = 0;
         constraints3.gridy = 0;
         constraints3.anchor = GridBagConstraints.CENTER;
         constraints3.insets = new Insets(10, 5, 10, 4);

         try {
             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

             String sql = "select count(*) from kanbaneditor where projectName = ?";

             PreparedStatement ptst = con.prepareStatement(sql);
             ptst.setString(1, currProject);
             ResultSet rs = ptst.executeQuery();
             rs.next();

             int count = rs.getInt(1);

             String sql2 = "select * from kanbaneditor where projectName = ?";

             PreparedStatement ptst2 = con.prepareStatement(sql2);

             ptst2.setString(1, currProject);

             ResultSet rs2 = ptst2.executeQuery();

             for (int i = 0; i < count; i++) {

                 rs2.next();

                 JPanel box = new JPanel();
                 JLabel boxlbl = new JLabel();
                 JSeparator boxsep = new JSeparator();

                 box.setBackground(new java.awt.Color(204, 204, 204));
                 box.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

                 boxlbl.setForeground(new java.awt.Color(0, 0, 0));
                 boxlbl.setText(rs2.getString(2));

                 JComboBox boxcombo = new JComboBox<>();
                 boxcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Low", "Medium", "High"}));
                 boxcombo.setSelectedIndex(rs2.getInt(3));
                 boxcombo.setEnabled(false);
                 javax.swing.GroupLayout boxLayout = new javax.swing.GroupLayout(box);
                 box.setLayout(boxLayout);
                 boxLayout.setHorizontalGroup(
                         boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(boxLayout.createSequentialGroup()
                                         .addContainerGap(25, Short.MAX_VALUE)
                                         .addGroup(boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(boxcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(boxsep, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(boxlbl))
                                         .addContainerGap(25, Short.MAX_VALUE))
                 );
                 boxLayout.setVerticalGroup(
                         boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLayout.createSequentialGroup()
                                         .addContainerGap()
                                         .addComponent(boxlbl)
                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                         .addComponent(boxsep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                         .addComponent(boxcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addContainerGap())
                 );

                 if (rs2.getInt(1) == 1) {
                     panelChoice = 1;
                     inProgPanel.add(box, constraints1);
                     inProgPanel.revalidate();
                     inProgPanel.repaint();
                     inProgPanel.setVisible(true);
                     constraints1.gridy = constraints1.gridy + 1;

                 } else if (rs2.getInt(1) == 2) {

                     panelChoice = 2;
                     toDoPanel.add(box, constraints2);
                     toDoPanel.revalidate();
                     toDoPanel.repaint();
                     toDoPanel.setVisible(true);
                     constraints2.gridy = constraints2.gridy + 1;
                 } else if (rs2.getInt(1) == 3) {

                     panelChoice = 3;
                     donePanel.add(box, constraints3);
                     donePanel.revalidate();
                     donePanel.repaint();
                     donePanel.setVisible(true);
                     constraints3.gridy = constraints3.gridy + 1;
                 }
                 box.setName(boxlbl.getText());

                 if (kanbanTiles == null) {
                     kanbanTiles = new JPanel[count];
                 }

                 kanbanTiles[i] = box;

                 box.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {

                         JPopupMenu menu = new JPopupMenu();

                         menu.add("Move to Completed").addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent ee) {

                                 for (int i = 0; i < count; i++) {

                                     if (e.getComponent().getName().equals(kanbanTiles[i].getName())) {

                                         Connection c;

                                         try {
                                             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                             String sql = "update kanbaneditor set columnID = ? where name = ?";

                                             PreparedStatement query = con.prepareStatement(sql);

                                             query.setInt(1, 3);

                                             moveKanbanTasks(i, query);

                                         } catch (Exception e) {
                                         }
                                     }
                                 }
                             }
                         });

                         menu.add("Move to ToDo").addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent ee) {

                                 for (int i = 0; i < count; i++) {

                                     if (e.getComponent().getName().equals(kanbanTiles[i].getName())) {

                                         Connection c;

                                         try {
                                             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                             String sql = "update kanbaneditor set columnID = ? where name = ?";

                                             PreparedStatement query = con.prepareStatement(sql);

                                             query.setInt(1, 2);

                                             moveKanbanTasks(i, query);
                                             break;

                                         } catch (Exception e) {
                                         }
                                     }
                                 }
                             }
                         });

                         menu.add("Move to In Progress").addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent ee) {

                                 for (int i = 0; i < count; i++) {

                                     if (e.getComponent().getName().equals(kanbanTiles[i].getName())) {

                                         Connection c;

                                         try {
                                             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                             String sql = "update kanbaneditor set columnID = ? where name = ?";

                                             PreparedStatement query = con.prepareStatement(sql);

                                             query.setInt(1, 1);

                                             moveKanbanTasks(i, query);

                                         } catch (Exception e) {
                                         }
                                     }
                                 }
                             }
                         });

                         menu.add("Delete").addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent ee) {

                                 for (int i = 0; i < count; i++) {

                                     if (e.getComponent().getName().equals(kanbanTiles[i].getName())) {

                                         Connection c;

                                         try {
                                             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                             String sql = "delete from kanbaneditor where name = ?";

                                             PreparedStatement query = con.prepareStatement(sql);

                                             query.setString(1, kanbanTiles[i].getName());

                                             query.execute();

                                             kanbanTiles = null;
                                             sleep(300);
                                             initializeBoard();
                                             sleep(300);
                                             kanbanPanel.repaint();
                                             kanbanPanel.revalidate();
                                             break;

                                         } catch (Exception e) {
                                         }
                                     }
                                 }
                             }
                         });

                         menu.show(e.getComponent(), e.getX(), e.getY());
                         menu.setVisible(true);

                     }
                 });
             }

         } catch (Exception e) {
             System.out.println("Connection invalid.");
         }
     }

    private void moveKanbanTasks(int i, PreparedStatement query) throws SQLException, InterruptedException {
        query.setString(2, kanbanTiles[i].getName());

        query.execute();

        kanbanTiles = null;
        sleep(200);
        initializeBoard();
        sleep(200);
        kanbanPanel.repaint();
        kanbanPanel.revalidate();
        return;
    }

    public static void main(String args[]){
         KanbanEditor kb = new KanbanEditor();
     }

    private void initComponents() {

        kanbanPanel = new javax.swing.JPanel();
        projectBtn = new javax.swing.JButton();
        siteNameLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addTaskButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inProgPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        toDoPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        donePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        kanbanPanel.setBackground(new java.awt.Color(0, 43, 54));

        projectBtn.setBackground(new java.awt.Color(0, 0, 0));
        projectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectBtn.setText("Projects");
        projectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));


        siteNameLbl.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        siteNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setText("Monokai");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout kanbanPanelLayout = new javax.swing.GroupLayout(kanbanPanel);
        kanbanPanel.setLayout(kanbanPanelLayout);
        kanbanPanelLayout.setHorizontalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(siteNameLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(projectBtn)))
                .addGap(18, 18, 18))
        );
        kanbanPanelLayout.setVerticalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(siteNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(projectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > Project > Kanban Board");

        addTaskButton.setBackground(new java.awt.Color(51, 51, 51));
        addTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        addTaskButton.setText("Add Task");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addTaskButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTaskButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inProgPanelLayout = new javax.swing.GroupLayout(inProgPanel);
        inProgPanel.setLayout(inProgPanelLayout);
        inProgPanelLayout.setHorizontalGroup(
            inProgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        inProgPanelLayout.setVerticalGroup(
            inProgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(inProgPanel);

        javax.swing.GroupLayout toDoPanelLayout = new javax.swing.GroupLayout(toDoPanel);
        toDoPanel.setLayout(toDoPanelLayout);
        toDoPanelLayout.setHorizontalGroup(
            toDoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        toDoPanelLayout.setVerticalGroup(
            toDoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(toDoPanel);

        javax.swing.GroupLayout donePanelLayout = new javax.swing.GroupLayout(donePanel);
        donePanel.setLayout(donePanelLayout);
        donePanelLayout.setHorizontalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        donePanelLayout.setVerticalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(donePanel);

        jLabel8.setText("Done");

        jLabel9.setText("ToDo");

        jLabel10.setText("Progress");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kanbanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void toDoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoBtnActionPerformed

    private void reminderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminderBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reminderBtnActionPerformed

    private void analyticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyticsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_analyticsBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtnActionPerformed

    private void toDoBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoBtn1ActionPerformed

    private void toDoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoBtn2ActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    javax.swing.JPanel donePanel;
    javax.swing.JPanel inProgPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel kanbanPanel;
    public javax.swing.JButton projectBtn;
    private javax.swing.JLabel siteNameLbl;
    javax.swing.JPanel toDoPanel;
    // End of variables declaration//GEN-END:variables
   


}

