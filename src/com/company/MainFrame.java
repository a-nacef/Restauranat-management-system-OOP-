package com.company;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JButton showDailyStatsButton;
    private JButton manageCommandsButton;
    private JButton quitButton;

    private JPanel MainPanel;
    private JPanel PlatePanel;
    private JPanel StatsPanel;
    private  JPanel CommandsPanel;



    public MainFrame(){
        setContentPane(MainPanel);
        setTitle("Welcome.");
        setSize(450,300);
        setVisible(true);
    }

}
