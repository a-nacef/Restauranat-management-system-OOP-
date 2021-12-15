package com.company;

import javax.swing.*;
import java.awt.*;
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
    private JTextArea textField1;
    private JTextArea textField2;
    private JButton calculerButton;
    private JTextArea textField3;
    private JTextArea textField4;
    private JTextArea resultatTextField;

    public MainForm(){
        Font font = new Font("Verdana", Font.BOLD, 12);
        setContentPane(MainPanel);
        setVisible(true);
        setSize(800,800);
        setTitle("Restaurant Management System");
        manageCommandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setFont(font);
                SubPanel.setSelectedIndex(1);
                if(textArea2.getText().equals("")) {
                    for (Commande c : Gestionnaire.Liste_Commandes.values()) {
                        textArea2.append(c.toString() + "\n");
                        textArea2.append("\n------------------------------------------------\n");
                    }
                }
            }
        });
        managePlatesButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setFont(font);
                SubPanel.setSelectedIndex(0);
                if(textArea1.getText().equals("")) {
                    for (Plat p : Gestionnaire.liste_plat) {
                        textArea1.append(p.toString());
                        textArea1.append("\n---------------------------------------------------\n");
                    }
                }
            }
        });
        showDailyStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setFont(font);
                resultatTextField.setFont(font);
                SubPanel.setSelectedIndex(2);
                if(textField1.getText().equals("") && textField2.getText().equals("")) {
                    textField1.append(Gestionnaire.plat_pref().toString());
                    textField2.append((String.valueOf(Gestionnaire.affiche_recette())));
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(textField3.getText().equals("") || textField4.getText().equals(""))){
                    resultatTextField.append(String.valueOf(Gestionnaire.affiche_recette_dans_periode(textField3.getText(), textField4.getText())));
                }
            }
        });
    }
}
