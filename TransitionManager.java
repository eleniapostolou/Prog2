package mysteryLab;

public class TransitionManager {
	
	UI ui;
	
	public TransitionManager(UI userInt) {
		ui = userInt;
	}
	
	public void showMainScreen() {
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		ui.choiceButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
		
	}
	
	public void showRoomChoices() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
	}
	
	public void welcomePlayer() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		
		ui.welcomePanel.setVisible(true);
		ui.inputPanel.setVisible(false);
		ui.MtPanel.setVisible(false);
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
		ui.cb.setVisible(false);
		ui.welcomePanel.setVisible(false);
		
		ui.inputPanel.setVisible(true);
		ui.MtPanel.setVisible(true);
		
	}
}
