/**
* Shadman Jubaer
* This program reads two integers from standard input and 
* displays their sum in standard output.
*/

import java.util.Scanner;

public class hw1_adder{

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first integer to add.");
		int x1 = s.nextInt();
		System.out.println("Enter the second integer to add.");
		int x2 = s.nextInt();
		System.out.println(x1+" + "+x2+": "+(x1+x2));
	}
}