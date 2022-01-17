/*Countdown.java
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

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
	
	//A timer object
	protected Timer timer;
	//The time in seconds that the timer runs for
	private int i;
	UI ui;
	TransitionManager tm;
	
	//Constructor
	public Countdown(UI userInterface, TransitionManager tm) {
		timer = new Timer();
		i = 2700;
		ui = userInterface;
		this.tm = tm;
		
	}
	
	//Method geti(): Returns the value of variable i (the remaining time in seconds)
	public int geti() {
		
		return i;
	}
	
	//Method startCountdown(): Creates and displays the countdown timer on the screen
	public void startCountdown() {

        timer.scheduleAtFixedRate(new TimerTask() {

    	 public void run() {

	            ui.timeLabel.setText("Time left: " + i/60 + ":" + (i%60/10 == 0 ? "0" : "") + i%60); //Display the time in the form XX:XX
	            i--;

	            if (i < 0) { //If the time is over cancel the timer and display a message saying "Time's Over"
	                timer.cancel();
	                ui.timeLabel.setText("Time's Over");
	                tm.resultPanel();
	    			ui.mainTextArea.setText("\n     GAME OVER \n\n");
	                  
	            }
	        }
	    }, 0, 1000);
	}
}
