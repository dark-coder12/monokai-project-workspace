
package com.mycompany.monokainetbeans.CodeSpace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class CodingSpace extends javax.swing.JInternalFrame {

    boolean changes = false;
    int tabSpace = 0;
    String openedName;
    File chosenFile;
    boolean fileOpened = false;
    public CodingSpace() {
        
        initComponents();
        
        JMenuBar nav = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu colorMenu = new JMenu("Themes");

        JMenuItem newFile = new JMenuItem("New File");
        JMenuItem openFile = new JMenuItem("Open File");
        JMenuItem saveFile = new JMenuItem("Save File");

        JMenuItem openPalette = new JMenuItem("Palette");
        JMenuItem monokaiTheme = new JMenuItem("Monokai");
        JMenuItem solarizedDark = new JMenuItem("Solarized Dark");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        colorMenu.add(openPalette);
        colorMenu.add(monokaiTheme);
        colorMenu.add(solarizedDark);

        nav.add(fileMenu);
        nav.add(colorMenu);

        setJMenuBar(nav);
    
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
    TextLineNumber tln = new TextLineNumber(codingArea);

    jScrollPane1.setRowHeaderView( tln );

        setVisible(true);
  
        tabOption.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                tabSpace = Integer.parseInt(tabOption.getSelectedItem().toString());
            }
        });
        
       newFile.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        
         if(changes == true){

        if (JOptionPane.showConfirmDialog(jScrollPane1, 
            "Are you sure you want to close this window without saving?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            codingArea.setText("");
        }
        else{
            JFileChooser saveCmd;
           
                if (fileOpened == true) {
                    
                    saveCmd = new JFileChooser(chosenFile.getAbsolutePath());
                    
                    saveCmd.setSelectedFile(new File(openedName));
                    
                } else
                    saveCmd = new JFileChooser("f:");

                int dialog = saveCmd.showSaveDialog(null);

                if (dialog == JFileChooser.APPROVE_OPTION) {

                    File saveFile = new File(saveCmd.getSelectedFile().getAbsolutePath());

                    try {
                        
                        FileWriter w = new FileWriter(saveFile);
                        
                        BufferedWriter writeBuff = new BufferedWriter(w);

                        writeBuff.write(codingArea.getText());
                        
                        writeBuff.close();
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File could not be saved");
                    }
                }
        }
        changes = false;
         }
         else
               codingArea.setText("");
    }
});
        
        codingArea.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            
            changes = true;
         
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
              
              if(tabSpace == 2){
                codingArea.append("  ");
              }
              else if(tabSpace == 4){
                  codingArea.append("    ");
              }
              else if(tabSpace == 4){
                  codingArea.append("      ");
              }
        }     
       }
    });
      

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser openFCmd = new JFileChooser("f:");
                
                int dialog = openFCmd.showOpenDialog(null);

                if (dialog == JFileChooser.APPROVE_OPTION) {

                    fileOpened = true;
                    chosenFile = new File(openFCmd.getSelectedFile().getAbsolutePath());
                    openedName = openFCmd.getSelectedFile().getName();

                    try {

                        String reader;

                        FileReader fr = new FileReader(chosenFile);
                        BufferedReader br = new BufferedReader(fr);

                        String currText = "";

                        reader = br.readLine();

                        while (reader != null) {

                            currText = currText + " \n" + reader;
                            reader = br.readLine();
                        }

                        codingArea.setText(currText);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File could not be opened");
                    }
                }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changes = false;
                JFileChooser saveCmd;

                if (fileOpened == true) {
                    saveCmd = new JFileChooser(chosenFile.getAbsolutePath());
                    saveCmd.setSelectedFile(new File(openedName));
                } else
                    saveCmd = new JFileChooser("f:");

                int dialog = saveCmd.showSaveDialog(null);

                if (dialog == JFileChooser.APPROVE_OPTION) {

                    File saveFile = new File(saveCmd.getSelectedFile().getAbsolutePath());

                    try {
                        FileWriter w = new FileWriter(saveFile);
                        BufferedWriter writeBuff = new BufferedWriter(w);

                        writeBuff.write(codingArea.getText());
                        writeBuff.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File could not be saved");
                    }
                }
            }
        });

        monokaiTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                codingArea.setBackground(Color.decode("#403d3d"));
                codingArea.setForeground(Color.decode("#A6E22E"));
                codingArea.setFont(new Font("JetBrains Mono", Font.ITALIC, 14));

            }
        });

        solarizedDark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codingArea.setBackground(Color.decode("#002b36"));
                codingArea.setForeground(Color.decode("#A6E22E"));
                codingArea.setFont(new Font("JetBrains Mono", Font.ITALIC, 14));

            }
        });

        openPalette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ColorPicker codeThemes = new ColorPicker(null);
                codeThemes.chosenColor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        codingArea.setBackground(codeThemes.colorPicker.getColor());

                        Color c = codeThemes.colorPicker.getColor();

                        if ((c.getRed()*0.299 + c.getGreen()*0.587 + c.getBlue()*0.114) > 186){

                            codingArea.setForeground(Color.black);
                        }else{
                            codingArea.setForeground(Color.white);
                        }

                        codeThemes.dispose();
                    }
                });
            }
        });

        projectBtn.setBorderPainted(false);
        projectBtn.setContentAreaFilled(false);
        projectBtn.setFocusable(false);
        projectBtn.setForeground(Color.WHITE);
        
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
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        projectBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        langOption = new javax.swing.JComboBox<>();
        tabOption = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        codingArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Code Editor");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        projectBtn.setText("Projects");

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Code Space");

        langOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C++", "Java" }));

        tabOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "6" }));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home > Editor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(tabOption, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(langOption, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(projectBtn)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(langOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(projectBtn))
                .addGap(6, 6, 6))
        );

        codingArea.setColumns(20);
        codingArea.setRows(5);
        jScrollPane1.setViewportView(codingArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea codingArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> langOption;
    public javax.swing.JButton projectBtn;
    private javax.swing.JComboBox<String> tabOption;
    // End of variables declaration//GEN-END:variables
}
