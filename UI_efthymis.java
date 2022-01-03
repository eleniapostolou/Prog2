package elenhs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;






import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import elenhs.EscapeRoom2.ChoiceHandler;
import elenhs.Gallows.InputHandler;


public class UI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, choiceButtonPanel, welcomePanel,inputPanel,MtPanel;
	JLabel titleNameLabel;
	JButton startButton, b1, b2, b3, b4,enterB;
	JTextArea welcomeText, mainTextArea;
	JTextField jtf ;
	Container con ;
	Gallows g;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	private JButton wb;
	AbstractButton cb;
	
	public void createUI(ChoiceHandler cHandler) {
		
		window = new JFrame();
		window.setSize(1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.magenta);
		window.setLayout(null);
		window.setResizable(false);
		con = window.getContentPane();
		
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
		startButton.setActionCommand("start");
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
		b1.setActionCommand("c1");
		choiceButtonPanel.add(b1);
		
		b2 = new JButton("Θησέας");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(normalFont);
		b2.setFocusPainted(false);
		b2.addActionListener(cHandler);
		b2.setActionCommand("c2");
		choiceButtonPanel.add(b2);
		
		b3 = new JButton("Περσεφόνη");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setFont(normalFont);
		b3.setFocusPainted(false);
		b3.addActionListener(cHandler);
		b3.setActionCommand("c3");
		choiceButtonPanel.add(b3);
		
		b4 = new JButton("Ίκαρος");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setFont(normalFont);
		b4.setFocusPainted(false);
		b4.addActionListener(cHandler);
		b4.setActionCommand("");
		choiceButtonPanel.add(b4);
		
		welcomePanel = new JPanel();
		welcomePanel.setBounds(120, 120, 750, 450);
		welcomePanel.setBackground(Color.black);
		welcomeText = new JTextArea("Καλωσόρισες στο δωμάτιο. \n Στόχος σου είναι να "
				+ "δραπετεύσεις ξεπερνώντας 4 δοκιμασίες. \n Στην αρχή κάθε δοκιμασίας θα σου δίνονται οδηγίες. \n"
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
		con.add(welcomePanel);
		
		wb = new JButton("CONTINUE");
		wb.setBackground(Color.black);
		wb.setForeground(Color.white);
		wb.setFont(normalFont);
		wb.setFocusPainted(false);
		wb.addActionListener(cHandler);
		wb.setActionCommand("wb");
		welcomePanel.add(wb);

		
		inputPanel = new JPanel();
		inputPanel.setBounds(250,650,500,50);
		inputPanel.setBackground(Color.black);
		inputPanel.setLayout(new GridLayout(1,2));
		
		jtf = new JTextField();
		inputPanel.add(jtf);
		
		enterB = new JButton ("ENTER");
		enterB.setForeground(Color.black);
		enterB.addActionListener(cHandler);
		enterB.setActionCommand("in");
		inputPanel.add(enterB);
		con.add(inputPanel);
		
		MtPanel = new JPanel();
		MtPanel.setBounds(90, 50, 800, 650);
		MtPanel.setBackground(Color.black);
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(120, 120, 750, 450);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		MtPanel.add(mainTextArea);
		
		cb = new JButton("CONTINUE");
		cb.setBackground(Color.black);
		cb.setForeground(Color.white);
		cb.setFont(normalFont);
		cb.setFocusPainted(false);
		cb.addActionListener(cHandler);
		cb.setActionCommand("wb");
		MtPanel.add(cb);
		cb.setVisible(false);
		
		
		window.add(MtPanel);
		con.add(MtPanel);
		
		
	
		window.setVisible(true);
	}

		



}
