package mysteryLab;
import java.util.Scanner;
import java.util.Timer;

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

	public void getResult(int room) { //This is a method that interacts with the player. The player inputs his/her answer until he/she finds the correct one.
		//We use a boolean flag in order to stop the loop
		//We use a counter in order to always keep track in which puzzle the player currently is.

		Scanner in = new Scanner(System.in);
		boolean flag = false;
		String answer;

		while (flag == false) {
			answer = in.nextLine();
			String change = answer.toUpperCase();

			if (change.equals(answers[room][getColumn() - 9])) {
				
				column = setColumn();
				counter = counter + 1;
				
				if (counter < 2) {
					System.out.println(" Συγχαρητήρια! Το έλυσες σωστα! Προχωράμε στον επόμενο γρίφο");
				} else {
					System.out.println(" Συγχαριτήρια! Έλυσες και τους τρεις γρίφους! Πέρασες όλες τις δοκιμασίες και απέδρασες από το δωμάτιο!" );
				}
					
			} else {
				System.out.println(" Ουπς... έκανες λάθος! Προσπάθησε πάλι!");
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
		
		Timer t = new Timer();

		while (counter < 3) {

			getPuzzle(room);
			getResult(room);
		}
		
		t.getTimer();
	}




}


