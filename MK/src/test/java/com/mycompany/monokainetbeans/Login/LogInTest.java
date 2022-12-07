package com.mycompany.monokainetbeans.Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class LogInTest extends JFrame{

        @ParameterizedTest
        @CsvSource({"a@.com,a"})
        public void testTrueLogin(String e, String p) {

            LogIn myL = new LogIn();
            JPanel log = myL;

            myL.setDefault();
            myL.tfEmail.setText(e);
            myL.pfPassword.setText(p);

            try {
                Assertions.assertEquals(true, myL.loginUser());
            }
            catch (Exception ev){}
        }

    @ParameterizedTest
    @CsvSource({"withoutAtSign.com,wrongpass", "khanizza@gmail.com,wrongpass", "wrongEmail@.com,pass", ",",
            "khanizza@gmail.com,", ",pass" })
    public void testFalseLogin(String e, String p) {

        LogIn myL = new LogIn();
        JPanel log = myL;

        myL.setDefault();
        myL.tfEmail.setText(e);
        myL.pfPassword.setText(p);

        try {
            Assertions.assertEquals(false, myL.executeLogin(e, p));
        }
        catch (Exception ev){}
    }

}


