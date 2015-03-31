/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

//This code takes an input integer and takes it to 1 using the
//Hailstone sequence
public class Hailstone extends ConsoleProgram {
	public void run() {
		int input = readInt("Enter an integer: ");
		int temp=0;
		while (input != 1){
			if ((input%2) == 0){
				temp = input/2;
				println(input+" is even, so I take half: "+temp);
				input = temp;
			}
			else{
				temp = input*3+1;
				println(input+" is odd, so I do 3n+1: "+temp);
				input = temp;
			}
		}
	}
}

