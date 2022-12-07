package com.mycompany.monokainetbeans.Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.mycompany.monokainetbeans.Application.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class AddProjectTest extends JFrame{

    @ParameterizedTest
    @CsvSource({"testProj,somecode,C++,4", "testProj2,somecode2,Java,3"})
    public void testTrueProjects(String n, String c, String l, int p) {

        AddProject newProject = new AddProject();

        newProject.projectName.setText(n);
        newProject.codeTxt.setText(c);

        if(l.equals("Java"))
        newProject.language.setSelectedIndex(0);
        else newProject.language.setSelectedIndex(1);

        newProject.progress.setSelectedIndex(p);

        Assertions.assertEquals(true, newProject.addProject());
    }

    @ParameterizedTest
    @CsvSource({",somecode,C++,4", "testProj3,,Java,1"})
    public void testFalseProjects(String n, String c, String l, int p) {

        AddProject newProject = new AddProject();

        newProject.projectName.setText(n);
        newProject.codeTxt.setText(c);

        if(l.equals("Java"))
            newProject.language.setSelectedIndex(0);
        else newProject.language.setSelectedIndex(1);

        newProject.progress.setSelectedIndex(p);

        newProject.addProject();
        newProject.getApplyButton().doClick();

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "select * from project";

            PreparedStatement ptst = con.prepareStatement(sql);

            ResultSet rs = ptst.executeQuery();

            boolean wrongProjectAdded = false;

            while(rs.next()){
                if(rs.getString("name").equals(n)){

                    wrongProjectAdded = true;
                }
            }

            Assertions.assertEquals(false, wrongProjectAdded);
        }catch(Exception e){

        }
    }
}


