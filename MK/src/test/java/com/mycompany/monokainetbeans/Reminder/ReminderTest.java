/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.monokainetbeans.Reminder;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Mr Rabbani
 */
public class ReminderTest {

    private static Reminder reminder;

    public ReminderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        reminder = new Reminder();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUpdateTask() {
        int expectedResult = 1;
        int taskID = 1;
        String taskName = "OOP Evaluation";
        Date date = Date.valueOf((LocalDate.now().toString()));
        Time time = Time.valueOf(LocalTime.now().toString());
        int repeat = 0;

        int result = reminder.updateTask(taskID, taskName, time, date, repeat);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetNewReminder() {
        int newRows = 1;
        assertEquals(newRows, reminder.setNewReminder("New Task", Time.valueOf(LocalTime.now().toString()),
                Date.valueOf(LocalDate.now().toString()), 0));
    }

    @Test
    public void testConnectDB() {
        assertTrue(
                reminder.connectDB());
    }

}
