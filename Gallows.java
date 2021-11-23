package mysteryLab ;

import java.util.Scanner ;

public class Gallows extends Game{

		 private String word ;
		 private char [] letters= new char[ word.length()];
		 private char [] temp = new char[ word.length()];
		 private int lives;
		 private int leftlet;

	public Gallows(int room) {//orisma to domatio

		temp[0]=word.charAt(0);
		for( int i = 1 ; i < word.length() ; i ++ ) {
			temp[i] = '_' ;
		}
		for( int i=0 ; i < word.length() ; i ++) {
					letters[i] =word.charAt(i);//it creates a char table wich contains the letters of the word
		}//for
		lives = 5;
		leftlet = word.length() - 1;
		word= answers[room][5];
		
	}// constractor

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
		show(temp ,word);
		System.out.println("Η κρεμάλα ξεκινάει ! καλή τύχη !");

		do{
			System.out.println("Μάντεψε ένα γράμμα !");
		
			String a ;
			a=input.next();
			while(a.length !=1)do{ //??a a???µ??s

				System.out.println("Μη έγκυρη προσπάθεια ! Προσπαθήστε χρησιμοποιώντας μόνο ένα γράμμα");
				a=input.next();
			}
			char gram=a.charAt(0);
			y= search(gram,temp,letters,word);
			if(y==true){

				show(temp ,word);
				leftlet = leftlet -1 ;
			} else {

				lives = lives - 1;
				System.out.println("Λάθος απάντηση ... Προσπθήστε ξανά !");
			}

		}while( lives != 0 && leftlet!=0 );

		if(lives == 0){

			System.out.println("Δυστυχώς δεν τα καταφέρατε , η λέξη ήταν "+ word );

		} else {

			System.out.println("Σωστή απάντηση! Περνάτε στο επόμενο επίπεδο");
			
		}

	} //StartGame

	public static void show(char[] temp, String word) {

		for( int i = 0 ; i < word.length() ; i ++ ) {
			System.out.print(temp[i]);
		}

	}//show

	public static boolean search(char g,char[] temp,char[] letters,String word) {

		boolean t = false ;
		for( int i =0 ; i < word.length() ; i++ ){
			if (g == letters[i]){

			temp[i] = g ;
			t = true ;

			}
		}
		return t ;

	}//search




}//class
