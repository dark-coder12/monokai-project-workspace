
package com.mycompany.monokainetbeans.Project;

import com.mycompany.monokainetbeans.Application.*;
import com.mycompany.monokainetbeans.KanbanEditor.*;
import com.mysql.cj.protocol.Resultset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import static com.mycompany.monokainetbeans.Application.*;

public class AddProject extends javax.swing.JFrame {

    boolean edit = false;
    boolean projAdded = false;

    public AddProject() {

        initComponents();
        setSize(700,500);
        setVisible(true);

          cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        cancelBtn.setBorderPainted(false);
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setFocusable(false);

        addFileBtn.setBorderPainted(false);
        addFileBtn.setContentAreaFilled(false);
        addFileBtn.setFocusable(false);

        applyBtn.setBorderPainted(false);
        applyBtn.setContentAreaFilled(false);
        applyBtn.setFocusable(false);

        applyBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                applyBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                applyBtn.setContentAreaFilled(false);
            }
        });

        cancelBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
               cancelBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancelBtn.setContentAreaFilled(false);
            }
        });

        addFileBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addFileBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addFileBtn.setContentAreaFilled(false);
            }
        });
    }

    public void edit(String pName){

        projectName.setText(pName);

        Connection c;

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from project where name = ?";

            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, pName);

            ResultSet rs = query.executeQuery();
            rs.next();
            int progNum = rs.getInt(2);

            if(progNum == 0){
                progress.setSelectedIndex(0);
            } else if(progNum == 25){
                progress.setSelectedIndex(1);
            }else if(progNum == 50){
                progress.setSelectedIndex(2);
            }else if(progNum == 75){
                progress.setSelectedIndex(3);
            }else if(progNum == 100){
                progress.setSelectedIndex(4);
            }
            codeTxt.setText(rs.getString(4));

            if(rs.getString(3).equals("C++"))
                language.setSelectedIndex(0);
            else{
                language.setSelectedIndex(1);
            }

            this.repaint();
            this.revalidate();
            this.setVisible(true);
        }
        catch(Exception e){}

        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(pName.length() == 0){
                    JOptionPane.showMessageDialog(null, "Project Name is Missing!");
                    return;
                }
                if(codeTxt.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Code is Missing!");
                    return;
                }
                String lang = language.getSelectedItem().toString();
                int prog = progress.getSelectedIndex();

                if(prog == 0)
                    prog = 0;
                else if(prog == 1)
                    prog = 25;
                else if(prog ==2)
                    prog = 50;
                else if(prog == 3)
                    prog = 75;
                else if(prog == 4)
                    prog = 100;

                try{
                    Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    String sql = "UPDATE project set name = ?, progress = ?,  language = ?, code = ? where name = ?";

                    PreparedStatement query = con.prepareStatement(sql);

                    query.setString(1, projectName.getText());
                    query.setInt(2, prog);
                    query.setString(3,  lang);
                    query.setString(4, codeTxt.getText());
                    query.setString(5, pName);
                    query.execute();

                    String sql2 = "update kanbaneditor set projectName = ? where projectName = ?";

                    PreparedStatement query2 = con.prepareStatement(sql2);
                    query2.setString(1, projectName.getText());
                    query2.setString(2, pName);
                    query2.execute();

                    query.close();
                    con.close();
                    edit = false;
                    dispose();

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
        majorPanel = new javax.swing.JPanel();
        projectNameLbl = new javax.swing.JLabel();
        progressLbl = new javax.swing.JLabel();
        codeLbl = new javax.swing.JLabel();
        projectName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        codeTxt = new javax.swing.JTextArea();
        progress = new javax.swing.JComboBox<>();
        sidePanel = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        addProjectLbl = new javax.swing.JLabel();
        applyBtn = new javax.swing.JButton();
        languageLbl = new javax.swing.JLabel();
        language = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        addFileBtn = new javax.swing.JButton();
        crumbLbl = new javax.swing.JLabel();

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

        majorPanel.setBackground(new java.awt.Color(0, 0, 0));
        majorPanel.setForeground(new java.awt.Color(0, 0, 0));

        projectNameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        projectNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        projectNameLbl.setText("Project Name");

        progressLbl.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        progressLbl.setForeground(new java.awt.Color(255, 255, 255));
        progressLbl.setText("Progress");

        codeLbl.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        codeLbl.setForeground(new java.awt.Color(255, 255, 255));
        codeLbl.setText("Code");

        projectName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        codeTxt.setColumns(20);
        codeTxt.setRows(5);
        jScrollPane1.setViewportView(codeTxt);

        progress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "25%", "50%", "75%", "100%" }));

        sidePanel.setBackground(new java.awt.Color(0, 43, 54));

        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");

        addProjectLbl.setBackground(new java.awt.Color(0, 0, 0));
        addProjectLbl.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        addProjectLbl.setForeground(new java.awt.Color(255, 255, 255));
        addProjectLbl.setText("Add Project");

        applyBtn.setForeground(new java.awt.Color(255, 255, 255));
        applyBtn.setText("Apply");


        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(applyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProjectLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(addProjectLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(applyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        languageLbl.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        languageLbl.setForeground(new java.awt.Color(255, 255, 255));
        languageLbl.setText("Language");

        language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "C++" }));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("OR");

        addFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        addFileBtn.setText("Add File Here");
        addFileBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser openFCmd = new JFileChooser("f:");

                int dialog = openFCmd.showOpenDialog(null);

                if (dialog == JFileChooser.APPROVE_OPTION) {

                    try {

                        String reader;

                        FileReader fr = new FileReader(openFCmd.getSelectedFile().getAbsolutePath());
                        BufferedReader br = new BufferedReader(fr);

                        String currText = "";

                        reader = br.readLine();

                        while (reader != null) {

                            currText = currText + " \n" + reader;
                            reader = br.readLine();
                        }

                        codeTxt.setText(currText);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File could not be opened");
                    }
                }
            }
        });

        crumbLbl.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        crumbLbl.setForeground(new java.awt.Color(255, 255, 255));
        crumbLbl.setText("Home > Project > Add Project");

        javax.swing.GroupLayout majorPanelLayout = new javax.swing.GroupLayout(majorPanel);
        majorPanel.setLayout(majorPanelLayout);
        majorPanelLayout.setHorizontalGroup(
            majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, majorPanelLayout.createSequentialGroup()
                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(majorPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(majorPanelLayout.createSequentialGroup()
                                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(projectNameLbl)
                                    .addComponent(languageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progress, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(projectName)
                                    .addComponent(language, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(majorPanelLayout.createSequentialGroup()
                                .addComponent(codeLbl)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, majorPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(majorPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(majorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(crumbLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        majorPanelLayout.setVerticalGroup(
            majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(majorPanelLayout.createSequentialGroup()
                .addComponent(crumbLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectNameLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(majorPanelLayout.createSequentialGroup()
                        .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(progressLbl)
                            .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(languageLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(majorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeLbl)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(majorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(majorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public boolean addProject() {

        final boolean[] projectAdded = new boolean[1];
        projectAdded[0] = true;

        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (projectName.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Project Name is missing.");
                    projectAdded[0] = false;
                }
                if (codeTxt.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Code is missing.");
                    projectAdded[0] = false;
                }

                if(projectAdded[0] == true) {
                    String lang = language.getSelectedItem().toString();
                    int prog = progress.getSelectedIndex();

                    if (prog == 0)
                        prog = 0;
                    else if (prog == 1)
                        prog = 25;
                    else if (prog == 2)
                        prog = 50;
                    else if (prog == 3)
                        prog = 75;
                    else if (prog == 4)
                        prog = 100;

                    try {
                        Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                        String sql = "INSERT into PROJECT (name, progress, language, code) values (?, ?, ?, ?)";

                        PreparedStatement query = con.prepareStatement(sql);

                        query.setString(1, projectName.getText());
                        query.setInt(2, prog);
                        query.setString(3, lang);
                        query.setString(4, codeTxt.getText());

                        query.execute();
                        projAdded = true;
                        query.close();
                        con.close();

                    } catch (Exception ee) {
                        System.out.println("Connection invalid.");
                    }
                }
            }
        });
        return projectAdded[0];
    }

    public JButton getApplyButton(){

        return applyBtn;
    }

    public JComboBox getPriority(){
        return progress;
    }

    public JTextField getField(){

        return projectName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFileBtn;
    private javax.swing.JLabel addProjectLbl;
    private javax.swing.JButton applyBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel codeLbl;
    javax.swing.JTextArea codeTxt;
    private javax.swing.JLabel crumbLbl;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JComboBox<String> language;
    private javax.swing.JLabel languageLbl;
    private javax.swing.JPanel majorPanel;
    javax.swing.JComboBox<String> progress;
    private javax.swing.JLabel progressLbl;
    javax.swing.JTextField projectName;
    private javax.swing.JLabel projectNameLbl;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables


    String name;
    String priority;
    String columnVal;
    boolean buttonClicked = false;
}
