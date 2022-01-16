/*EscapeRoom.java
 *Copyright 2021 mysteryLab
 */

/**
*The class EscapeRoom contains the main class of the game. The class displays a selection menu, 
*where the player can choose one of the four available themed escape rooms. Then, the class creates 
*the appropriate objects of the other classes (which contain the game of each of the four levels)
* and calls the game implementation methods.
*
*
*@version  _____
*@author ELENI APOSTOLOU, ELENI NTOUSI , PATRA ROXANI 
*/
package mysteryLab;
import java.util.Scanner;

public class EscapeRoom {
	
	//Class fields
	private static int room = 0; //The chosen room
	private static String roomName = null; //The chosen room's name
	
	//Main method: 
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Selection menu
		System.out.println(" Καλωσορισες στο δωμάτιο. Στόχος σου είναι να δραπετεύσεις ξεπερνώντας τρεις δοκιμασίες.");
		System.out.println(" Στην αρχή κάθε δοκιμασίες θα σου δίνονται οδηγίες.");
		System.out.println(" Έχεις 20 λεπτά για να δραπετεύσεις!");
		System.out.println(" Αρχικά διάλεξε τον χαρακτήρα σου πληκτρολογώντας τον αντίστοιχο αριθμό.");
		System.out.println(" 1. Κίρκη");
		System.out.println(" 2. Θησέας");
		System.out.println(" 3. Περσεφόνη");
		System.out.println(" 4. Ίκαρος");

		//Get the room number from the user and check that room>=1 and room<=4
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

		//Given the chosen room, set the roomName based on the main character of the room
		if (room == 1) {
			roomName = " Κίρκη";
		} else if (room == 2) {
			roomName = "Θησέας";
		} else if (room == 3) {
			roomName = "Περσεφόνη";
		} else {
			roomName = "Ίκαρος";
		}
		
		//Create the objects from the four game classes
		Crossword crossword = new Crossword(roomName);
		//GuessWho guesswho = new GuessWho(roomName);
		Gallows gallows = new Gallows(room-1);
		Puzzles puzzles = new Puzzles();

		System.out.println(" Ο χρόνος σου ξεκινάει από τώρα! Χρησιμοποίησέ τον έξυπνα!");
		
		//Start countdown timer
		Countdown countdown = new Countdown();
		countdown.startCountdown();

		//Start playing
		crossword.playGame(room-1); //First level: crossword
		//guesswho.startGuessing(); //Second level: guess who
		boolean success3 = gallows.startGame(); //Third level: gallows
		
		boolean finalSuccess = false;
		if (success3) { //If the player has succeeded in level three
			finalSuccess = puzzles.playPuzzle(room-1); //Fourth level: puzzles
		} else {
			countdown.timer.cancel(); //End timer
			System.out.println("GAME OVER"); //Display "GAME OVER" message
		}
		
		
		if (finalSuccess) { //If the player finished the game without surpassing the time limit
			System.out.println("ΣΥΓΧΑΡΗΤΗΡΙΑ! ΚΑΤΑΦΕΡΕΣ ΝΑ ΑΠΟΔΡΑΣΕΙΣ ΑΠΟ ΤΟ ΔΩΜΑΤΙΟ!"); //Display SUCCESS message
			countdown.timer.cancel(); //End timer
			int timeLeft = 2700 - countdown.geti();
			System.out.print(timeLeft/60 + ":" + timeLeft%60 + ((timeLeft%60/10 == 0)? "0" : " ") + "\n"); //Display the time that the player completed the game in
		}
		
		
	}
	
}

		
		
		
		
