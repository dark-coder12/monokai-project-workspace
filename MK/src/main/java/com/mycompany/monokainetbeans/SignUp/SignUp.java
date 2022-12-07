package com.mycompany.monokainetbeans.SignUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import static com.mycompany.monokainetbeans.Application.*;

public class SignUp extends javax.swing.JPanel {

    boolean successfulSignUp = false;
    String userName;
    String emailID;
    String password;
    String confirmPassword;
    String language;
    boolean checked = false;
   
    public SignUp() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        languageOpt = new javax.swing.JComboBox<>();
        infoCheckbox = new javax.swing.JCheckBox();
        signUpBtn = new javax.swing.JButton();
        uNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        redirectLoginBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 28, 59));

        jPanel1.setBackground(new java.awt.Color(0, 28, 35));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("User Name");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Confirm Password");

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Language");

        languageOpt.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        languageOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Developer", "C++ Developer" }));
        languageOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageOptActionPerformed(evt);
            }
        });

        infoCheckbox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        infoCheckbox.setText("All Information is correct");
        infoCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoCheckboxActionPerformed(evt);
            }
        });

        signUpBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        signUpBtn.setText("Make my account!");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 30)); // NOI18N
        jLabel6.setText("Sign Up");

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Monokai - Your Own Personal Workspace");

        redirectLoginBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        redirectLoginBtn.setText("Or Login Here");

        passwordField.setText("thisisapassword");

        confirmPasswordField.setText("thisisapassword");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(languageOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(signUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(infoCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(redirectLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(100, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(languageOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(infoCheckbox)
                        .addGap(50, 50, 50)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(signUpBtn)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redirectLoginBtn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //pack();
    }// </editor-fold>//GEN-END:initComponents

    private void languageOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageOptActionPerformed
        
        language = languageOpt.getSelectedItem().toString();
    }//GEN-LAST:event_languageOptActionPerformed

    private void infoCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoCheckboxActionPerformed
        
         checked = infoCheckbox.isSelected();
    }

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        
        userName = uNameField.getText().toString();
        emailID = emailField.getText().toString();
        password = passwordField.getText().toString();
        confirmPassword = confirmPasswordField.getText().toString();
        language = languageOpt.getSelectedItem().toString();

        boolean passwordCheck = passwordCheck(password, confirmPassword);
                
        boolean emailCheck = emailCheck(emailID);

        if(userName.length() == 0 || emailID.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
            JOptionPane.showMessageDialog(null, "Empty field error");
            return;

        }
        if(!passwordCheck){
            JOptionPane.showMessageDialog(null, "Passwords do not match");
            return;
        }
   
        if(!emailCheck){
            JOptionPane.showMessageDialog(null, "Improper Email Format");
            return;
        }

        if(!checked){
            JOptionPane.showMessageDialog(null, "Unchecked field");
            return;
        }
        if(emailCheck && passwordCheck && checked){
            
            SignUpUser(emailID, password);
            successfulSignUp = true;
        }
    }

    boolean passwordCheck(String pass, String confirmPass){
        
        if(pass.equals(confirmPass))
            return true;
        
        return false;
    }
    boolean emailCheck(String email_){
        
        if(email_ != null){

            if(email_.contains("@") && email_.contains(".") && email_.length() > 5){
                return true;
                
            }
            else return false;
        }
        else return false;
    }
      private void SignUpUser(String email_, String password_) {

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            String sql = "INSERT into USER (email, password, userName, language) values (?, ?, ?, ?)";
            
            PreparedStatement query = con.prepareStatement(sql);
            
            query.setString(1, emailID);
            query.setString(2, password);
            query.setString(3,  userName);

            if(language.equals("Java Developer")){
                query.setString(4,  "Java");
            }
            else if(language.equals("C++ Developer")){
                query.setString(4,  "C++");
            }
            query.execute();
            query.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Sign Up Successful - You may login now!");

        }catch(Exception e){
            System.out.println("Connection invalid.");
        }
    }

    public boolean checkIfAnyUserExists(){

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select count(*) from user;";

            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            rs.next();

            if(rs.getInt(1) != 0){

                query.close();
                con.close();
                return true;
            }else{
                return false;
            }

        }catch(Exception e){
            System.out.println("Connection invalid.");
        }

        return  false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JCheckBox infoCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> languageOpt;
    private javax.swing.JPasswordField passwordField;
     public  javax.swing.JButton redirectLoginBtn;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JTextField uNameField;
}
