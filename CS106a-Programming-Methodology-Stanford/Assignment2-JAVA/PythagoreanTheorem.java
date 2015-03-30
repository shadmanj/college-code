/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

// Create a simple script to compute the hypotenuse of a triangle
// using the Pythagorean Theorem
public class PythagoreanTheorem extends ConsoleProgram {
	public void run(){
		println("This program will calculate the hypotenuse of a triangle.");
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		double c = Math.sqrt((a*a)+(b*b));
		println("c = " + c);
	}
}
