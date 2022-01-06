package mysteryLab;

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


public class Puzzles extends Game {

	private int column = 15; //Refers to the position of the questions and answers at these tables.
	private int counter = 0; //It will be used in order to define in which puzzle the player currently is.
	TransitionManager tm;
	Countdown cd;
	UI ui;
	

	public Puzzles(UI ui, TransitionManager tm, Countdown cd) {
		this.ui = ui;
		this.tm = tm;
		this.cd = cd;
	}

	public void instructions(int room) {
		ui.mainTextArea.setText("Συγχαρητήρια! Έφτασες στο τελευταίο επίπεδο! \n"+
		"Τώρα, για να αποδράσεις επιτέλους, πρέπει να λύσεις αυτούς τους τρεις γρίφους, χρησιμοποιώντας όσα έμαθες στα προηγούμενα στάδια. \n"+
		"Χρησιμοποίησε τον χρόνο που σου απομένει έξυπνα! Ας ξεκινήσουμε και καλή επιτυχία! \n \n" + getPuzzle(room));
	
	}

	public String getPuzzle(int room) { //We get the puzzle for each room.
		 return questions[room][getColumn()];
	}

	public void getResult(int room, String answer) {

		//This is a method that interacts with the player. The player inputs his/her answer until he/she finds the correct one.
		//We use a boolean flag in order to stop the loop
		//We use a counter in order to always keep track in which puzzle the player currently is.

			String change = answer.toUpperCase();

			if (change.equals(answers[room][getColumn() - 9])) {
				
				
				column = setColumn();
				counter += 1;

				if (counter < 3) {
					ui.mainTextArea.setText(" Συγχαρητήρια! Το έλυσες σωστα! Προχωράμε στον επόμενο γρίφο");
				} else {
					ui.timePanel.setVisible(false);
					tm.resultPanel();
					ui.mainTextArea.setText("\n\n YOU ARE A WINNER BABY !" );
					cd.timer.cancel();
				}


			} else {
				ui.mainTextArea.setText(" Ουπς... έκανες λάθος! Προσπάθησε πάλι!");
			}


	}

	public int setColumn() { //We update our location at the tables.

		column = column + 1;
		return column;
	}

	public int getColumn() {
		return column;
	}

	public void playPuzzle(int room ,String answer) { //This is the method that we are going to call in main in order to play the game.
		//We call in repeat the puzzle and then the answer from the player until he/she finds all three or the time is up.

		
		if (counter < 3) {
			
			getResult(room,answer);
			if (counter < 3) {
			ui.mainTextArea.append("\n\n"+getPuzzle(room));
			}
			System.out.println("poo");
		}
		

	}




}



