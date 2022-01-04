package mysteryLab;

public class TransitionManager {
	
	UI ui;
	
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
		ui.timePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);
	}
	
	public void welcomePlayer() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.timePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.welcomePanel.setVisible(true);
	}
	
	public void inputP() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.welcomePanel.setVisible(true);
		ui.timePanel.setVisible(true);
		
	}
	
	public void roomPrep() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.cb.setVisible(false);
		ui.welcomePanel.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.MtPanel.setVisible(true);
		ui.timePanel.setVisible(true);
		
	}
}
