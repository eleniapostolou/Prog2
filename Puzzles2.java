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
import java.util.Scanner;

public class Puzzles extends Game {

	private int column = 15; //Refers to the position of the questions and answers at these tables.
	private int counter = 0; //It will be used in order to define in which puzzle the player currently is.
	UI ui;

	public Puzzles(UI ui) {
		this.ui = ui;
	}

	public void instructions(int room) {
		ui.mainTextArea.setText("Συγχαρητήρια! Έφτασες στο τελευταίο επίπεδο! \n"+
		"Τώρα, για να αποδράσεις επιτέλους, πρέπει να λύσεις αυτούς τους τρεις γρίφους, χρησιμοποιώντας όσα έμαθες στα προηγούμενα στάδια. \n"+
		"Χρησιμοποίησε τον χρόνο που σου απομένει έξυπνα! Ας ξεκινήσουμε και καλή επιτυχία!\n " + 
		getPuzzle(room));
	}

	public String getPuzzle(int room) { //We get the puzzle for each room.
		return(questions[room][getColumn()]);
	}

	public void getResult(int room, String answer) {

		//This is a method that interacts with the player. The player inputs his/her answer until he/she finds the correct one.
		//We use a boolean flag in order to stop the loop
		//We use a counter in order to always keep track in which puzzle the player currently is.





			String change = answer.toUpperCase();

			if (change.equals(answers[room][getColumn() - 9])) {


				column = setColumn();
				counter = counter + 1;

				if (counter < 3) {
					ui.mainTextArea.append(" Συγχαρητήρια! Το έλυσες σωστα! Προχωράμε στον επόμενο γρίφο");
				} else {
					ui.mainTextArea.append(" Συγχαριτήρια! Έλυσες και τους τρεις γρίφους! Πέρασες όλες τις δοκιμασίες και απέδρασες από το δωμάτιο!" );
					EscapeRoom2.miniGame = 5;
				}


			} else {
					ui.mainTextArea.append(" Ουπς... έκανες λάθος! Προσπάθησε πάλι!");
			}


	}

	public int setColumn() { //We update our location at the tables.

		column = column + 1;
		return column;
	}

	public int getColumn() {
		return column;
	}

	public boolean playPuzzle(int room, String answer) { //This is the method that we are going to call in main in order to play the game.
		//We call in repeat the puzzle and then the answer from the player until he/she finds all three or the time is up.

		boolean result = false;


		while (counter < 3) {

			getPuzzle(room);
			getResult(room, answer);
			result = true;
		}

		return result;
		ui.cb.setVisible(true)

	}




}






