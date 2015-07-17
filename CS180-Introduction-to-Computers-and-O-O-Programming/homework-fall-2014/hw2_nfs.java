/**
* Shadman Jubaer
* This program reads a single tree circumference from the standard input
* and prints the corresponding diameter in the same units as the input
*/

import java.util.Scanner;

public class hw2_nfs{

	public static final double PI = Math.PI;

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the tree circumference:");
		double circumference = s.nextDouble();
		double diameter = circumference / PI;
		System.out.println("The diameter of the tree is: "+diameter);
	}
}