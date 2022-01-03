package elenhs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EscapeRoom2 {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	int theme;
	public static int miniGame;
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
				theme = 0;
				miniGame = 1;
				tm.welcomePlayer(); 	
				break;
			case "c2":
				theme = 1; 
				miniGame = 3;
				tm.welcomePlayer();
				break;
			case "c3":
				theme = 2;
				miniGame = 1;
				tm.welcomePlayer();
				break;
			case "c4": 
				theme = 3;
				miniGame = 1;
				tm.welcomePlayer();
				break;
				
			case "wb" :
				tm.roomPrep();
				switch(miniGame) {
				case 1: 
					//cr = new CrossRoad();
					//cr.instructions();
					break;
				case 2:
					
					break;
				case 3: 
					g = new GallowsG(theme,ui);
					g.instructions();
					break;
				case 4: break;
				}
				
				break;
			}
			
			if (yourCh == "in") {
				switch (miniGame) {
				case 1: break;
				case 2: 
					
					break;
				case 3: 
					input = ui.jtf.getText();
					g.startGame(input);
					break;
				case 4: break;
				}
			}
			
		}
   }
}
