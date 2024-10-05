/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class myGame extends JFrame implements ActionListener{
    
    JLabel heading,clockLable;
    Font font = new Font("", Font.BOLD,40);
    JPanel mainPanel;
    
    JButton []btns = new JButton[9];
    //GAME INSTANCE VARIABLE..
    int gameChances[] = {2,2,2,2,2,2,2,2,2};
    int activePlayer = 0;
    
    public myGame() {
        System.out.println("Constructor is created and working properly");
        setTitle("My Game");
        setSize(850,850);
        ImageIcon icon = new ImageIcon("src/img/logo.png");
        setIconImage(icon.getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }
        private void createGUI() {
            
            this.getContentPane().setBackground(Color.decode("#00ff7f"));
            this.setLayout(new BorderLayout());
            
             // NORTH HEADING/....
            
            heading = new JLabel("Tic Tac Toe");
            heading.setIcon(new ImageIcon("src/img/tG.png"));
            
            heading.setFont(font);
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setHorizontalTextPosition(SwingConstants.CENTER);
            heading.setVerticalTextPosition(SwingConstants.BOTTOM);
            heading.setForeground(Color.white);
           this.add(heading, BorderLayout.NORTH);
            
            
            // CREATING OBJECT OF JLABEL FOR CLOCK/...
            
            clockLable = new JLabel("Clock");
            clockLable.setFont(font);                                                     
            clockLable.setHorizontalAlignment(SwingConstants.CENTER);
            clockLable.setForeground(Color.white);
            this.add(clockLable,BorderLayout.SOUTH);
            
            Thread t;
        t = new Thread () {
            public void run() {
                try {
                    while (true){
                        String datetime = new Date(). toLocaleString();
                        clockLable.setText(datetime);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        t.start();
        
        
        /////MAIN PANEL SECTION...///
        
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new GridLayout(3,3));
        
            for (int i = 1; i < 10; i++) {
                JButton btn = new JButton();
                btn.setBackground(Color.decode("#c9f2dc"));
               // btn.setIcon(new ImageIcon("src/img/R.png"));
                btn.setFont(font);
                mainPanel.add(btn);
                btns [i-1] = btn;
                btn.addActionListener(this);
                btn.setName(String.valueOf(i-1));
            }
            this.add(mainPanel,BorderLayout.CENTER);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton)e.getSource();
        
        String nameStr = currentButton.getName();
        
        int name = Integer.parseInt(nameStr.trim());
        
        if (gameChances[name] == 2) {
            if (activePlayer == 1) {
                currentButton.setIcon(new ImageIcon("src/img/R.png"));
                gameChances[name] = activePlayer;
                activePlayer = 0;
            } else {
                currentButton.setIcon(new ImageIcon("src/img/O.png"));
                gameChances[name] = activePlayer;
                activePlayer = 1;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Position already occupied");
        }
    }
    
}
    
