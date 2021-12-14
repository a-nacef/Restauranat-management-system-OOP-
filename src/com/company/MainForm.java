package com.company;

import javax.swing.*;

public class MainForm extends JFrame {
    private JPanel MainPanel;
    private JButton quitButton;
    private JTabbedPane tabbedPane1;
    private JPanel Plates;
    private JPanel Commands;
    private JPanel DailyStats;
    private JButton manageCommandsButton;
    private JButton managePlatesButton2;
    private JButton showDailyStatsButton;


    public MainForm(){
        setContentPane(MainPanel);
        setVisible(true);
        setSize(800,800);
    }
}
