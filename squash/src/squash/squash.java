package squash;

import java.util.ArrayList;

//import java.awt.Canvas;

import processing.core.PApplet;

public class squash extends PApplet{
	int xpad = 0;
	int first = 0;
	int rnd;
	int x;
	int y;
	boolean hit;
	boolean hitted = false;
	int height = 1080;
	int width = 1920;

	int cord_ball[] = new int[2];
	ArrayList<Brick> br;
	

	
	Paddle pad = new Paddle(width);
	Ball b = new Ball((width/2)/2,(height/2)/2,width);
	Brick brick = new Brick(x,y);

	
	
	@Override
	public void settings() {
		size(width/2,height/2);


	}
	@Override
	public void setup() {
		frameRate(80);
		fill(200);
		br = new ArrayList<Brick>();
		br = brick.spawn(height,width);
		
	}

	@Override
	public void draw() {
		
		boolean startpad = true;
		background(20,50,100);
		
		
		if(hitted == false) {
			
			ellipse(cord_ball[0],cord_ball[1],20,20);
//			System.out.println(cord_ball[1]);
				if(first == 0) {
//					xpad = pad.movePaddle(startpad);
//					rect(pad.startx,400,width/4,height/50);
					b.randStart(height,width);
					first = 1;
				}else {
					xpad = pad.movePaddle(!startpad);
					rect(xpad,400,width/4,height/50);
					cord_ball = b.moveBall(height);
				}
				for(int i =0;i<br.size();i++) {
					
					rect(br.get(i).x,br.get(i).y,30,10);
					hit = b.collideWithBrick(br.get(i).x, br.get(i).y, cord_ball[0], cord_ball[1]);
					if(hit) {
					br.remove(i);

					}
			
				}
				hitted = b.collideWith(cord_ball[0],cord_ball[1], xpad, 400,height,width);
		
		
		}else {
			b.xspeed =0;
			b.yspeed =0;
			ellipse(cord_ball[0],cord_ball[1],30,30);
			for(int i =0;i<br.size();i++) {
				rect(br.get(i).x,br.get(i).y,30,10);
			}
			pad.xspeed = 0;
			rect(pad.x,400,width/4,height/50);
		}

	}

	@Override
	public void keyPressed() {
		
		
		if(keyCode == UP) {
			if(hitted != false) {
			hitted = false;
			b.randStart(height, width);
			pad.x = width/4 -600;
			rect(pad.x,400,width/4,height/50);
			for(int i =0;i<br.size();i++) {
			
				br.remove(i);
				}
			br = brick.spawn(height,width);
			}
//			first = 0;
			
		}else if(keyCode == RIGHT) {
			
			pad.dir(3);

			
		}else if(keyCode == LEFT) {
			
			pad.dir(-3);

			
		}
		
		
	}
}
