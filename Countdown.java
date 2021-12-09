package mysteryLab;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
	
	protected Timer timer;
	private int i;
	
	public Countdown() {
		timer = new Timer();
		i = 2700;
		
	}
	
	public int geti() {
		
		return i;
	}
	
	    public void startCountdown() {
	    
	        JFrame jframe = new JFrame();
	        JLabel jLabel = new JLabel();
	        jframe.setLayout(new FlowLayout());
	        jframe.setBounds(500, 300, 400, 100);

	        jframe.add(jLabel);
	        jframe.setVisible(true);

	        

	        timer.scheduleAtFixedRate(new TimerTask() {

	            public void run() {

	                jLabel.setText("Time left: " + i/60 + ":" + i%60 + (i%60/10 == 0 ? "0" : ""));
	                i--;

	                if (i < 0) {
	                    timer.cancel();
	                    jLabel.setText("Time Over");
	                  
	                }
	            }
	        }, 0, 1000);
	    }
	}
