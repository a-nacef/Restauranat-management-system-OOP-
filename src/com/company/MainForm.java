package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel MainPanel;
    private JButton quitButton;
    private JTabbedPane SubPanel;
    private JPanel Plates;
    private JPanel Commands;
    private JPanel DailyStats;
    private JButton manageCommandsButton;
    private JButton managePlatesButton2;
    private JButton showDailyStatsButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calculerButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField resultatTextField;


    public MainForm(){
        setContentPane(MainPanel);
        setVisible(true);
        setSize(800,800);
        setTitle("Restaurant Management System");
        manageCommandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(1);
            }
        });
        managePlatesButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(0);
            }
        });
        showDailyStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(2);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
