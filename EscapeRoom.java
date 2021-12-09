package mysteryLab;

import java.util.Scanner;

public class EscapeRoom {
	
	
	private static int room = 0;
	private static String roomName = null;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
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

		} while(room!=1 & room!=2 & room!=3 & room!=4);

		if (room == 1) {
			roomName = " Κίρκη";
		} else if (room == 2) {
			roomName = "Θησέας";
		} else if (room == 3) {
			roomName = "Περσεφόνη";
		} else {
			roomName = "Ίκαρος";
		}
		
		Crossword crossword = new Crossword(roomName);
		//GuessWho guesswho = new GuessWho(roomName);
		Gallows gallows = new Gallows(room-1);
		Puzzles puzzles = new Puzzles();

		System.out.println(" Ο χρόνος σου ξεκινάει από τώρα! Χρησιμοποίησέ τον έξυπνα!");
		
		Countdown countdown = new Countdown();
		countdown.startCountdown();

		crossword.playGame(room-1);
		//guesswho.startGuessing();
		boolean success3 = gallows.startGame();
		
		boolean finalSuccess = false;
		if (success3) {
			finalSuccess = puzzles.playPuzzle(room-1);
		} else {
			countdown.timer.cancel();
			System.out.println("GAME OVER");
		}
		
		if (finalSuccess) {
			System.out.println("ΣΥΓΧΑΡΗΤΗΡΙΑ! ΚΑΤΑΦΕΡΕΣ ΝΑ ΑΠΟΔΡΑΣΕΙΣ ΑΠΟ ΤΟ ΔΩΜΑΤΙΟ!");
			countdown.timer.cancel();
			int timeLeft = 2700 - countdown.geti();
			System.out.print(timeLeft/60 + ":" + timeLeft%60 + ((timeLeft%60/10 == 0)? "0" : " ") + "\n");
		}
		
		
	}
	
}

		
