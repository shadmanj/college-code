/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Starting X and Y velocities **/
	private double X_VEL = 1;
	private double Y_VEL = 1;
	
/** Animation delay between ball moves **/
	private static final int DELAY = 5;
	
/**	Private GInstance variable **/
	private GOval ball;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/*Draw GUI*/
		setup();
		while(true){
			moveBall();
			checkBoundaries();
			pause(DELAY);
		}
	}
	
/** BALL ANIMATION **/
	/*Check for ball collision*/
	private void checkBoundaries(){
		/*Condition if ball goes beyond the y position of the paddle*/
		if (ball.getY() > (HEIGHT-PADDLE_Y_OFFSET)-BALL_RADIUS* 2){
			Y_VEL = -Y_VEL;
		}
		else if (ball.getY() < 0){Y_VEL = -Y_VEL;}
		else if (ball.getX() < 0 || ball.getX()>WIDTH){X_VEL = -X_VEL;}
	}
	
	/*Update and move ball*/
	private void moveBall(){
		ball.move(X_VEL, Y_VEL);
	}

/** SETUP GUI**/
	
	/*Setup Method*/
	private void setup(){
		drawBricks();
		drawPaddle();
		drawBall();
	}
	/*Method to draw ball*/
	private void drawBall(){
		ball = new GOval(getWidth()/2-BALL_RADIUS,getHeight()/2-BALL_RADIUS,BALL_RADIUS,BALL_RADIUS);
		ball.setFilled(true);
		ball.setFillColor(Color .black);
		add(ball);
	}
	
	/*Method to draw paddle*/
	private void drawPaddle(){
		/*Set starting position of paddle*/
		int paddlex = getWidth()/2-PADDLE_WIDTH/2;
		int paddley = HEIGHT-PADDLE_Y_OFFSET;
		GRect paddle = new GRect(paddlex,paddley,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color .black);
		add(paddle);
	}
	/*Method to draw initial array of bricks*/
	private void drawBricks(){
		/*Initialize row number*/
		int row = 0, row4color = 0;
		/*Starting y position of bricks*/
		int bricky = 70;
		while (row < NBRICK_ROWS){
			/*Make sure row4color is between 0 and 11 for accurate row coloring*/
			if (row4color == 11){row4color = 0;}
			/*Brick in row*/
			int Nbrick = 0;
			/*Starting x position of bricks*/
			int brickx = 4;
			while (Nbrick < NBRICKS_PER_ROW){
				/*Draw a brick of given dimensions and position*/
				GRect brick = new GRect(brickx,bricky,BRICK_WIDTH,BRICK_HEIGHT);
				/*SET BRICK COLOR*/
				brick.setFilled(true);
				if (row < 2){brick.setFillColor(Color .red);}
				else if (row < 4 && row >=2){brick.setFillColor(Color .orange);}
				else if (row <6 && row >=4){brick.setFillColor(Color .yellow);}
				else if (row <8 && row >=6){brick.setFillColor(Color .green);}
				else if (row <10 && row >=8){brick.setFillColor(Color .cyan);}
				/*Show brick*/
				add(brick);
				brickx+=BRICK_WIDTH+BRICK_SEP;
				Nbrick+=1;
			}
			bricky+=BRICK_HEIGHT+BRICK_SEP;
			row+=1;
		}
	}
}