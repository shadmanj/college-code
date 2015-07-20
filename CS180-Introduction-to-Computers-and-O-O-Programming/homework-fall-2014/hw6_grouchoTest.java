/**
* Shadman Jubaer
* This program tests the Groucho class by providing a secret word,
* and then running until the program is quit or the secret word is 
* guessed.
*/

import java.util.Scanner;

public class hw6_grouchoTest{
	public static void main(String[] args) {
		boolean test = false;
		String line;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the secret word:");
		
		String secret = in.nextLine();
		
		for (int i = 110; i > 0; i--)
			System.out.println();
		
		hw6_groucho game = new hw6_groucho(secret);
		System.out.println("Enter some guesses.");
		while (test != true){
			line = in.nextLine();
			test = game.saysSecret(line);
		}
		if (test = true)
			System.out.println("\n\n\nCONGRATULATIONS!\n\n\nYou won $100!");
	}
}