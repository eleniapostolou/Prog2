/*EscapeRoom.java
 *Copyright 2021 mysteryLab
 */

/**
*The class EscapeRoom contains the main implementation of the game. It contains the main method
*where the game starts as well as another class called ChoiceHandler.
*
*
*@version ____
*@author ELENI APOSTOLOU, VASILIKI KARAMANOU, EFTHYMIOS KONTOES, 
*MARIOS LIAPIS FOTOU, ELENI NTOUSI, PATRA ROXANI, 
*KOSTANTINOS SPATHAS,KONSTANTINA SOTIROPOULOU
*/
package mysteryLab;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mysteryLab.Gallows;
import mysteryLab.TransitionManager;
import mysteryLab.UI;


public class EscapeRoom {
	
	//Class fields
	private int room;
	public static int miniGame;
	private String roomName;
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	private Countdown timer;
	private Crossword cr;
	private Gallows g;
	private Puzzles p;
	private GuessWho gw;
	
	//Constructor
	public EscapeRoom()  {	
		ui.createUI(cHandler);
		tm.showMainScreen();
	}
	
	//Main method: Creates an EscapeRoom object in order to start the game
	public static void main(String[] args) {
	 
		new EscapeRoom();
	}
	
		
	//Inner Class ChoiceHandler: Controls all the buttons of the game. The class implements
	//the interface ActionListener and therefore controls the actions performed when the
	//user clicks on a button
	public class ChoiceHandler implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent event) {
		
			String yourCh = event.getActionCommand();
			String input = "null"; //The answers that the user gives (user input)
			
			switch(yourCh){
			case "start": //startButton
				tm.showRoomChoices(); //Shows the four escape room choices
				break;
			case "c1": //Button b1
				room = 0;
				roomName = "Κίρκη";
				miniGame = 1;
				tm.welcomePlayer(); 	
				break;
			case "c2": //Button b2
				room = 1; 
				roomName = "Θησέας";
				miniGame = 1;
				tm.welcomePlayer();
				break;
			case "c3": //Button b3
				room = 2;
				roomName = "Περσεφόνη";
				miniGame = 1;
				tm.welcomePlayer();
				break;
			case "c4": //Button b4
				room = 3;
				roomName = "Ικαρος";
				miniGame = 1;
				tm.welcomePlayer();
				break;
				
			case "wb" : //Button wb
				tm.roomPrep();
				
				switch(miniGame) {
				case 1: 
					ui.timePanel.setVisible(true); 
					timer = new Countdown(ui,tm); 
					timer.startCountdown(); //Start the timer
					cr = new Crossword(room,roomName,ui);
					cr.printInstructions();
					break;
				case 2:
					ui.CWPanel.setVisible(false);
					gw = new GuessWho(room,ui,tm,timer);
					gw.printInstructions(room);
					ui.gwB.setVisible(true);
					break;
				case 3: 
					g = new Gallows(room,ui,tm,timer);
					g.printInstructions();
					break;
				case 4: 
					p = new Puzzles(ui,tm,timer);
					p.printInstructions(room);
					break;
				}
			break;
			case "gwB" : //Button gwB: Hint button for the GuessWho game
				gw.showHint(room);	
			}
			
			if (yourCh == "in") { //enterB Button: Enter button to submit the input from the user
				
				switch (miniGame) {
				case 1:
					input = ui.jtf.getText(); //Get the input from the user
					cr.playGame(input); //Start the first minigame
					ui.jtf.setText("");
					break;
				case 2: 
					input = ui.jtf.getText(); //Get the input from the user
					gw.playGame(room, input); //Start the second minigame
					ui.jtf.setText("");
					break;
				case 3: 
					input = ui.jtf.getText(); //Get the input from the user
					g.playGame(input); //Start the third minigame
					ui.jtf.setText("");
					break;
				case 4: 
					input = ui.jtf.getText(); //Get the input from the user
					p.playGame(room,input); //Start the fourth minigame
					ui.jtf.setText("");
					break;
				}
			}
			
		}
   }
}
