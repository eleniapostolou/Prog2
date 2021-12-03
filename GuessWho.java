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
    //Αρχικοποιούμε την name με το όνομα του ατόμου που αποκρύπτεται και τον πίνακα με τα αντίστοιχα hints 
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
	//Όσο το όνομα που βρίσκει ο παίκτης διαφέρει από το ζητούμενο και έχει προσπαθήσει ήδη λιγότερες από τρεις φορές και ο χρόνος δεν έχει λήξει συνεχίζει να παίζει 
        while(!guess.equals(name) && !outofGuesses  && /*timer>0*/) {
        //Του δίνουμε την επιλογή να πάρει extra hint ή να μαντέψει
            Object[] options = {"Extra Hint",
                    "Μάντεψε"};
            int n = JOptionPane.showOptionDialog(frame,
                    "Μαντέψτε ή πάρτε το επόμενο στοιχείο.",
                    "Try",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
	//Αν θέλει extra hint του εμφανίζουμε το αμέσως επόμενο που βρίσκεται στον πίνακα και αυξάνουμε τον μετρητή	
            if (n == JOptionPane.YES_OPTION) {
	        if(QuestionCount < guessLimit) {
                     JOptionPane.showMessageDialog(null, Questions[QuestionCount]);
		     QuestionCount++;
		} else {
                    outofGuesses = true;
		    String message = String.format("Δεν έχεις άλλα hints, μάντεψε ποιός είναι.");
                    JOptionPane.showMessageDialog(null, message);	
                }	
        //Αν θέλει να μαντέψει ελέγχουμε αν έχει λιγότερες απο τρεις ζωές και του ζητάμε να πληκτρολογήσει το όνομα		    
            } else if (n == JOptionPane.NO_OPTION) {
                if(lives<3) {
                    String who = JOptionPane.showInputDialog(null, "Γράψε ένα όνομα");
	//Αν μάντεψε σωστά το όνομα, εμφανίζουμε αντίατοιχο μήνυμα και βγαίνει από την while 		
                    if(who == name) {
                        String message = String.format("Μπράβο σου κέρδισες!");
                        JOptionPane.showMessageDialog(null, message);
	//Αν μάντεψε λάθος όνομα, εμφανίζουμε αντίστοιχο μήνυμα και αυξάνουμε τις ζωές του		    
                    } else {
                        String message = String.format("Λάθος Απάντηση.");
                        JOptionPane.showMessageDialog(null, message);
                        lives++;
                    }
	//Αν συμπλήρωσε 3 προσπάθειες λάθος του βγάζουμε μήνυμα ότι έχασε		
		} else {
                    String message = String.format("Ωχ.. έχασες! Δεν έχεις άλλες ζωές.");
                    JOptionPane.showMessageDialog(null, message);
		    break;	
                }
                /*else {
                    String message = String.format("Μπράβο σου κέρδισες!");
                    JOptionPane.showMessageDialog(null, message);
	        }  */
	//Αν πατήσει οπουδήποτε αλλού εκτός από τις δύο επιλογές που του δίνουμε του εμφανίζουμε κατάλληλο μήνυμα 	    
            } else {
                setLabel("Παρακαλώ επιλέξτε.");
            }
        }
    }
}


 
