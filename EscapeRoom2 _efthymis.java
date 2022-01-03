package elenhs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EscapeRoom2 {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	int position;
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
			case "c1": tm.welcomePlayer(); break;
			case "c2":
				position = 2; //γιατι παιζεισ το δευτερο παιχνδι
				tm.roomPrep();
				g = new GallowsG(1,ui);
				g.instructions();
				
				break;
			case "c3": break;
			case "c4": break;
			case "in": 
				tm.roomPrep();
				switch(position) {
				case 1 : break;
				case 2 : 
					input = ui.jtf.getText();
					g.startGame(input);
					//ui.mainTextArea.setText("phre input  "+input);
					break;
				case 3 : break;
				case 4 : break;
				}
				break;
			}
			
		}
   }
}
