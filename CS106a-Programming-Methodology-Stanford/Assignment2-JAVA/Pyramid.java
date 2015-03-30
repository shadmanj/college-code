/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

// Build a pyramid that is centered and starts at the bottom of the screen.
public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		//Bricks must start at the bottom of the screen
		//and be centered.'
		//Find width of window
		int cx = getWidth()/2;
		//Find Height of window
		int cy = getHeight();
		//Set x position of first brick
		int brickStart_x = cx - (BRICKS_IN_BASE*BRICK_WIDTH/2);
		//Set y position of first brick
		int brickStart_y = cy;
		//Start at bottom row, and build up
		int currentRow = BRICKS_IN_BASE;
		while (currentRow > 0){
			placeRow(currentRow,brickStart_x,brickStart_y);
			brickStart_x += BRICK_WIDTH/2;
			brickStart_y -= BRICK_HEIGHT;
			currentRow -= 1;
		}
	}
	
	//Creates a row of blocks given starting coordinates and number of blocks
	private void placeRow(int bricks2Lay,int x_pos,int y_pos){
		int rowPosition = 0;
		int newX = x_pos;
		while(rowPosition < bricks2Lay){
			GRect block = new GRect(newX,y_pos,BRICK_WIDTH,BRICK_HEIGHT);
			add(block);
			newX+=BRICK_WIDTH;
			rowPosition+=1;
		}
	}
}
