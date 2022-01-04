package mysteryLab;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EscapeRoom2 {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	int room;
	public static int miniGame;
	private String roomName;
	Countdown timer;
	Crossword2 cr;
	GallowsG g;
	public static void main(String[] args) {
	 
		new EscapeRoom2();
	}
	
	public EscapeRoom2() {	
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
				timer = new Countdown(ui);
				timer.startCountdown();
				tm.roomPrep();
				switch(miniGame) {
				case 1: 
					cr = new Crossword2(room,roomName,ui);
					cr.printInstructions();
					break;
				case 2:
					
					break;
				case 3: 
					g = new GallowsG(room,ui);
					g.instructions();
					break;
				case 4: break;
				}
				
				break;
			}
			
			if (yourCh == "in") {
				switch (miniGame) {
				case 1:
					input = ui.jtf.getText();
					cr.playGame(input);
					ui.jtf.setText("");
					break;
				case 2: 
					
					break;
				case 3: 
					input = ui.jtf.getText();
					g.startGame(input);
					ui.jtf.setText("");
					break;
				case 4: break;
				}
			}
			
		}
   }
}
