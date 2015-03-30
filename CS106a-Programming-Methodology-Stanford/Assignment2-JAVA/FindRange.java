/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

// This script takes inputs until a sentinel value is entered.
// The program will display the highest and lowest values entered.

public class FindRange extends ConsoleProgram {
	//Set sentinel value
	private static final double SENTINEL = 0;
	public void run() {
		println("This script will calculate the highest and lowest input.");
		println("Enter " + SENTINEL + " to finish inputs");
		double input = readDouble("? ");
		int i = 0;
		double high=0, low=0, nextInput=0;
		while (input != SENTINEL){
			if (i == 0){
				nextInput = readDouble("? ");
				low = getLowest(input,nextInput);
				if (low == input){high = nextInput;}
				else{high = input;}
				i = 1;
			}
			else{
				input = readDouble("? ");
				if (input == SENTINEL){break;}
				else{
					low = getLowest(input,low);
					if(low != input){high = getHighest(input,high);}
			
				}
			}
		}
		println("Highest value: " + high);
		println("Lowest value: " + low);
	}
	
	private double getLowest(double input1, double input2){
		double lowest = input1;
		if (input1 >= input2){lowest = input2;}
		return lowest;
	}
	
	private double getHighest(double input1, double input2){
		double highest = input2;
		if (input1 >= input2){highest = input1;}
		return highest;
	}
}

