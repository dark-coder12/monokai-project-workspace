package com.mycompany.monokainetbeans.GanttChart;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import javax.swing.*;
import java.sql.*;

import com.mycompany.monokainetbeans.Application;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

import static com.mycompany.monokainetbeans.Application.*;

public class GanttSource extends JPanel {
    JMenuBar mBar;
    public JButton replaceNewChart;
    public JButton addSingleTask;
    public JButton removeChart;
    public JButton backToProjects;
    public static TaskSeries series1 ;
    public static TaskSeries series2;

    public static JPanel Chart;
    public GanttSource(String title) {

        setLayout(new BorderLayout());

        mBar = new JMenuBar();

        replaceNewChart = new JButton("Replace Chart");
        backToProjects = new JButton("Back to Projects");
        addSingleTask = new JButton("Add Task in Current Chart");
        removeChart = new JButton("Remove Current Chart");

        replaceNewChart.setBorderPainted(false);
        replaceNewChart.setContentAreaFilled(false);
        replaceNewChart.setFocusable(false);
        replaceNewChart.setBackground(Color.GRAY);

        replaceNewChart.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                replaceNewChart.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replaceNewChart.setContentAreaFilled(false);
            }
        });


        backToProjects.setBorderPainted(false);
        backToProjects.setContentAreaFilled(false);
        backToProjects.setFocusable(false);
        backToProjects.setBackground(Color.GRAY);

        backToProjects.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                backToProjects.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backToProjects.setContentAreaFilled(false);
            }
        });

        addSingleTask.setBorderPainted(false);
        addSingleTask.setContentAreaFilled(false);
        addSingleTask.setFocusable(false);
        addSingleTask.setBackground(Color.GRAY);

        addSingleTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                addSingleTask.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addSingleTask.setContentAreaFilled(false);
            }
        });

        removeChart.setBorderPainted(false);
        removeChart.setContentAreaFilled(false);
        removeChart.setFocusable(false);
        removeChart.setBackground(Color.GRAY);

        removeChart.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                removeChart.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                removeChart.setContentAreaFilled(false);
            }
        });

        mBar.add(replaceNewChart);
        mBar.add(backToProjects);
        mBar.add(addSingleTask);
        mBar.add(removeChart);

        add(mBar, BorderLayout.NORTH);
        Chart = initGantt(title);

        add(Chart, BorderLayout.CENTER);

        addSingleTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AddTask newTask = new AddTask();
            }
        });

        removeChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Connection con = DriverManager.getConnection (DB_URL, USERNAME, PASSWORD);

                    if(con != null){

                        Statement truncate1 = con.createStatement();
                        String sql1 = "truncate projects";
                        truncate1.executeUpdate(sql1);

                        Statement truncate2 = con.createStatement();
                        String sql2 = "truncate expectedtask";
                        truncate2.executeUpdate(sql2);

                        Statement truncate3 = con.createStatement();
                        String sql3 = "truncate actualtask";
                        truncate3.executeUpdate(sql3);
                        Timer timer = new Timer(1000, new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                remove(Chart);
                                Chart = null;
                                Chart = initGantt(title);
                                add(Chart, BorderLayout.CENTER);
                                repaint();
                                revalidate();
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();

                    }
                    else {
                        System.out.print("Connection not established");
                    }
                }catch(SQLException sqlEx){
                    System.out.print("Connection not established");
                }
            }
        });
        replaceNewChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){

                try{
                    Connection con = DriverManager.getConnection (DB_URL, USERNAME, PASSWORD);

                    if(con != null){

                        Statement truncate1 = con.createStatement();
                        String sql1 = "truncate projects";
                        truncate1.executeUpdate(sql1);

                        Statement truncate2 = con.createStatement();
                        String sql2 = "truncate expectedtask";
                        truncate2.executeUpdate(sql2);

                        Statement truncate3 = con.createStatement();
                        String sql3 = "truncate actualtask";
                        truncate3.executeUpdate(sql3);

                        AddChart x = new AddChart();

                        x.getApplyButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                Timer timer = new Timer(1000, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        remove(Chart);
                                        Chart = null;
                                        Chart = initGantt(title);
                                        add(Chart, BorderLayout.CENTER);
                                        repaint();
                                        revalidate();
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();
                            }
                        });
                    }
                    else {
                        System.out.print("Connection not established");
                    }
                }catch(SQLException sqlEx){
                    System.out.print("Connection not established");
                }
            }
        });
    }

    public JPanel initGantt(String title){

        String ptitle = title;
        String X = "Task Completion Timeline";
        String Y = "Task Name";

        try{
            Connection con = DriverManager.getConnection (DB_URL, USERNAME, PASSWORD);
            if(con != null){
                Statement st3 = con.createStatement();
                String sql3 = "select * from projects";
                ResultSet rs3 = st3.executeQuery(sql3);

                while ( rs3.next() ) {

                    X = rs3.getString("xaxis");
                    Y = rs3.getString("yaxis");
                    ptitle = rs3.getString("chartname");
                    int sd = Integer.parseInt(rs3.getString("tasknum"));
                }
            }
            else {
                System.out.print("Connection not established");
            }
        }catch(SQLException sqlEx){}

        IntervalCategoryDataset dataset = getCategoryDataset();

        JFreeChart chart = ChartFactory.createGanttChart(
                ptitle,Y,X,dataset, true, true,true);

        ChartPanel panel = new ChartPanel(chart);
        chart.getPlot().setBackgroundPaint( Color.black );
        panel.setBackground(Color.black);

        return panel;
    }
    public static IntervalCategoryDataset getCategoryDataset() {

         series1 = new TaskSeries("Estimated Date");
         series2 = new TaskSeries("Actual Date");
        try{
            Connection con = DriverManager.getConnection (DB_URL, USERNAME, PASSWORD);

            if(con != null){

                Statement st = con.createStatement();
                String sql = "select * from expectedtask";
                ResultSet rs = st.executeQuery(sql);

                while ( rs.next() ) {

                    String name = rs.getString("taskname");
                    LocalDate sd = LocalDate.parse(rs.getString("startdate"));
                    LocalDate ed = LocalDate.parse(rs.getString("enddate"));
                    series1.add(new Task(name,
                            Date.from(sd.atStartOfDay().toInstant(ZoneOffset.UTC)),
                            Date.from(ed.atStartOfDay().toInstant(ZoneOffset.UTC))));
                }
                Statement st2 = con.createStatement();
                String sql2 = "select * from actualtask";
                ResultSet rs2 = st2.executeQuery(sql2);
                while ( rs2.next() ) {

                    String name2 = rs2.getString("taskname");
                    LocalDate sd2 = LocalDate.parse(rs2.getString("startdate"));
                    LocalDate ed2 = LocalDate.parse(rs2.getString("enddate"));

                    series2.add(new Task(name2,
                            Date.from(sd2.atStartOfDay().toInstant(ZoneOffset.UTC)),
                            Date.from(ed2.atStartOfDay().toInstant(ZoneOffset.UTC))));
                }
            }
            else{
                System.out.print("Connection not established");
            }
        }catch(Exception sqlEx){

        }
        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series1);
        dataset.add(series2);
        return dataset;
    }
}

