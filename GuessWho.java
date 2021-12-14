/*Crossword.java
 *Copyright 2021 mysteryLab
 */

/**
*The class QuessWho extends superclass Game (main class). The class implements the guessing a name game.
*The Class displays 10 hints which help the player to find the secret person. The player has 3 tries to guess.
*
*
*@version  _____
*@author VASILIKI KARAMANOU , MARIOS LIAPIS 
*/
package mysteryLab;

import javax.swing.JOptionPane;

public class GuessWho extends Game {
	
    // class fields 	
    private String[] Questions;
    private String name;
    private String who;
    private int QuestionCount = 0;
    private int lives = 3;
    private final int guessLimit = 10;
    private boolean outofGuesses = false;
    private String guess="null";

    // Constructor
    public GuessWho(int room) {
    	Questions = new String[10];
        for(int i =4; i<14 ; i++){
        	Questions[i-4] = questions[room][i];
        	name = answers[room][4];
        }
    }

    public void printInstructions() {
        System.out.println("Η τελευταία δοκιμάσια απαιτεί να μαντέψετε το όνομα του μυθικού προσώπου");
        System.out.println("Οι κανόνες του παιχνιδιού είναι η εξής:");
        System.out.println("Σας δίνονται σταδιακά 10 hints. Σύμφωνα με αυτά πρέπει να βρείτε το πρόσωπο που αποκρύπτεται.");
        System.out.println("Έχετε τρεις προσπάθειες.");
        System.out.println("Καλή Επιτυχία!");
    }

    // Method startGuessing: the main implementation of the Guessing game	
    public void startGuessing() {
	printInstructions();    
	JOptionPane.showMessageDialog(null, Questions[QuestionCount]);
	QuestionCount++;
        while(!(guess.equals(name)) && !outofGuesses  ) {
            Object[] options = {"Extra Hint",
                    "Μάντεψε"};
            int n = JOptionPane.showOptionDialog(null,
                    "Μαντέψτε ή πάρτε το επόμενο στοιχείο.",
                    "Try",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == JOptionPane.YES_OPTION) {
	            if(QuestionCount < guessLimit) {
	                     JOptionPane.showMessageDialog(null, Questions[QuestionCount]);
			     QuestionCount++;
	            } else {
	                    outofGuesses = true;
	                    String message = String.format("Δεν έχεις άλλα hints, μάντεψε ποιός είναι.");
	                    JOptionPane.showMessageDialog(null, message); 
	                    // It prints the result of his effort
	                    for(int i=lives ; i>=0 ;i--){
	                    	if(i!=0){
	                    		String who = JOptionPane.showInputDialog(null, "Γράψε ένα όνομα");
	                    		
	                    		if(who.equals(name)) {
	                    			String message1 = String.format("Μπράβο σου κέρδισες!");
	                    			JOptionPane.showMessageDialog(null, message1);
	                    			break;
	                    			//Αν μάντεψε λάθος όνομα, εμφανίζουμε αντίστοιχο μήνυμα και αυξάνουμε τις ζωές του		    
	                    		} else {
	                    			String message1 = String.format("Λάθος Απάντηση.");
	                    			JOptionPane.showMessageDialog(null, message1);
	                    		} 
	                    		
	                    	}else {
	                        	 String message1 = String.format("Ωχ.. έχασες! Δεν έχεις άλλες ζωές.");
                        	         JOptionPane.showMessageDialog(null, message1);
                        	         break;
				}	 
	                    
	                    	}
	                    }
	            
	            
           
            } else if (n == JOptionPane.NO_OPTION) {
                if(lives>0) {
                    String who = JOptionPane.showInputDialog(null, "Γράψε ένα όνομα");
	 
                    if(who.equals(name)) {
                        String message = String.format("Μπράβο σου κέρδισες!");
                        JOptionPane.showMessageDialog(null, message);
                        break;
	 	    
                    } else {
                        String message = String.format("Λάθος Απάντηση.");
                        JOptionPane.showMessageDialog(null, message);
                        lives--;
                        if(lives==0){
                        	outofGuesses = true;
                        	String message1 = String.format("Ωχ.. έχασες! Δεν έχεις άλλες ζωές.");
                                JOptionPane.showMessageDialog(null, message1);}
                    }
	 	
		} else {
                    String message = String.format("Ωχ.. έχασες! Δεν έχεις άλλες ζωές.");
                    JOptionPane.showMessageDialog(null, message);
		    break;	
                }
                
                /*else {
                    String message = String.format("Μπράβο σου κέρδισες!");
                    JOptionPane.showMessageDialog(null, message);
	        }  */
		    
            }else{
            	
            } 
            
        }
    }
}


 
