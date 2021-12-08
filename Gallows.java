/*Gallows.java
 *Copyright 2021 mysteryLab
 */

/**
*The class Gallows extends superclass Game (main class). The class implements the gallows puzzle game.
*The Class expects the user to guess correctly the letters of a word in order to move on to the next
*level of the game.
*
*
*@version  _____
*@author EFTHYMIOS KONTOES , KOSTANTINOS SPATHAS 
*/

package mysteryLab ;
import java.util.Scanner ;

public class Gallows extends Game{

                 // Class fields
		 private String word ;
		 private char [] letters;
		 private char [] temp ;
		 private int lives;
		 private int leftlet;

	
	// Constructor
	public Gallows(int room) {
		
		word= answers[room][5];
		letters= new char[ word.length()];
		temp = new char[ word.length()];
		temp[0]=word.charAt(0);
		for( int i = 1 ; i < word.length() ; i ++ ) {
			temp[i] = '_' ; // it creates a table with only the first the letter of the word
		}
		for( int i=0 ; i < word.length() ; i ++) {
			letters[i] =word.charAt(i);//it creates a char table wich contains the letters of the word
		}
		lives = 5;
		leftlet = word.length() - 1;
		
		
	}

	// Method startGame: the main implementation of the Gallows game
	public void startGame() {

		Scanner input = new Scanner( System.in );
		boolean y ;
		System.out.println("Συγχαρητήρια! βρίσκεστε στο 3ο επίπεδο! ");
		System.out.println("Είστε ένα επίπεδο πριν τη τελευταία δοκιμασία αυτού του δωματίου...");
		System.out.println("Ο γρίφος που καλείστε να λύσετε τώρα είναι μια κρεμάλα !");
		System.out.println("Το παιχνίδι παίζεται ως εξής");
		System.out.println("Υπάρχει μια κρυμμένη λέξη που καλείστε να βρείτε ...");
		System.out.println("Σας δίνεται το πρώτο γράμμα της λέξης και πρέπει να μαντέψετε ποια άλλα γράμματα υπάρχουν μέσα σε αυτή !");
		System.out.println("Έχετε περιθώριο 5 λαθών! Αν τα ξεπεράσετε τότε χάνετε ..."); // Να ρωτησουμε παιδια
		System.out.println("Αν τα καταφέρετε τότε θα περάσετε στο 4ο και δυσκολότερο επίπεδο !!");
		System.out.println("Η λέξη έχει τη μορφή ");
		show();
		System.out.println("Η κρεμάλα ξεκινάει ! καλή τύχη !");

		do{
			System.out.println("Μάντεψε ένα γράμμα !");
		
			String a ;
			a=input.next();
			
			// data validation check
			while(a.length() !=1) { 

				System.out.println("Μη έγκυρη προσπάθεια ! Προσπαθήστε χρησιμοποιώντας μόνο ένα γράμμα");
				a=input.next();
			}
			char gram=a.charAt(0);
			y= search(gram);
			
			// It keeps his guesses in check and it updates the proper variables
			if(y==true){
				show();
				system.out.println("Το γράμμα υπάρχει στη λέξη!");
			} else {

				lives -= 1;
				System.out.println("Λάθος απάντηση ... Προσπθήστε ξανά !");
			}

		}while( lives != 0 && leftlet!=0 );
		
                // It prints the result of his effort
		if(lives == 0){

			System.out.println("Δυστυχώς δεν τα καταφέρατε , η λέξη ήταν "+ word );

		} else {

			System.out.println("Σωστή απάντηση! Περνάτε στο επόμενο επίπεδο");
			
		}

	} 
        
	// Method show : It prints the right guesses of the user and what is left to guess
	public void show() {

		for( int i = 0 ; i < word.length() ; i ++ ) {
			System.out.print(temp[i]);
		}

	}

	// Method search : It checks if the guess of the user is right and if it's so , it returns true
	public boolean search(char g) {

		boolean t = false ;
		for( int i =0 ; i < word.length() ; i++ ){
			if (g == letters[i]){
				temp[i] = g ;
				t = true ;
			}
		}
		return t ;
	}


}
