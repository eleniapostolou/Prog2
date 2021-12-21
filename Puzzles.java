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
import java.util.InputMismatchException;

public class Puzzles extends Game {

	private int column = 15; //Refers to the position of the questions and answers at these tables.
	private int counter = 0; //It will be used in order to define in which puzzle the player currently is.

	public void instructions() {
		System.out.println("Συγχαρητήρια! Έφτασες στο τελευταίο επίπεδο!");
		System.out.println("Τώρα, για να αποδράσεις επιτέλους, πρέπει να λύσεις αυτούς τους τρεις γρίφους, χρησιμοποιώντας όσα έμαθες στα προηγούμενα στάδια.");
		System.out.println("Χρησιμοποίησε τον χρόνο που σου απομένει έξυπνα! Ας ξεκινήσουμε και καλή επιτυχία! ");
	}

	public void getPuzzle(int room) { //We get the puzzle for each room.
		System.out.println(questions[room][getColumn()]);
	}

	public void getResult(int room) throws InputMismatchException {

		//This is a method that interacts with the player. The player inputs his/her answer until he/she finds the correct one.
		//We use a boolean flag in order to stop the loop
		//We use a counter in order to always keep track in which puzzle the player currently is.

		Scanner in = new Scanner(System.in);
		boolean flag = false;
		String answer;

		while (flag == false) {

			try {
				answer = in.nextLine();
				String change = answer.toUpperCase();


				if (change.equals(answers[room][getColumn() - 9])) {

					flag = true;
					column = setColumn();
					counter = counter + 1;

					if (counter < 3) {
						SSystem.out.println(" Συγχαρητήρια! Το έλυσες σωστα! Προχωράμε στον επόμενο γρίφο");
					} else {
						System.out.println(" Συγχαριτήρια! Έλυσες και τους τρεις γρίφους! Πέρασες όλες τις δοκιμασίες και απέδρασες από το δωμάτιο!" );
					}

				} else {
					System.out.println(" Ουπς... έκανες λάθος! Προσπάθησε πάλι!");
				}
			} catch (InputMismatchException inputMismatchException) { //In case the player inputs data in another language or special characters.

				System.err.printf("%nException: %s%n", inputMismatchException);
				in.nextLine(); //It erases the false input
				System.out.println(" Παρακαλούμε εισάγεται την απάντησή σας αποκλειστικά με ελληνικούς χαρακτήρες.");
				System.out.println(" Μην χρησιμοποιείται λατινικούς χαρακτήρες και άλλα σύμβολα.");
				System.out.println(" Προσπαθήστε ξανά!");
			}
		}
	}

	public int setColumn() { //We update our location at the tables.

		column = column + 1;
		return column;
	}

	public int getColumn() {
		return column;
	}

	public void playPuzzle(int room) { //This is the method that we are going to call in main in order to play the game.
		//We call in repeat the puzzle and then the answer from the player until he/she finds all three or the time is up.

		instructions();


		while (counter < 3) {

			getPuzzle(room);
			getResult(room);
		}

	}




}







