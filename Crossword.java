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
import java.util.Scanner;

public class Crossword extends Game {

	/* class fields*/
	private int success; /*number of right answers*/
	private String roomName; /*the name of the choosen room*/
	
	/*Constructor*/
	public Crossword(String name) {
		success=0;
		roomName=name;
	}
	
	
	/* Method printInstructions : prints the game's instructions*/
	public void printInstructions() {
	    System.out.println("Καλώς ήρθατε στο Escape room: Greek mythology Edition ");
	    System.out.println("Επιλέξατε να αποδράσετε από το δωμάτιο του/της " + roomName);
	    System.out.println("Ο χρόνος σας ξεκινάει από τώρα!");
	    System.out.println("Η πρώτη δοκιμάσια απαιτεί να αξιοποιήσετε το γνωστικό σας υπόβαθρο και να λύσετε το παρακάτω σταυρόλεξο");
	    System.out.println("Οι κανόνες του παιχνιδιού είναι η εξής:");
	    System.out.println("Πρέπει να ανακαλύψετε και τις 4 κρυμμένες λέξεις προκειμένου να προχωρήσετε στο επόμενο στάδιο.");
	    System.out.println("Μπορείτε να επιλέγετε κάθε φορά την ερώτηση στην οποία θέλετε να απαντήσετε χωρίς να υπάρχει περιορισμός προσπαθειών");
	    System.out.println("Καλή Επιτυχία!");
	    System.out.println();
	
	}
		
	/* Method playGame: the main implementation of the crossword game*/
	public void playGame(int roomNumber) {
		
		Scanner input1 = new Scanner(System.in);
		int qnumber; /* qnumber: the number of the choosen question that user wants to answer*/
		
		do {
			for (int i=0;i<4;i++) { /*prints the question selection menu*/
				System.out.println(questions[roomNumber][i]); 
			}
			System.out.println();
			System.out.println("Διαλέξτε την ερώτηση που θέλετε να απαντήσετε!");
			
			do {
				qnumber=input1.nextInt();
				if (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4) { /*validation check*/
					System.out.println("Ο αριθμός που διαλέξατε δεν αντιστοιχεί σε κάποια ερώτηση! Παρακαλώ προσπαθείστε ξανά!");
				}
			} while (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4);
			
			
			if(checkAnswers(qnumber, roomNumber)) { /* checks if the answer that user gives is the correct one or not*/
				success++;
				System.out.println("Συγχαρητήρια! Βρήκατε την λέξη!");
			} else {
				System.out.println("Λάθος! Προσπαθήστε ξανά!");
			}
		} while(success<4); /*until the user answers correctly all of the 4 questions*/
		
	System.out.println("ΜΠΡΑΒΟ! Αποδράσατε από το πρώτο στάδιο του δωματίου! Είστε έτοιμοι να προχωρήσετε!"); /*success message*/
	}
	
	
	/* Method CheckAnswers: checks if the answer that user gives is the correct one and returns boolean value true or false for eatch case*/
	public boolean checkAnswers(int num, int roomNumber) {
		System.out.println("Δώστε την απάντηση σας!");
		Scanner input2 = new Scanner(System.in);
		String answer;
		answer = input2.nextLine();
		String change = answer.toUpperCase(); /* this method converts every type of answer in Upper letters in order to match with the correct answer*/
		if (change.equals(answers[roomNumber][(num-1)])) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
	
	



