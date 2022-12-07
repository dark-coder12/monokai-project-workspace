package com.mycompany.monokainetbeans.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;

import static com.mycompany.monokainetbeans.Application.*;

public class LogIn extends javax.swing.JPanel {
    com.mycompany.monokainetbeans.SignUp.User currentUser = null;
    public LogIn() {
        initComponents();
        setVisible(true);

        btnOK.setBorderPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.setBackground(Color.darkGray);
        btnOK.setFocusable(false);
        
        btnOK.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
               btnOK.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnOK.setContentAreaFilled(false);
            }
        });
         
        signUpBtn.setBorderPainted(false);
        signUpBtn.setContentAreaFilled(false);
        signUpBtn.setBackground(Color.darkGray);
        signUpBtn.setFocusable(false);
        
        signUpBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
               signUpBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpBtn.setContentAreaFilled(false);
            }
        });
        setVisible(true);
    }
    public boolean loginUser() {

        String email_ = tfEmail.getText();
        String password_ = String.valueOf(pfPassword.getPassword());

        if(email_.length() == 0){
            JOptionPane.showMessageDialog(monokaiDesktopApp, "Email field can not be empty", "Login Unsuccessful", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!email_.contains("@")){
            JOptionPane.showMessageDialog(monokaiDesktopApp, "Missing @ symbol", "Login Unsuccessful", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        if(password_.length() == 0){
            JOptionPane.showMessageDialog(monokaiDesktopApp, "Password field can not be empty", "Login Unsuccessful", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean userExists = false;

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement sqlStatement = con.createStatement();

            boolean executeL = executeLogin(email_, password_);

            if (executeL) {

                userExists = true;
                currentUser = new com.mycompany.monokainetbeans.SignUp.User();

                currentUser.email = email_;
                currentUser.password = password_;
            }else{
                JOptionPane.showMessageDialog(monokaiDesktopApp, "Invalid Credentials", "Login Unsuccessful", JOptionPane.ERROR_MESSAGE);

            }

            sqlStatement.close();
            con.close();

        }catch(Exception e){
            System.out.println("Connection invalid.");
            e.printStackTrace();
        }
        return userExists;
    }

    public boolean executeLogin(String email_, String password_) throws SQLException {

        Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        Statement sqlStatement = con.createStatement();

        String query = "SELECT * FROM user WHERE email='"+email_+"' AND password='"+password_+"'";

        ResultSet result = sqlStatement.executeQuery(query);

        if(result.next())
            return true;
        return false;
    }

    public void setDefault(){
        tfEmail.setText("");
        pfPassword.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        btnOK = new javax.swing.JButton();
        signUpBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 43, 54));
        setForeground(new java.awt.Color(255, 94, 151));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255,255,255));
        jLabel5.setText("Monokai is glad to have you back!");

        jPanel2.setBackground(new java.awt.Color(0, 28, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("Log In To Account!");

        signUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn.setText("Or Sign Up here");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnOK)
                .addGap(18, 18, 18)
                .addComponent(signUpBtn)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

       // pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    javax.swing.JPasswordField pfPassword;
   public javax.swing.JButton signUpBtn;
    javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
