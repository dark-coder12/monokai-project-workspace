package com.mycompany.monokainetbeans;

import com.mycompany.monokainetbeans.Analytics.AnalyticsDisplay;
import com.mycompany.monokainetbeans.Analytics.Time;
import com.mycompany.monokainetbeans.GanttChart.GanttSource;
import com.mycompany.monokainetbeans.Home.Home;
import com.mycompany.monokainetbeans.Reminder.Reminder;
import com.mycompany.monokainetbeans.SignUp.SignUp;
import com.mycompany.monokainetbeans.ToDo.AddToDoDoc;
import com.mycompany.monokainetbeans.CodeSpace.CodingSpace;
import com.mycompany.monokainetbeans.KanbanEditor.KanbanEditor;
import com.mycompany.monokainetbeans.Login.LogIn;
import com.mycompany.monokainetbeans.Project.AddProject;
import com.mycompany.monokainetbeans.Project.Project;
import com.mycompany.monokainetbeans.ToDo.CreatedDocs;
import com.mycompany.monokainetbeans.ToDo.ToDoDocsAll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Thread.sleep;

public class Application extends JFrame{

    final public static String DB_URL = "jdbc:mysql://localhost:3306/monokai";
    final public static String USERNAME = "root";
    final public static String PASSWORD = "password";
    public static JPanel toDoPanel;
    public static JPanel kanbanPanel;
    public static LogIn loginPage = new LogIn();
    public static JPanel loginPanel = loginPage;

    public static Home homePage = new Home();
    public static JPanel homePanel = homePage;

    public static Project projectsPage = new Project();
    public static JPanel projectsPanel = projectsPage;

    public static CodingSpace editorPanel = new CodingSpace();
    public static JInternalFrame editorPage = editorPanel;

    public static ToDoDocsAll allToDoDocumentsPage = new ToDoDocsAll();
    public static JPanel allToDoDocumentsPanel = allToDoDocumentsPage;

    public static AnalyticsDisplay analyticsPage = new AnalyticsDisplay();
    public static JPanel analyticsPanel = analyticsPage;

    public static GanttSource ganttChartPage = new GanttSource("Monokai");
    public static JPanel ganttChartPanel = ganttChartPage;

    public static JDesktopPane monokaiDesktopApp;
    public void runApp(){

        Time.initTime();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit the program?", "Exit Program Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        monokaiDesktopApp = new JDesktopPane();
        JInternalFrame ToolFrame = new JInternalFrame();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(ToolFrame, BorderLayout.NORTH);

        monokaiDesktopApp.setLayout(new GridLayout());

        contentPane.add(monokaiDesktopApp, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        SignUp signUpPage = new SignUp();
        JPanel signUpPanel = signUpPage;

        if(signUpPage.checkIfAnyUserExists()){
            monokaiDesktopApp.add(loginPage);

            loginPage.signUpBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "This App can only be used by a single user!");
                }
            });
        }else{
            monokaiDesktopApp.add(signUpPanel);
            signUpPage.redirectLoginBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    monokaiDesktopApp.remove(signUpPanel);
                    monokaiDesktopApp.repaint();
                    monokaiDesktopApp.revalidate();
                    monokaiDesktopApp.setVisible(true);
                    monokaiDesktopApp.add(loginPage);
                }
            });

            loginPage.signUpBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(!signUpPage.checkIfAnyUserExists()) {
                        monokaiDesktopApp.remove(loginPage);
                        monokaiDesktopApp.repaint();
                        monokaiDesktopApp.revalidate();
                        monokaiDesktopApp.setVisible(true);
                        monokaiDesktopApp.add(signUpPage);
                    }else{
                        JOptionPane.showMessageDialog(null, "This App can only be used by a single user!");
                    }
                }
            });
        }

        loginPage.btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(loginPage.loginUser()){
                    JOptionPane.showMessageDialog(monokaiDesktopApp, "You've been logged in!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    monokaiDesktopApp.remove(loginPanel);
                    monokaiDesktopApp.repaint();
                    monokaiDesktopApp.revalidate();
                    monokaiDesktopApp.setVisible(true);
                    monokaiDesktopApp.add(homePanel);
                }
            }
        });

        homePage.homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(homePanel);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(projectsPanel);
            }
        });

        projectsPage.editorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(projectsPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(editorPage);
            }
        });

        editorPanel.projectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(editorPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(projectsPanel);
            }
        });

        projectsPage.ganttBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(projectsPanel);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(ganttChartPanel);
            }
        });

        ganttChartPage.backToProjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(ganttChartPanel);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(projectsPanel);
            }
        });

        projectsPage.toDoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(projectsPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(allToDoDocumentsPanel);
            }
        });

        kanbanPanel = projectsPage.allProj;
        toDoPanel = allToDoDocumentsPage.AllDocPanel;

        allToDoDocumentsPage.projectRedirectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(allToDoDocumentsPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(projectsPanel);
            }
        });

        projectsPage.analyticsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(projectsPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                analyticsPage.returnTime();
                monokaiDesktopApp.add(analyticsPanel);
            }
        });

        analyticsPage.projectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(analyticsPanel);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                monokaiDesktopApp.add(projectsPanel);
            }
        });

        projectsPage.logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monokaiDesktopApp.remove(projectsPage);
                monokaiDesktopApp.repaint();
                monokaiDesktopApp.revalidate();
                monokaiDesktopApp.setVisible(true);
                analyticsPage.returnTime();

                loginPage.setDefault();
                monokaiDesktopApp.add(loginPanel);
            }
        });

        projectsPage.reminderBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Reminder reminder = new Reminder();
                projectsPage.addProjectBtn.setVisible(false);
                projectsPage.jLabel1.setText("Home > Reminders");
                projectsPage.projectsBtn.setEnabled(true);
                projectsPage.allProj.removeAll();
                projectsPage.allProj.repaint();
                projectsPage.allProj.revalidate();
                projectsPage.allProj.add(reminder.returnReminders());

                projectsPage.projectsBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        projectsPage.addProjectBtn.setVisible(true);
                        projectsPage.jLabel1.setText("Home > Projects");
                        projectsPage.projectsBtn.setEnabled(false);
                        projectsPage.initProjs();
                        monokaiDesktopApp.removeAll();
                        monokaiDesktopApp.repaint();
                        monokaiDesktopApp.revalidate();
                        monokaiDesktopApp.add(projectsPanel);
                    }
                });
            }
        });
        setVisible(true);
    }

    Application(){
        runApp();
    }

    public static void main(String args[]){

        InitializerCard initCard = new InitializerCard();
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        initCard.dispose();

        Application app = new Application();
    }
}
