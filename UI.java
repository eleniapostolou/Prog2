package mysteryLab;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mysteryLab.EscapeRoom2.ChoiceHandler;

public class UI {
	
	//the creation of the variables that are used
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, choiceButtonPanel, welcomePanel, inputPanel, MtPanel, timePanel;
	JLabel titleNameLabel, timeLabel;
	JButton startButton, b1, b2, b3, b4, enterB, gob;
	JTextArea welcomeText, mainTextArea;
	JTextField jtf;
	Container con;
	Gallows g;
	Font titleFont = new Font("Century Gothic", Font.PLAIN, 80); 
	Font normalFont = new Font("Century Gothic", Font.PLAIN, 30);
	Font miniGameFont = new Font("Century Gothic", Font.PLAIN, 22);
	Font biggerFont = new Font("Century Gothic", Font.PLAIN, 40);
	private JButton wb;
	AbstractButton cb;
	JButton gwB;
	private JPanel picturePanel;
	private JLabel pictureLabel;
	private ImageIcon image;
	
	public void createUI(ChoiceHandler cHandler)  { 
		
		//a new window is created for the game 
		window = new JFrame();
		window.setSize(1000, 750);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.magenta);
		window.setLayout(null);
		window.setResizable(false);
		con = window.getContentPane();
		
		//this panel is made to show the game's title
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(120, 120, 750, 450);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("\nESCAPE THE MYTH");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		//creating the "start" button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(330, 400, 325, 100);
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
		
		//four buttons are created to allow the player to enter the room of his choice
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(120, 120, 750, 450);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(2, 2));
		window.add(choiceButtonPanel);
		
		b1 = new JButton("ΚΙΡΚΗ");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(normalFont);
		b1.setFocusPainted(false);
		b1.addActionListener(cHandler);
		b1.setActionCommand("c1");
		choiceButtonPanel.add(b1);
		
		b2 = new JButton("ΘΗΣΕΑΣ");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(normalFont);
		b2.setFocusPainted(false);
		b2.addActionListener(cHandler);
		b2.setActionCommand("c2");
		choiceButtonPanel.add(b2);
		
		b3 = new JButton("ΠΕΡΣΕΦΟΝΗ");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setFont(normalFont);
		b3.setFocusPainted(false);
		b3.addActionListener(cHandler);
		b3.setActionCommand("c3");
		choiceButtonPanel.add(b3);
		
		b4 = new JButton("ΙΚΑΡΟΣ");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setFont(normalFont);
		b4.setFocusPainted(false);
		b4.addActionListener(cHandler);
		b4.setActionCommand("c4");
		choiceButtonPanel.add(b4);
		
		//it's the beginning of the game, general instructions of the game are given
		welcomePanel = new JPanel();
		welcomePanel.setBounds(120, 120, 750, 450);
		welcomePanel.setBackground(Color.black);
		welcomeText = new JTextArea("Καλωσόρισες στο δωμάτιο. \n Στόχος σου είναι να "
				+ "δραπετεύσεις περνώντας 4 δοκιμασίες.\n Στην αρχή κάθε δοκιμασίας θα σου δίνονται οδηγίες.\n"
				+ "Έχεις 45 λεπτά για να δραπετεύσεις!");
		welcomeText.setBounds(120, 120, 750, 450);
		welcomeText.setBackground(Color.black);
		welcomeText.setForeground(Color.white);
		welcomeText.setFont(miniGameFont);
		welcomeText.setLineWrap(true);
		welcomeText.setWrapStyleWord(true);
		welcomeText.setEditable(false);
		welcomePanel.add(welcomeText);
		window.add(welcomePanel);
		con.add(welcomePanel);
		
		//the "continue" button is activated in order to proceed the game
		wb = new JButton("CONTINUE");
		wb.setBackground(Color.black);
		wb.setForeground(Color.white);
		wb.setFont(normalFont);
		wb.setFocusPainted(false);
		wb.addActionListener(cHandler);
		wb.setActionCommand("wb");
		welcomePanel.add(wb);

		//each game starts here
		inputPanel = new JPanel();
		inputPanel.setBounds(250, 625, 500, 50); 
		inputPanel.setBackground(Color.black);
		inputPanel.setLayout(new GridLayout(1, 2));
		
		jtf = new JTextField();
		jtf.setFont(miniGameFont);
		inputPanel.add(jtf);
		
		//the "enter" button is activated in order for the player to submit the answer
		enterB = new JButton ("ENTER");
		enterB.setBackground(Color.black);
		enterB.setForeground(Color.white);
		enterB.setFont(normalFont);
		enterB.addActionListener(cHandler);
		enterB.setActionCommand("in");
		inputPanel.add(enterB);
		con.add(inputPanel);
		
		//the text area is created in order for the player to write down the answer
		MtPanel = new JPanel();
		MtPanel.setBounds(90, 50, 800, 650);
		MtPanel.setBackground(Color.black);
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(120, 120, 750, 450);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(miniGameFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		MtPanel.add(mainTextArea);
		
		//the "continue" button is activated in order to proceed to the next level
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
		
		//this panel is made to show the count down 
		timePanel = new JPanel();
		timePanel.setBounds(330, 5, 300, 40);
		timePanel.setBackground(Color.black);
		timeLabel = new JLabel();
		timeLabel.setForeground(Color.white);
		timeLabel.setFont(miniGameFont);
		timePanel.add(timeLabel);
		window.add(timePanel);
		con.add(timePanel);
		
		//at the end of the game, this button restarts the game if the player wishes to play again
		gob = new JButton("PLAY AGAIN");
		gob.setBackground(Color.black);
		gob.setForeground(Color.white);
		gob.setFont(normalFont);
		gob.setFocusPainted(false);
		gob.addActionListener(cHandler);
		gob.setActionCommand("start");
		MtPanel.add(gob);
		
		//this button is activated for the second game in order to show more information to the player to find the answer
		gwB = new JButton ("TAKE A HINT");
		gwB.setBackground(Color.black);
		gwB.setForeground(Color.white);
		gwB.setFont(normalFont);
		gwB.addActionListener(cHandler);
		gwB.setActionCommand("gwB");
		MtPanel.add(gwB);
		gwB.setVisible(false);
		
		//the background image is loaded
		picturePanel = new JPanel();
		picturePanel.setBounds(0, 0, 1000, 800);
		picturePanel.setBackground(Color.black);
		con.add(picturePanel);

		pictureLabel = new JLabel();
		image = new ImageIcon(".//image//image0.png");
		pictureLabel.setIcon(image);
		picturePanel.add(pictureLabel);
	
		//all the above are visible at this point
		window.setVisible(true);
	}
}
