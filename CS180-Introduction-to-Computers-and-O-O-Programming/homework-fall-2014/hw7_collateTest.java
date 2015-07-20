/**
* Shadman Jubaer
* This code tests the collate class which collates the letters of two 
* input strings
*/

import java.util.*;

public class hw7_collateTest{

	public static void main(String[] args){

		String string1;
		String string2;
		String collated;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter string 1:");
		string1 = in.nextLine();
		System.out.println("Enter string2:");
		string2 = in.nextLine();

		hw7_collate collate = new hw7_collate();
		collated = collate.collate(string1,string2);

		System.out.println(collated);

	}
}