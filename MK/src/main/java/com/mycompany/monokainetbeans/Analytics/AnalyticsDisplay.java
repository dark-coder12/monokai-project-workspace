package com.mycompany.monokainetbeans.Analytics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import static com.mycompany.monokainetbeans.Application.*;

public class AnalyticsDisplay extends javax.swing.JPanel {

    public AnalyticsDisplay() {

        initComponents();

        projectBtn.setBorderPainted(false);
        projectBtn.setContentAreaFilled(false);
        projectBtn.setFocusable(false);


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

        int charCount = 0;
        int javaPer = 0;
        int cPlusPlusPer = 0;
        int projectsCount = 0;
        int tododocCount;
        int kanbanCount;
        int timeC =0;

        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select language, count(language) as langCount from project group by language;";

            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();

            rs.next();

            int javaL = 0;
            int cPlusPlusL = 0;

            if (rs.getString(1).equals("Java")) {
                javaL = rs.getInt(2);
                rs.next();
                cPlusPlusL = rs.getInt(2);
            } else {
                cPlusPlusL = rs.getInt(2);
                rs.next();
                javaL = rs.getInt(2);
            }

            int total = javaL + cPlusPlusL;
            javaPer = (javaL * 100) / total;
            cPlusPlusPer = (cPlusPlusL * 100) / total;

           String sql2 = "select count(*) from project";

            PreparedStatement query2 = con.prepareStatement(sql2);
            ResultSet rs2 = query2.executeQuery();

            rs2.next();
            projectsCount = rs2.getInt(1);
            projectCount.setText(projectsCount + " ");

            String sql3 = "SELECT LENGTH(code) AS len FROM project";

            PreparedStatement query3 = con.prepareStatement(sql3);
            ResultSet rs3 = query3.executeQuery();

            while(rs3.next()){
                charCount += rs3.getInt("len");
            }

            cCount.setText(charCount + "");

            String sql4 = "SELECT count(*) from tododocs";

            PreparedStatement query4 = con.prepareStatement(sql4);
            ResultSet rs4 = query4.executeQuery();

            rs4.next();
            tododocCount = rs4.getInt(1);
            toDoDocCount.setText(tododocCount + " ");

            String sql5 = "SELECT count(*) from kanbaneditor";

            PreparedStatement query5 = con.prepareStatement(sql5);
            ResultSet rs5 = query5.executeQuery();

            rs5.next();
            kanbanCount = rs5.getInt(1);
            kbCount.setText(kanbanCount + " ");

        } catch (Exception e) {
            System.out.println("Connection invalid");
        }

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("C++", cPlusPlusPer);
        dataset.setValue("Java", javaPer);

        JFreeChart chart = ChartFactory.createPieChart("Languages", dataset, true, false, false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);
        plot.setIgnoreZeroValues(true);
        plot.setLabelGap(0.02);

        jPanel5.setSize(70, 70);

        ChartPanel myPie = new ChartPanel(chart) {

            public Dimension getPreferredSize() {
                return new Dimension(jPanel5.getWidth(), jPanel5.getHeight());
            }
        };

        myPie.setVisible(true);

        jPanel5.setLayout(new GridBagLayout());

        jPanel5.add(myPie);

        float completed = 0;

        String sqlIncProjects = "select count(*) from project where progress = 100";

        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement st1 = con.prepareStatement(sqlIncProjects);
            ResultSet rs1 = st1.executeQuery();
            rs1.next();
            completed = rs1.getInt(1);

        }
        catch(Exception e){

        }
        float doneProjectsRatio = (float) (completed / projectsCount) * 100;

        DoneProjectsProgress4.setValue((int) doneProjectsRatio);

        setVisible(true);
    }

    public void returnTime(){

        int timeC = 0;
        try {
            String sql6 = "SELECT * from time";

            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement query6 = con.prepareStatement(sql6);
            ResultSet rs6 = query6.executeQuery();

            rs6.next();
            timeC = rs6.getInt(1);

            long end = System.nanoTime();
            long elapsedTime = end - Time.start;
            timeC += elapsedTime;
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
            timeSpentLbl.setText(elapsedTimeInSecond + " S");

        }catch(Exception e){}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        basePanel = new javax.swing.JPanel();
        heading_Label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        kanbanCount = new javax.swing.JLabel();
        kbCount = new javax.swing.JLabel();
        totalProjectsDone_Label = new javax.swing.JLabel();
        projectCount = new javax.swing.JLabel();
        LoC_Label = new javax.swing.JLabel();
        toDoDocCount = new javax.swing.JLabel();
        todolbl = new javax.swing.JLabel();
        cCount = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        totalTime_Label = new javax.swing.JLabel();
        totalTime_Label1 = new javax.swing.JLabel();
        DoneProjectsProgress4 = new javax.swing.JProgressBar();
        timeSpentLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        kanbanPanel.setBackground(new java.awt.Color(0, 43, 54));

        projectBtn.setBackground(new java.awt.Color(0, 0, 0));
        projectBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectBtn.setForeground(new java.awt.Color(255, 255, 255));
        projectBtn.setText("Projects");
        projectBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        projectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectBtnActionPerformed(evt);
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

        javax.swing.GroupLayout kanbanPanelLayout = new javax.swing.GroupLayout(kanbanPanel);
        kanbanPanel.setLayout(kanbanPanelLayout);
        kanbanPanelLayout.setHorizontalGroup(
            kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kanbanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(siteNameLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                        .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kanbanPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(kanbanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(kanbanPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(projectBtn)))))
                        .addGap(21, 21, 21)))
                .addContainerGap())
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
                    .addComponent(projectBtn))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home > Analytics");

        jScrollPane1.setAlignmentX(0.0F);

        basePanel.setBackground(new java.awt.Color(51, 51, 51));

        heading_Label.setBackground(new java.awt.Color(153, 153, 153));
        heading_Label.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        heading_Label.setForeground(new java.awt.Color(204, 204, 204));
        heading_Label.setText("Progress Analysis");

        jPanel3.setBackground(new java.awt.Color(61, 61, 61));

        kanbanCount.setBackground(new java.awt.Color(204, 153, 255));
        kanbanCount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kanbanCount.setForeground(new java.awt.Color(255, 255, 255));
        kanbanCount.setText("Total Kanban Tasks:");

        kbCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        kbCount.setForeground(new java.awt.Color(255, 255, 255));
        kbCount.setText("10");

        totalProjectsDone_Label.setBackground(new java.awt.Color(204, 153, 255));
        totalProjectsDone_Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalProjectsDone_Label.setForeground(new java.awt.Color(255, 255, 255));
        totalProjectsDone_Label.setText("Total Projects Completed:");

        projectCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        projectCount.setForeground(new java.awt.Color(255, 255, 255));
        projectCount.setText("5");

        LoC_Label.setBackground(new java.awt.Color(51, 51, 51));
        LoC_Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoC_Label.setForeground(new java.awt.Color(255, 255, 255));
        LoC_Label.setText("Total Code Char Count:");

        toDoDocCount.setBackground(new java.awt.Color(204, 153, 255));
        toDoDocCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        toDoDocCount.setForeground(new java.awt.Color(255, 255, 255));
        toDoDocCount.setText("2");

        todolbl.setBackground(new java.awt.Color(204, 153, 255));
        todolbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        todolbl.setForeground(new java.awt.Color(255, 255, 255));
        todolbl.setText("Total ToDo Documents :");

        cCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        cCount.setForeground(new java.awt.Color(255, 255, 255));
        cCount.setText("200");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(kbCount)
                        .addGap(184, 184, 184)
                        .addComponent(projectCount))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(kanbanCount)
                        .addGap(87, 87, 87)
                        .addComponent(totalProjectsDone_Label)
                        .addGap(116, 116, 116)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(LoC_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(todolbl)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(cCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toDoDocCount)
                        .addGap(75, 75, 75))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(kanbanCount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(totalProjectsDone_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LoC_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(todolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kbCount)
                        .addComponent(projectCount))
                    .addComponent(cCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDoDocCount, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(61, 61, 61));

        totalTime_Label.setBackground(new java.awt.Color(204, 153, 255));
        totalTime_Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalTime_Label.setForeground(new java.awt.Color(255, 255, 255));
        totalTime_Label.setText("Overall Time Spent :");

        totalTime_Label1.setBackground(new java.awt.Color(204, 153, 255));
        totalTime_Label1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalTime_Label1.setForeground(new java.awt.Color(255, 255, 255));
        totalTime_Label1.setText("Overall Tasks achieved :");

        DoneProjectsProgress4.setBackground(new java.awt.Color(0, 43, 54));

        timeSpentLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeSpentLbl.setForeground(new java.awt.Color(255, 255, 255));
        timeSpentLbl.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalTime_Label1)
                    .addComponent(totalTime_Label))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DoneProjectsProgress4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(timeSpentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTime_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeSpentLbl))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalTime_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoneProjectsProgress4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(61, 61, 61));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(heading_Label))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(heading_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 142, Short.MAX_VALUE)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(basePanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kanbanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kanbanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectBtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar DoneProjectsProgress4;
    private javax.swing.JLabel LoC_Label;
    private javax.swing.JPanel basePanel;
    private java.awt.Label cCount;
    private javax.swing.JLabel heading_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel kanbanCount;
    private javax.swing.JPanel kanbanPanel;
    private javax.swing.JLabel kbCount;
    public javax.swing.JButton projectBtn;
    private javax.swing.JLabel projectCount;
    private javax.swing.JLabel siteNameLbl;
    private javax.swing.JLabel timeSpentLbl;
    private javax.swing.JLabel toDoDocCount;
    private javax.swing.JLabel todolbl;
    private javax.swing.JLabel totalProjectsDone_Label;
    private javax.swing.JLabel totalTime_Label;
    private javax.swing.JLabel totalTime_Label1;
    // End of variables declaration//GEN-END:variables
   


}

