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
    private JTextArea textField1;
    private JTextArea textField2;
    private JButton calculerButton;
    private JTextArea textField3;
    private JTextArea textField4;
    private JTextArea resultatTextField;


    public MainForm(){
        setContentPane(MainPanel);
        setVisible(true);
        setSize(800,800);
        setTitle("Restaurant Management System");
        manageCommandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(1);
                for(Commande c: Gestionnaire.Liste_Commandes.values()) {
                    textArea2.append(c.toString()+"\n");
                    textArea2.append("------------------------------------------------");
                }
            }
        });
        managePlatesButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(0);
                for (Plat p : Gestionnaire.liste_plat) {

                    textArea1.append(p.toString());
                    textArea1.append("---------------------------------------------------");
                }
            }
        });
        showDailyStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubPanel.setSelectedIndex(2);
                textField1.append( Gestionnaire.plat_pref().toString());
                textField2.append((String.valueOf(Gestionnaire.affiche_recette())));
                resultatTextField.append(getWarningString().valueOf(Gestionnaire.affiche_recette_dans_periode(textField3.getText(), textField4.getText())));
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
