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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Crossword extends Game {

	/*Class fields*/
	private int[] success = new int[4]; //number of right answers
	private String roomName; //the name of the chosen room
	
	/*Constructor*/
	public Crossword(String name) {
		roomName=name;
	}
	
	/*Method getRoomName: Getter method for the field roomName*/
	public String getRoomName() {
		return roomName;
	}
	
	
	/* Method printInstructions : prints the game's instructions*/
	public void printInstructions() {
	    System.out.println("Καλώς ήρθατε στο Escape room: Greek mythology Edition ");
	    System.out.println("Επιλέξατε να αποδράσετε από το δωμάτιο του/της " + getRoomName());
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
		
		boolean continueGame;
		printInstructions(); //Prints the game's instructions
		
		do {
			continueGame = false;
			
			printSelectionMenu(roomNumber); //Prints the question selection menu
		    	
			int qNumber = getQNumber(); //Get the question number that the user wants to answer
					
			printAnswerResult(roomNumber, qNumber); //Print the appropriate message according to the user's answer
		
			for (int i = 0; i < success.length; i++) { //Check if the user has answered all the questions correctly 
				if (success[i] == 0) {
					continueGame = true;
				}
			}
			
		} while(continueGame); //Until the user answers correctly all of the 4 questions
		
	System.out.println("ΜΠΡΑΒΟ! Αποδράσατε από το πρώτο στάδιο του δωματίου! "
			+ "Είστε έτοιμοι να προχωρήσετε!"); //Prints success message
	}
	
	
	/* Method checkAnswers: checks if the answer that user gives is the correct one 
	 * and returns boolean value true or false for eatch case*/
	public boolean checkAnswers(int num, int roomNumber) {
		System.out.println("Δώστε την απάντηση σας!");
		Scanner input2 = new Scanner(System.in);
		String answer;
		answer = input2.nextLine();
		String change = answer.toUpperCase(); //Convert every answer in Upper letters in order to match the correct answer
		if (change.equals(answers[roomNumber][(num-1)])) {
			return true;
		} else {
			return false;
		}
	}
	
	/*Method printSelectionMenu: prints the crossword questions of the chosen room*/
	public void printSelectionMenu(int roomNumber) {
		for (int i=0;i<4;i++) { /*prints the question selection menu*/
			System.out.println(questions[roomNumber][i]); 
		}
		System.out.println();
		System.out.println("Διαλέξτε την ερώτηση που θέλετε να απαντήσετε!");
	}
	
	/*Method getQNumber: Reads and checks the question number that the user wants to answer*/
	public int getQNumber() {
		Scanner input1 = new Scanner(System.in);
		int qnumber =  0; //the number of the chosen question that user wants to answer
		boolean continueLoop = true;
		do {
			do {
				try {
					qnumber=input1.nextInt();
					if (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4) { //validation check
					System.out.println("Ο αριθμός που διαλέξατε δεν αντιστοιχεί σε κάποια ερώτηση! Παρακαλώ προσπαθείστε ξανά!");
					}
					continueLoop = false;
				} catch (InputMismatchException e) {
					System.out.println("Λάθος τύπος δεδομένων!");
					input1.nextLine();
					System.out.println("Παρακαλώ εισάγετε ακέραιο αριθμό που να αντιστοιχεί σε μία ερώτηση!");
				}
			} while (continueLoop);
		} while (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4);
		
		return qnumber;
		
	}
	
	/*Method printAnswerResult: Prints the appropriate message based on the given answer by the user:
	 * Correct answer: Prints success message
	 * Wrong answer: Prints error message
	 * Else: Prints already answered question message */
	public void printAnswerResult(int roomNumber, int qNumber) {
		if(checkAnswers(qNumber, roomNumber)) { //checks if the answer that user gives is the correct one or not
			if (success[qNumber-1] == 0) {
				success[qNumber-1]++;
				System.out.println("Συγχαρητήρια! Βρήκατε την λέξη!");
			} else {
				System.out.println("Έχεις απαντήσει ήδη αυτή την ερώτηση. Παρακαλώ διάλεξε μία άλλη ερώτηση!");
			}
			
		} else {
			System.out.println("Λάθος! Προσπαθήστε ξανά!");
		}
		
		
	}
	
	
	
}
	
	
	



