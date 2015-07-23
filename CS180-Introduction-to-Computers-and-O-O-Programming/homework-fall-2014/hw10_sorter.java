/**
* Shadman Jubaer
* This class takes an array as input and sorts the values within from
* smallest to largest.
*/

import java.util.*;

public class hw10_sorter{

	public static void main(String[] args){
		//INPUT
		double[] a1 = { 42.0, 3.5, Math.PI, 12.2, -47 };
		System.out.printf("input: %s\n", Arrays.toString(a1));
		
		//Sort
		double[] output = sortArray(a1);
		
		//Print
		System.out.printf("output: %s\n", Arrays.toString(output));
	}

	//Returns copy of input array
	static double[] copyOf(double[] input){
		return input; 
	}

	// Sorts array
	static double[] sort(double[] input){
		double temp;
		for (int i = 0; i<input.length;i++){
			for (int j = 0; j < input.length;j++){
				if(input[i] < input[j]){
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}

	//Returns sorted array
	static double[] sortArray(double[] input){
		double[] copy = copyOf(input);
		return sort(copy);
	}

}