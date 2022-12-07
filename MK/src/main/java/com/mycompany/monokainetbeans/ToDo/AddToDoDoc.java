package com.mycompany.monokainetbeans.ToDo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.*;

import static com.mycompany.monokainetbeans.Application.*;


public class AddToDoDoc extends javax.swing.JFrame {

    public AddToDoDoc() {


        initComponents();
        setVisible(true);
        
          cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

          addDocButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                  if(docName.getText().length() == 0){
                      JOptionPane.showMessageDialog(null, "Project Name is Missing!");
                  }

                  Date d = createDateCal.getDate();

                  int day_ = d.getDay();
                  int month_ = d.getMonth();
                  int year_ = d.getYear();

                  try{
                      Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                      String sql = "INSERT into tododocs (docName, day, month, year) values (?, ?, ?, ?)";

                      PreparedStatement query = con.prepareStatement(sql);

                      query.setString(1, docName.getText());
                      query.setInt(2, day_);
                      query.setInt(3, month_);
                      query.setInt(4, year_);

                      query.execute();
                      query.close();
                      con.close();

                  }catch(Exception ev){
                      System.out.println("Connection invalid.");
                  }
              }
          });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        DocNameLabel = new javax.swing.JLabel();
        creationDateLabel = new javax.swing.JLabel();
        docName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        addDocLabel = new javax.swing.JLabel();
        addDocButton = new javax.swing.JButton();
        createDateCal = new com.toedter.calendar.JCalendar();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        DocNameLabel.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        DocNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        DocNameLabel.setText("Document Name ");

        creationDateLabel.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        creationDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        creationDateLabel.setText("Creation Date");

        docName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));


        jPanel3.setBackground(new java.awt.Color(0, 43, 56));

        cancelButton.setBackground(new java.awt.Color(102, 102, 102));
        cancelButton.setText("Cancel");


        addDocLabel.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addDocLabel.setForeground(new java.awt.Color(255, 255, 255));
        addDocLabel.setText("Add To Do Document");

        addDocButton.setBackground(new java.awt.Color(204, 204, 204));
        addDocButton.setText("Add");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDocButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDocLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(addDocLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home > ToDo > Add ToDo Document");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DocNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creationDateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(docName)
                            .addComponent(createDateCal, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DocNameLabel))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createDateCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creationDateLabel))
                .addContainerGap(66, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public JButton getApplyButton(){
        
        return addDocButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DocNameLabel;
    private javax.swing.JButton addDocButton;
    private javax.swing.JLabel addDocLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JCalendar createDateCal;
    private javax.swing.JLabel creationDateLabel;
    private javax.swing.JTextField docName;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]){
        AddToDoDoc myDoc = new AddToDoDoc();
    }
}
