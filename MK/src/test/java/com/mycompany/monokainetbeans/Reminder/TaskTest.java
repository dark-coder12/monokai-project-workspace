/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.monokainetbeans.Reminder;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Mr Rabbani
 */
public class TaskTest {

    private static Task task;

    public TaskTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        task = new Task();
    }

    @AfterClass
    public static void tearDownClass() {
        task = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of completeTask method, of class Task.
     */
    @Test
    public void testCompleteTask() {
        System.out.println("completeTask");
        Task instance = new Task();
        instance.completeTask();

    }

    @Test
    public void testConnectDB() {
        assertTrue(task.connectDB());
    }

}
