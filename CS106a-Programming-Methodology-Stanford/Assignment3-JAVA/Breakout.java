/*
 * File: Breakout.java
 * -------------------
 * Name: Shadman Jubaer
 * 
 * 
 * This file implements the game of Breakout. The user has three lives to 
 * clear the screen of blocks by bouncing a ball off of a paddle at the 
 * bottom of the screen. 
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
	private double X_VEL;
	private double Y_VEL=2;
	
/** Animation delay between ball moves **/
	private static final int DELAY = 5;
	
/**	Objects used in the program **/
	private GOval ball;
	private GRect paddle;
	private GRect brick;

/** Previous mouse position **/
	private double lastX;
	
/** NUMBER OF LIVES IN GAME **/
	private int LIVES_LEFT = 3;

/** BLOCKS **/
	private int BLOCKS = NBRICKS_PER_ROW*NBRICK_ROWS;

/*--------------------------------------------------------------------------*/	

/** RUNS THE BREAKOUT PROGRAM. */
	public void run() {
		/*Draw GUI*/
		setup();
		
		/*The win condition is when zero blocks remain*/
		int win = 0;

		/**START GAME **/
		
		/*Set random starting x velocity. This determines direction of travel */
		X_VEL = -2 + (int)(Math.random() * ((2 - (-2)) + 1));
		
		/*Start controlling paddle*/
		addMouseListeners();
		
		/*Continue game until lives run out*/
		while(LIVES_LEFT > 0){
			/*Initialize markers to mark deaths and whether blocks have been hit*/
			int markDeath;
			int blockHit;
			/*Move ball by the specified X_VEL and Y_VEL*/
			moveBall();
			/*Check for collision with blocks, boundaries, and the paddle*/
			//If block is hit, bounce off and remove block
			checkBlockHit();
			//Bounce off paddle if paddle is hit
			checkPaddleContact();
			//Detect if ball hit any outer boundaries
			//If ball hit bottom boundary, set markDeath to 1
			//Otherwise bounce ball off walls.
			markDeath = checkBoundaries();
			//If markDeath equals 1, reset ball and paddle, also 
			//subtract 1 from remaining lives
			checkDeath(markDeath);
			/*Check if win conditions have been met*/
			if (win == 1){
				break;
			}
			pause(DELAY);
		}
		/*Display end of game message*/
		remove(paddle);
		remove(ball);
		/*If game is won, display win message*/
		if (win == 1){
			GLabel winLabel = new GLabel("YOU WON!",0,HEIGHT-50);
			winLabel.setVisible(true);
			add(winLabel);
		}
		/*Otherwise display lose message*/
		else{
			GLabel loss = new GLabel("YOU LOST",0,HEIGHT-50);
			loss.setVisible(true);
			add(loss);
		}
	}

/*-------------------------------------------------------------------*/
	
/** DEFINES WIN CONDITIONS **/
	private int checkWin(){
		//If the number of remaining blocks is 0, return winning flag
		if (BLOCKS==0){
			return 1;
		}
		//Otherwise, ignore
		else {return 0;}
	}

/** DEFINE BALL INTERACTIONS WITH BLOCKS AND BOUNDARIES **/
	/*Checks if death has occured, and resets game*/
	private void checkDeath(int Death){
		//If death flag is 1, reset ball and subtract 1 life
		if (Death == 1){
			remove(ball);
			drawBall();
			X_VEL = -2 + (int)(Math.random() * ((2 - (-2)) + 1));
			LIVES_LEFT--;
		}
	}
	
	/*Check whether a block has been hit*/
	private GObject getCollision(){
		//Return the element at the ball's position
		//If the element isn't null, subtract a ball
		if((getElementAt(ball.getX(),ball.getY())) != null){
			BLOCKS--;
			return getElementAt(ball.getX(),ball.getY());
		}
		else{return null;}
	}
	
	private void checkBlockHit(){
		//Set collider equal to the element returned by getCollision()
		GObject collider = getCollision();
		//If the element isn't null or the paddle, assume a block has been hit
		//Bounce the ball and remove the element 
		if (collider != null && collider !=paddle){
			remove(collider);
			Y_VEL = -Y_VEL;
		}
	}
	
/** PADDLE ANIMATION WITH MOUSE **/
	//Define Mouse Movement of paddle
	public void mouseMoved(MouseEvent e){
		//Hardcode the y position of the paddle, since it stays fixed in the 
		//y axis
		int paddley = HEIGHT-PADDLE_Y_OFFSET;;
		//As long as the paddle exists, update its position based on the 
		//position of the mouse
		if (paddle != null){
			//As long as the paddle si within the bounds, set the paddle's location 
			//As the position of the mouse
			if (paddle.getX()+PADDLE_WIDTH < WIDTH || e.getX()-lastX < 0){
				paddle.setLocation((e.getX()-PADDLE_WIDTH/2),paddley);
				//Update mouse location 
				lastX = e.getX();
			}
		}
	}
	
/** BALL ANIMATION **/
	/*Check for contact with paddle*/
	private void checkPaddleContact(){
		//Determine the x and y coordinates of the ball
		double ballx = ball.getX()+BALL_RADIUS;
		double bally = ball.getY()+BALL_RADIUS*2;
		//Determine the x and y coordinates of the paddle
		double paddlex = paddle.getX();
		double paddley = paddle.getY();
		//If the ball approaches the same spot as the paddle, bounce the 
		//Ball
		if (ballx >= paddlex-5 && ballx <= paddlex+PADDLE_WIDTH+5){
			if (bally >= paddley){
				Y_VEL = -Y_VEL;
			}
		}
	}
	
	/*Check for ball collision with boundaries*/
	private int checkBoundaries(){
		/*Set marker to signal ball leaving bottom boundary*/
		int i = 0;
		/*Condition if ball goes beyond the y position of the paddle*/
		if (ball.getY() > HEIGHT-BALL_RADIUS* 2){
			i = 1;
		}
		//Check ball stays inside top of screen
		else if (ball.getY() < 0){Y_VEL = -Y_VEL;}
		//Check ball doesn't fly out the sides
		else if (ball.getX() < 0 || ball.getX()>WIDTH){X_VEL = -X_VEL;}
		return i;
	}
	
	/*Update and move ball*/
	private void moveBall(){
		//Move ball using x and y velocities that are determined at setup
		ball.move(X_VEL, Y_VEL);
	}

/** SETUP GUI **/
	
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
		X_VEL = 2;
		Y_VEL = 1;
		add(ball);
	}
	
	/*Method to draw paddle*/
	private void drawPaddle(){
		/*Set starting position of paddle*/
		int paddlex = getWidth()/2-PADDLE_WIDTH/2;
		int paddley = HEIGHT-PADDLE_Y_OFFSET;
		paddle = new GRect(0,paddley,PADDLE_WIDTH,PADDLE_HEIGHT);
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
				brick = new GRect(brickx,bricky,BRICK_WIDTH,BRICK_HEIGHT);
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