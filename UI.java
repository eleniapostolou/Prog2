package mysteryLab;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mysteryLab.EscapeRoom2.ChoiceHandler;


public class UI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, choiceButtonPanel, welcomePanel;
	JLabel titleNameLabel;
	JButton startButton, b1, b2, b3, b4;
	JTextArea welcomeText;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	
	public void createUI(ChoiceHandler cHandler) {
		
		window = new JFrame();
		window.setSize(1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.magenta);
		window.setLayout(null);
		window.setResizable(false);
		
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(120, 120, 750, 450);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ESCAPE THE MYTH");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(350, 400, 325, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButtonPanel.add(startButton);
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(120, 120, 750, 450);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(2,2));
		window.add(choiceButtonPanel);
		
		
		b1 = new JButton("Κίρκη");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(normalFont);
		b1.setFocusPainted(false);
		b1.addActionListener(cHandler);
		choiceButtonPanel.add(b1);
		b2 = new JButton("Θησέας");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(normalFont);
		b2.setFocusPainted(false);
		b2.addActionListener(cHandler);
		choiceButtonPanel.add(b2);
		b3 = new JButton("Περσεφόνη");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setFont(normalFont);
		b3.setFocusPainted(false);
		b3.addActionListener(cHandler);
		choiceButtonPanel.add(b3);
		b4 = new JButton("Ίκαρος");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setFont(normalFont);
		b4.setFocusPainted(false);
		b4.addActionListener(cHandler);
		choiceButtonPanel.add(b4);
		
		welcomePanel = new JPanel();
		welcomePanel.setBounds(120, 120, 750, 450);
		welcomePanel.setBackground(Color.black);
		welcomeText = new JTextArea("Καλωσόρισες στο δωμάτιο. \n Στόχος σου είναι να "
				+ "δραπετεύσεις ξεπερνώντας τρεις δοκιμασίες. \n Στην αρχή κάθε δοκιμασίας θα σου δίνονται οδηγίες. \n"
				+ "Έχεις 20 λεπτά για να δραπετεύσεις!");
		welcomeText.setBounds(120, 120, 750, 450);
		welcomeText.setBackground(Color.black);
		welcomeText.setForeground(Color.white);
		welcomeText.setFont(normalFont);
		welcomeText.setLineWrap(true);
		welcomeText.setWrapStyleWord(true);
		welcomeText.setEditable(false);
		welcomePanel.add(welcomeText);
		window.add(welcomePanel);
		
		
		
		
	
		window.setVisible(true);
	}

		



}
