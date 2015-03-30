/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {
	//Set width and height of text boxes
	private static final double WIDTH = 110;
	private static final double HEIGHT = 30;

	public void run() {
		//Get center x and y coordinates of screen and make them center of the box
		double cx = (getWidth()/2);
		double cy = (getHeight()/2);
		drawBoxes(cx,cy);
		drawLabels(cx,cy);
		drawLines(cx,cy);
	}
	
	private void drawLabels(double cx, double cy){
		//Set label properties
		GLabel Program = new GLabel("Program");
		Program.setLocation(cx-Program.getWidth()/2,cy-HEIGHT/2+Program.getAscent()/2);
		GLabel Graphics = new GLabel("GraphicsProgram");
		Graphics.setLocation(cx-Graphics.getWidth()/2,cy+2*(HEIGHT-HEIGHT/4)+Graphics.getAscent()/2);
		GLabel Console = new GLabel("ConsoleProgram");
		Console.setLocation(cx-2*WIDTH+Console.getWidth()/12,cy+2*(HEIGHT-HEIGHT/4)+Console.getAscent()/2);
		GLabel Dialog = new GLabel("DialogProgram");
		Dialog.setLocation(cx+WIDTH+Dialog.getWidth()/12,cy+2*(HEIGHT-HEIGHT/4)+Dialog.getAscent()/2);
		//Add labels
		add(Program);
		add(Graphics);
		add(Console);
		add(Dialog);
	}
	
	private void drawLines(double cx, double cy){
		//Define center x and y coordinates of boxes
		double box_cx = cx-(WIDTH/2);
		double box_cy = cy-(HEIGHT);
		//Define lines
		GLine Graphics = new GLine(cx,box_cy+2*HEIGHT,cx,cy);
		GLine Console = new GLine(box_cx-WIDTH,box_cy+2*HEIGHT,cx,cy);
		GLine Dialog = new GLine(box_cx+2*WIDTH,box_cy+2*HEIGHT,cx,cy);
		//Add lines
		add(Graphics);
		add(Console);
		add(Dialog);
	}
	
	private void drawBoxes(double cx,double cy){
		//Define center x and y coordinates of the boxes
		double box_cx = cx-(WIDTH/2);
		double box_cy = cy-(HEIGHT);
		//Set dimensions of boxes
		GRect boxProgram = new GRect(box_cx,box_cy,WIDTH,HEIGHT);
		GRect boxGraphics = new GRect(box_cx,box_cy+2*HEIGHT,WIDTH,HEIGHT);
		GRect boxConsole = new GRect(box_cx-1.5*WIDTH,box_cy+2*HEIGHT,WIDTH,HEIGHT);
		GRect boxDialog = new GRect(box_cx+1.5*WIDTH,box_cy+2*HEIGHT,WIDTH,HEIGHT);
		//Add boxes
		add(boxProgram);
		add(boxGraphics);
		add(boxConsole);
		add(boxDialog);
	}
}

