package squash;


import processing.core.*;

public class Ball extends PApplet {
	int x;
	int y;
	int width;
	int xspeed;
	int yspeed;
	int d;
	int d1;
	int vect[] = new int[2];
	int vectb;
	
	
	
	
	public Ball(int x,int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	Paddle pad = new Paddle(width);
	
	public int[] moveBall(int height) {
		
		this.x+= this.xspeed;
		this.y+= this.yspeed;
		this.vect[0]=this.x;
		this.vect[1]=this.y;
		
		x = constrain(x, 10, width/2-10);
		y = constrain(y, 10, height/2-10);
		return this.vect;
	}
	
	public void randStart(int height,int width) {
		
		
		this.x = (width/2)/2;
		this.y = (height/2)/2;
		
		this.xspeed = (int)(random(2)-1) *4;
			if(xspeed == 0) {
				while(this.xspeed == 0){
					this.xspeed = (int)(random(2)-1) *4;

				}
			}

			this.yspeed = (int)(random(2)-1)*4;
			if(yspeed == 0) {
				while(this.yspeed == 0){
					this.yspeed = (int)(random(2)-1)*4;

				}
			}
		
	}
	
	public void dir(int x, int y) {
		
		this.xspeed = x;
		this.yspeed = y;
		
	}
	
	public boolean collideWith(int xball,int yball, int xpad, int ypad,int height,int width) {
		boolean hitted = false;

		d = (int)Math.abs((ypad-6)-yball);
		if (d==4) {
			if(xball>= xpad-15 && xball<=xpad+(width/4)+15) {
				this.yspeed = -4;
				if (xspeed >= 0) {
					this.xspeed = this.pad.xspeed +4;
				}else {
					this.xspeed = this.pad.xspeed -4;

				}

			}
		}
		if(yball <= 10) {
			
			this.yspeed = 4;
			
		}else if(xball <= 10) {
			
			this.xspeed = 4;
			
		}else if(xball >= width/2-10) {
			
			this.xspeed = -4;
			
		}else if(yball >= height/2 -30) {
			
			this.yspeed = -4;

			
			hitted  = true;
			System.out.println("Game over! Start again?");
			System.out.println("Press UP arrow key to restart");

			
		}

		
		return hitted;
	}
	public boolean collideWithBrick(int xbrick,int ybrick,int xball,int yball) {
		boolean hitted;
		d = (int)Math.abs((yball+15)-ybrick+5);

		if (d==30) {
			if(xball+16>= xbrick && xball+16<=xbrick+31) {
				this.yspeed = 4;
//				if(xball+15 ==xbrick+15) {
//					this.xspeed = -this.xspeed;
//				}else if(xball +15==xbrick) {
					this.xspeed = -this.xspeed;
//				}

				hitted = true;
//			}else if(xball>= xbrick+27 && xball<=xbrick+32) {
//				this.yspeed = 4;
//				this.xspeed = -this.xspeed;
//
//				hitted = true;
			}else if(xball>= xbrick && xball<=xbrick+30) {
				this.yspeed = 4;
				this.xspeed = -this.xspeed;
				hitted = true;
			}else{
				hitted = false;
			}
		}else {
			hitted = false;
		}
		return hitted;

	}

}

