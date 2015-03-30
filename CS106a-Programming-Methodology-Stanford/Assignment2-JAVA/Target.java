/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
//Create the target logo
public class Target extends GraphicsProgram {	
	public void run() {
		//Get center coordinates of screen
		double cx = getWidth()/2;
		double cy = getHeight()/2;
		//Set dimensions of each circle
		double d_OuterCircle = 72*2;
		double d_WhiteCircle = 72 *2* 0.65;
		double d_InnerCircle = 72 *2* 0.3;
		//Initialize circles
		GOval outerCircle = new GOval(cx-(d_OuterCircle/2),cy-(d_OuterCircle/2),d_OuterCircle,d_OuterCircle);
		GOval whiteCircle = new GOval(cx-(d_WhiteCircle/2),cy-(d_WhiteCircle/2),d_WhiteCircle,d_WhiteCircle);
		GOval innerCircle = new GOval(cx-(d_InnerCircle/2),cy-(d_InnerCircle/2),d_InnerCircle,d_InnerCircle);
		//Set Circle Colors
		outerCircle.setFilled(true);
		outerCircle.setFillColor(Color .red);
		whiteCircle.setFilled(true);
		whiteCircle.setFillColor(Color .white);
		innerCircle.setFilled(true);
		innerCircle.setFillColor(Color .red);
		//Draw circles on canvas
		add(outerCircle);
		add(whiteCircle);
		add(innerCircle);
	}
}
