/*Puzzles.java
 *Copyright 2021 mysteryLab
 */

/**
*This class -Puzzles- extends the superclass Game. It implements the game puzzles, the final game to escape the room.
*The player needs to answer the three puzzles in his/her remaining time.
*This class contains six methods.
*
*
*@version ____
*@author ELENI APOSTOLOU, KONSTANTINA SOTIROPOULOU
*/
package mysteryLab;

public class Puzzles extends Game {
	
	//Class fields
	private int column = 15; //Refers to the position of the questions and answers at these tables.
	private int counter = 0; //It will be used in order to define in which puzzle the player currently is.
	TransitionManager tm;
	Countdown cd;
	UI ui;
	
	//Constructor
	public Puzzles(UI ui, TransitionManager tm, Countdown cd) {
		this.ui = ui;
		this.tm = tm;
		this.cd = cd;
	}

	//Method printInstructions: The instructions are printed with the first puzzle.
	public void printInstructions(int room) {
		ui.mainTextArea.setText("Συγχαρητήρια! Έφτασες στο τελευταίο επίπεδο! \n"+
		"Τώρα, για να αποδράσεις επιτέλους, πρέπει να λύσεις αυτούς τους τρεις γρίφους, χρησιμοποιώντας όσα έμαθες στα προηγούμενα στάδια. \n"+
		"Χρησιμοποίησε τον χρόνο που σου απομένει έξυπνα! Ας ξεκινήσουμε και καλή επιτυχία! \n \n" + getPuzzle(room));
	}

	//Method getPuzzle: It gets the puzzle of each room.
	public String getPuzzle(int room) { 
		 return questions[room][getColumn()];
	}

	//Method getResult: It checks if the input is the correct one.
	public void getResult(int room, String answer) {

		//We use a counter in order to always keep track in which puzzle the player currently is.
		String change = answer.toUpperCase();

		if (change.equals(answers[room][getColumn() - 9])) {		
				
			column = setColumn();
			counter += 1;

			if (counter < 3) {
				ui.mainTextArea.setText("Συγχαρητήρια! Το έλυσες σωστα! Προχωράμε στον επόμενο γρίφο");
			} else {
				ui.timePanel.setVisible(false);
				tm.resultPanel();
				ui.mainTextArea.setText("\n\n YOU ARE A WINNER BABY !");
				cd.timer.cancel();
			}

		} else {
			ui.mainTextArea.setText(" Ουπς... έκανες λάθος! Προσπάθησε πάλι!");
		}
		
	}

	//Method setColumn: It updates the location of the tables.
	public int setColumn() { 

		column = column + 1;
		return column;
	}

	//Method getColumn: It returns the current column.
	public int getColumn() {
		return column;
	}

	//Method playGame: the main implementation of the puzzle game.
	public void playGame(int room, String answer) { 

		if (counter < 3) {
			getResult(room, answer);
			if (counter < 3) {
			ui.mainTextArea.append("\n\n"+getPuzzle(room));
			}
		}
	}
}




