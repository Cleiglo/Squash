package squash;

//import javax.swing.SpringLayout.Constraints;

import processing.core.*;

public class Paddle extends PApplet{
	
	int x;
	int xspeed;
	int startx;
	
	public Paddle(int width) {
		
		this.startx = width/4;
		
	}

	public void dir(int x) {
		
		this.xspeed = x;
		
	}
	
	public int movePaddle(boolean start) {
		
		x += xspeed;
		x = constrain(x, 0, startx );

		return x;
		
	}

}
