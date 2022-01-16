/*TransitionManager.java
 *Copyright 2021 mysteryLab
 */

/**
*The class TransitionManager swaps the GUI according to the player's choices as the game procides.
*
*
*@version  ___
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
	
	public void showMainScreen() {
		ui.choiceButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		ui.timePanel.setVisible(false);
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);	
	}
	
	public void showRoomChoices() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);

	}
	
	public void welcomePlayer() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		ui.gob.setVisible(false);
		
		ui.welcomePanel.setVisible(true);
	
	}
	
	public void inputP() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.welcomePanel.setVisible(true);
	}
	
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
