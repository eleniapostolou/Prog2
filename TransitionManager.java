	
	public TransitionManager(UI userInt) {
		ui = userInt;
	}
	
	public void showMainScreen() {
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		ui.choiceButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		
		
	}
	
	public void showRoomChoices() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.welcomePanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);
		
	}
	
	public void welcomePlayer() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		
		ui.welcomePanel.setVisible(true);
		
	}

}
