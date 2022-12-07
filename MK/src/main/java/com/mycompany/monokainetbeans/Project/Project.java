package com.mycompany.monokainetbeans.Project;
import com.mycompany.monokainetbeans.Application;
import com.mycompany.monokainetbeans.KanbanEditor.KanbanEditor;
import com.mycompany.monokainetbeans.Reminder.Reminder;

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

public class Project extends javax.swing.JPanel {

    public JMenuItem ed;
    public JMenuItem del;
    public AddProject at;
    private javax.swing.JButton kbLbl;
    private javax.swing.JLabel projectLbl;
    private javax.swing.JPanel projectTile;
    public JPanel allPanelTiles[];

    public Project() {

        initComponents();

        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setFocusable(false);

        editorBtn.setBorderPainted(false);
        editorBtn.setContentAreaFilled(false);
        editorBtn.setFocusable(false);

        addProjectBtn.setBorderPainted(false);
        addProjectBtn.setContentAreaFilled(false);
        addProjectBtn.setFocusable(false);
        addProjectBtn.setBackground(Color.darkGray);

        reminderBtn.setBorderPainted(false);
        reminderBtn.setContentAreaFilled(false);
        reminderBtn.setFocusable(false);

        toDoBtn.setBorderPainted(false);
        toDoBtn.setContentAreaFilled(false);
        toDoBtn.setFocusable(false);

        analyticsBtn.setBorderPainted(false);
        analyticsBtn.setContentAreaFilled(false);
        analyticsBtn.setFocusable(false);

        projectsBtn.setBorderPainted(false);
        projectsBtn.setContentAreaFilled(false);
        projectsBtn.setFocusable(false);
        projectsBtn.setEnabled(false);

        ganttBtn.setBorderPainted(false);
        ganttBtn.setContentAreaFilled(false);
        ganttBtn.setFocusable(false);

        ganttBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ganttBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ganttBtn.setContentAreaFilled(false);
            }
        });

        editorBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                editorBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editorBtn.setContentAreaFilled(false);
            }
        });

        addProjectBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addProjectBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addProjectBtn.setContentAreaFilled(false);
            }
        });

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

        reminderBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                reminderBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reminderBtn.setContentAreaFilled(false);
            }
        });

        analyticsBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                analyticsBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                analyticsBtn.setContentAreaFilled(false);
            }
        });


        toDoBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                toDoBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                toDoBtn.setContentAreaFilled(false);
            }
        });

        initProjs();

        // this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kanbanPanel = new javax.swing.JPanel();
        projectsBtn = new javax.swing.JButton();
        editorBtn = new javax.swing.JButton();
        analyticsBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        reminderBtn = new javax.swing.JButton();
        siteNameLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        toDoBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ganttBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addProjectBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        allProj = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        kanbanPanel.setBackground(new java.awt.Color(0, 34, 43));

        projectsBtn.setBackground(new java.awt.Color(0, 0, 0));
        projectsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectsBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectsBtn.setText("Projects");
        projectsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        editorBtn.setBackground(new java.awt.Color(0, 0, 0));
        editorBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editorBtn.setForeground(new java.awt.Color(255, 255, 255));
        editorBtn.setText("Editor");
        editorBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        analyticsBtn.setBackground(new java.awt.Color(0, 0, 0));
        analyticsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        analyticsBtn.setForeground(new java.awt.Color(255, 255, 255));
        analyticsBtn.setText("Analytics");
        analyticsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        logoutBtn.setBackground(new java.awt.Color(0, 0, 0));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        reminderBtn.setBackground(new java.awt.Color(0, 0, 0));
        reminderBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reminderBtn.setForeground(new java.awt.Color(255, 255, 255));
        reminderBtn.setText("Reminders");
        reminderBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        siteNameLbl.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        siteNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        siteNameLbl.setText("Monokai");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        toDoBtn.setBackground(new java.awt.Color(0, 0, 0));
        toDoBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        toDoBtn.setForeground(new java.awt.Color(255, 255, 255));
        toDoBtn.setText("Todo");
        toDoBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        ganttBtn.setBackground(new java.awt.Color(0, 0, 0));
        ganttBtn.setFont(new java.awt.Font("Segoe UI", 0, 14));
        ganttBtn.setForeground(new java.awt.Color(255, 255, 255));
        ganttBtn.setText("Gantt");

        javax.swing.GroupLayout kanbanPanelLayout = new javax.swing.GroupLayout(kanbanPanel);
        kanbanPanel.setLayout(kanbanPanelLayout);
        kanbanPanelLayout.setHorizontalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(siteNameLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                                .addComponent(ganttBtn)
                                .addContainerGap())
                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(projectsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reminderBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editorBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(analyticsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(toDoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))))))
        );
        kanbanPanelLayout.setVerticalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                                        .addComponent(siteNameLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                                .addGap(11, 11, 11))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(kanbanPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(reminderBtn)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(analyticsBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(toDoBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(projectsBtn))
                .addGap(20, 20, 20)
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                        .addComponent(editorBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ganttBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        kanbanPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {analyticsBtn, editorBtn, logoutBtn, projectsBtn});

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > Projects");

        addProjectBtn.setBackground(new java.awt.Color(0, 0, 0));
        addProjectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addProjectBtn.setForeground(new java.awt.Color(255, 255, 255));
        addProjectBtn.setText("Add Project");
        addProjectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));

        addProjectBtn.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                at = new AddProject();
                if(!at.addProject()){

                    at.dispose();
                    return;
                }

                at.getApplyButton().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Timer timer = new Timer(1000, new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                projectsPage.allPanelTiles = null;
                                projectsPage.initProjs();
                                Application.kanbanPanel = projectsPage.allProj;

                                projectsPage.at.dispose();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProjectBtn))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout allProjLayout = new javax.swing.GroupLayout(allProj);
        allProj.setLayout(allProjLayout);
        allProjLayout.setHorizontalGroup(
            allProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        allProjLayout.setVerticalGroup(
            allProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(allProj);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1)
                .addGap(38, 38, 38))
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
    }

    public void initProjs(){

        allProj.removeAll();
        GridBagLayout g = new GridBagLayout();
        allProj.setLayout(g);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 35,30, 34);

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select count(*) from project";

            PreparedStatement ptst = con.prepareStatement(sql);

            ResultSet rs = ptst.executeQuery();
            rs.next();

            int count = rs.getInt(1);

            if(allPanelTiles == null)
                allPanelTiles = new JPanel[count];
            int j = 0;

            String sql2 = "select * from project";

            PreparedStatement ptst2 = con.prepareStatement(sql2);

            ResultSet rs2 = ptst2.executeQuery();

            for (int i = 0; i < count; i++) {

                rs2.next();

                if(j % 3 != 0 && j != 0){

                    constraints.gridy = constraints.gridy + 1 ;
                }else {
                    constraints.gridx = constraints.gridx + 1 ;
                    constraints.gridy  = 0 ;
                }
                j++;

                projectTile = new javax.swing.JPanel();
                projectLbl = new javax.swing.JLabel();

                kbLbl = new javax.swing.JButton();

                projectLbl.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
                projectLbl.setForeground(Color.white);

                projectLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                projectLbl.setText(rs2.getString(1));

                projectLbl.setToolTipText("");

                kbLbl.setText("Kanban");

                projectTile.setBackground(Color.BLACK);

                kbLbl.setBorderPainted(false);

                kbLbl.setFocusable(false);
                kbLbl.setBackground(Color.DARK_GRAY);
                kbLbl.setForeground(Color.white);

                javax.swing.GroupLayout projectTileLayout = new javax.swing.GroupLayout(projectTile);
                projectTile.setLayout(projectTileLayout);
                projectTileLayout.setHorizontalGroup(
                        projectTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(projectLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projectTileLayout.createSequentialGroup()
                                        .addContainerGap()

                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addComponent(kbLbl)
                                        .addContainerGap()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                )
                );
                projectTileLayout.setVerticalGroup(
                        projectTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(projectTileLayout.createSequentialGroup()
                                        .addComponent(projectLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addGroup(projectTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(kbLbl)
                                           )
                                        .addContainerGap())
                );

                Border blackLine = BorderFactory.createLineBorder(Color.black);
                projectTile.setBorder(blackLine);
                projectTile.setName(projectLbl.getText());
                kbLbl.setName(projectTile.getName());
                allPanelTiles[i] = projectTile;

                allProj.add(projectTile, constraints);

                allProj.revalidate();
                allProj.repaint();

                projectTile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        JPopupMenu menu = new JPopupMenu();

                        ed = new JMenuItem("Edit");
                        del = new JMenuItem("Delete");
                        ed.setName(projectTile.getName());
                        del.setName(projectTile.getName());

                        menu.add(del).addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent ee) {

                                for (Component cc : allProj.getComponents()) {

                                    if (cc.getName().equals(e.getComponent().getName())) {
                                        Connection c;

                                        try {
                                            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                                            String sql = "delete from project where name = ?";

                                            PreparedStatement query = con.prepareStatement(sql);

                                            query.setString(1, e.getComponent().getName());

                                            query.execute();
                                            String sql2 = "delete from kanbaneditor where projectName = ?";

                                            PreparedStatement query2 = con.prepareStatement(sql2);

                                            query2.setString(1, e.getComponent().getName());

                                            query2.execute();

                                            Timer timer = new Timer(500, new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        sleep(100);
                                                        allPanelTiles = null;
                                                        initProjs();
                                                        sleep(100);


                                                    } catch (InterruptedException ex) {
                                                        throw new RuntimeException(ex);
                                                    }
                                                }
                                            });
                                            timer.setRepeats(false);
                                            timer.start();


                                        } catch (Exception e) {
                                        }
                                        break;
                                    }
                                }
                            }
                        });
                        menu.add(ed).addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent ee) {

                                for (Component cc : allProj.getComponents()) {

                                    if (cc.getName().equals(e.getComponent().getName())) {

                                        at = new AddProject();
                                        at.edit = true;

                                        at.edit(e.getComponent().getName());

                                        at.getApplyButton().addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                Timer timer = new Timer(500, new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        try {
                                                            sleep(100);
                                                            allPanelTiles = null;
                                                            sleep(100);
                                                            initProjs();

                                                            projectsPage.allPanelTiles = null;
                                                            projectsPage.initProjs();
                                                            Application.kanbanPanel = projectsPage.allProj;

                                                            projectsPage.at.dispose();

                                                        } catch (InterruptedException ex) {
                                                            throw new RuntimeException(ex);
                                                        }
                                                    }
                                                });
                                                timer.setRepeats(false);
                                                timer.start();
                                            }
                                        });
                                    }
                                }
                            }
                        });
                        menu.show(e.getComponent(), e.getX(), e.getY());
                        menu.setVisible(true);
                    }
                });

                kbLbl.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {

                        JButton myButton = (JButton) ev.getSource();
                        String bName = myButton.getName();

                        for (Component c : allProj.getComponents()) {

                            if (c.getName().equals(bName)) {

                                monokaiDesktopApp.remove(projectsPanel);
                                monokaiDesktopApp.repaint();
                                monokaiDesktopApp.revalidate();
                                monokaiDesktopApp.setVisible(true);

                                KanbanEditor myKanban = new KanbanEditor();
                                myKanban.currProject = bName;
                                myKanban.initializeBoard();
                                JPanel kanban = myKanban;
                                monokaiDesktopApp.add(kanban);

                                myKanban.projectBtn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        monokaiDesktopApp.remove(kanban);
                                        monokaiDesktopApp.repaint();
                                        monokaiDesktopApp.revalidate();
                                        monokaiDesktopApp.setVisible(true);

                                        monokaiDesktopApp.add(projectsPanel);
                                    }
                                });
                            }
                        }

                        allProj.revalidate();
                        allProj.repaint();
                        allProj.setVisible(true);
                    }
                });
            }
        }catch(Exception e){
            System.out.println("Connection invalid.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addProjectBtn;
    public javax.swing.JPanel allProj;
    public javax.swing.JButton analyticsBtn;
    public javax.swing.JButton editorBtn;
    public javax.swing.JButton ganttBtn;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel kanbanPanel;
    public javax.swing.JButton logoutBtn;
    public javax.swing.JButton projectsBtn;
    public javax.swing.JButton reminderBtn;
    private javax.swing.JLabel siteNameLbl;
    public javax.swing.JButton toDoBtn;
    // End of variables declaration//GEN-END:variables
}

