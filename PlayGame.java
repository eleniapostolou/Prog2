package mysteryLab;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;


public class PlayGame {

	private static BigInteger Fibonacci(int n) {
	        if (n < 2)
	            return BigInteger.ONE;
	        else
	            return Fibonacci(n - 1).add(Fibonacci(n - 2));
	    }
	}

	public static void main(String[] args) {

		StopWatch1 stopwatch = new StopWatch1();
		Scanner input = new Scanner(System.in)
		int room = 0;
		String roomName = null;

		System.out.println(" Καλωσορισες στο δωμάτιο. Στόχος σου είναι να δραπετεύσεις ξεπερνώντας τρεις δοκιμασίες.");
		System.out.println(" Στην αρχή κάθε δοκιμασίες θα σου δίνονται οδηγίες.");
		System.out.println(" Έχεις 20 λεπτά για να δραπετεύσεις!");
		System.out.println(" Αρχικά διάλεξε τον χαρακτήρα σου πληκτρολογώντας τον αντίστοιχο αριθμό.");
		System.out.println(" 1. Κίρκη");
		System.out.println(" 2. Θησέας");
		System.out.println(" 3. Περσεφόνη");
		System.out.println(" 4. Ίκαρος");

		do {
			room = input.nextInt();

			if (room!=1 & room!=2 & room!=3 & room!=4) {
				System.out.println(" Ο αριθμός που εισήγαγες δεν αντιστοιχεί σε κάποιο χαρακτήρα.");
				System.out.println(" Προσ΄πάθησε ξανά! Θυμήσου:");
				System.out.println(" 1. Κίρκη");
				System.out.println(" 2. Θησέας");
				System.out.println(" 3. Περσεφόνη");
				System.out.println(" 4. Ίκαρος");
			}

		} while(room!=1 & room!=2 & room!=3 & room!=4)

		if (room == 1) {
			roomName = " Κίρκη";
		} else if (room == 2) {
			roomName = "Θησέας";
		}else if (room == 3) {
			roomName = "Περσεφόνη";
		}else {
			roomName = "Ίκαρος";
		}

		Crossword crossword = new Crossword(roomName);
		GuessWho guesswho = new GuessWho();
		Gallows gallows = new Gallows(room);
		Puzzles puzzles = new puzzles();

		System.out.println(" Ο χρόνος σου ξεκινάει από τώρα! Χρησιμοποίησέ τον έξυπνα!");

		stopwatch.start();
		Fibonacci(45);

		crossword.playGame(room);
		guesswho.startGuessing();
		gallows.startGame();
		puzzles.playPuzzle(room);

		stopwatch.stop();
	}
}


