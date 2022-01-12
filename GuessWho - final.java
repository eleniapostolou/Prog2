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
package mysteryLab;
public class GuessWho extends Game {
	
    // class fields 
    private String name;
    private int column = 5;
    private int lives = 3;
    private boolean r;
    TransitionManager tm;
    Countdown cd;
    UI ui;
    

    // Constructor
    public GuessWho(int room,UI ui,TransitionManager tm,Countdown cd) {
    	
        	name = answers[room][4];
        	this.ui = ui;
        	this.tm = tm;
        	this.cd = cd;
        }

    //Method printInstructions : prints the game's instructions	
    public void printInstructions(int room) {
        ui.mainTextArea.setText("Η δεύτερη δοκιμάσια απαιτεί να μαντέψετε το όνομα ενός μυθικού προσώπου \n"+
        		"Οι κανόνες του παιχνιδιού είναι η εξής: \n"+
        		"Σας δίνονται σταδιακά 10 hints. Σύμφωνα με αυτά πρέπει να βρείτε το πρόσωπο που αποκρύπτεται.\n"+
        		"Έχετε τρεις προσπάθειες.\n"+
        		"Καλή Επιτυχία! Ορίστε το πρώτο hint \n\n"+
        		questions[room][column-1]);
    }

	
        //Method showHint: gives an extra hint to the user
	public void showHint(int room) {
		
		ui.mainTextArea.setFont(ui.miniGameFont);
		if(column==5 || r){
			ui.mainTextArea.setText("\n"+questions[room][column]);
			r = false;
		} else if(column <14) {
			ui.mainTextArea.append("\n"+questions[room][column]);
		} else {
			ui.gwB.setVisible(false);
			ui.mainTextArea.append("\n Δεν έχεις άλλα HINTS ,πρέπει να μαντέψεις ");
		}
		column+=1;
	
	} 
	
	
	
	//Method checkAnswer: checks if the answer that user gives is the correct one and returns boolean value true or false for each case
	public boolean checkAnswer(String name, String who) {
		
		if(who.equals(name)) {
			return true;
			
		} else {
			lives--;
			ui.mainTextArea.setText("\nΛάθος Απάντηση.\n");
			ui.mainTextArea.append("Εχεις "+lives+" ζωες\n");	
			ui.mainTextArea.setFont(ui.biggerFont);
			r = true;
			return false;
		} 
	}
    
	//Method playGame: the main implementation of the guessing game
	public void playGame(int room,String answer) {
		
			boolean flag ;		
			answer = answer.toUpperCase();
			flag = checkAnswer(name, answer);
			if(flag) {
				ui.mainTextArea.setText("Μπράβο σου βρήκες το πρόσωπο και περνάς στο 3ο επίπεδο!");
				EscapeRoom2.miniGame = 3; 
				ui.cb.setVisible(true);
				ui.gwB.setVisible(false);
				ui.mainTextArea.setFont(ui.biggerFont);
			} else if(lives==0) {
				ui.gwB.setVisible(false);
				ui.timePanel.setVisible(false);
				tm.resultPanel(); 
				ui.mainTextArea.setText("\n     GAME OVER \n\n");
				cd.timer.cancel();
				
			}
					
					
		
		
		  	
	}
		
			
		
		
}
 
