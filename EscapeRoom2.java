package mysteryLab;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mysteryLab.Gallows;
import mysteryLab.TransitionManager;
import mysteryLab.UI;


public class EscapeRoom2 {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	int room;
	public static int miniGame;
	private String roomName;
	Countdown timer;
	Crossword cr;
	Gallows g;
	Puzzles p;
	GuessWho gw;
	public static void main(String[] args) {
	 
		new EscapeRoom2();
	}
	
	public EscapeRoom2()  {	
		ui.createUI(cHandler);
		tm.showMainScreen();
	}
		
		
	public class ChoiceHandler implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent event) {
		
			String yourCh = event.getActionCommand();
			String input = "null";
			
			switch(yourCh){
			case "start": tm.showRoomChoices(); break;
			case "c1":
				room = 0;
				roomName = "Κίρκη";
				miniGame = 1;
				tm.welcomePlayer(); 	
				break;
			case "c2":
				room = 1; 
				roomName = "Θησέας";
				miniGame = 1;
				tm.welcomePlayer();
				break;
			case "c3":
				room = 2;
				roomName = "Περσεφόνη";
				miniGame = 1;
				tm.welcomePlayer();
				break;
			case "c4": 
				room = 3;
				roomName = "Ικαρος";
				miniGame = 1;
				tm.welcomePlayer();
				break;
				
			case "wb" :
				tm.roomPrep();
				switch(miniGame) {
				case 1: 
					ui.timePanel.setVisible(true);
					timer = new Countdown(ui,tm);
					timer.startCountdown();
					cr = new Crossword(room,roomName,ui);
					cr.printInstructions();
					break;
				case 2:
					gw = new GuessWho(room,ui,tm,timer);
					gw.printInstructions(room);
					ui.gwB.setVisible(true);
					break;
				case 3: 
					g = new Gallows(room,ui,tm,timer);
					g.instructions();
					break;
				case 4: 
					p = new Puzzles(ui,tm,timer);
					p.instructions(room);
					break;
				}
				break;
			case "gwB" :
				gw.showHint(room);	
			}
			
			if (yourCh == "in") {
				switch (miniGame) {
				case 1:
					input = ui.jtf.getText();
					cr.playGame(input);
					ui.jtf.setText("");
					break;
				case 2: 
					input = ui.jtf.getText();
					gw.playGuessWho(room, input);
					ui.jtf.setText("");
					break;
				case 3: 
					input = ui.jtf.getText();
					g.startGame(input);
					ui.jtf.setText("");
					break;
				case 4: 
					input = ui.jtf.getText();
					p.playPuzzle(room,input);
					ui.jtf.setText("");
					break;
				}
			}
			
		}
   }
}
