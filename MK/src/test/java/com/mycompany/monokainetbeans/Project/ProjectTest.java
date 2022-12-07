package com.mycompany.monokainetbeans.Project;

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

@RunWith(Parameterized.class)
class ProjectTest extends JFrame {

    Project projectPage = new Project();

    @Test
    public void projectInitialization() {

        try{
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql2 = "select * from project";

            Statement st2 = con.createStatement();

            ResultSet rs2 = st2.executeQuery(sql2);

            rs2.next();

            projectPage.initProjs();

            boolean projectsFound = true;

            for(Component c : projectPage.allProj.getComponents()){

                if(c instanceof JPanel){

                    if(!c.getName().equals(rs2.getString("name"))){
                        projectsFound = false;
                    }
                    rs2.next();
                }
            }

            Assertions.assertEquals(true, projectsFound);

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }
}


