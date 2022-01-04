/*Crossword.java
 *Copyright 2021 mysteryLab
 */

/**
*The class Crossword extends superclass Game (main class). The class implements the crossword puzzle game.
*The Class displays 4 questions to which the user must give the correct answer in order to move on to the next
*level of the game.
*
*
*@version  _____
*@author ELENI NTOUSI , PATRA ROXANI 
*/
package mysteryLab;

public class Crossword2 extends Game{
	
	/*Class fields*/
	private int[] success = new int[4]; //number of right answers
	private int roomNumber;
	private String roomName; //the name of the chosen room
	boolean continueGame = true;
	UI ui;
	
	/*Constructor*/
	public Crossword2 (int room, String name, UI userInterface) {
		roomNumber = room;
		roomName=name;
		ui = userInterface; 
	}
	
	/*Method getRoomName: Getter method for the field roomName*/
	public String getRoomName() {
		return roomName;
	}
	
	/* Method printInstructions : prints the game's instructions*/
	public void printInstructions() {
		ui.mainTextArea.setText("Καλώς ήρθατε στο Escape room!\n" 
	    +"Επιλέξατε να αποδράσετε από το δωμάτιο του/της " + getRoomName() + "\n"
	    +"Η πρώτη δοκιμάσια απαιτεί να αξιοποιήσετε το \nγνωστικό σας υπόβαθρο και να λύσετε το παρακάτω σταυρόλεξο.\n"
	    +"Οι κανόνες του παιχνιδιού είναι η εξής: \n"
	    +"Πρέπει να ανακαλύψετε και τις 4 κρυμμένες λέξεις \nπροκειμένου να προχωρήσετε στο επόμενο στάδιο.\n"
	    +"Μπορείτε να προσπαθήσετε όσες φορές χρειαστεί!\n"
	    +"Καλή Επιτυχία!\n" + printSelectionMenu());
		
	}
	
	/* Method playGame: the main implementation of the crossword game*/
	public void playGame(String answer) {
		
		
		if (continueGame)	{
			ui.mainTextArea.setText(printSelectionMenu() + "\n");
			
			checkAnswers(answer);
			
			continueGame = false;
			for (int i = 0; i < success.length; i++) { //Check if the user has answered all the questions correctly 
				if (success[i] == 0) {
					continueGame = true;
				}
			}
			
		} 
		
		if (!continueGame) {
			ui.mainTextArea.append("ΜΠΡΑΒΟ! Αποδράσατε από το πρώτο στάδιο του δωματίου! "
									+ "Είστε έτοιμοι να προχωρήσετε!");
			EscapeRoom2.miniGame = 3; 
			ui.cb.setVisible(true);
		}
		
	}
	
	/*Method printSelectionMenu: prints the crossword questions of the chosen room*/
	public String printSelectionMenu() {
		
		String quest = "";
		for (int i=0;i<4;i++) { /*prints the question selection menu*/
			
			quest += (i+1) + ") " + questions[roomNumber][i] + "\n";
		}
		quest += "Δώστε την απάντηση σας!\n";
		return quest;
	}
	
	/* Method checkAnswers: checks if the answer that user gives is the correct one 
	 * and returns boolean value true or false for each case*/
	public boolean checkAnswers(String answer) {
		//ui.mainTextArea.append("Δώστε την απάντηση σας!\n");
		String change = answer.toUpperCase(); //Convert every answer in Upper letters in order to match the correct answer
		boolean result = false;
		for (int i = 0; i < 4; i++) {
			if (change.equals(answers[roomNumber][(i)])) {
				result = true;
				
				if (success[i] == 0) {
					success[i]++;
					ui.mainTextArea.append("Συγχαρητήρια! Βρήκατε την λέξη!\n");
				} else {
					ui.mainTextArea.append("Έχετε απαντήσει ήδη αυτή την ερώτηση. Απάντηστε μία άλλη ερώτηση!");
				}	
			} 
		}
		if (!result) {
			ui.mainTextArea.append("Λάθος! Προσπαθήστε ξανά!");
		}
		return result;
	}
	


}

