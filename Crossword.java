package mysteryLab;
import java.util.Scanner;

public class Crossword {
   
	private Scanner input = new Scanner(System.in);
	private int success;
	private String roomName;
	
	public Crossword(String name) {
		success=0;
		roomName=name;
	}
	
	public boolean playGame() {
		
		int qnumber;
		
		do {
			for(int i=0;i<4;i++) {
				System.out.println(questions[i]);
			}
			System.out.println("Διαλέξτε την ερώτηση που θέλετε να απαντήσετε!");
			
			do {
			qnumber=input.nextInt();
			if (qnumber!=1 || qnumber!=2 || qnumber!=3 || qnumber!=4) {
				System.out.println("Ο αριθμός που διαλέξατε δεν αντιστοιχεί σε κάποια ερώτηση! Παρακαλώ προσπαθείστε ξανά!");
			}	
			}while(qnumber!=1 || qnumber!=2 || qnumber!=3 || qnumber!=4);
			
			
			if(checkAnswers(qnumber);) {
				success++;
				System.out.println("Συγχαρητήρια! Βρήκατε την λέξη!");
			}else {
				System.out.println("Λάθος! Προσπαθείστε ξανά!");
			}
			}while(success!=4);
		
	System.out.println("ΜΠΡΑΒΟ! Αποδράσατε από το πρώτο στάδιο του δωματίου! Είστε έτοιμη να προχωρήσετε!");
	}
	
	
	
	
	public boolean checkAnswers(int num) {
		String answer;
		answer=input.nextLine();
		String change = answer.toUpperCase();
		if(answers[num-1]==change){
			return true;
		}else {
			return false;
		}
	}
	
	
	public void printInstructions() {
		System.out.println("Καλώς ήρθατε στο Escape room: Greek mythology Edition ");
		System.out.println("Επιλέξατε να αποδράσετε από το δωμάτιο του/της" + roomName);
		System.out.println("Ο χρόνος σας ξεκινάει από τώρα!");
	    System.out.println("Η πρώτη δοκιμάσια απαιτεί να αξιοποιήσετε το γνωστικό σας υπόβαθρο και να λύσετε το παρακάτω σταυρόλεξο");
	    System.out.println("Οι κανόνες του παιχνιδιού είναι η εξής:");
	    System.out.println("Πρέπει να ανακαλύψετε και τις 4 κρυμμένες λέξεις προκειμένου να προχωρήσετε στο επόμενο στάδιο.");
	    System.out.println("Μπορείτε να επιλέγετε κάθε φορά την ερώτηση στην οποία θέλετε να απαντήσετε χωρίς να υπάρχει περιορισμός προσπαθειών");
	    System.out.println("Καλή Επιτυχία!");
	
	}
		
}
