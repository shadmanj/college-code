/**
* Shadman Jubaer
* This class collates the letters of two inputted strings
*/

import java.util.*;

public class hw7_collate{

	private String string1;
	private String string2;

	public hw7_collate(){int x = 1;}

	public String collate (String stringA, String stringB){

		//Take input strings and set string 1 equal to the larger string

		//System.out.println(string1);
		//System.out.println(string2);
		//System.out.println(string1.length());
		
		if(stringA.length() >= stringB.length()){
			this.string1 = stringA;
			this.string2 = stringB;
		}

		else {
			this.string1 = stringB;
			this.string2 = stringA;
		}

		//Initialize output string
		String temp="";
		int j = 0;
		//Index through both strings and add switched letters to temp
		for (int i = 0; i < string1.length();i++){
			temp  = temp + string1.charAt(i);
			while (i < string2.length()){
				temp = temp + string2.charAt(j);
				j++;
				break;
			}
		}

		return temp;
	}

}