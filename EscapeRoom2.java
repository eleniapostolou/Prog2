package mysteryLab;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EscapeRoom2 {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	TransitionManager tm = new TransitionManager(ui);
	
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
		
		
			if (event.getSource() == ui.startButton) {
				tm.showRoomChoices();	
	
			} else if (event.getSource() == ui.b1) {
				tm.welcomePlayer();
			
			} else if (event.getSource() == ui.b2) {
			
			} else if (event.getSource() == ui.b3) {
			
			} else if (event.getSource() == ui.b4) {
	
			}
		}
   }
}
