package com.mycompany.monokainetbeans.ToDo;

import com.mycompany.monokainetbeans.Application;
import com.mycompany.monokainetbeans.KanbanEditor.AddTask;

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
import javax.swing.border.Border;

import static com.mycompany.monokainetbeans.Application.*;
import static java.lang.Thread.sleep;

public class CreatedDocs extends javax.swing.JPanel {
    public String currDoc  = "";
    public CreatedDocs() {

        initComponents();


        addItem.setBorderPainted(false);
        addItem.setContentAreaFilled(false);
        addItem.setFocusable(false);
        addItem.setBackground(Color.darkGray);

         delAllBtn.setBorderPainted(false);
         delAllBtn.setContentAreaFilled(false);
         delAllBtn.setFocusable(false);
        delAllBtn.setBackground(Color.darkGray);

        projectRedirectBtn.setBorderPainted(false);
        projectRedirectBtn.setContentAreaFilled(false);
        projectRedirectBtn.setFocusable(false);

        toDoRedirectBtn.setBorderPainted(false);
        toDoRedirectBtn.setContentAreaFilled(false);
        toDoRedirectBtn.setFocusable(false);


        addItem.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addItem.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addItem.setContentAreaFilled(false);
            }
        });

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

        toDoRedirectBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                toDoRedirectBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                toDoRedirectBtn.setContentAreaFilled(false);
            }
        });

       delAllBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                 delAllBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 delAllBtn.setContentAreaFilled(false);
            }

        });

       addItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               addToDoItem(e);
           }
       });

       delAllBtn.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {

               try {
                   Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                   String sql2 = "delete from todoitems where docName = ?";

                   PreparedStatement ptst2 = con.prepareStatement(sql2);

                   ptst2.setString(1,  currDoc);
                   ptst2.execute();

                   Timer timer = new Timer(200, new ActionListener() {

                       @Override
                       public void actionPerformed(ActionEvent e) {

                           initToDoItems();
                           repaint();
                           revalidate();
                           setVisible(true);
                       }
                   });
                   timer.setRepeats(false);
                   timer.start();

               }catch (Exception ee){
                   System.out.println("Connection Invalid");
               }
           }
       });
    }

    public void initToDoItems(){

        itemsBox.removeAll();
        GridBagLayout g = new GridBagLayout();
        itemsBox.setLayout(g);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 35,30, 34);

        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select count(*) from todoitems where docName = ?";

            PreparedStatement ptst = con.prepareStatement(sql);

            ptst.setString(1, currDoc);
            ResultSet rs = ptst.executeQuery();
            rs.next();

            int count = rs.getInt(1);

            int j = 0;

            String sql2 = "select * from todoitems where docName = ?";

            PreparedStatement ptst2 = con.prepareStatement(sql2);
            ptst2.setString(1, currDoc);
            ResultSet rs2 = ptst2.executeQuery();

            for (int i = 0; i < count; i++) {

                rs2.next();

                constraints.gridy = constraints.gridy + 1;

                JPanel itemOneBox = new JPanel();
                itemOneBox.setName(rs2.getString(2));

                JCheckBox itemOneCheck = new JCheckBox();
                itemOneCheck.setName(rs2.getString(2));
                itemOneCheck.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        for(Component c: itemsBox.getComponents()){

                            if(c instanceof JPanel && c.getName().equals(itemOneCheck.getName())){

                                itemsBox.remove(c);

                                try {
                                    Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                    String sql = "delete from todoitems where itemDesc = ?";

                                    PreparedStatement ptst = con.prepareStatement(sql);

                                    ptst.setString(1, itemOneCheck.getName());
                                    ptst.execute();

                                    Timer timer = new Timer(200, new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            initToDoItems();
                                            repaint();
                                            revalidate();
                                            setVisible(true);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();

                                }catch (Exception ee){
                                    System.out.println("Connection Invalid");
                                }

                            }
                        }
                    }
                });
                JLabel itemOneName = new JLabel();

                itemOneBox.setBackground(new java.awt.Color(51, 51, 51));

                itemOneName.setForeground(new java.awt.Color(255, 255, 255));
                itemOneName.setText(rs2.getString(2));

                javax.swing.GroupLayout itemOneBoxLayout = new javax.swing.GroupLayout(itemOneBox);
                itemOneBox.setLayout(itemOneBoxLayout);
                itemOneBoxLayout.setHorizontalGroup(
                        itemOneBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(itemOneBoxLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(itemOneCheck)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itemOneName)
                                        .addContainerGap(342, Short.MAX_VALUE))
                );
                itemOneBoxLayout.setVerticalGroup(
                        itemOneBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemOneBoxLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(itemOneBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(itemOneCheck)
                                                .addComponent(itemOneName))
                                        .addGap(3, 3, 3))
                );
                itemsBox.add(itemOneBox, constraints);


                itemsBox.revalidate();
                itemsBox.repaint();
                itemsBox.setVisible(true);

            }
        }
        catch(Exception e){
            System.out.println("Connection Invalid");
        }
    }
    private void addToDoItem(java.awt.event.ActionEvent evt) {

        AddToDoItem at = new AddToDoItem();

        at.getApplyButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    String sql = "INSERT into todoitems (docName, itemDesc) values (?, ?)";

                    PreparedStatement query = con.prepareStatement(sql);

                    query.setString(2, at.itemDesc.getText());
                    query.setString(1,currDoc);

                    query.execute();
                    query.close();
                    con.close();

                }catch(Exception ev){
                    System.out.println("Connection invalid.");
                }

                initToDoItems();
                at.dispose();
            }
        });
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
        toDoRedirectBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        itemsBox = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        delAllBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addItem = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));

        kanbanPanel.setBackground(new java.awt.Color(0, 43, 56));

        projectRedirectBtn.setBackground(new java.awt.Color(0, 0, 0));
        projectRedirectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectRedirectBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectRedirectBtn.setText("Projects");
        projectRedirectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        projectRedirectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectRedirectBtnActionPerformed(evt);
            }
        });

        siteNameLbl.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        siteNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setText("Monokai");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        toDoRedirectBtn.setBackground(new java.awt.Color(0, 0, 0));
        toDoRedirectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toDoRedirectBtn.setForeground(new java.awt.Color(255, 255, 255));
        toDoRedirectBtn.setText("Todo");
        toDoRedirectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        toDoRedirectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDoRedirectBtnActionPerformed(evt);
            }
        });

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
                    .addComponent(siteNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(toDoRedirectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(projectRedirectBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addComponent(toDoRedirectBtn)
                        .addGap(18, 18, 18)
                        .addComponent(projectRedirectBtn)
                        .addGap(234, 234, 234))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout itemsBoxLayout = new javax.swing.GroupLayout(itemsBox);
        itemsBox.setLayout(itemsBoxLayout);
        itemsBoxLayout.setHorizontalGroup(
            itemsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        itemsBoxLayout.setVerticalGroup(
            itemsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        delAllBtn.setBackground(new java.awt.Color(0, 0, 0));
        delAllBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delAllBtn.setForeground(new java.awt.Color(255, 255, 255));
        delAllBtn.setText("Delete All");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > To Do > To Do Items");

        addItem.setBackground(new java.awt.Color(0, 0, 0));
        addItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addItem.setForeground(new java.awt.Color(255, 255, 255));
        addItem.setText("Add Item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(addItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delAllBtn)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delAllBtn)
                    .addComponent(addItem))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(itemsBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(itemsBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kanbanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projectRedirectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectRedirectBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectRedirectBtnActionPerformed

    private void toDoRedirectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoRedirectBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDoRedirectBtnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItem;
    private javax.swing.JButton delAllBtn;
    private javax.swing.JPanel itemsBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel kanbanPanel;
    public javax.swing.JButton projectRedirectBtn;
    private javax.swing.JLabel siteNameLbl;
    public javax.swing.JButton toDoRedirectBtn;
    // End of variables declaration//GEN-END:variables



}

