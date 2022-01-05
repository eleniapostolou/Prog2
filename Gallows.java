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
package mysteryLab;


public class Gallows extends Game{

                 // Class fields
		 private String word ;
		 private char [] letters;
		 private char [] temp ;
		 private int lives,j;
		 private int leftlet;
		 private char [] unique ;
		 UI ui; 
		 TransitionManager tm;
		 Countdown cd;
	
	// Constructor
	public Gallows(int room, UI ui, TransitionManager tm,Countdown cd) {
		
		word= answers[room][5];
		letters= new char[ word.length()];
		unique= new char[ 24];
		temp = new char[ word.length()];
		temp[0]=word.charAt(0);
		for( int i = 1 ; i < word.length() ; i ++ ) {
			temp[i] = '_' ; // it creates a table with only the first the letter of the word
			unique[i]=	'\u0000';
		}
		for( int i=0 ; i < word.length() ; i ++) {
			letters[i] =word.charAt(i);//it creates a char table which contains the letters of the word
		}
		lives = 5;
		leftlet = word.length() - 1;
		j=0;
		this.ui =ui;
		this.tm = tm;
		this.cd = cd;
		
	}

	// Method startGame: the main implementation of the Gallows game
	public void startGame(String s) {

		boolean y ;
		
		if (lives != 0 && leftlet!=0 ) {
			
			s =s.toUpperCase();
			char gram = s.charAt(0);
			ui.mainTextArea.setText(show()+"\n");
			y= search( gram);
			ui.mainTextArea.setText(show()+"\n");
			// It keeps his guesses in check and it updates the proper variables
			if(y){
				
				if (leftlet != 0) {
				ui.mainTextArea.append("Το γράμμα υπάρχει στη λέξη!");
				ui.mainTextArea.append("Έχετε "+lives+" ζωές \n");
				}
				
			} else {

				lives -= 1;
				ui.mainTextArea.append("Λάθος απάντηση ... \n");
				if(lives !=0){
					
					ui.mainTextArea.append("Προσπαθήστε ξανά ! ");
					ui.mainTextArea.append("Έχετε "+lives+" ζωές \n");
				}
			}

		}
		
                // It prints the result of his effort
		if(lives == 0){
			
			ui.timePanel.setVisible(false);
			tm.resultPanel(); 
			ui.mainTextArea.setText("\n     GAME OVER \n\n");
			cd.timer.cancel();
		
		
		} else if (leftlet == 0){

			ui.mainTextArea.append(" \n Βρήκατε τη λέξη! Περνάτε στο επόμενο επίπεδο");
			EscapeRoom2.miniGame = 4; 
			ui.cb.setVisible(true);
		}

	} 
        
	// Method show : It prints the right guesses of the user and what is left to guess
	public String show() {
		String s = "";
		for( int i = 0 ; i < word.length() ; i ++ ) {
			s +=temp[i]+" ";
		}
		return s;
	}

	// Method search : It checks if the guess of the user is right and if it's so , it returns true
	public boolean search(char g) {

		boolean t1 = false ;
		boolean t2 =false ; 

		
		for(int k =0 ; k<unique.length ; k++){
			if(unique[k]==g){
				t2=true;
			}
		}
		if(t2==false || unique.length<1){
			for( int i =1 ; i < word.length() ; i++ ){
				if (g == letters[i]){
					temp[i] = g ;
					t1 = true ;
					leftlet-=1;
				}
			}
			unique[j]=g;
			j++;
		}
	
		return t1 ;
	}

	public void instructions() {
		
		ui.mainTextArea.setText("Συγχαρητήρια! βρίσκεστε στο 3ο επίπεδο! \n"+
		"Είστε ένα επίπεδο πριν τη τελευταία δοκιμασία αυτού του δωματίου...\n"+
		"Ο γρίφος που καλείστε να λύσετε τώρα είναι μια κρεμάλα !\n"+
		"Το παιχνίδι παίζεται ως εξής \n"+
		"Υπάρχει μια κρυμμένη λέξη που καλείστε να βρείτε ...\n"+
		"Σας δίνεται το πρώτο γράμμα της λέξης και πρέπει να μαντέψετε ποια άλλα γράμματα υπάρχουν μέσα σε αυτή !\n"+
		"Έχετε περιθώριο 5 λαθών! Αν τα ξεπεράσετε τότε χάνετε ...\n"+
		"Αν τα καταφέρετε τότε θα περάσετε στο 4ο και δυσκολότερο επίπεδο !!\n"+
		"Η κρεμάλα ξεκινάει ! καλή τύχη !\n"+
		"Η λέξη έχει τη μορφή \n"+show());
	}

}

