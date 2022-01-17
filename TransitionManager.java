/*TransitionManager.java
 *Copyright 2021 mysteryLab
 */

/**
*The class TransitionManager swaps the GUI according to the player's choices as the game proceeds.
*
*
*@version  ____
*@author EFTHYMIS KONTOES, ELENI NTOUSI
*/

 
package mysteryLab;

 
public class TransitionManager {
	
	//Class Fields
	UI ui;
	
    //Constructor
	public TransitionManager(UI userInt) {
		ui = userInt;
	}
	
	//Method showMainScreen:it sets visible the title panel and the start button 
	public void showMainScreen() {
		ui.choiceButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		ui.timePanel.setVisible(false);
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);	
	}
	
	
	//Method showRoomChoices:it sets visible the 4 button of the rooms 
	public void showRoomChoices() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);

	}
	
	
	//Method welcomePlayer: It displays some relevant instructions for the game 
	public void welcomePlayer() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		ui.gob.setVisible(false);
		
		ui.welcomePanel.setVisible(true);
	
	}
	
	//Method inputP: It shows the input panel
	public void inputP() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.welcomePanel.setVisible(true);
	}
	
	
	//Method roomPrep: It prepares the window for each game 
	public void roomPrep() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.cb.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.MtPanel.setVisible(true);
		ui.mainTextArea.setFont(ui.miniGameFont);
	}
	
	
	//Method resultPanel:it prepares the window for the game's results 
	public void resultPanel() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.timePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.cb.setVisible(false);
		
		ui.MtPanel.setVisible(true);
		ui.gob.setVisible(true);
		ui.mainTextArea.setFont(ui.titleFont);
	}
}
