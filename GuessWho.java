package Gameplay;
import javax.swing.JOptionPane;
/*Crossword.java
 *Copyright 2021 mysteryLab
 */

/**
*The class QuessWho extends superclass Game (main class). The class implements the guessing a name game.
*The Class displays 10 hints which help the player to find the secret person. The player has 3 tries to guess.
*
*
*@version  _____
*@author VASILIKI KARAMANOU , MARIOS LIAPIS FOTOU
*/
public class GuessWho extends Game {
	
    // class fields 
    private String name;
    private String who;
    private String answer;
    private int column = 4;
    private int lives = 3;
    private boolean win = false;
    private String guess="null";
    private int i = 1;
    private boolean flag = true;
    

    // Constructor
    public GuessWho(int room) {
    	/*Questions = new String[10];
        for(int i =4; i<14 ; i++){
        	Questions[i-4] = questions[room][i];*/
        	name = answers[room][4];
        }

    ///Method printInstructions : prints the game's instructions	
    public void printInstructions() {
        System.out.println("Η τελευταία δοκιμάσια απαιτεί να μαντέψετε το όνομα του μυθικού προσώπου");
        System.out.println("Οι κανόνες του παιχνιδιού είναι η εξής:");
        System.out.println("Σας δίνονται σταδιακά 10 hints. Σύμφωνα με αυτά πρέπει να βρείτε το πρόσωπο που αποκρύπτεται.");
        System.out.println("Έχετε τρεις προσπάθειες.");
        System.out.println("Καλή Επιτυχία!");
    }

	//Method chooseOption: lets the user pick a hint or guess the secret name
	public int chooseOption() {
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
		return n;
	}
	
        //Method showHint: gives an extra hint to the user
	public void showHint(int room, int column, int i) {
		
		String msg = String.format("%dο Στοιχείο",i);
		String hint = questions[room][column];
		JOptionPane.showMessageDialog(null, msg);
		JOptionPane.showMessageDialog(null, hint);
		
	} 
	
	//Method getAnswer: lets the user to type the secret name
	public String getAnswer() {
		
		String who = JOptionPane.showInputDialog(null, "Γράψε ένα όνομα");
		answer = who.toUpperCase();
		return answer;
	}
	
	//Method checkAnswer: checks if the answer that user gives is the correct one and returns boolean value true or false for eatch case
	public boolean checkAnswer(String name, String who) {
		
		if(answer.equals(name) && lives>0) {
			String message1 = String.format("Μπράβο σου κέρδισες!");
			JOptionPane.showMessageDialog(null, message1);
			return true;
			//Αν μάντεψε λάθος όνομα, εμφανίζουμε αντίστοιχο μήνυμα και αυξάνουμε τις ζωές του		    
		
		} else {
			String message1 = String.format("Λάθος Απάντηση.");
			JOptionPane.showMessageDialog(null, message1);
			return false;
		} 
	}
    
	//Method playGuessWho: the main implementation of the guessing game
	public void playGuessWho(int room) {
		
		printInstructions();
		
		showHint(room, column, i);
		
		do {
			
			if(lives > 0 && i <10) {
				
				int option = ChooseOption();
				
					if (option == JOptionPane.YES_OPTION) {
						
						i++;
						column++;
						showHint(room, column, i);
						
				
					} else {
					
						who = getAnswer();
						win = checkAnswer(name, who);
							if(win == false) {
								lives--;
								String message3 = String.format("Εχεις %d ζωες", lives);
								JOptionPane.showMessageDialog(null, message3);
							}
					}
		
			} else if(lives == 0 && i < 10) {
				String message3 = String.format("Δεν εχεις αλλες ζωες.Λυπαμαι εχασες!");
				JOptionPane.showMessageDialog(null, message3);
				break;
				
			} else if(lives > 0 && i == 10) {
				if(flag == true) {
					String message3 = String.format("Δεν έχεις αλλα hints");
					JOptionPane.showMessageDialog(null, message3);
					flag = false;
				}
				
				who = getAnswer();
				win = checkAnswer(name, who);
					if(win == false) {
						lives--;
						String message3 = String.format("Εχεις %d ζωες", lives);
						JOptionPane.showMessageDialog(null, message3);
					}
			}	

		} while (win == false); 
			
		
		
}
} 
