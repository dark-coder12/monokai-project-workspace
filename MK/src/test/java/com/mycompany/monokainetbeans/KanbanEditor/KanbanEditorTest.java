package com.mycompany.monokainetbeans.KanbanEditor;

import com.mycompany.monokainetbeans.Login.LogIn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

import static com.mycompany.monokainetbeans.Application.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class KanbanEditorTest extends JFrame{

    KanbanEditor kanbanEd = new KanbanEditor();

        @ParameterizedTest
        @CsvSource({"1,TestTask699,1,Chess", "2,TestTask79,2,Chess"})
        public void testKanbanAddExistingProject(int col, String name, int prior, String projectName) {

            boolean taskAdded =  kanbanEd.addKanbanTask(col, name, prior, projectName);
            Assertions.assertEquals(true, taskAdded);
        }

    @ParameterizedTest
    @CsvSource({"1,TestTask,1,Chess1", "2,TestTask2,2,Chess1"})
    public void testKanbanAddNonExistingProject(int col, String name, int prior, String projectName) {

        boolean taskAdded =  kanbanEd.addKanbanTask(col, name, prior, projectName);
        Assertions.assertNotEquals(true, taskAdded);
    }

    @Test
    public void testKanbanDonePanelInitialization() {

        int doneCount = 0;
        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from kanbaneditor where columnID = 3 and projectName = 'Chess'";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            rs.next();
            doneCount = rs.getInt(1);

            String sql2 = "select * from kanbaneditor where columnID = 3 and projectName = 'Chess'";

            Statement st2 = con.createStatement();

            ResultSet rs2 = st2.executeQuery(sql2);

            rs2.next();

            kanbanEd.currProject = "Chess";
            kanbanEd.initializeBoard();

            boolean correctKanban = true;

            for(Component done : kanbanEd.donePanel.getComponents()){

                if(done instanceof JPanel){

                    if(!done.getName().equals(rs2.getString(2))){
                        correctKanban = false;
                    }
                }
                rs2.next();
            }
            Assertions.assertEquals(true, correctKanban);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testKanbanInProgressPanelInitialization() {

        int doneCount = 0;
        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from kanbaneditor where columnID = 1 and projectName = 'Chess'";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            rs.next();
            doneCount = rs.getInt(1);

            String sql2 = "select * from kanbaneditor where columnID = 1 and projectName = 'Chess'";

            Statement st2 = con.createStatement();

            ResultSet rs2 = st2.executeQuery(sql2);

            rs2.next();

            kanbanEd.currProject = "Chess";
            kanbanEd.initializeBoard();

            boolean correctKanban = true;

            for(Component done : kanbanEd.inProgPanel.getComponents()){

                if(done instanceof JPanel){

                    if(!done.getName().equals(rs2.getString(2))){
                        correctKanban = false;
                    }
                }
                rs2.next();
            }
            Assertions.assertEquals(true, correctKanban);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testKanbanToDoPanelInitialization() {

        int doneCount = 0;
        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from kanbaneditor where columnID = 2 and projectName = 'Chess'";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            rs.next();
            doneCount = rs.getInt(1);

            String sql2 = "select * from kanbaneditor where columnID = 2 and projectName = 'Chess'";

            Statement st2 = con.createStatement();

            ResultSet rs2 = st2.executeQuery(sql2);

            rs2.next();

            kanbanEd.currProject = "Chess";
            kanbanEd.initializeBoard();

            boolean correctKanban = true;

            for(Component done : kanbanEd.toDoPanel.getComponents()){

                if(done instanceof JPanel){

                    if(!done.getName().equals(rs2.getString(2))){
                        correctKanban = false;
                    }
                }
                rs2.next();
            }
            Assertions.assertEquals(true, correctKanban);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTaskInit() {

            Task myKanbanTask = new Task();
            myKanbanTask.addValues("new task", "Low");
            Assertions.assertEquals(0, myKanbanTask.priority.compareTo(Priority.LOW));

    }
}