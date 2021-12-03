import javax.swing.JOptionPane;
public class GuessWho {
    private String Questions[10];
    private String name;
    private String who;
    private int QuestionCount = 0;
    private int lives = 1;
    //edo vazoume xrono logika kati prepei na ginei import tha to vroume
    private final int guessLimit = 10;
    private boolean outofGuesses = false;
	
    public GuessWho(String[] quest, String answer) {
	    name = answer;
	    Quenstions[0] = quest[0];
	    Quenstions[1] = quest[1];
	    Quenstions[2] = quest[2];
	    Quenstions[3] = quest[3];
	    Quenstions[4] = quest[4];
	    Quenstions[5] = quest[5];
	    Quenstions[6] = quest[6];
	    Quenstions[7] = quest[7];
	    Quenstions[8] = quest[8];
	    Quenstions[9] = quest[9];
    }	    

    public void printInstructions() {
	    System.out.println("Η τελευταία δοκιμάσια απαιτεί να μαντέψετε το όνομα του μυθικού προσώπου");
	    System.out.println("Οι κανόνες του παιχνιδιού είναι η εξής:");
	    System.out.println("Σας δίνονται σταδιακά 10 hints. Σύμφωνα με αυτά πρέπει να βρείτε το πρόσωπο που αποκρύπτεται.");
	    System.out.println("Έχετε τρεις προσπάθειες.");
	    System.out.println("Καλή Επιτυχία!");
    }
    
    public void startGuessing() {
	    String guess;
	    while(!guess.equals(name)&& !outofGuesses) {
		 if(lives<3 && /*timer>0)*/ {
			 if(QuestionCount < guessLimit) {
                                 JOptionPane.showMessageDialog(null, Questions[QuestionCount]);
                                 String who = JOptionPane.showInputDialog(null, "Enter name");
                                 if(who == name) {
                                          String message = String.format("You Won!");
                                          JOptionPane.showMessageDialog(null, message);
                                 } else {
                                          String message = String.format("Wrong guess");
                                          JOptionPane.showMessageDialog(null, message);
                                          QuestionCount++;
                                          lives++;
                                 }
                         } else {
                         outofGuesses = true;
                         }
                         if(outofGuesses) {
                                String message = String.format("You Lose!No more guesses");
                                JOptionPane.showMessageDialog(null, message);
                         } else {
                                String message = String.format("You Won!");
                                JOptionPane.showMessageDialog(null, message);
                         }
		 } else {
                         break;
                 }
            }
    }
