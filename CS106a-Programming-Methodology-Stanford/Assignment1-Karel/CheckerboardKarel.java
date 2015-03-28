/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		int x = 0;
		if(frontIsBlocked()){fillRowUp();}
		else{
			if (checkTop()==1){fillRowRight();}
			while(checkTop()==0){x=fill2Rows();}
			if (x==1){fillRowRight();}
		}
	}
	
	private int fill2Rows(){
		int i = 0;
		int b = fillRowRight();
		turnLeft();
		move();
		turnLeft();
		if (b==1){fillRowRight();}
		else{invFillRowRight();}
		turnAround();
		if (checkTop()==0){
			turnLeft();
			move();
			turnRight(); 
			i=1;
		}
		return i;
	}
	
	private int checkTop(){
		int i = 0;
		turnLeft();
		if (frontIsBlocked()){i = 1;};
		turnRight();
		return i;
	}
	private int fillRowRight(){
		int i = 0;
		while (frontIsClear()){
			if (i == 0){
				putBeeper();
				move(); 
				i = 1;
			}
			else{
				move();
				i = 0;
			}
		}
		if (i==0){putBeeper();}
		return i;
	}

	private int invFillRowRight(){
		int i = 0;
		while (frontIsClear()){
			if (i == 1){
				putBeeper();
				move();
				i = 0;
				}
			else{
				move();
				i = 1;
			}
		}
		if (i==1){putBeeper();}
		return i;
	}
	
	private void fillRowUp(){
		turnLeft();
		int i = 0;
		while(frontIsClear()){
			if (i==0){
				putBeeper();
				move();
				i=1;
			}
			else{
				move();
				i=0;
			}
		}
		if (i==0){putBeeper();}
	}
}