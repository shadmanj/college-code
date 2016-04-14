/**
* Shadman Jubaer
* This class sums an arbitrary number of string inputs while ignoring 
* white space in the string
*/

import java.util.Scanner;

public class hw5_calculator{
	String s;

	public int sum(String s){
		int sum=0;
		this.s = s; 
		Scanner in = new Scanner(s);
		while (in.hasNextInt())
			sum+=in.nextInt();
		return sum;
	}
}