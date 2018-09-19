package squash;

import java.util.ArrayList;

import processing.core.*;

public class Brick extends PApplet{
	int x;
	int y;
	int lung;
	int score = 0;
	
	int vect[] = new int[3];
	
	public Brick(int x,int y) {
		
		this.x = x;
		this.y = y;
	}
	
	ArrayList<Brick> br = new ArrayList<Brick>();
	
	public ArrayList<Brick> spawn(int heigth, int width){
		for(int j = 0; j<3;j++) {
			for(int i = 0;i<=(width/2)/30;i++) {
			
			
				br.add(i, new Brick(i*30-30,20*(4-j)));
			
			}
		}
		
		
		return br;
	}
	
	
}
