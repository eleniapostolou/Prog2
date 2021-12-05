package mysteryLab;
import java.util.Scanner;

//hey





public class Crossword extends Game {

	private int success;
	private String roomName;
	
	public Crossword(String name) {
		success=0;
		roomName=name;
	}
	
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
		
	
	public void playGame(int roomNumber) {
		
		Scanner input1 = new Scanner(System.in);
		int qnumber;
		
		do {
			for (int i=0;i<4;i++) {
				System.out.println(questions[roomNumber][i]);
			}
			System.out.println();
			System.out.println("Διαλέξτε την ερώτηση που θέλετε να απαντήσετε!");
			
			do {
				qnumber=input1.nextInt();
				if (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4) {
					System.out.println("Ο αριθμός που διαλέξατε δεν αντιστοιχεί σε κάποια ερώτηση! Παρακαλώ προσπαθείστε ξανά!");
				}
			} while (qnumber!=1 && qnumber!=2 && qnumber!=3 && qnumber!=4);
			
			
			if(checkAnswers(qnumber, roomNumber)) {
				success++;
				System.out.println("Συγχαρητήρια! Βρήκατε την λέξη!");
			} else {
				System.out.println("Λάθος! Προσπαθήστε ξανά!");
			}
		} while(success<4);
		
	System.out.println("ΜΠΡΑΒΟ! Αποδράσατε από το πρώτο στάδιο του δωματίου! Είστε έτοιμοι να προχωρήσετε!");
	}
	
	
	public boolean checkAnswers(int num, int roomNumber) {
		System.out.println("Δώστε την απάντηση σας!");
		Scanner input2 = new Scanner(System.in);
		String answer;
		answer = input2.nextLine();
		String change = answer.toUpperCase();
		if (change.equals(answers[roomNumber][(num-1)])) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
	
	



