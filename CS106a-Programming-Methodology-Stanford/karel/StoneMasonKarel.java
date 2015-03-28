/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel{
	public void run(){
		//Set Counter
		int i = 4;
		//As long as front is clear, fill every fourth Avenue
		while (frontIsClear()){
		//If at a fourth avenue, fill the column
			if (i == 4){
				fillColumn();
				i = i - 1;
			}
		//If not at a fourth avenue, move and subtract one.
			else{
				move();
		//If counter is 1, set to 4
				if (i == 0){i = 4;}
				else{i = i - 1;}
			}
		}
		if (i == 4){fillColumn();} 
	}
	
	//Fill columns by checking if beepers are present.
	private void fillColumn(){
		turnLeft();
		while (frontIsClear()){
			beeperCheck();
			move();
		}
		beeperCheck();
		turnAround();
		while (frontIsClear()){move();}
		turnLeft();
	}
	
	//Check and Place Beeper
	private void beeperCheck(){
		if (beepersPresent()){}
		else{putBeeper();}
	}
}
