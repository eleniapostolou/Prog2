*Countdown.java
 *Copyright 2021 mysteryLab
 */

/**
*The class Countdown creates and displays a countdown timer that calculates the time left 
*for the player to complete the game. The timer is set to run for 45 minutes. When the 45 minutes pass,
*the game is terminated and a message informing the user that the time is over shows up on the screen.
*
*
*@version  _____
*@author ELENI APOSTOLOU, ELENI NTOUSI 
*/
package mysteryLab;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
	
	//A timer object
	protected Timer timer;
	//The time in seconds that the timer runs for
	private int i;
	
	//Constructor
	public Countdown() {
		timer = new Timer();
		i = 2700;
		
	}
	
	//Method geti(): Returns the value of i (the remaining time in seconds)
	public int geti() {
		
		return i;
	}
	
	//Method startCountdown(): Creates and displays the countdown timer on the screen
	public void startCountdown() {
	    
	    JFrame jframe = new JFrame();
	    JLabel jLabel = new JLabel();
	    jframe.setLayout(new FlowLayout());
	    jframe.setBounds(500, 300, 400, 100);

	    jframe.add(jLabel);
	    jframe.setVisible(true);

        timer.scheduleAtFixedRate(new TimerTask() {

    	 public void run() {

	            jLabel.setText("Time left: " + i/60 + ":" + i%60 + (i%60/10 == 0 ? "0" : "")); //Display the time in the form XX:XX
	            i--;

	            if (i < 0) { //If the time is over cancel the timer and display a message saying "Time Over"
	                timer.cancel();
	                jLabel.setText("Time Over");
	                  
	            }
	        }
	    }, 0, 1000);
	}
}


