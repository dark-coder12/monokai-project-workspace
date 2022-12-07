package com.mycompany.monokainetbeans.ToDo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import static com.mycompany.monokainetbeans.Application.*;
import static java.lang.Thread.sleep;

public class ToDoDocsAll extends javax.swing.JPanel {
    public int totalDocs = 0;
    public AddToDoDoc at;
    public ToDoDocsAll() {
        
        initComponents(); 

        projectRedirectBtn.setBorderPainted(false);
        projectRedirectBtn.setContentAreaFilled(false);
        projectRedirectBtn.setFocusable(false);
        
        addToDoBtn.setBorderPainted(false);
        addToDoBtn.setContentAreaFilled(false);
        addToDoBtn.setFocusable(false);
        addToDoBtn.setBackground(Color.darkGray);

        projectRedirectBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                projectRedirectBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                projectRedirectBtn.setContentAreaFilled(false);
            }
        });

        addToDoBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addToDoBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addToDoBtn.setContentAreaFilled(false);
            }
        });
         initToDoList();
         setVisible(true);

         DeleteAll.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 try {
                     Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                     String sql2 = "truncate todoitems";
                     PreparedStatement ptst2 = con.prepareStatement(sql2);
                     ptst2.execute();

                     String sql = "truncate tododocs";
                     PreparedStatement ptst = con.prepareStatement(sql);
                     ptst.execute();

                     initToDoList();
                 }catch (Exception ee){
                     System.out.println("Connection Invalid");
                 }
             }
         });
    }
     public void deleteDoc(String document){

         try {
             Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

             String sql2 = "delete from todoitems where docName = ?";

             PreparedStatement ptst2 = con.prepareStatement(sql2);

             ptst2.setString(1,  document);
             ptst2.execute();

             String sql = "delete from tododocs where docName = ?";

             PreparedStatement ptst = con.prepareStatement(sql);

             ptst.setString(1,  document);
             ptst.execute();
         }catch (Exception ee){
             System.out.println("Connection Invalid");
         }
     }
        public void initToDoList(){

        AllDocPanel.removeAll();
        GridBagLayout g = new GridBagLayout();
        AllDocPanel.setLayout(g);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 35,30, 34);

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select count(*) from tododocs";

            PreparedStatement ptst = con.prepareStatement(sql);

            ResultSet rs = ptst.executeQuery();
            rs.next();

            int count = rs.getInt(1);
            totalDocs = count;
            int j = 0;

            String sql2 = "select * from tododocs";

            PreparedStatement ptst2 = con.prepareStatement(sql2);

            ResultSet rs2 = ptst2.executeQuery();

            for (int i = 0; i < count; i++) {

                rs2.next();

                singleDocPanel = new JPanel();
                singleDocName = new JLabel();
                singleDocDate = new JLabel();
                viewBtn = new JButton();
                delBtn = new JButton();

                singleDocPanel.setBackground(new java.awt.Color(51, 51, 51));

                singleDocName.setForeground(new java.awt.Color(255, 255, 255));
                singleDocName.setText(rs2.getString(1));

                singleDocDate.setForeground(new java.awt.Color(255, 255, 255));
                singleDocDate.setText(rs2.getInt(2) +  "/" +  rs2.getInt(3) + "/" + rs2.getInt(4));

                viewBtn.setForeground(new java.awt.Color(255, 255, 255));
                viewBtn.setText("View");


                delBtn.setForeground(new java.awt.Color(255, 255, 255));
                delBtn.setText("Delete");

                delBtn.setBorderPainted(false);
                delBtn.setFocusable(false);
                delBtn.setBackground(Color.darkGray);

                viewBtn.setBorderPainted(false);
                viewBtn.setFocusable(false);
                viewBtn.setBackground(Color.darkGray);


                javax.swing.GroupLayout singleDocPanelLayout = new javax.swing.GroupLayout(singleDocPanel);
                singleDocPanel.setLayout(singleDocPanelLayout);
                singleDocPanelLayout.setHorizontalGroup(
                        singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(singleDocPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(singleDocName)
                                        .addGap(140, 140, 140)
                                        .addComponent(singleDocDate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                        .addComponent(viewBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(delBtn)
                                        .addGap(61, 61, 61))
                );
                singleDocPanelLayout.setVerticalGroup(
                        singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(singleDocPanelLayout.createSequentialGroup()
                                        .addContainerGap(9, Short.MAX_VALUE)
                                        .addGroup(singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(singleDocName)
                                                .addComponent(singleDocDate)
                                                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7))
                );

                singleDocPanel.setName(singleDocName.getText());
                delBtn.setName(singleDocName.getText());
                viewBtn.setName(singleDocName.getText());
                AllDocPanel.add(singleDocPanel, constraints);

                constraints.gridy = constraints.gridy + 1 ;

                delBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JButton myButton = (JButton)e.getSource();
                        String bName =myButton.getName();

                        for(Component c : AllDocPanel.getComponents()){

                            if(c.getName().equals(bName)){

                                deleteDoc(c.getName());
                                initToDoList();
                                break;
                            }
                        }
                    }
                });
                viewBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        monokaiDesktopApp.removeAll();
                        monokaiDesktopApp.repaint();
                        monokaiDesktopApp.revalidate();
                        monokaiDesktopApp.setVisible(true);

                        CreatedDocs oneDoc = new CreatedDocs();
                        JButton myButton = (JButton)e.getSource();
                        String bName =myButton.getName();

                        oneDoc.currDoc = bName;

                        oneDoc.initToDoItems();
                        JPanel todoItems = oneDoc;
                        monokaiDesktopApp.add(todoItems);

                        oneDoc.projectRedirectBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                monokaiDesktopApp.remove(todoItems);
                                monokaiDesktopApp.repaint();
                                monokaiDesktopApp.revalidate();
                                monokaiDesktopApp.setVisible(true);
                                  monokaiDesktopApp.add(projectsPanel);
                            }
                        });
                        oneDoc.toDoRedirectBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                monokaiDesktopApp.remove(todoItems);
                                monokaiDesktopApp.repaint();
                                monokaiDesktopApp.revalidate();
                                monokaiDesktopApp.setVisible(true);
                                  monokaiDesktopApp.add(allToDoDocumentsPanel);
                            }
                        });
                    }
                });
            }
            AllDocPanel.revalidate();
            AllDocPanel.repaint();

            AllDocPanel.setVisible(true);

        }catch(Exception e){
            System.out.println("Connection invalid.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        kanbanPanel = new javax.swing.JPanel();
        projectRedirectBtn = new javax.swing.JButton();
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
        addToDoBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        DeleteAll = new javax.swing.JButton();
        jScrollPane_AllDoc = new javax.swing.JScrollPane();
        AllDocPanel = new javax.swing.JPanel();
        singleDocPanel = new javax.swing.JPanel();
        singleDocName = new javax.swing.JLabel();
        singleDocDate = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));

        kanbanPanel.setBackground(new java.awt.Color(0, 43, 56));

        projectRedirectBtn.setBackground(new java.awt.Color(0, 0, 0));
        projectRedirectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectRedirectBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectRedirectBtn.setText("Projects");
        projectRedirectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

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
                        .addComponent(projectRedirectBtn)))
                .addGap(18, 18, 18))
        );
        kanbanPanelLayout.setVerticalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addComponent(siteNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(projectRedirectBtn))
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
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > To Do List");

        addToDoBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToDoBtn.setText("Add ToDo List");
        addToDoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                        at = new AddToDoDoc();

                        at.getApplyButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                Timer timer = new Timer(500, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        initToDoList();
                                        at.dispose();
                                        at = null;
                                        toDoPanel = allToDoDocumentsPage.AllDocPanel;
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();

                            }
                        });
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addToDoBtn)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToDoBtn))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        DeleteAll.setBackground(new java.awt.Color(102, 102, 102));
        DeleteAll.setText("Delete All");

        AllDocPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout singleDocPanelLayout = new javax.swing.GroupLayout(singleDocPanel);
        singleDocPanel.setLayout(singleDocPanelLayout);
        singleDocPanelLayout.setHorizontalGroup(
            singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleDocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(singleDocName)
                .addGap(140, 140, 140)
                .addComponent(singleDocDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(viewBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delBtn)
                .addGap(61, 61, 61))
        );
        singleDocPanelLayout.setVerticalGroup(
            singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleDocPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(singleDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleDocName)
                    .addComponent(singleDocDate)
                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout AllDocPanelLayout = new javax.swing.GroupLayout(AllDocPanel);
        AllDocPanel.setLayout(AllDocPanelLayout);
        AllDocPanelLayout.setHorizontalGroup(
            AllDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllDocPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(singleDocPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(211, 211, 211))
        );
        AllDocPanelLayout.setVerticalGroup(
            AllDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllDocPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(singleDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jScrollPane_AllDoc.setViewportView(AllDocPanel);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("To Do Documents");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteAll)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane_AllDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(DeleteAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_AllDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kanbanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel AllDocPanel;
    private javax.swing.JButton DeleteAll;
    public javax.swing.JButton addToDoBtn;
    public javax.swing.JButton delBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_AllDoc;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel kanbanPanel;
    public javax.swing.JButton projectRedirectBtn;
    private javax.swing.JLabel singleDocDate;
    private javax.swing.JLabel singleDocName;
    private javax.swing.JPanel singleDocPanel;
    private javax.swing.JLabel siteNameLbl;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
   


}

