package com.mycompany.monokainetbeans;

import javax.swing.*;
import java.awt.*;

public class InitializerCard  extends JFrame {

    InitializerCard(){
        Container c = new Container();
        c.setLayout(new GridLayout());
        setContentPane(c);
        JPanel icon = new JPanel();
        JLabel iconLbl = new JLabel();

        ImageIcon bellIcon = new ImageIcon("C:\\Users\\Izza Mujeeb\\Desktop\\Everything\\Academic Stuff\\Semester 5\\SCD\\MK\\src\\main\\java\\com\\mycompany\\monokainetbeans\\mkLogo.jpeg");
        iconLbl.setIcon(bellIcon);
        iconLbl.setForeground(Color.black);
        iconLbl.setBackground(Color.black);
        icon.setBackground(Color.black);
        icon.setForeground(Color.black);
        setBackground(Color.black);
        setForeground(Color.black);

        icon.add(iconLbl);
        c.add(icon);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(377,252);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String [] args){

        InitializerCard monokaiInit = new InitializerCard();

    }
}
